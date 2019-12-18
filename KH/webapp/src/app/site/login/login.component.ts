import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  users: any;
  loginForm: FormGroup;
  error: string;
  isLoggedIn: boolean;
  loginStatus: boolean;
  constructor(private route: Router, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.loginStatus = true;
    this.isLoggedIn = true;
  
    this.loginForm = new FormGroup({
      'userId': new FormControl('', [Validators.required]
      ),
      'passwrd': new FormControl('', [Validators.required]
      )
    });
  }

  onSubmit(loginForm) {
    console.log(loginForm.value);
    
     this.authenticationService.authenticate(loginForm.value.userId, loginForm.value.passwrd).subscribe((response) => {
       console.log(response);
      if(response['status'] == 'A'){
          this.loginStatus = true;
          this.authenticationService.login();
          this.authenticationService.setToken(response['token']);
          this.authenticationService.setStatus(response['status']);
          this.authenticationService.setUserType(response['userType']);
          this.authenticationService.setName(response['name']);
          this.route.navigate(['stock-page']);
      }
    },
      (responseError) => {
        this.loginStatus = false;
        console.log(responseError.error.errorMessage);
        this.error = responseError.error.errorMessage;
      });
  }

}
