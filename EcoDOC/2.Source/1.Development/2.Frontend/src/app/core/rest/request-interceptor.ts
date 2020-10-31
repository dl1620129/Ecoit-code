import {HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Router} from '@angular/router';
import {SharedPreferences} from "../config/shared-preferences";
import {Injectable} from "@angular/core";
@Injectable({providedIn: 'root'})
export class RequestInterceptor implements HttpInterceptor {
  constructor(private router: Router) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    let requestOption: any = {};
    console.log('RequestInterceptor');
    let tokenValue = localStorage.getItem('token');
    //let tokenValue = 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWV1Y2F5IiwiaWF0IjoxNTg5MTE2OTg5LCJleHAiOjE1ODkzNzYxODl9.GNboixbWj1EUr8L0FqEOoQ6NMmSczekZ24yLsSClYQHP6uchgLSv9YT8_f4pIbeqagaz3S8BmlSYGR33Px4SaA';
    const headerConfig = {};
    if (tokenValue) {
      headerConfig['Authorization'] = `Bearer ${tokenValue}`;
    }
    headerConfig['Access-Control-Allow-Methods'] = 'GET, POST, OPTIONS, PUT, PATCH, DELETE';
    headerConfig['Access-Control-Allow-Headers'] = 'X-Requested-With,content-type';
    headerConfig['Access-Control-Allow-Origin'] = '*';
    headerConfig['Access-Control-Allow-Credentials'] = 'true';

    request = request.clone({
      setHeaders: headerConfig
    });
    return next.handle(request);
  }
}
