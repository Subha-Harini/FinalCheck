import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }

  register(registrationForm){
   
    let body = {
                id: registrationForm.id,
                name: registrationForm.name,
                contactNumber: registrationForm.contactNumber,
                email: registrationForm.email,
                password: registrationForm.password,
                userType: registrationForm.userType,
                status: registrationForm.status
    };
    console.log(body);
    return this.httpClient.post<any>("http://localhost:8083/authentication-service/stockmarketcharting/users", body);

  }
  
}
