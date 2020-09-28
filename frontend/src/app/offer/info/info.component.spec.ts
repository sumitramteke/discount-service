import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfferInfoComponent } from './info.component';

describe('OfferInfoComponent', () => {
  let component: OfferInfoComponent;
  let fixture: ComponentFixture<OfferInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OfferInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OfferInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
