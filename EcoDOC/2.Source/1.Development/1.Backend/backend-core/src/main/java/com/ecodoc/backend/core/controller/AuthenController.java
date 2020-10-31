package com.ecodoc.backend.core.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecodoc.backend.core.auth.AuthenResponse;
import com.ecodoc.backend.core.auth.SecurityContext;
import com.ecodoc.backend.core.auth.TokenHelper;
import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.ActionEnum;
import com.ecodoc.backend.core.config.CategoryEnum;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.config.ModuleCodeEnum;
import com.ecodoc.backend.core.domain.Client;
import com.ecodoc.backend.core.domain.Module;
import com.ecodoc.backend.core.domain.ResponseMessage;
import com.ecodoc.backend.core.domain.Role;
import com.ecodoc.backend.core.domain.Token;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.UserTreeDto;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestForbidden;
import com.ecodoc.backend.core.repository.IClientRepository;
import com.ecodoc.backend.core.service.CategoryService;
import com.ecodoc.backend.core.service.IService;
import com.ecodoc.backend.core.service.ModuleService;
import com.ecodoc.backend.core.service.OrganizationService;
import com.ecodoc.backend.core.service.RoleService;
import com.ecodoc.backend.core.service.StraceSystemService;
import com.ecodoc.backend.core.service.UserService;
import com.ecodoc.backend.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author EcoDOC
 * 
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class AuthenController extends BaseController<User> {
	enum SortBy {
		UPDATEDATE("updateDate"), // ngày cập nhật
		FULLNAME("fullName"), // ngày cập nhật
		ORG("orgModel.name"), // ngày tạo
		POSITION("positionModel.name"), BIRTHDAY("birthday"), // số-kí hiệu
		PHONE("phone"), // trích yếu
		ACTIVE("active"); // ngày ban hành

		private String field;

		private SortBy(String field) {
			this.field = field;
		}
	}

	@Autowired
	private StraceSystemService straceService;

	@Autowired
	private IClientRepository clientRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
 
	@Autowired
	private TokenHelper tokenProvider;

	@Override
	public IService<User> getService() {
		return userService;
	}

	@Autowired
	private ModuleService moduleService;

	@Autowired
	OrganizationService orgService;

	@Autowired
	CategoryService catService;

	private void checkPermission() {
		if (roleService.existUserInModule(ModuleCodeEnum.USER.getName())) {
			return;
		}
		throw new RestForbidden("Bạn không có quyền truy cập vào người dùng");
	}

	//true : admin
	//false : user
	private boolean isAdmin(Long id) {
		if (roleService.existUserInModule(ModuleCodeEnum.USER.getName())) {
			return true;
		} else if (BussinessCommon.getUserId().equals(id)) {
			return false;
		}
		throw new RestForbidden("Bạn không có quyền truy cập vào người dùng");
	}

	@PostMapping(value = "/search")
	public ResponseEntity<?> search(@RequestParam("textSearch") String textSearch) {
		return new ResponseEntity<>(userService.searchUserActive(textSearch), HttpStatus.OK);
	}

	@PostMapping(value = "/search1")
	public ResponseEntity<?> search1(@RequestParam("textSearch") String textSearch) {
		return new ResponseEntity<>(userService.searchUserDtoActive(textSearch), HttpStatus.OK);
	}

	@GetMapping(value = "/version")
	public ResponseEntity<ResponseMessage> version() {
		return new ResponseEntity<>(new ResponseMessage("Version BE: 1280"), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> authentication(@RequestParam String userName, @RequestParam String password) {
		//valid
		if(StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(password))
			throw new RestExceptionHandler(Message.NO_INPUT_DATA);

		User userInfo = userService.findByUserNameAndActive(userName, true);
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		if (userInfo == null || !encoder.matches(password, userInfo.getPassword()) || userInfo.isLdap()) {
			throw new RestExceptionHandler(Message.FAIL_LOGIN);
		}

		Client clientInfo = clientRepository.findById(userInfo.getClientId()).get();
		String tokenExpire = tokenProvider.generateExpire(clientInfo.getCreateDate());
		if (!tokenProvider.checkExpireClient(tokenExpire)) {
			throw new RestExceptionHandler(Message.CLIENT_EXPIRE);
		}
		Token tokenInfo = tokenProvider.generateToken(userInfo.getUserName());
		List<Module> moduleAll = getAllModule(userInfo);
		AuthenResponse response = new AuthenResponse(tokenInfo, userInfo, moduleAll);
		log.info("Token info: " + tokenInfo.toString());

		userInfo.setLastLogin(new Date());
		userService.save(userInfo);

		straceService.save(userInfo.getId(), ActionEnum.LOGIN.getName(), userName, CategoryEnum.LOGIN.getValue(),
				userInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/login/cas")
	public ResponseEntity<?> authentication(@RequestParam String token) {
		String userName = tokenProvider.getUserIdFromJWT(token);
		User userInfo = userService.findByUserNameAndActive(userName, true);
		if (userInfo == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
		}
		Token tokenInfo = tokenProvider.generateToken(userInfo.getUserName());
		List<Module> moduleAll = getAllModule(userInfo);
		AuthenResponse response = new AuthenResponse(tokenInfo, userInfo, moduleAll);
		userInfo.setLastLogin(new Date());
		userService.save(userInfo);

		straceService.save(userInfo.getId(), ActionEnum.LOGIN.getName(), userName, CategoryEnum.LOGIN.getValue(),
				userInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/login/serial")
	public ResponseEntity<?> authenticationToken(@RequestBody String serialToken){
		if (StringUtils.isNullOrEmpty(serialToken))
			throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		User userInfo = userService.findBySerialTokenAndActiveTrue(serialToken);
		if (userInfo == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
		}
		Token tokenInfo = tokenProvider.generateToken(userInfo.getUserName());
		List<Module> moduleAll = getAllModule(userInfo);
		AuthenResponse response = new AuthenResponse(tokenInfo, userInfo, moduleAll);
		userInfo.setLastLogin(new Date());
		userService.save(userInfo);
		straceService.save(userInfo.getId(), ActionEnum.LOGIN.getName(), userInfo.getUserName(), CategoryEnum.LOGIN.getValue(),
				userInfo);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private List<Module> getAllModule(User userInfo) {
		List<Module> moduleOfUser = new ArrayList<>();
		List<Module> moduleOfUserClone = new ArrayList<>();
		List<Role> roleByUser = userService.findRoleByUserIdAndActive(userInfo, true, userInfo.getClientId());
		userInfo.setRoles(roleByUser);
		if (userInfo.getDefaultRole() == null) {
			moduleOfUser = moduleService.findByRoleList(roleByUser, null);
			userInfo.setCurrentRole(0L);
		} else {
			Role defaultRole = null;
			for (Role r : roleByUser) {
				if (r.getId() == userInfo.getDefaultRole()) {
					defaultRole = r;
					break;
				}
			}
			if (defaultRole != null) {
				List<Role> lr = new ArrayList<>();
				lr.add(defaultRole);
				moduleOfUser = moduleService.findByRoleList(lr, null);
				userInfo.setCurrentRole(defaultRole.getId());
			} else {
				moduleOfUser = moduleService.findByRoleList(roleByUser, null);
				userInfo.setCurrentRole(0L);
			}
		}
		for (Module m : moduleOfUser) {
			Module t = new Module();
			BeanUtils.copyProperties(m, t);
			moduleOfUserClone.add(t);
		}
		userInfo.setAuthorize(moduleOfUserClone);

		return moduleService.findByClientIdAndParentId(userInfo.getClientId(), null);
	}

	@GetMapping("/getModules/{roleId}")
	public ResponseEntity<?> getModules(@PathVariable Long roleId) {
		Optional<Role> r = roleService.findById(roleId);
		if (r.isPresent()) {
			List<Role> lr = new ArrayList<>();
			lr.add(r.get());
			List<Module> moduleOfUser = moduleService.findByRoleList(lr, null);
			return new ResponseEntity<>(moduleOfUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
	}

	@PostMapping("/registry")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		checkPermission();
		try {

			//valid user name + fullName
			BussinessCommon.validLengthData(user.getUserName(), "Tên đăng nhập", 200);
			BussinessCommon.validLengthData(user.getFullName(), "Họ và tên", 200);

			Long clientId = SecurityContext.getCurrentUser().getClientId();
			User userInfo = userService.findByUserNameAndClientId(user.getUserName(), clientId);
			if (userInfo != null)
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			user.setChangePass(false);
			user.setActive(true);
			user.setClientId(clientId);
			return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		checkPermission();
		try {
			//valid user name + fullName
			BussinessCommon.validLengthData(user.getUserName(), "Tên đăng nhập", 200);
			BussinessCommon.validLengthData(user.getFullName(), "Họ và tên", 200);

			Long clientId = SecurityContext.getCurrentUser().getClientId();
			User userInfo = userService.findByUserNameAndClientId(user.getUserName(), clientId);
			if (userInfo != null)
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			if (user.getOrg() == null)
				throw new RestExceptionHandler(Message.NOT_FOUND_ORG);
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(Constant.PASSWORD_DEFAULT));
			user.setChangePass(false);
			user.setActive(true);
			user.setClientId(clientId);
			user.setPositionModel(null);
			return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/userinfo")
	public ResponseEntity<?> getUserInfo() {
		try {
			return new ResponseEntity<>(userService.findById(SecurityContext.getCurrentUser().getId()), HttpStatus.OK);
		} catch (UnsupportedOperationException ex) {
			log.warn(" Exception get User infor", ex);
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping(value = "/oauth/password")
	public ResponseEntity<?> changePassword(@RequestParam String oPassword, @RequestParam String nPassword) {
		User userInfo = SecurityContext.getCurrentUser();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		if (userInfo != null && !userInfo.isLdap()) {
			if (encoder.matches(oPassword, userInfo.getPassword())) {
				userInfo.setPassword(encoder.encode(nPassword));
				userInfo.setChangePass(true);
				userInfo.setLastLogin(new Date());
				return new ResponseEntity<>(userService.save(userInfo), HttpStatus.OK);
			} else {
				throw new RestExceptionHandler(Message.PASSWORD_INCORRECT);
			}
		}
		throw new RestExceptionHandler(Message.INVALID_ACCOUNT);
	}

	@PutMapping("/authen/{id}")
	public ResponseEntity<User> updateUser(@PathVariable long id) {
		User user = userService.findById(id).get();
		user.setActive(!user.getActive());
		return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
	}

	@Override
	@PostMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User input) {
		boolean isAdmin = isAdmin(id);
		//valid user name + fullName
		BussinessCommon.validLengthData(input.getUserName(), "Tên đăng nhập", 200);
		BussinessCommon.validLengthData(input.getFullName(), "Họ và tên", 200);

		User data = getService().findByClientIdAndId(getClientId(), id);
		if (data == null || data.isLdap()) throw new RestExceptionHandler(Message.NOT_FOUND_USER);
		if (!data.getUserName().equals(input.getUserName())) {
			User userInfo = userService.findByUserNameAndClientId(input.getUserName(), getClientId());
			if (userInfo != null)
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		if (isAdmin) {
			data.setUser(input);
		} else {
			data.setUserLess(input);
		}

		return new ResponseEntity<>(userService.save(data), HttpStatus.OK);
	}

	@PostMapping("/updateDefaultRole")
	public ResponseEntity<?> updateDefaultRole(@RequestParam Long roleId) {
		List<Long> roleByUser = userService.findRoleIdByUserIdAndActive(BussinessCommon.getUser(), true,
				BussinessCommon.getClientId());
		if (!roleByUser.contains(roleId)) {
			return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
		}
		User data = getService().findByClientIdAndId(getClientId(), getCurrentUser().getId());
		if (data != null) {
			data.setDefaultRole(roleId);
		}
		data = getService().save(data);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	 @GetMapping(value = "/findUser")
	 public ResponseEntity<Page<User>> findUser(
	 		@PathParam(value = "fullName") String fullName,
	 		@PathParam(value = "userName") String userName, @PathParam(value = "email") String email,
	 		@PathParam(value = "phone") String phone, @PathParam(value = "sex") Long sex,
	 		@PathParam(value = "indentity") String indentity, @PathParam(value = "title") String title,
	 		@PathParam(value = "employeeId") String employeeId, @PathParam(value = "employeeCode") String employeeCode,
	 		@PathParam(value = "salt") String salt, @PathParam(value = "org") String org,
	 		@PathParam(value = "position") String position, @PathParam(value = "lead") Boolean lead,
	 		@PathParam(value = "birthday") @DateTimeFormat(iso = ISO.DATE) Date birthday,
	 		@RequestParam(defaultValue = "FULLNAME") SortBy sortBy,
	 		@RequestParam(defaultValue = "ASC") Direction direction,
	 		@RequestParam(defaultValue = "" + Constant.NUMBER_OF_PAGE) int size,
	 		@RequestParam(defaultValue = "1") int page) {
	 	fullName = StringUtils.handleSubmit(fullName);
	 	userName = StringUtils.handleSubmit(userName);
	 	email = StringUtils.handleSubmit(email);
	 	phone = StringUtils.handleSubmit(phone);
	 	indentity = StringUtils.handleSubmit(indentity);
	 	title = StringUtils.handleSubmit(title);
	 	employeeCode = StringUtils.handleSubmit(employeeCode);
	 	salt = StringUtils.handleSubmit(salt);
	 	Long employeeIdT = employeeId != null && employeeId.length() > 0 ? Long.parseLong(employeeId) : null;
	 	Long orgT = org != null && org.length() > 0 ? Long.parseLong(org) : null;
	 	Long positionT = position != null && position.length() > 0 ? Long.parseLong(position) : null;
	 	Date birthdayT = birthday != null && birthday.toString().length() > 0 ? birthday : null;
	 	Sort sort = Sort.by(direction, sortBy.field);
	 	Pageable pageable = PageRequest.of(page - 1, size, sort);
	 	return new ResponseEntity<>(userService.findUser(fullName, userName, email, phone, sex, indentity, title,
	 			employeeIdT, employeeCode, salt, orgT, positionT, lead, birthdayT, pageable), HttpStatus.OK);
	 }

	@GetMapping("/findListUserByPosition/{positionId}")
	public ResponseEntity<?> findListUserByPosition(@PathVariable Long positionId) {
		catService.validPositionId(positionId);
		return new ResponseEntity<>(userService.findListUserByPosition(positionId), HttpStatus.OK);
	}

	@GetMapping("/findListUserByOrg/{orgId}")
	public ResponseEntity<?> findListUserByOrg(@PathVariable Long orgId) {
		orgService.validOrgId(orgId);
		return new ResponseEntity<>(userService.findByOrgIdAndClientId(orgId, BussinessCommon.getClientId()),
				HttpStatus.OK);
	}

	

//	@GetMapping("/findListDelegateUser/{userId}")
//	public ResponseEntity<?> findListDelegateUser(@PathVariable Long userId) {
//		return new ResponseEntity<>(userService.findListNguoiDuocUyQuyen(userId), HttpStatus.OK);
//	}

	@PostMapping("/all-user-in-org")
	public ResponseEntity<List<User>> allUserInOrg(@RequestParam("textSearch") String textSearch) {
		Long orgId = BussinessCommon.getUser().getOrg();
		if (textSearch == null || textSearch.length() == 0 || textSearch.equals("undefined")) {
			textSearch = "";
		}
		textSearch = textSearch.toLowerCase();
		return new ResponseEntity<>(userService.allUserInOrg(orgId, textSearch), HttpStatus.OK);
	}

	@Override
	@GetMapping("/getAllSort/{direction}/{column}")
	public ResponseEntity<?> getByClientIdAndSort(@PathVariable String direction,
			@RequestParam(required = false, defaultValue = "true") Boolean active, @PathVariable String column) {
		return new ResponseEntity<>(userService.getByClientIdAndActiveAndSort(direction, active, column),
				HttpStatus.OK);
	}

	@GetMapping("/getAllOrder")
	public ResponseEntity<List<UserTreeDto>> getAllOrder() {
		return new ResponseEntity<>(userService.getAllOrder(), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllUser")
	public ResponseEntity<?> getAllUser(@PathParam(value = "page") Integer page) {
		return new ResponseEntity<>(userService.getAllUser(page), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllUserByLead")
	public ResponseEntity<?> getAllUserByLead() {
		return new ResponseEntity<>(userService.getAllUserByLead(), HttpStatus.OK);
	}

	@GetMapping(value = "/get_all_user")
	public ResponseEntity<?> getAllUserDtoByActive() {
		return new ResponseEntity<>(userService.getAllUserDtoByActive(), HttpStatus.OK);
	}

	@PostMapping(value = "/findByUserName")
	public ResponseEntity<?> findByUserName(@PathParam(value = "userName") String userName) {
		return new ResponseEntity<>(userService.findByUserName(userName), HttpStatus.OK);
	}

	@GetMapping("/switchRole/{roleId}")
	public ResponseEntity<?> switchRole(@PathVariable Long roleId) {
		List<Long> roleByUser = userService.findRoleIdByUserIdAndActive(BussinessCommon.getUser(), true,
				BussinessCommon.getClientId());
		if (roleByUser.contains(roleId)) {
			List<Module> moduleOfUser = moduleService.findByRoleIdList(Arrays.asList(roleId), null);
			userService.setCurrentRole(BussinessCommon.getUserId(), roleId);
			return new ResponseEntity<>(moduleOfUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
	}

	@Override
	@GetMapping("/active/{id}")
	public ResponseEntity<?> active(@PathVariable Long id) {
		checkPermission();
		User data = getService().findByClientIdAndId(getClientId(), id);
		if (!orgService.existsByIdAndActive(data.getOrg(), true))
			throw new RestExceptionHandler("Đơn vị không tồn tại hoặc không còn hoạt động");
		if (data == null || (data.getActive() != null && data.getActive())) {
			log.error("Data object is null");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			data.setActive(true);
			data = getService().save(data);
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
	}

	@Override
	@GetMapping("/deactive/{id}")
	public ResponseEntity<?> deactive(@PathVariable Long id) {
		checkPermission();
		User data = getService().findByClientIdAndId(getClientId(), id);
		if (data == null || !data.getActive()) {
			log.error("Data object is null");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			data.setActive(false);
			data = getService().save(data);
			return new ResponseEntity<>(data, HttpStatus.OK);
		}
	}
}
