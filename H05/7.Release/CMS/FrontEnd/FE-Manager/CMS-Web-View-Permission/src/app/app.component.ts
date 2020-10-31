import { Component } from '@angular/core';

import LiferayParams from '../types/LiferayParams'

declare const Liferay: any;

@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMSWebViewPermission/app/app.component.html'
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
			groupId:34345 || Liferay.ThemeDisplay.getScopeGroupId(),
			userId:Liferay.ThemeDisplay.getUserId(),
			languageIdd:Liferay.ThemeDisplay.getLanguageId(),
			getSiteGroupId:Liferay.ThemeDisplay.getSiteGroupId(),
			getSessionId:Liferay.ThemeDisplay.getSessionId(),
		}
	}
	toggleDefaultMessage(state: boolean) {
		this.showDefaultMessage = state;
	}
	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
