import { Component, OnInit } from '@angular/core';
import { CompanyService } from './shared/company.service';
import { CompanyList } from './shared/company-list.model';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-companies',
  standalone: true,
  imports: [NgFor],
  templateUrl: './companies.component.html',
  styleUrl: './companies.component.css'
})
export class CompaniesComponent implements OnInit {

  companies: CompanyList = {
    companies: []
  };

  constructor(private companyService: CompanyService) {

  }

  ngOnInit(): void {
    this.companyService.getCompanies().subscribe(
      {
        next: (res: any) => {
          this.companies = res
          console.log("1");
          
          console.log(res);
          
        },
 
        error: (e: any) => {
          console.error(e);
          console.log("2");

        },
     
        complete() {
          console.log("is completed");
        },
      }

    )
  }
}
