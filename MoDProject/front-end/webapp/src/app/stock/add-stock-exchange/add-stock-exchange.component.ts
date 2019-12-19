import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { StockExchangeService } from '../stock-exchange.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-stock-exchange',
  templateUrl: './add-stock-exchange.component.html',
  styleUrls: ['./add-stock-exchange.component.css']
})
export class AddStockExchangeComponent implements OnInit {
  addForm: FormGroup;
  stockCreated: boolean = false;
  error:string;
  constructor(private stockExchangeService : StockExchangeService, private router:Router) { }

  ngOnInit() {
    this.error = '';
    this.stockCreated = false;
    this.addForm = new FormGroup({
      'id': new FormControl(0),
      'stockExchange': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
      'brief': new FormControl("", [Validators.required]),
      'address': new FormControl("", [Validators.required]),
      'remarks': new FormControl(""),
      'logo': new FormControl("", [Validators.required]),
    });
  }

  onSubmit(addForm){
    this.error = '';
    this.stockExchangeService.postStockExchange(addForm.value).subscribe((response) => {
      this.stockCreated = true;
    }, (responseError) => {
      this.error = responseError.error.errorMessage;
    });
  }
  back(){
    this.router.navigate(['stock-exchange']);
  }
}
