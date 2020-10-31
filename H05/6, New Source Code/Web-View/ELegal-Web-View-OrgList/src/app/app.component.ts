import { Component, OnInit } from '@angular/core';

import LiferayParams from '../types/LiferayParams'
import { OrganizationService } from './service/organization.service';
import { Constants } from './common/constants';
import { Organization } from './model/organization.model';
import { URLConstants } from './common/URLConstants';

declare const Liferay: any;
declare const $: any;
@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ELegal-Web-View-OrgList/app/app.component.html'
})
export class AppComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

	params: LiferayParams;
	labels: any;
    organizationsList: Organization[] = new Array();

    mainOrgId: number;
	constructor(private organizationService: OrganizationService) {
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
        if (parseInt(queryData['organizationId'])) {
            this.mainOrgId = parseInt(queryData['organizationId']);
        }
		this.organizationService.getAllOrganizations().subscribe((response: any) => {
			console.log(response);
			if (response.error_code == Constants.SUCCESSFUL_CODE) {
				this.organizationsList = response.data;
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
	
	displayDropDown(event: any) {
        event.preventDefault();
        console.log('testing');
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-chevron-right" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-chevron-down" aria-hidden="true"></i>');
        }
        let targetLevel = $(event.currentTarget).data('target');
        let currentRow = $(event.currentTarget).parents('.panel-body').next();
        let currentLevel = $(currentRow).data('level');
        let mainVisible = isVisible;
        while (currentLevel > targetLevel) {
            let isShow = false;
            if (mainVisible) {
                if ($(currentRow).is(':visible')) {
                    $(currentRow).hide();
                }
            } else {
                isShow = true;
                $(currentRow).show();
            }

            if (($(currentRow).next().data('level') - targetLevel) == 1) {
                mainVisible = isVisible;
            } else {
                if ($(currentRow).find('.dropdown-btn').length > 0 && isShow) {
                    mainVisible = !$(currentRow).find('.dropdown-btn').data('visible');
                }
            }
            currentRow = $(currentRow).next();
            currentLevel = $(currentRow).data('level');
        }
    }
}
