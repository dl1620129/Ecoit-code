import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarApprovedComponent } from './calendar-approved.component';

describe('CalendarApprovedComponent', () => {
  let component: CalendarApprovedComponent;
  let fixture: ComponentFixture<CalendarApprovedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalendarApprovedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalendarApprovedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
