package com.ecodoc.backend.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecodoc.backend.core.common.BussinessCommon;
import com.ecodoc.backend.core.config.Constant;
import com.ecodoc.backend.core.config.Message;
import com.ecodoc.backend.core.domain.Category;
import com.ecodoc.backend.core.domain.CategoryType;
import com.ecodoc.backend.core.domain.Organization;
import com.ecodoc.backend.core.domain.User;
import com.ecodoc.backend.core.dto.CategoryDto;
import com.ecodoc.backend.core.dto.CategoryInitDto;
import com.ecodoc.backend.core.dto.ListObjectDtoOrder;
import com.ecodoc.backend.core.exception.RestExceptionHandler;
import com.ecodoc.backend.core.exception.RestFieldExceptionHandler;
import com.ecodoc.backend.core.repository.ICategoryRepository;
import com.ecodoc.backend.core.repository.IRepository;
import com.ecodoc.backend.core.repository.OrganizationRepository;

@Service
public class CategoryService extends BaseService<Category>{

	@Autowired
	private OrganizationRepository orgRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	CategoryTypeService catTypeService;

	@Autowired
	OrganizationService orgService;

	@Autowired
	UserService uService;

	@Override
	public IRepository<Category> getRepository() {
		return categoryRepository;
	}

	public Category findByClientIdAndName(Long clientId, String name) {
		return categoryRepository.findByClientIdAndName(clientId, name);
	}

	public Category findByClientIdAndNameAndCategoryTypeId(Long clientId, String name, Long type) {
		List<Category> cList = categoryRepository.findByClientIdAndNameAndCategoryTypeId(clientId, name, type);
		return cList.isEmpty() ? null : cList.get(0);
	}

	public List<Category> findByClientIdAndCategoryTypeId(Long clientId, long categoryTypeId, Sort sort) {
		return categoryRepository.findByClientIdAndCategoryTypeId(clientId, categoryTypeId, sort);
	}

	public List<Category> findByClientIdAndCategoryTypeIdAndActive(Long clientId, long categoryTypeId, boolean active, Sort sort) {
		return categoryRepository.findByClientIdAndCategoryTypeIdAndActive(clientId, categoryTypeId, active, sort);
	}

	public ListObjectDtoOrder<Category> findByClientIdAndCategoryTypeId(String name, Boolean active,
			Long id, Long categoryTypeId, Pageable pageable) {
		if (!(name == null || "".equals(name))) {
			name = name.trim().toLowerCase();
		}

		Page<Category> cPage = categoryRepository.findByClientIdAndCategoryTypeId(name, active, id,
				categoryTypeId, BussinessCommon.getClientId(), pageable);
		Long preMax = categoryRepository.getMaxOrderByCategoryType(BussinessCommon.getClientId(), categoryTypeId);
		long max = 0;
		if (preMax != null) {
			max = preMax.longValue();
		}
		return BussinessCommon.paging(cPage, max);
	}

	public List<Category> findByClientIdAndCategoryCodeAndOrgId(String code) {
		return categoryRepository.findByClientIdAndCategoryCodeAndOrgId(code, BussinessCommon.getClientId());
	}

	public void validPositionId(long id) {
		CategoryType type = catTypeService.findByClientIdAndCode(BussinessCommon.getClientId(), Constant.CAT_POSITION) ;
		if(type == null) throw new RestExceptionHandler(Message.NOT_FOUND_POSITION);
		List<Category> cList =  findByClientIdAndCategoryTypeId(BussinessCommon.getClientId(),type.getId(), null);
		List<Long> lList = new ArrayList<>();
		cList.stream().forEach(i->{
			lList.add(i.getId());
		});
		if(!lList.contains(id)) throw new RestExceptionHandler(Message.NOT_FOUND_POSITION);
	}

	public List<CategoryDto> findPosition(Long orgId) {
		Organization org = orgRepository.findByClientIdAndId(BussinessCommon.getClientId(), orgId);
		if (org == null) {
			org = orgRepository.findByClientIdAndActiveAndParentId(BussinessCommon.getClientId(), true, null);
		}
		List<Category> cList = findByClientIdAndCategoryCodeAndOrgId(Constant.CAT_POSITION);
		List<CategoryDto> dtoList = new ArrayList<>();
		int j = 0;
		for (Category ct : cList) {
			CategoryDto dto = new CategoryDto();
			dto.setPositionId(ct.getId());
			dto.setPositionName(ct.getName());
			dto.setPositionOrder(ct.getOrder());
			dto.setNo(++j);
			if(org != null) {
				dto.setOrgId(org.getId());
				dto.setOrgName(org.getName());
			}
			dtoList.add(dto);
		}
		dtoList.sort((CategoryDto a, CategoryDto b) -> {
			int i = toInt(a.getPositionOrder()) - toInt(b.getPositionOrder());
			if (i != 0) {
				return i;
			}
			return a.getPositionName().compareToIgnoreCase(b.getPositionName());
		});
		return dtoList;
	}

