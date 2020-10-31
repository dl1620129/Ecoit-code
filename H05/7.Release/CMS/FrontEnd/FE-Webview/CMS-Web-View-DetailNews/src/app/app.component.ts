import { Component, OnInit } from '@angular/core';

import LiferayParams from '../types/LiferayParams'

declare const Liferay: any;

@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-DetailNews/app/app.component.html'
})
export class AppComponent implements OnInit {
	params: LiferayParams;
	labels: any;
	constructor() {
		this.labels = {        
			
			configuration: Liferay.Language.get('configuration'),
			
			portletNamespace: Liferay.Language.get('portlet-namespace'),
        	contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}

	ngOnInit() {
       /* let queryData = this.getQueryString();
        if (queryData['isPrint'] && queryData['isPrint'] == 'true') {
            this.isPrint = true;
        }*/
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

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
