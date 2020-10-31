import { Component, OnInit } from "@angular/core";
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { CategoryService } from '../service/category.service';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { CategoryModel } from '../model/category.model';
import { ImageModel } from '../model/image.model';
import { ImageService } from '../service/image.service';
import { Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DomSanitizer } from '@angular/platform-browser';
declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-editor',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/Manager-Category-Image/app/category-editor.component.html'
})
export class CategoryEditorComponent implements OnInit{
    pageSize= 10;
    page = 1;
    listSize = 0;
    imgSrc: any;
    constructor(public _DomSanitizationService: DomSanitizer,public service: CategoryService, public modalService: NgbModal, public router: ActivatedRoute,public rt: Router,public notifierService:NotifierService, public imageService: ImageService,
        private fb: FormBuilder ){}
    categoryModel: CategoryModel = new CategoryModel();
    imageModel: ImageModel= new ImageModel();
    CategoryId: any;
    fields: any;
    listImageCategory:any;
    imageModels:ImageModel[];
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    get ARTICLE_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ '/hinh-anh';
        }
    updateform = this.fb.group({
        // [''[Validators.required,Validators.minLength(30),Validators.pattern(/^((?!\s{2,}).)*$/)]]
        name: ['', [Validators.required, Validators.maxLength(500),Validators.pattern(".*\\S.*")]],
        images: ['', Validators.maxLength(500)],
        description: [''],
        thuTu: [0, [Validators.required, Validators.min(0),Validators.pattern(".*\\S.*")]],
        tacGiaAlbum: ['', Validators.maxLength(75)],
    });
    get name(){ 
        return this.updateform.get('name');
    }
    get images(){ 
        return this.updateform.get('images');
    }
    get thuTu(){ 
        return this.updateform.get('thuTu');
    }
    get tacGiaAlbum(){ 
        return this.updateform.get('tacGiaAlbum');
    }
    get description(){ 
        return this.updateform.get('description');
    }
    ngOnInit(){
        this.service.getAllLinhVuc().subscribe((lv: any)=>{
            this.fields= lv.data[0].data;
        })
        this.router.paramMap.subscribe((params: ParamMap)=>{
            this.CategoryId = params.get('id');
        })
        if(this.CategoryId !=null){
            this.service.getCategory(this.CategoryId).subscribe((res:any)=>{
                this.updateform.patchValue({
                    name:res.data.name,
                    description:res.data.description,
                    thuTu:res.data.thuTu,
                    tacGiaAlbum:res.data.tacGiaAlbum,
                })
            });
            this.getImageByCategoryData(0,this.CategoryId);
        }
    }
    displayId(event: any){
        console.log("id:"+event.target.value);
    }

    onSubmit(){        
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.CategoryId = params.get('id');
        });
        if(this.CategoryId != null){
            this.service.updateCategory(this.updateform,this.CategoryId).subscribe((response: any) =>{
                if (response.error_code == Constants.SUCCESSFUL_CODE) {    
                    const id= response.data.categoryId;
                    let imageName= response.data.name;
                    this.imageService.createImageMutiple(this.imageModel,id,imageName,this.listImages).subscribe();                
                    this.rt.navigate(['/list']);
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            })
        }
        else{
            this.service.createCategory(this.updateform).subscribe((res:any) =>{
                if (res.error_code == Constants.SUCCESSFUL_CODE) {  
                    console.log('res: '+res);
                    const id= res.data.categoryId;
                    let imageName= res.data.name;
                    this.imageService.createImageMutiple(this.imageModel,id,imageName,this.listImages).subscribe();            
                    console.log('text: '+this.listText);
                    this.rt.navigate(['/list']);
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            })
           
        }
       
        
       
    }
    getImageByCategoryData(start: number,id:number){
        this.service.getImageByCategory(this.pageSize,start,id).subscribe((result: any) =>{
            if(result.error_code == Constants.SUCCESSFUL_CODE){
            this.imageModels = result.data[0].data;
            this.listSize=result.data[0].total;
        } else if (result.error_code == Constants.NOT_ACCESS_CODE) {
            this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
        }else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    pageChange(event: any){
        let startPage = (event - 1) * this.pageSize;
        this.getImageByCategoryData(startPage,this.CategoryId);
    }
    urlim: string;
   
    deleteImage(index: any) {
        this.listImages.splice(index, 1);
        this.fileImages.splice(index, 1);
        
    }

    deletevideo() {
        this.urlim = '';
    }
    validExts = [".jpg", ".png", ".jpeg", ".gif"];
    listText:any= new Array();
    nhapText(event:any){
       return event.target.value
    }
    processFile( event: any) {
        let fileExt = event.target.value;
        if (fileExt != '') {
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            if (this.validExts.indexOf(fileExt.toLowerCase()) < 0) {
                alert("Không đúng định dạng " +
                    this.validExts.toString());
                return false;
            } else {
                let totalSize = event.target.files[0].size;
                let fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
                let fSize = totalSize;
                let i = 0;
              
               
                while (fSize > 900) { fSize /= 1024; i++; }
                var total = (Math.round(fSize * 100) / 100);
                if (fSExt[i] == 'MB') {
                    if (total >= 5) {
                        alert("File đính kèm ảnh không được quá 5 Mb");
                        return false;
                    } else {
                        let F = event.target.files;
                        if(F && F[0]) this.readImage( F);
                    }
                } else {
                    var F = event.target.files;
                    if(F && F[0]) this.readImage( F);
                }
            }
        }
    }
    fileImages:any[]= new Array();
    listImages:any[]= new Array();
    
    readImage(file: any) {
        for (let index = 0; index < file.length; index++) {
            this.listImages.push(file[index])
            
        }
     
        const reader = new FileReader();
        for (let index = 0; index < file.length; index++) {
         
            let url = URL.createObjectURL(file[index]);
            let urlimage={
                "title":'',
                "imageUrl":url
            }
            this.fileImages.push(urlimage);
            
        }
        console.log(this.fileImages);
        reader.onload = (e: any) => {
            this.imgSrc = e.target.result;
            var w = e.target.width;
            if (w < 100) {
                alert("Kích thước ảnh không hợp lệ width >= 656");
            }
        };
    }
    removeImage(id: number) {
        this.imageService.deleteImage(id).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getImageByCategoryData(startPage,this.CategoryId);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })

    }
    removedEvent: any;
    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });

    }
    listId: any[] = new Array();
    masterSelected: boolean;
    selectAll(event: any) {
        let isChecked = event.target.checked;
        if (isChecked) {
            for (let i = 0; i < this.imageModels.length; i++) {
                this.imageModels[i].selected = this.masterSelected;
                if(this.listId.indexOf(this.imageModels[i].imageId) == -1){
                    this.listId.push(this.imageModels[i].imageId);
                }
            }
        } else {
            for (let i = 0; i < this.imageModels.length; i++) {
                this.imageModels[i].selected = this.masterSelected;
                if (this.listId.indexOf(this.imageModels[i].imageId) !== -1) {
                    this.listId.splice(this.listId.indexOf(this.imageModels[i].imageId), 1);
                }
            }
        }

    }
    checkIfAllSelected(event: any, id: number) {
        this.masterSelected = this.imageModels.every(function (item: any) {
            return item.selected == true;
        })
        let isChecked = event.target.checked;
        if (isChecked) {
            this.listId.push(id)
        }
        else {
            const index: number = this.listId.indexOf(id);
            if (index !== -1) {
                this.listId.splice(index, 1);
            }
        }
    }
    removeMutiple() {
        this.router.paramMap.subscribe((params: ParamMap) =>{
            this.CategoryId = params.get('id');
        });
        this.imageService.deleteMutiple(this.listId).subscribe((response:any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getImageByCategoryData(startPage,this.CategoryId);
                this.listId = [];
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });

    }

}