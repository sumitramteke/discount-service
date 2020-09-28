import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipientInfoComponent } from './info.component';

describe('RecipientInfoComponent', () => {
  let component: RecipientInfoComponent;
  let fixture: ComponentFixture<RecipientInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecipientInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipientInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
