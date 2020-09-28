import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscountContainerComponent } from './container.component';

describe('DiscountContainerComponent', () => {
  let component: DiscountContainerComponent;
  let fixture: ComponentFixture<DiscountContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscountContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscountContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
