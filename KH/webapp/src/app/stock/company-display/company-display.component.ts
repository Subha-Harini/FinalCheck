import { Component, OnInit } from '@angular/core';
import { CompanyService } from '../company.service';

@Component({
  selector: 'app-company-display',
  templateUrl: './company-display.component.html',
  styleUrls: ['./company-display.component.css']
})
export class CompanyDisplayComponent implements OnInit {
  companyList:any;
  filterCompanyList: any;
  isGetDetailsClicked: boolean;
  company: any;
  constructor(private companyService: CompanyService) { }

  ngOnInit() {
    this.isGetDetailsClicked = false;
    this.companyService.getAllCompanies().subscribe((response) => {
      console.log(response);
      this.companyList = response;
      this.filterCompanyList = response;
      console.log(this.companyList);
    })

  }
  getDetails(id){
    this.isGetDetailsClicked = true;
    this.companyService.getCompanyById(id).subscribe((response) =>{
      console.log(response);
      this.company = response;
    })
  }
  filterItems($event) {
    this.filterCompanyList = this.companyService.getFilteredCompanies($event, this.companyList);
  }
  back(){
    this.isGetDetailsClicked = false;
  }

}
