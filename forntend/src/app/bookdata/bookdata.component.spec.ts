import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookdataComponent } from './bookdata.component';

describe('BookdataComponent', () => {
  let component: BookdataComponent;
  let fixture: ComponentFixture<BookdataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookdataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
