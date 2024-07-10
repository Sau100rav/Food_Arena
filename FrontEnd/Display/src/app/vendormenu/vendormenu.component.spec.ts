import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VendormenuComponent } from './vendormenu.component';

describe('VendormenuComponent', () => {
  let component: VendormenuComponent;
  let fixture: ComponentFixture<VendormenuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VendormenuComponent]
    });
    fixture = TestBed.createComponent(VendormenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
