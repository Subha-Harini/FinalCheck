import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterComponent } from './register.component';
import { By } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterComponent ],
      imports: [FormsModule, ReactiveFormsModule, HttpClientModule, RouterModule.forRoot([])]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

   it('component variables to be initilized', () => {
    expect(component.error).toBeUndefined();
    expect(component.signupForm).toBeNull();
    expect(component.userCreated).toBeUndefined();
   
  }); 

  it('created a form with fields in register form', () => {
    const usernameContainer = fixture.debugElement.nativeElement.querySelector('#name');
    const passwordContainer = fixture.debugElement.nativeElement.querySelector('#password');
    const contactContainer = fixture.debugElement.nativeElement.querySelector('#contactNumber');
    const emailContainer = fixture.debugElement.nativeElement.querySelector('#email');

    expect(usernameContainer).toBeDefined();
    expect(passwordContainer).toBeDefined();
    expect(contactContainer).toBeDefined();
    expect(emailContainer).toBeDefined();
  });

  it('button loading', () => {
    expect(fixture.debugElement.query(By.css('button')).properties.disabled).toBeFalsy();
  }); 
});
