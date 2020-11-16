import {  Routes } from '@angular/router';
import { DocumentListComponent } from './document-list/document-list.component';
import { DocumentViewFile } from './document-view-file/document-view-file.component';
import { FolderManagerComponent } from './folder-manager/folder-manager.component';

export const DocumentRoute: Routes = [
  {
    path: 'folder',
    children: [
      {
        path: '',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: '', url: '/' },
          ]
        }
      },
      {
        path: ':id',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: '', url: '/' },
          ]
        }
      }
    ]
  },
  {
    path: 'thuthap',
    children: [
      {
        path: ':id',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: 'Danh sách thư mục', url: '/' },
          ]
        }
      },
      {
        path: ':id',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: 'Danh sách thư mục', url: '/' },
          ]
        }
      }
    ]
  },
  {
    path: 'bienmuc-chinhly',
    children: [
      {
        path: ':id',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: 'Danh sách thư mục', url: '/' },
          ]
        }
      },
      {
        path: ':id',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: 'Danh sách thư mục', url: '/' },
          ]
        }
      }
    ]
  },
  {
    path: 'fileview/:id',
    component: DocumentViewFile,
    data: {
      title: 'Thư mục',
      urls: [
        {title: 'Danh sách thư mục', url: '/'},
      ]
    }
  },
  {
    path: 'luuthong',
    children: [
      {
        path: '',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: 'Danh sách thư mục', url: '/' },
          ]
        }
      },
      {
        path: ':id',
        component: DocumentListComponent,
        data: {
          title: 'Thư mục',
          urls: [
            { title: 'Danh sách thư mục', url: '/' },
          ]
        }
      }
    ]
  }
]