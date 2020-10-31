import { Component, OnInit } from '@angular/core';

import LiferayParams from '../types/LiferayParams'
import { Constants } from './common/constants';

declare const Liferay: any;

@Component({
	templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/QA-Web-Question/app/app.component.html'
})
export class AppComponent implements OnInit {
	params: LiferayParams;
	labels: any;
	showDefaultMessage: boolean = true;

	constructor() {
		this.labels = {        
			
			configuration: Liferay.Language.get('configuration'),
			
			portletNamespace: Liferay.Language.get('portlet-namespace'),
        	contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}

	ngOnInit() {
		let infoType = 'PHAN_HOI';
		if (this.params.configuration.portletInstance.THONG_TIN) {
			infoType = this.params.configuration.portletInstance.THONG_TIN;
		};
		Constants.CONFIGURATION = infoType;
	}
	
	toggleDefaultMessage(state: boolean) {
		this.showDefaultMessage = state;
	}

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
