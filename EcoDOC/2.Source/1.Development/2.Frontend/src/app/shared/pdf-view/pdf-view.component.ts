import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { UploadFileService } from 'src/app/services/upload-file.service';
import { ToastrService } from 'ngx-toastr';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-pdf-view',
  templateUrl: './pdf-view.component.html',
  styleUrls: ['./pdf-view.component.css']
})
export class PdfViewComponent implements OnInit {
  @ViewChild('pdfViewerOnDemand', {static: false}) pdfViewerOnDemand;
  @Input() public fileName;
  @Input() public type = "";
  constructor(
    private fileService: UploadFileService,
    private toastService: ToastrService,
    public activeModal: NgbActiveModal,
  ) { 
  }

  ngOnInit() {
    this.fileService.getFileToView(this.fileName, this.type).subscribe(
      res => {
        this.pdfViewerOnDemand.pdfSrc = res;
        this.pdfViewerOnDemand.refresh();
      },
      err => {
        // this.toastService.error("Tải file không thành công.", "Lỗi");
      }
    );
  }

}
