import { Component } from '@angular/core';

import LiferayParams from '../types/LiferayParams'

declare const Liferay: any;

@Component({
	templateUrl: '/o/ELegal-Web-DocumentStat/app/app.component.html'
})
export class AppComponent {
	params: LiferayParams;
	labels: any;
	showDefaultMessage: boolean = true;

	constructor() {
		this.labels = {        
			
			configuration: 'Configuration',
			
			portletNamespace: 'Portlet Namespace',
        	contextPath: 'Context Path',
			portletElementId: 'Portlet Element Id',
		}
	}


	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
