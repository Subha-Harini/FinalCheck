import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  signupForm: FormGroup;
  user: any;
  userEdited:boolean;
  error:string;
  constructor(private router: ActivatedRoute,private userService:UserService, private route: Router) {
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

  ngOnInit() {


    this.router.paramMap.subscribe(params => {
      console.log(params);
      this.userService.getUserByName(params.get('name')).subscribe((response) => {
        console.log(response);
        this.user = response;
        

        this.signupForm = new FormGroup({
          'id': new FormControl(this.user.id),
          'name': new FormControl(this.user.name, [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
          'contactNumber': new FormControl(this.user.mobileNumber, [Validators.required, Validators.maxLength(10), Validators.minLength(10), Validators.pattern("^[0-9]*$")]),
          'email': new FormControl(this.user.email, [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
          'password': new FormControl("", [Validators.required, Validators.maxLength(10), Validators.minLength(2)]),
          'confirmpassword': new FormControl("", [Validators.required, Validators.maxLength(10), Validators.minLength(2)]),
          'userType': new FormControl(this.user.userType),
          'status': new FormControl(this.user.status)
        });
        console.log(this.signupForm.value);
      });
      });
  }
  onSubmit(signupForm){
    console.log(signupForm.value)
    this.userService.register(signupForm.value).subscribe((response)=>{
      this.userEdited = true;
    }, (responseError) => {
      this.error = responseError.error.errorMessage;
    });
  }

  login(){
    this.route.navigate(['login']);
  }
}
