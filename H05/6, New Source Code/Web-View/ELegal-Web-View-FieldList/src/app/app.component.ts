import { Component, OnInit } from '@angular/core';

import LiferayParams from '../types/LiferayParams'
import { FieldService } from './service/field.service';
import { Constants } from './common/constants';
import { LegalField } from './model/legalfield.model';
import { URLConstants } from './common/URLConstants';

declare const Liferay: any;
declare const $: any;
@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ELegal-Web-View-FieldList/app/app.component.html'
})
export class AppComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

	params: LiferayParams;
	labels: any;
    fieldsList: LegalField[] = new Array();

    mainFieldId: number;
	constructor(private fieldService: FieldService) {
		this.labels = {        
			
			configuration: Liferay.Language.get('configuration'),
			
			portletNamespace: Liferay.Language.get('portlet-namespace'),
        	contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}

    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get DOCUMENT_URL() {
        return URLConstants.DOCUMENT_URL;
    }

    get CURRENT_URL() {
		let currentUrl = Liferay.ThemeDisplay.getLayoutURL();
        return currentUrl;
    }

    ngOnInit() {
        let queryData = this.getQueryString();
        if (parseInt(queryData['fieldId'])) {
            this.mainFieldId = parseInt(queryData['fieldId']);
        }
		this.fieldService.getAllFields().subscribe((response: any) => {
			console.log(response);
			if (response.error_code == Constants.SUCCESSFUL_CODE) {
				this.fieldsList = response.data;
			}
		});
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
}
