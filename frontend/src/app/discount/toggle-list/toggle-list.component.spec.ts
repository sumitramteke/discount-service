import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscountToggleListComponent } from './toggle-list.component';

describe('DiscountToggleListComponent', () => {
  let component: DiscountToggleListComponent;
  let fixture: ComponentFixture<DiscountToggleListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiscountToggleListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscountToggleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
