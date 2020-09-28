import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscountApplyComponent } from './apply.component';

describe('DiscountApplyComponent', () => {
  let component: DiscountApplyComponent;
  let fixture: ComponentFixture<DiscountApplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscountApplyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscountApplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
