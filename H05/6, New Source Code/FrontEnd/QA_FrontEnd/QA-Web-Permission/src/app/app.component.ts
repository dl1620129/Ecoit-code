import { Component } from '@angular/core';

import LiferayParams from '../types/LiferayParams'

declare const Liferay: any;

@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/QA-Web-Permission/app/app.component.html'
})
export class AppComponent {
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

	toggleDefaultMessage(state: boolean) {
		this.showDefaultMessage = state;
	}

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
