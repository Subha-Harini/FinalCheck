import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from '../site/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  filterItems:any;
  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }

  getAllCompanies(){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get<any>("http://localhost:8083/retrive-company-service/stockmarketcharting/companies", httpOptions);
  }

  getFilteredCompanies(str, companyList) {
    let search = str.toLocaleLowerCase();
    this.filterItems = companyList.filter((m: any) => m.name.toLocaleLowerCase().indexOf(search) != -1);
    return this.filterItems;
  }

  getCompanyById(id){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get<any>("http://localhost:8083/retrive-company-service/stockmarketcharting/companies/"+id, httpOptions);
  }
}
