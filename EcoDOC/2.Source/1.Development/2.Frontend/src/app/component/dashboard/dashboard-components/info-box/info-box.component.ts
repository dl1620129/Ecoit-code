import {Component, AfterViewInit, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import * as c3 from 'c3';
import { TokenService } from 'src/app/core/authen/token.service';

@Component({
  selector: 'app-info-box',
  templateUrl: './info-box.component.html',
  styleUrls: ['./info-box.component.css']
})
export class InfoBoxComponent implements OnInit {
  constructor(
    private router: Router,
    private tokenService: TokenService
    ) {
  }

  documentInWait = 0;
  documentOutWait = 0;
  taskWait = 0;

  ngOnInit() {
 
  }
  doGotoDocumentList(type){
    console.log('doGotoDocumentList : ', type);
    let submodule = JSON.parse(this.tokenService.getLocalSubModulePath());
    switch (type) {
      case 'OUT':
        let docout = submodule.find(x => x == '/document-out/main');
        if(docout) {
          this.router.navigate(['/document-out/main']);
        } else {
          console.log('doGotoDocumentList : No permission'); 
        }
        break;
      case 'IN':
        let docin = submodule.find(x => x == '/document-in/draft-handle');
        if(docin) {
          this.router.navigate(['/document-in/draft-handle']);
        } else {
          console.log('doGotoDocumentList : No permission');
        }
        break;
      default:
        break;
    }
  }
}
