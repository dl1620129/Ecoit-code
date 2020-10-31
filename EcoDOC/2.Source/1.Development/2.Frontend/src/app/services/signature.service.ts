import { Injectable } from '@angular/core';
import { SharedService } from './shared.service';
import { CommonUtils } from '../core/common/common-utils';
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root'
})
export class SignatureService {

  private webSocket = null;
  private isConnect = false;
  private callbackFunction = null;
  private callFunction = null;

  constructor(
    private shareService: SharedService,
    private commonUtils: CommonUtils,
    private translateService: TranslateService
  ) { 
  }

  connectSignService(_callFunction) {
      this.callFunction = _callFunction;
      this.webSocket = new WebSocket("ws://localhost:9999/PDFSign");
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
          this.callFunction("-100");
        }
        this.resetConnect();
        this.resetCallback();
      }
  }

  sendMessage(message) {
    console.log(message)
    this.webSocket.send(message);
  }

  sendObject(object) {
    let json = JSON.stringify(object);
    this.webSocket.send(this.shareService.b64EncodeUnicode(json));
  }

  signPdfFile(params, _callbackFunction) {
    if (this.isConnect && this.webSocket != null) {
      if (this.callbackFunction == null) {
        this.callbackFunction = _callbackFunction; 
        this.sendObject(params);
      } else {
        this.commonUtils.showPopupOK(this.translateService.instant('signature.sign-in-progess'));
      }
    } else {
      this.connectSignService((data) => {
        if (data !== "-100") {
          this.signPdfFile(params, _callbackFunction);
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

@Injectable({
  providedIn: 'root'
})
export class GetTokenInfoService {

  private webSocket: WebSocket = null;
  private isConnect = false;
  private callbackFunction = null;
  private callFunction = null;

  constructor(
    private shareService: SharedService,
    private commonUtils: CommonUtils,
    private translateService: TranslateService
  ) { 
  }

  connectWebSocket(_callFunction) {
      this.callFunction = _callFunction;
      this.webSocket = new WebSocket("ws://localhost:9999/GetTokenInfo");
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
          this.callFunction("-100");
        }
        this.resetConnect();
        this.resetCallback();
      }
  }

  sendMessage(message) {
    console.log(message)
    this.webSocket.send(message);
  }

  sendObject(object) {
    let json = JSON.stringify(object);
    this.webSocket.send(this.shareService.b64EncodeUnicode(json));
  }

  getTokenInfo(_callbackFunction) {
    if (this.isConnect && this.webSocket != null) {
      this.sendMessage("GetTokenInfo");
      if (this.callbackFunction == null) {
        this.callbackFunction = _callbackFunction; 
      } else {
        this.commonUtils.showPopupOK(this.translateService.instant('signature.sign-in-progess'));
      }
    } else {
      this.connectWebSocket((data) => {
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

@Injectable({
  providedIn: 'root'
})
export class ViewFileService {

  private webSocket:WebSocket = null;
  private isConnect = false;
  private callbackFunction = null;
  private callFunction = null;

  constructor(
    private shareService: SharedService,
    private commonUtils: CommonUtils,
    private translateService: TranslateService
  ) { 
  }

  connectWebSocket(_callFunction) {
      this.callFunction = _callFunction;
      this.webSocket = new WebSocket("ws://localhost:9999/ViewWordFile");
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
          this.callFunction("-100");
        }
        this.resetConnect();
        this.resetCallback();
      }
  }

  sendMessage(message) {
    console.log(message)
    this.webSocket.send(message);
  }

  sendObject(object) {
    let json = JSON.stringify(object);
    this.webSocket.send(this.shareService.b64EncodeUnicode(json));
  }

  viewDocFile(params, _callbackFunction) {
    if (this.isConnect && this.webSocket != null) {
      if (this.callbackFunction == null) {
        this.callbackFunction = _callbackFunction; 
        this.sendObject(params);
      } else {
        this.commonUtils.showPopupOK(this.translateService.instant('file.open-or-edit-in-progress'));
      }
    } else {
      this.connectWebSocket((data) => {
        if (data !== "-100") {
          this.viewDocFile(params, _callbackFunction);
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

@Injectable({
  providedIn: 'root'
})
export class EditFileService {

  private webSocket = null;
  private isConnect = false;
  private callbackFunction = null;
  private callFunction = null;

  constructor(
    private shareService: SharedService,
    private commonUtils: CommonUtils,
    private translateService: TranslateService
  ) { 
  }

  connectWebSocket(_callFunction) {
      this.callFunction = _callFunction;
      this.webSocket = new WebSocket("ws://localhost:9999/EditWordFile");
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
          if (event.data === "close") {
            this.callbackFunction = null;
          }
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

  sendMessage(message) {
    console.log(message)
    this.webSocket.send(message);
  }

  sendObject(object) {
    let json = JSON.stringify(object);
    this.webSocket.send(this.shareService.b64EncodeUnicode(json));
  }

  editFile(params, _callbackFunction) {
    if (this.isConnect && this.webSocket != null) {
      if (this.callbackFunction == null) {
        this.callbackFunction = _callbackFunction; 
        this.sendObject(params);
      } else {
        this.commonUtils.showPopupOK(this.translateService.instant('file.open-or-edit-in-progress'));
      }
    } else {
      this.connectWebSocket((data) => {
        if (data !== "-100") {
          this.editFile(params, _callbackFunction);
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

@Injectable({
  providedIn: 'root'
})
export class ConvertWordToPDF {

  private webSocket = null;
  private isConnect = false;
  private callbackFunction = null;
  private callFunction = null;

  constructor(
    private shareService: SharedService,
    private commonUtils: CommonUtils,
    private translateService: TranslateService
  ) { 
  }

  connectWebSocket(_callFunction) {
      this.callFunction = _callFunction;
      this.webSocket = new WebSocket("ws://localhost:9999/ConvertWordToPDF");
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
          this.callFunction("-100");
        }
        this.resetConnect();
        this.resetCallback();
      }
  }

  sendMessage(message) {
    console.log(message)
    this.webSocket.send(message);
  }

  sendObject(object) {
    let json = JSON.stringify(object);
    this.webSocket.send(this.shareService.b64EncodeUnicode(json));
  }

  convert(params, _callbackFunction) {
    if (this.isConnect && this.webSocket != null) {
      if (this.callbackFunction == null) {
        this.callbackFunction = _callbackFunction; 
        this.sendObject(params);
      } else {
        this.commonUtils.showPopupOK(this.translateService.instant('file.convert-in-progress'));
      }
    } else {
      this.connectWebSocket((data) => {
        if (data !== "-100") {
          this.convert(params, _callbackFunction);
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

@Injectable({
  providedIn: 'root'
})
export class VerifierPDF {

  private webSocket = null;
  private isConnect = false;
  private callbackFunction = null;
  private callFunction = null;

  constructor(
    private shareService: SharedService,
    private commonUtils: CommonUtils,
    private translateService: TranslateService
  ) { 
  }

  connectWebSocket(_callFunction) {
      this.callFunction = _callFunction;
      this.webSocket = new WebSocket("ws://localhost:9999/VerifyPDF");
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
          this.callFunction("-100");
        }
        this.resetConnect();
        this.resetCallback();
      }
  }

  sendMessage(message) {
    console.log(message)
    this.webSocket.send(message);
  }

  sendObject(object) {
    let json = JSON.stringify(object);
    this.webSocket.send(this.shareService.b64EncodeUnicode(json));
  }

  VerifierPDF(params, _callbackFunction) {
    if (this.isConnect && this.webSocket != null) {
      if (this.callbackFunction == null) {
        this.callbackFunction = _callbackFunction; 
        this.sendObject(params);
      } else {
        this.commonUtils.showPopupOK(this.translateService.instant('file.open-or-edit-in-progress'));
      }
    } else {
      this.connectWebSocket((data) => {
        if (data !== "-100") {
          this.VerifierPDF(params, _callbackFunction);
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