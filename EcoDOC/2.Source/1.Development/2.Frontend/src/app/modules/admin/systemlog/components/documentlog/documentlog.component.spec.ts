import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentlogComponent } from './documentlog.component';

describe('DocumentlogComponent', () => {
  let component: DocumentlogComponent;
  let fixture: ComponentFixture<DocumentlogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentlogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentlogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
