import {User} from '../domain/user';
import {BaseResponse} from './base-response';

export class LoginResponse extends BaseResponse {
  public data: User;
}
