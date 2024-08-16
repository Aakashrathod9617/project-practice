import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AtimslistComponent } from './atimslist.component';

describe('AtimslistComponent', () => {
  let component: AtimslistComponent;
  let fixture: ComponentFixture<AtimslistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AtimslistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtimslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
