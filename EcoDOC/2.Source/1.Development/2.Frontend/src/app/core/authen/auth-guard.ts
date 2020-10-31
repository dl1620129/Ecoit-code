import {Injectable} from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {TokenService} from './token.service';
import {Constant} from '../config/constant';

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {

  constructor(private router: Router, private tokenService: TokenService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.tokenService.checkAuthentication()) {
      this.tokenService.subModulePath = JSON.parse(this.tokenService.getLocalSubModulePath());
      return true;
    }
    if (Constant.AUTHEN_CAS) {
      window.location.href = Constant.LOGIN;
    } else {
      this.router.navigateByUrl('/login');
    }
  }
}
