import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditDetailsEachComponent } from './audit-details-each.component';

describe('AuditDetailsEachComponent', () => {
  let component: AuditDetailsEachComponent;
  let fixture: ComponentFixture<AuditDetailsEachComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuditDetailsEachComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuditDetailsEachComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
