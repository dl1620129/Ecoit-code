import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root'
})
export class SignatureService {


    private webSocket: WebSocket = null;
    private isConnect = false;
    private callbackFunction: (arg0: any) => void = null;
    private callFunction: (arg0: string) => void = null;
    constructor(
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
        console.log(message)
        this.webSocket.send(message);
    }

    sendObject(object: any) {
        let json = JSON.stringify(object);
        // this.webSocket.send(this.shareService.b64EncodeUnicode(json));
    }

    getTokenInfo(_callbackFunction: { (arg0: any): void; (arg0: any): void; }) {
        if (this.isConnect && this.webSocket != null) {
            this.sendMessage("GetTokenInfo");
            if (this.callbackFunction == null) {
                this.callbackFunction = _callbackFunction;
            } else {
                // this.commonUtils.showPopupOK(this.translateService.instant('signature.sign-in-progess'));
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

