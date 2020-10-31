import { Component, OnInit, Input, Output } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-waiting-popup',
  templateUrl: './waiting-popup.component.html',
  styleUrls: ['./waiting-popup.component.css']
})
export class WaitingPopupComponent implements OnInit {

  @Input() public message;
  @Output() public closePopup = () => {
    this.closePass();
  }
  
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
  }
}
