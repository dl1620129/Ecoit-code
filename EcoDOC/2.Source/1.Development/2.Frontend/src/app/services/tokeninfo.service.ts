import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
import { CommonUtils } from "../core/common/common-utils";
import { Constant } from "../core/config/constant";
import { ApiHelper } from "../core/rest/api-helper";
import { SharedService } from "./shared.service";
import {map} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class TokenInfoService {
    private webSocket: WebSocket = null;
    private isConnect = false;
    private callbackFunction = null;
    private callFunction = null;

    constructor(
        private shareService: SharedService,
        private http: HttpClient,
        private commonUtils: CommonUtils,
        private apiHelper: ApiHelper,
        private translateService: TranslateService
    ) {
    }
    
    connectWebSocket(_callFunction) {
        this.callFunction = _callFunction;
        this.webSocket = new WebSocket('ws://localhost:9999/GetTokenInfo');
        this.webSocket.onopen = () => {
          this.isConnect = true;
          if (this.callFunction != null) {
            this.callFunction();
            this.callFunction = null;
          }
        };
  
        this.webSocket.onmessage = (event) => {
          if (this.callbackFunction != null) {
              this.callbackFunction(event.data);
              this.callbackFunction = null;
          }
        };
  
        this.webSocket.onclose = () => {
          this.resetConnect();
          this.resetCallback();
        };
  
        this.webSocket.onerror = () => {
          if (this.callFunction != null) {
            this.callFunction('-100');
          }
          this.resetConnect();
          this.resetCallback();
        };
    }

    sendMessage(message) {
        console.log(message);
        this.webSocket.send(message);
    }

    sendObject(object) {
        const json = JSON.stringify(object);
        this.webSocket.send(this.shareService.b64EncodeUnicode(json));
    }

    getTokenInfo(_callbackFunction) {
        if (this.isConnect && this.webSocket != null) {
          this.sendMessage('GetTokenInfo');
          if (this.callbackFunction == null) {
            this.callbackFunction = _callbackFunction;
          } else {
            this.commonUtils.showPopupOK(this.translateService.instant('signature.sign-in-progess'));
          }
        } else {
          this.connectWebSocket((data) => {
            if (data !== '-100') {
              this.getTokenInfo(_callbackFunction);
            } else {
              this.commonUtils.showPopupOK(this.translateService.instant('signature.sign-no-connect'));
              _callbackFunction(data);
            }
    
          });
        }
    }

    LoginBySerial(serialToken : string) {
      return this.apiHelper.post(Constant.API_AUTHEN_SERIAL, serialToken).pipe(map(res => res.data));
    }

    public b64EncodeUnicode(str: string): string {
        if (window
            && 'btoa' in window
            && 'encodeURIComponent' in window) {
            return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, (match, p1) => {
                return String.fromCharCode(('0x' + p1) as any);
            }));
        } else {
            console.warn('b64EncodeUnicode requirements: window.btoa and window.encodeURIComponent functions');
            return null;
        }
    
    }

    public b64DecodeUnicode(str: string): string {
        if (window
            && 'atob' in window
            && 'decodeURIComponent' in window) {
            return decodeURIComponent(Array.prototype.map.call(atob(str), (c) => {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));
        } else {
            console.warn('b64DecodeUnicode requirements: window.atob and window.decodeURIComponent functions');
            return null;
        }
    }

    resetConnect() {
        this.webSocket = null;
        this.isConnect = false;
      }
    
    resetCallback() {
        this.callbackFunction = null;
    }
}