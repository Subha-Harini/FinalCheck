import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { By } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [FormsModule, ReactiveFormsModule, HttpClientModule, RouterModule.forRoot([])]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

    it('created a form with username and password with login button', () => {
    const usernameContainer = fixture.debugElement.nativeElement.querySelector('#name');
    const passwordContainer = fixture.debugElement.nativeElement.querySelector('#pwd');
    expect(usernameContainer).toBeDefined();
    expect(passwordContainer).toBeDefined();
  });

  it('button loading', () => {
    expect(fixture.debugElement.query(By.css('button')).properties.disabled).toBeFalsy();
  }); 
  
   it('component variables to be initilized', () => {
    expect(component.loginStatus).toBeDefined(true);
    expect(component.error).toBeUndefined();
    expect(component.users).toBeUndefined();
  });  


});
