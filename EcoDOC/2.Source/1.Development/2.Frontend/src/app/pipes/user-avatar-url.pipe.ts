import {Pipe, PipeTransform} from '@angular/core';
import {TokenService} from "../core/authen/token.service";
import {User} from "../core/model/domain/user";
import {Constant} from "../core/config/constant";

@Pipe({
  name: 'userAvatarUrl',
  pure: false,
})
export class UserAvatarUrlPipe implements PipeTransform {
  userLogin: any;
  constructor(
    private tokenService: TokenService,
  ) {}
  transform(user: User): string {
    this.tokenService.userAvatar = JSON.parse(this.tokenService.getUserInfo());
    if (!user.photo) {
      return user.gender ? '/assets/images/users/girl-no-avatar.png' : '/assets/images/users/boy-no-photo.jpg';
    }
    if (/http/.exec(user.photo) == null) {
      return `${Constant.API_ENDPOINT}/files/avatar/${user.photo}`;
    }
    return user.photo;
  }
}
