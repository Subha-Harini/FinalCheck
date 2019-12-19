import { Component, OnInit } from '@angular/core';
import { StockExchangeService } from '../stock-exchange.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-stock-exchange',
  templateUrl: './stock-exchange.component.html',
  styleUrls: ['./stock-exchange.component.css']
})
export class StockExchangeComponent implements OnInit {
  stockExchangeList: any;
  companies: string[] = [];
  constructor(private stockExchangeService: StockExchangeService,private router: Router) { }

  ngOnInit() {
    this.stockExchangeService.getAllStockExchange().subscribe((response) =>{
      this.stockExchangeList = response['stockExchange'];
    })

  }
  add(){
    this.router.navigate(['add-stock-exchange']);
  }
  edit(id){
    this.router.navigate(['edit-stock-exchange', id]);
  }
}
