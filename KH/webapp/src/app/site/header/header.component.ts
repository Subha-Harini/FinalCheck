import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }
  firstName: string;
  loginStatus: boolean;
  userType: string;

  ngOnInit() {
    this.firstName = null;
    this.loginStatus = this.authenticationService.loggedInUser();
    this.userType = null;
  }

  getName(){
    this.firstName = this.authenticationService.getName();
    return this.authenticationService.getName();
  }

  getUserType(){
    this.userType = this.authenticationService.getUserType();
    return this.userType;
  }

  logout(){
    this.authenticationService.logout();
    this.authenticationService.setUserType("");
    this.authenticationService.setName("");
    this.authenticationService.setStatus("");
    this.authenticationService.setToken("");
    this.router.navigate(['home']);
  }
  login(){
    this.router.navigate(['login']);
  }
}
