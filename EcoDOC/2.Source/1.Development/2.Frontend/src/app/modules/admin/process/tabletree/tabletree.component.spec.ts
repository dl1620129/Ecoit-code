import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabletreeComponent } from './tabletree.component';

describe('TabletreeComponent', () => {
  let component: TabletreeComponent;
  let fixture: ComponentFixture<TabletreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabletreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabletreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
