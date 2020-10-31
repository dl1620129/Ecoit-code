import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SidebarService {

  constructor() { }
  getMenuSideBar() {
    return localStorage.getItem('menuSideBar');
  }

  setMenuSideBar(menuSideBar: string) {
    localStorage.setItem('menuSideBar', menuSideBar);
  }

  removeMenuSideBar() {
    localStorage.removeItem('menuSideBar');
  }
}
