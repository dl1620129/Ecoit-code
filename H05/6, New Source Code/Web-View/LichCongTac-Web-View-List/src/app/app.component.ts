import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';

import LiferayParams from '../types/LiferayParams';
import { LichCongTacService } from './service/lichcongtac.service';

declare const Liferay: any;

@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/LichCongTac-Web-View-List/app/app.component.html'
})
export class AppComponent {
	params: LiferayParams;
	labels: any;
    showDefaultMessage: boolean = true;
    isPrint = false;
	constructor() {
		this.labels = {        
			
			configuration: Liferay.Language.get('configuration'),
			
			portletNamespace: Liferay.Language.get('portlet-namespace'),
        	contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}

    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['isPrint'] && queryData['isPrint'] == 'true') {
            this.isPrint = true;
        }
    }

    getQueryString() {
        let hashMap = {};
        let queries = Liferay.currentURL.slice(Liferay.currentURL.indexOf('?') + 1).split('&');
        for (let i = 0; i < queries.length; i++) {
            let hash = queries[i].split('=');
            hashMap[hash[0]] = hash[1];
        }
        console.log(hashMap);
        return hashMap;
    }

	toggleDefaultMessage(state: boolean) {
		this.showDefaultMessage = state;
	}

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
