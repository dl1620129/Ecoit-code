import { Component, OnInit } from "@angular/core";



declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-ImageNews/app/new-list.component.html'
})
export class ListNewComponent implements OnInit{
    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }
}