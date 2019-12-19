import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private authenticationApiUrl ='http://localhost:8083/authentication-service/stockmarketcharting/authenticate';
  state: boolean;
  token: string;
  userType: string;
  status: string;
  name: string;

  constructor(private httpClient: HttpClient) { }

  authenticate(user: string, password: string) {
    let credentials = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials);
    return this.httpClient.get(this.authenticationApiUrl, { headers });
  }

  login() {
    this.state = true;
  }

  logout() {
    this.state = false;
  }

  loggedInUser() {
    return this.state;
  }
  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }
  
  public setUserType(userType: string) {
    this.userType = userType;
  }
  public getUserType() {
    return this.userType;
  }
  
  public setStatus(status: string) {
    this.status = status;
  }
  public getStatus() {
    return this.status;
  }

  public setName(firstName: string) {
    this.name = firstName;
  }
  public getName() {
    return this.name;
  }
}
