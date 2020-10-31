import {Component, AfterViewInit, OnInit} from '@angular/core';
import {Router, ActivatedRoute,NavigationExtras} from '@angular/router';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { TokenService } from 'src/app/core/authen/token.service';
import { PermissionService } from 'src/app/services/permission.service';
import { User } from 'src/app/core/model/domain/user';
import { SidebarService } from 'src/app/core/authen/sidebar.service';
import { UserService } from 'src/app/services/user.service';
import {HttpParams} from '@angular/common/http';


declare var $: any;

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  showMenu = 'DASHBOARD';
  showSubMenu = '';
  public sidebarnavItems: any[];
  user = new User();
  searchUserList: any;

  addExpandClass(element: any) {
    if (element === this.showMenu) {
      this.showMenu = '0';
    } else {
      this.showMenu = element;
    }
  }

  addActiveClass(element: any) {
    if (element === this.showSubMenu) {
      // this.showSubMenu = '0';
    } else {
      this.showSubMenu = element;
      this.sidebarService.setMenuSideBar(this.showMenu);
    }
  }
  userLogin:User;
  constructor(
    private modalService: NgbModal,
    private router: Router,
    private route: ActivatedRoute,
    private tokenService: TokenService,
    private sidebarService: SidebarService,
    private userService: UserService,
  ) {
  }
  logout() {
    this.tokenService.logout();
  }

  ngOnInit() {
    this.getall();
    this.getMenu();
    this.showMenu = this.sidebarService.getMenuSideBar() != null ? this.sidebarService.getMenuSideBar() : 'DASHBOARD';
    this.userLogin = JSON.parse(this.tokenService.getUserInfo());
  }

  getMenu() {
    let data = this.tokenService.getModules();
    if (data != null && data != undefined) {
      this.sidebarnavItems = JSON.parse(data);
    }
  }

  goToCurrentUserEditPageInfor() {
    if (localStorage.userInfo) {
      this.userService.goToEditPageInfo(JSON.parse(localStorage.userInfo).userName, false)
    }
  }

  getall(){
    let params = new HttpParams();
    this.userService.searchUser(params).subscribe(
      data => {
        this.searchUserList = data.content[0];
        console.log("cc")
        console.log(this.searchUserList)
      }
    );
  }
  onUpdateUser(user) {
    // const dialogConfig = new MatDialogConfig();
    // dialogConfig.autoFocus = true;
    // dialogConfig.disableClose = true;
    // dialogConfig.width = '50%';
    //dialogConfig.data = user;
    const navigationExtras: NavigationExtras = { 
      state: user
    }
    console.log(this.userLogin)
    this.router.navigate(['edit',user.userName])
    console.log(this.userLogin)
    // this.dialog.open(UserComponent, dialogConfig).afterClosed().subscribe(res => {
    //   this.onSearch(false);
    // });
  }


}
