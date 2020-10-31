import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormpropertiesComponent } from './formproperties.component';

describe('FormpropertiesComponent', () => {
  let component: FormpropertiesComponent;
  let fixture: ComponentFixture<FormpropertiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormpropertiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormpropertiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
