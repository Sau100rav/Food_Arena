import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorMyordersComponent } from './vendor-myorders.component';

describe('VendorMyordersComponent', () => {
  let component: VendorMyordersComponent;
  let fixture: ComponentFixture<VendorMyordersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VendorMyordersComponent]
    });
    fixture = TestBed.createComponent(VendorMyordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
