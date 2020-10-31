import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class GetTokenInfoService {

  private webSocket: WebSocket = null;
  private isConnect = false;
  private callbackFunction: (arg0: any) => void = null;
  private callFunction: (arg0: string) => void = null;

  constructor(
    // private shareService: SharedService,
    // private commonUtils: CommonUtils,
    // private translateService: TranslateService
  ) { 
  }

  connectWebSocket(_callFunction: { (data: any): void; (arg0: string): void; }) {
      this.callFunction = _callFunction;
      this.webSocket = new WebSocket("ws://localhost:9999/GetTokenInfo");
      this.webSocket.onopen = () => {
        this.isConnect = true;
        if (this.callFunction != null) {
          this.callFunction("");
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
          this.callFunction("-100");
        }
        this.resetConnect();
        this.resetCallback();
      }
  }

  sendMessage(message: string | ArrayBuffer | Blob | ArrayBufferView) {
    this.webSocket.send(message);
  }

  sendObject(object: any) {
    // let json = JSON.stringify(object);
    // this.webSocket.send(this.shareService.b64EncodeUnicode(json));
    this.webSocket.send(JSON.stringify(object));
  }

  getTokenInfo(_callbackFunction: { (arg0: any): void; (arg0: any): void; }) {
    if (this.isConnect && this.webSocket != null) {
      if (this.callbackFunction == null) {
        this.sendMessage("GetTokenInfo");
        this.callbackFunction = _callbackFunction; 
      } else {
        // this.commonUtils.showPopupOK(this.translateService.instant('signature.sign-in-progess'));
        alert('Bạn chưa có xác thực ký số. Hãy xác thực');
      }
    } else {
      this.connectWebSocket((data: string) => {
        if (data !== "-100") {
          this.getTokenInfo(_callbackFunction);
        } else {
          _callbackFunction(data);
        }
        
      });
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