import { Component, ViewChild, ElementRef, AfterViewInit, OnInit, Input } from '@angular/core';
import { DatePipe } from '@angular/common';
import { DocumentService } from '../../../services/document.service';
import { Router, ActivatedRoute, NavigationExtras } from '@angular/router';
import { Observable, Observer } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { TokenService } from 'src/app/core/authen/token.service';


@Component({
  selector: 'app-document-list-file',
  templateUrl: './document-view-file.component.html',
  styleUrls: ['./document-view-file.component.css']

})
export class DocumentViewFile implements OnInit {
  @ViewChild('pdfViewerOnDemand', {static: false}) pdfViewerOnDemand;
  @ViewChild('canvasEl', { static: true }) canvasEl: ElementRef;
  @Input() public fileName;
  @Input() public type = "";
  private context: CanvasRenderingContext2D;
  constructor(
    private service: DocumentService,
    private datepipe: DatePipe,
    private router: Router,
    private routers: ActivatedRoute,
    private tokenService: TokenService,
  ) {
  }
  ticKet = '';
  url= "";
  document: string;
  list: any[];
  abc: string;
  date: string;
  name: any;
  text: any;
  id: any;
  Item: any[];
  viewImg ="";
  viewFile: any[];
  textview :any;
  comment = true;


  ngOnInit() {

    this.routers.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log(name)
      console.log(this.id)
    })
    if(this.id != null && this.id != undefined){
      this.getId(this.id, this.tokenService.getTickets());
      this.View(this.id, this.tokenService.getTickets());
      this.getview(this.id, this.tokenService.getTickets());
      this.viewimgage(this.id, this.tokenService.getTickets());
      
    }
  }

  

  getId(id: String, ticKet: string) {
    this.service.getIdFile(ticKet, id).subscribe((res: any) => {
      this.Item = res.data.entry;
      console.log('item',this.Item)
      if(res.data.entry.content.mimeType=="application/pdf"){
        this.viewpdf(this.tokenService.getTickets(),this.id);
      }
      else{
        this.View(this.id, this.tokenService.getTickets());
      }
      this.date = this.datepipe.transform(res.data.entry.modifiedAt, 'dd-MM-yyyy');
    })
  }
  dataURItoBlob(dataURI: string): Observable<Blob> {
    return Observable.create((observer: Observer<Blob>) => {
      const byteString: string = window.atob(dataURI);
      const arrayBuffer: ArrayBuffer = new ArrayBuffer(byteString.length);
      const int8Array: Uint8Array = new Uint8Array(arrayBuffer);
      for (let i = 0; i < byteString.length; i++) {
        int8Array[i] = byteString.charCodeAt(i);
      }
      const blob = new Blob([int8Array], { type: "image/jpeg" });
      observer.next(blob);
      observer.complete();
    });
  }
  generateName(): any {
    const date: number = new Date().valueOf();
    let text: string = "";
    const possibleText: string =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (let i = 0; i < 5; i++) {
      text += possibleText.charAt(
        Math.floor(Math.random() * possibleText.length)
      );
    }
  }
  View(id: String, ticKet: string) {
    this.service.previewDocument(ticKet,id,'pdf').subscribe(data=>{
      this.pdfViewerOnDemand.pdfSrc = new Blob([data], { type: 'application/octet-stream' });
      this.pdfViewerOnDemand.refresh();
    });
    }
    viewimgage(id: String, ticKet: string) {   
      this.service.previewDocument(ticKet, id,"imgpreview").pipe(switchMap(blob => this.convertBlobToBase64(blob))).subscribe(base64ImageUrl =>  
        console.log(base64ImageUrl)) 
      }
    viewpdf( ticKet: string,id: String) {
      this.service.img(ticKet,id).subscribe(data=>{
        this.pdfViewerOnDemand.pdfSrc = data;
        this.pdfViewerOnDemand.refresh();
     console.log('1',this.pdfViewerOnDemand)
      });
      }

  convertBlobToBase64(blob: Blob) {
    return Observable.create(observer => {
      const reader = new FileReader();
      const binaryString = reader.readAsDataURL(blob);
      reader.onload = (event: any) => {
        console.log('Image in Base64: ', event.target.result);
        this.viewImg=event.target.result;
        observer.next(event.target.result);
        observer.complete();
      };
      reader.onerror = (event: any) => {
        console.log("File could not be read: " + event.target.error.code);
        observer.next(event.target.error.code);
        observer.complete();
      };
    });
  }
  

  getview(id: String, ticKet: string) {
    this.service.getview(ticKet, id).subscribe((res: any) => {
      this.textview=res;
  
    
    })
  }
  Comment() {
    this.comment = false;
  }
  thoat() {
    this.comment = true;
  }




}
