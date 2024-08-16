import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtimsComponent } from './atims.component';

describe('AtimsComponent', () => {
  let component: AtimsComponent;
  let fixture: ComponentFixture<AtimsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtimsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
