import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-confirm-popup',
  templateUrl: './confirm-popup.component.html',
  styleUrls: ['./confirm-popup.component.css']
})
export class ConfirmPopupComponent implements OnInit {
  @Input() public message;
  @Input() public oKOnly = false;
  @Input() public funcCloseCallback;
  
  constructor(
    public activeModal: NgbActiveModal,
  ) { }

  ngOnInit() {
  }

  confirmPass() {
    this.activeModal.close(true);
  }

  closePass() {
    this.activeModal.close(false);
    if (this.funcCloseCallback)
      this.funcCloseCallback();
  }
}
