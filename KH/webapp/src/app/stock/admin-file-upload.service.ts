import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from '../site/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AdminFileUploadService {
  

  constructor(private http:HttpClient, private authenticateService: AuthenticationService) { }

  showSummary(){
    let token = 'Bearer ' + this.authenticateService.getToken();
    const httpOption = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.http.get("http://localhost:8083/upload-excel-service/upload-excel/summary", httpOption)
  }
}