	// TODO: utils
	private int toInt(Integer input) {
		if (input == null) {
			return 0;
		}
		return input.intValue();
	}

	public Category save1(Category input) {
		if (input == null || input.getName() == null || input.getName().trim().length() == 0
				|| input.getCategoryTypeId() == null) {
			throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		}

		//valid name
		BussinessCommon.validLengthData(input.getName(), "Tên danh mục", 200);

		String name = input.getName().trim();
		input.setName(name);
		Category c = findByClientIdAndNameAndCategoryTypeId(BussinessCommon.getClientId(), name, input.getCategoryTypeId());
		if (c != null) throw new RestFieldExceptionHandler("name", Message.EXIST_CATEGORY);

		if(input.getOrder() == null) input.setOrder(1);
		return categoryRepository.save(input);
	}

	public List<Category> findByClientIdAndCategoryTypeId(Long[] categoryTypeIds) {
		return categoryRepository.findByClientIdAndCategoryTypeIdAndActive(BussinessCommon.getClientId(), categoryTypeIds, true);
	}

	public List<Category> getCategoryByCode(List<CategoryType> tlist, List<Category> cList, String code) {
		if(tlist == null || cList == null) return null;
		List<Category> rsList = new ArrayList<>();
		Optional<CategoryType> type = tlist.stream().filter(t -> t.getCode().equals(code)).findFirst();
		if (type.isPresent()) {
			rsList = cList.stream().filter(c -> c.getCategoryTypeId().equals(type.get().getId())).collect(Collectors.toList());
		}
		return rsList;
	}

	public List<Category> getListCategoriesByCode(String[] codes) {
		List<CategoryType> catTypeList = catTypeService.getListCategoriesTypeByCode(codes);
		List<Long> catTypeIdList = catTypeList.stream().map(CategoryType::getId).collect(Collectors.toList());
		Long[] catTypeIdArr = catTypeIdList.stream().toArray(Long[]::new);
		List<Category> catList = findByClientIdAndCategoryTypeId(catTypeIdArr);
		if (catList == null) throw new RestExceptionHandler(Message.ERROR_SYS);
		return catList;
	}

	public List<CategoryInitDto> castToCategoryInitDto(List<Category> cList) {
		if (cList == null)  return null;
		List<CategoryInitDto> dtoList = new ArrayList<>();
		cList.stream().forEach(c -> {
			CategoryInitDto dto = new CategoryInitDto();
			dto.setId(c.getId());
			dto.setName(c.getName());
			dtoList.add(dto);
		});
		return dtoList;
	}

	public List<CategoryInitDto> getCategoryInitDtoByCode (List<Category> cList, List<CategoryType> tlist, String code) {
		return castToCategoryInitDto(getCategoryByCode(tlist, cList, code));
	}

	public Category validCatId(Long catId) {
		User u = BussinessCommon.getUser();
		if (catId == null) throw new RestExceptionHandler(Message.NO_INPUT_DATA);
		Category cat = findByClientIdAndId(u.getClientId(), catId);
		if (cat == null) throw new RestExceptionHandler(Message.ERROR_SYS);
		return cat;
	}

	public Category findCatByName(String name) {
		Category cat = findByClientIdAndName(BussinessCommon.getClientId(), name);
		if (cat == null) throw new RestExceptionHandler(Message.ERROR_SYS);
		return cat;
	}

	public Category findByName(String name) {
		return findByClientIdAndName(BussinessCommon.getClientId(), name);
	}

	public Category update(Category input, Long id) {
		Category old = findByClientIdAndId(BussinessCommon.getClientId(), id);
		if (old == null) throw new RestExceptionHandler(Message.NOT_FOUND_CATEGORY);
		//valid name
		BussinessCommon.validLengthData(input.getName(), "Tên danh mục", 200);
		String name = input.getName().trim();
		if(!old.getName().equals(name)) {
			Category c = findByClientIdAndNameAndCategoryTypeId(BussinessCommon.getClientId(), name, old.getCategoryTypeId());
			if (c != null) throw new RestFieldExceptionHandler("name", Message.EXIST_CATEGORY);
		}
		old.setName(name);
		if(input.getOrder() == null) {
			old.setOrder(1);
		} else {
			old.setOrder(input.getOrder());
		}
		return categoryRepository.save(old);
	}
}
