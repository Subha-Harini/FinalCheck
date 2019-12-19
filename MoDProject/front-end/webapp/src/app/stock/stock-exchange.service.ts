import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from '../site/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class StockExchangeService {

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }

  getAllStockExchange(){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get<any>("http://localhost:8083/stock-exchange-service/stockmarketcharting/list", httpOptions);
  }

  postStockExchange(stockExchange){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    let body =  {
      id: stockExchange.id,
      stockExchange: stockExchange.stockExchange,
      brief: stockExchange.brief,
      address: stockExchange.address,
      remarks: stockExchange.remarks,
      logo: stockExchange.logo
  };
    return this.httpClient.post<any>("http://localhost:8083/stock-exchange-service/stockmarketcharting/list",body ,  httpOptions);
  }

  updateStockExchange(stockExchange){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    let body =  {
      id: stockExchange.id,
      stockExchange: stockExchange.stockExchange,
      brief: stockExchange.brief,
      address: stockExchange.address,
      remarks: stockExchange.remarks,
      logo: stockExchange.logo
  };
    return this.httpClient.put<any>("http://localhost:8083/stock-exchange-service/stockmarketcharting/list",body ,  httpOptions);
  }

  getCompaniesInStockExchange(name){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get<any>("http://localhost:8083/stock-exchange-service/stockmarketcharting/company-list/"+name, httpOptions);
  }

  getStockExchangeById(id){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get<any>("http://localhost:8083/stock-exchange-service/stockmarketcharting/list/"+id, httpOptions);
  }

}
