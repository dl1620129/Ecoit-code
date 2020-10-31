import {HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {SharedPreferences} from '../config/shared-preferences';
import { Constant } from '../config/constant';
import { TokenService } from 'src/app/core/authen/token.service';
import {Injectable} from '@angular/core';
@Injectable({providedIn: 'root'})
export class ErrorInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private toastr: ToastrService,
    private tokenService: TokenService,
    ) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    return next.handle(request).pipe(catchError(err => {
      console.log('ErrorInterceptor: ' + JSON.stringify(err));
      let error = err.error.message || err.error.statusText;
      // this.toastr.error(err.error.message, "Lỗi");
      if (err.status === 403) {
        // call logout
        this.tokenService.logout();
        // this.router.navigate(['/login']);
      } else if (err.status === 0) {
        error = 'Internal Error Server';
      } else if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
        return throwError(err);
      } else {
        error = err.error.message || err.error.statusText;
      }

      if (err.status != 404) {
        this.toastr.error(error);
        return throwError(err);
      }
      SharedPreferences.IS_LOADING_CONTEN = false;
      // return throwError(error);
      this.toastr.error(error);
      return throwError(err);
    }));
  }
}
