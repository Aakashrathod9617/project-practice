import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicleTrackingListComponent } from './vehicle-tracking-list.component';

describe('VehicleTrackingListComponent', () => {
  let component: VehicleTrackingListComponent;
  let fixture: ComponentFixture<VehicleTrackingListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VehicleTrackingListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicleTrackingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
