import {Injectable} from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {TokenService} from './token.service';

@Injectable({providedIn: 'root'})
export class SubmoduleGuard implements CanActivate {
  routerPath = [];

  constructor(private router: Router, private tokenService: TokenService) {
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    // Do Check user submodule in local storage
    // console.log(route, state.url, this.tokenService.subModulePath);
    for (let i = 0; i < this.tokenService.subModulePath.length; i++){
      // console.log('state.url.indexOf(this.tokenService.subModulePath[i] : ', state.url.indexOf(this.tokenService.subModulePath[i]), this.tokenService.subModulePath[i]);
      if(state.url.indexOf(this.tokenService.subModulePath[i]) > -1) {
        return true;
      }
    }
    this.router.navigate(['**']);
  }
}
