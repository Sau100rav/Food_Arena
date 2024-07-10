import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenupagehomeComponent } from './menupagehome.component';

describe('MenupagehomeComponent', () => {
  let component: MenupagehomeComponent;
  let fixture: ComponentFixture<MenupagehomeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MenupagehomeComponent]
    });
    fixture = TestBed.createComponent(MenupagehomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
