import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CalendarOrgComponent } from './calendar-org.component';

describe('CalendarOrgComponent', () => {
  let component: CalendarOrgComponent;
  let fixture: ComponentFixture<CalendarOrgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CalendarOrgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CalendarOrgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
