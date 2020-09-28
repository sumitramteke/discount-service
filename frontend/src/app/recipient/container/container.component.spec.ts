import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientContainerComponent } from './container.component';

describe('RecipientContainerComponent', () => {
  let component: RecipientContainerComponent;
  let fixture: ComponentFixture<RecipientContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecipientContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
