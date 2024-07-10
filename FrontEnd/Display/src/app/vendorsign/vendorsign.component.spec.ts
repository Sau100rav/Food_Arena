import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorsignComponent } from './vendorsign.component';

describe('VendorsignComponent', () => {
  let component: VendorsignComponent;
  let fixture: ComponentFixture<VendorsignComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VendorsignComponent]
    });
    fixture = TestBed.createComponent(VendorsignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
