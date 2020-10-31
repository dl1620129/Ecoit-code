import { Component, OnInit } from '@angular/core';

import LiferayParams from '../types/LiferayParams'
import { DocumentService } from './service/document.service';
import { Constants } from './common/constants';
import { DocumentModel } from './model/document.model';
import { URLConstants } from './common/URLConstants';

declare const Liferay: any;
declare const $: any;
@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ELegal-Web-View-Popular/app/app.component.html'
})
export class AppComponent implements OnInit {
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    arrayOne(n: number): any[] {
        return Array(n);
    }

    documentsList: DocumentModel[] = new Array();
	params: LiferayParams;
	labels: any;
	constructor(private documentService: DocumentService) {
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

    get DETAIL_DOCUMENT_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/')) + URLConstants.DETAIL_DOCUMENT_URL;
    }

    ngOnInit() {
		this.documentService.getAllDocuments().subscribe((response: any) => {
			console.log(response);
			if (response.error_code == Constants.SUCCESSFUL_CODE) {
				this.documentsList = response.data;
			}
		});
	}
}
