import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  signupForm: FormGroup;
  userCreated: boolean = false;
  error:string;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.error = '';
    this.userCreated = false;
    this.signupForm = new FormGroup({
      'id': new FormControl(0),
      'name': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
      'contactNumber': new FormControl("", [Validators.required, Validators.maxLength(10), Validators.minLength(10), Validators.pattern("^[0-9]*$")]),
      'email': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
      'password': new FormControl("", [Validators.required, Validators.maxLength(10), Validators.minLength(2)]),
      'confirmpassword': new FormControl("", [Validators.required, Validators.maxLength(10), Validators.minLength(2)]),
      'userType': new FormControl("USER"),
      'status': new FormControl("P")
    });
  }

  onSubmit(signupForm){
    this.userService.register(signupForm.value).subscribe((response)=>{
      this.userCreated = true;
    }, (responseError) => {
      this.error = responseError.error.errorMessage;
    });
  }

  login(){
    this.router.navigate(['login']);
  }
}
