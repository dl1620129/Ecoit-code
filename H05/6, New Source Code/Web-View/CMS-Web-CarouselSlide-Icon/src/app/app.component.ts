import { Component } from '@angular/core';

import LiferayParams from '../types/LiferayParams'
import { Constants } from './Constants';

declare const Liferay: any;

@Component({
	templateUrl:
		Liferay.ThemeDisplay.getPathContext() +
		'/o/CMS-Web-CarouselSlide-Icon/app/app.component.html'
})
export class AppComponent {
	params: LiferayParams;
	labels: any;
	public urlWebSite = Liferay.ThemeDisplay.getLayoutRelativeURL();
	get QUANLYVANBAN() {
		return 'http://192.168.10.103/';
	}
	get LICH() {
		return Constants.baseUrl + this.urlWebSite.substring(0, this.urlWebSite.lastIndexOf('/')) + '/lich-cong-tac';
	}
	get BAO_CAO_QUAN_SO() {
		return Constants.baseUrl + this.urlWebSite.substring(0, this.urlWebSite.lastIndexOf('/')) + '/bao-cao';
	}
	get DANH_BA() {
		return Constants.baseUrl + this.urlWebSite.substring(0, this.urlWebSite.lastIndexOf('/')) + '/danh-ba';
	}
	get EMAIL() {
		return 'https://192.168.10.104/';
	}
	constructor() {
		this.labels = {

			configuration: Liferay.Language.get('configuration'),

			portletNamespace: Liferay.Language.get('portlet-namespace'),
			contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}

	get configurationJSON() {
		return JSON.stringify(this.params.configuration, null, 2);
	}
}
