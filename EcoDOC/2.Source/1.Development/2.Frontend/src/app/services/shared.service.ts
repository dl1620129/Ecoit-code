import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Comments } from '../core/model/domain/comments';
import { TokenService } from '../core/authen/token.service';
@Injectable({
providedIn: 'root'
})
export class SharedService {
  public currentMenuDocumentIn = null;
  public currentTabDocumentIn = null;

  constructor(
    private tokenService: TokenService
  ) {
  }

  isOfCurrentUser(userId: number) {
    if (localStorage.userInfo) {
      if(JSON.parse(localStorage.userInfo).id == userId) {
        return true
      }
    }
    return false
  }

  isCurrentUsername(userName: String) {
    console.log('currentUserName', userName, JSON.parse(localStorage.userInfo).userName )
    if (localStorage.userInfo) {
      if(JSON.parse(localStorage.userInfo).userName == userName) {
        return true
      }
    }
    return false
  }

  setCurrentMenuDocIn(menu) {
    this.currentMenuDocumentIn = menu;
    localStorage.setItem('currentMenuDocIn', menu);
  }

  setCurrentTabDocIn(tab) {
    this.currentTabDocumentIn = tab;
    localStorage.setItem('currentTabDocIn', tab);
  }

  loadCurrentMenuTab() {
    if (this.currentMenuDocumentIn == null || this.currentTabDocumentIn == null) {
      this.currentMenuDocumentIn = localStorage.getItem('currentMenuDocIn');
      this.currentTabDocumentIn = localStorage.getItem('currentTabDocIn');
    }
  }

  isInSignList(listSignIds) {
    console.log(listSignIds)
    if (listSignIds) {
      const userId = JSON.parse(this.tokenService.getUserInfo()).id;
      for (let id of listSignIds) {
        console.log(id)
        if (id == userId) return true;
      }
    }
    return false;
  }

  public b64EncodeUnicode(str: string): string {
    if (window
        && "btoa" in window
        && "encodeURIComponent" in window) {
        return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, (match, p1) => {
            return String.fromCharCode(("0x" + p1) as any);
        }));
    } else {
        console.warn("b64EncodeUnicode requirements: window.btoa and window.encodeURIComponent functions");
        return null;
    }

  }
  
  public b64DecodeUnicode(str: string): string {
      if (window
          && "atob" in window
          && "decodeURIComponent" in window) {
          return decodeURIComponent(Array.prototype.map.call(atob(str), (c) => {
              return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
          }).join(""));
      } else {
          console.warn("b64DecodeUnicode requirements: window.atob and window.decodeURIComponent functions");
          return null;
      }
  }

  setDelegateTab(tab) {
    localStorage.setItem('currentDelegateTab', tab);
  }
  loadDelegateTab() {
    return localStorage.getItem('currentDelegateTab');
  }
  removeDelegateTab() {
    localStorage.removeItem('currentDelegateTab');
  }
}
