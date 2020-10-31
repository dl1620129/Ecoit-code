import { Component, OnInit } from '@angular/core';

import LiferayParams from '../types/LiferayParams'
import { Constants } from './common/constants';
import { DocumentModel } from './model/document.model';
import { DocumentService } from './service/document-service.service';
import { URLConstants } from './common/URLConstants';

declare const Liferay: any;

@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ELegal-Web-View-Latest/app/app.component.html'
})
export class AppComponent implements OnInit {
	params: LiferayParams;
	labels: any;
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    documentsList: DocumentModel[] = new Array();
    configuration = 0;

    get Constants() {
		return Constants;
	}

	get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get DOCUMENT_URL() {
		return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.DOCUMENT_URL;
	}
	
	get DETAIL_DOCUMENT_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/')) + URLConstants.DETAIL_DOCUMENT_URL;
    }

	constructor(private documentService: DocumentService) {
		this.labels = { 
			
			portletNamespace: Liferay.Language.get('portlet-namespace'),
        	contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}

    ngOnInit() {
		if (this.params.configuration.portletInstance.display) {
			this.configuration = this.params.configuration.portletInstance.display;
		};

		this.documentService.getLatestDocument(this.configuration).subscribe((response: any) => {
			console.log(response);
			if (response.error_code == Constants.SUCCESSFUL_CODE) {
				this.documentsList = response.data;
			}
		});
    }

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
