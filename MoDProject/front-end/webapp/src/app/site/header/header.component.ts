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
  userStatus : string;

  ngOnInit() {
    this.firstName = null;
    this.loginStatus = this.authenticationService.loggedInUser();
    this.userType = null;
    this.userStatus =  null;
  }

  getName(){
    this.firstName = this.authenticationService.getName();
    return this.authenticationService.getName();
  }

  getUserType(){
    this.userType = this.authenticationService.getUserType();
    return this.userType;
  }

  getUserStatus(){
    this.userStatus = this.authenticationService.getStatus();
    return this.userStatus;
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

  editUser(name){
    this.router.navigate(['edit-user', name]);
  }

  uploadFile(){
    this.router.navigate(['upload-file']);
  }

  stockExchange(){
    this.router.navigate(['stock-exchange']);
  }
}
