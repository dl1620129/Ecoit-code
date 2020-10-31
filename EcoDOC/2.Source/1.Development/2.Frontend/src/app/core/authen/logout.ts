import {Injectable} from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {TokenService} from './token.service';

@Injectable({providedIn: 'root'})
export class Logout implements CanActivate {

  constructor(private router: Router, private tokenService: TokenService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log('call log out from link');
    this.tokenService.logout();
    return false;
  }
}
