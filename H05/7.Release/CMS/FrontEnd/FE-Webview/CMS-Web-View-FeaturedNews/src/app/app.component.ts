import { Component, OnInit  } from '@angular/core';

import LiferayParams from '../types/LiferayParams';
import { Constants } from './common/constants';

declare const Liferay: any;

@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-FeaturedNews/app/app.component.html'
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
		Constants.portletId = this.params.portletNamespace;
		if (this.params.configuration.portletInstance.category) {
			Constants.CONFIG_CATEGORY = this.params.configuration.portletInstance.category;
		};
    }

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
