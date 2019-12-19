import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StockExchangeService } from '../stock-exchange.service';

@Component({
  selector: 'app-edit-stock-exchange',
  templateUrl: './edit-stock-exchange.component.html',
  styleUrls: ['./edit-stock-exchange.component.css']
})
export class EditStockExchangeComponent implements OnInit {
  addForm: FormGroup;
  stockExchange: any;
  stockCreated: boolean = false;
  error:string;
  constructor(private router:ActivatedRoute, private stockExchangeService: StockExchangeService, private route: Router) { 
    this.addForm = new FormGroup({
      'id': new FormControl(0),
      'stockExchange': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
      'brief': new FormControl("", [Validators.required]),
      'address': new FormControl("", [Validators.required]),
      'remarks': new FormControl(""),
      'logo': new FormControl("", [Validators.required]),
    });
  }

  ngOnInit() {
    this.router.paramMap.subscribe(params => {
      console.log(params);
      this.stockExchangeService.getStockExchangeById(params.get('id')).subscribe((response) => {
        console.log(response);
        this.stockExchange = response;
        this.addForm = new FormGroup({
          'id': new FormControl(this.stockExchange.id),
          'stockExchange': new FormControl(this.stockExchange.stockExchange, [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
          'brief': new FormControl(this.stockExchange.brief, [Validators.required]),
          'address': new FormControl(this.stockExchange.address, [Validators.required]),
          'remarks': new FormControl(this.stockExchange.remarks),
          'logo': new FormControl(this.stockExchange.logo, [Validators.required]),
        }); 
      });
      });
  }
  onSubmit(addForm){
    this.stockExchangeService.updateStockExchange(addForm.value).subscribe((response) => {
      this.stockCreated = true;
    })
  }
  back(){
    this.route.navigate(['stock-exchange']);
  }
}
