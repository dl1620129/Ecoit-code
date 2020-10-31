import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { User } from './user';
import { Field } from './field';

declare const Liferay: any;


@Component({
    selector: 'app-article-editor',
    templateUrl: './article-editor.component.html',
    styleUrls: ['./article-editor.component.scss'],
    providers: [ArticleService],
})
export class ArticleEditorComponent implements OnInit {
    selectedField: any = [];
    chosenField: any;
    relatedField: any;
    listField: Field[];
    imgURL: any;
    fakeData: any;

    selectedPeople: any = [];
    chosenPeople: any;
    assignee: any;
    listPeople: User[];

    listFile: any = [];

    isFieldSelectVisible: boolean = false;
    isAssigneeSelectVisible: boolean = false;

    constructor(private articleService : ArticleService) { }

    onSubmit() {
        // TODO: Use EventEmitter with form value
      }
      
    toggleVisibleField() {
        if (this.isFieldSelectVisible) {
            this.isFieldSelectVisible = false;
        } else {
            this.isFieldSelectVisible = true;
        }
    }

    toggleVisibleAssignee() {
        if (this.isAssigneeSelectVisible) {
            this.isAssigneeSelectVisible = false;
        } else {
            this.isAssigneeSelectVisible = true;
        }
    }

    processFile(imageInput : any) {
        const file: File = imageInput.files[0];
        const reader = new FileReader();

        reader.addEventListener('load', (event: any) => {
            this.imgURL = reader.result;
        });
        reader.readAsDataURL(file);
    }

    addSelectedField() {
        this.articleService.moveDataFromList(this.chosenField, this.listField, this.selectedField);
    }

    addSelectedPeople() {
        this.articleService.moveDataFromList(this.chosenPeople, this.listPeople, this.selectedPeople);
    }

    removeSelectedField() {
        this.articleService.moveDataFromList(this.relatedField, this.selectedField, this.listField);
    }

    removeSelectedPeople() {
        this.articleService.moveDataFromList(this.assignee, this.selectedPeople, this.listPeople);
    }


    addFile() {
        let fileObject = {
            id: 0,
            fileName: "",
            fileData: ""
        }
        this.listFile.push(fileObject);
    }

    deleteFile(index: any) {
        this.listFile.splice(index, 1);
    }

    ngOnInit() {
        this.articleService.getFakeField().subscribe(listField => {
            this.listField = listField;
        });
        this.articleService.getFakePeople().subscribe(listPeople => {
            this.listPeople = listPeople;
        });;

        let fileObject = {
            id: 0,
            fileName: "",
            fileData: ""
        }
        this.listFile.push(fileObject);
    }

}