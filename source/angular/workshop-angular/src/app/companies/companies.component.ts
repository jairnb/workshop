import { Component, OnInit } from '@angular/core';
import { CompanyService } from './shared/company.service';
import { CompanyList } from './shared/company-list.model';
import { CommonModule, NgFor } from '@angular/common';
import { randomUUID } from 'crypto';
import { Observable } from 'rxjs';
import { Store, select } from '@ngrx/store';
import { CompaniesActions, getAllCompanies } from "./state_temporary/companies.action";
import { allCompanies } from './state_temporary/companies.selector';

@Component({
  selector: 'app-companies',
  standalone: true,
  imports: [NgFor, CommonModule],
  templateUrl: './companies.component.html',
  styleUrl: './companies.component.css'
})
export class CompaniesComponent implements OnInit {

  // companies: CompanyList = {
  //   companies: []
  // };

  companies$: Observable<CompanyList>;
  // companies$ = this.store.select(state => state.companies);

  constructor(private companyService: CompanyService, private store: Store<{companies: CompanyList}>) {
    this.companies$ = this.store.pipe(select((state) => state.companies));
  }

  ngOnInit(): void {

    this.store.dispatch(CompaniesActions.getAll());

    // this.companyService.findAll().subscribe((companies) => {
    //   this.store.dispatch(getAllCompanies({companies}));
    // })



    // this.companyService.findAll().subscribe(
    //   {
    //     next: (res: any) => {
    //       this.companies = res
    //       console.log("1");

    //       console.log(res);

    //     },

    //     error: (e: any) => {
    //       console.error(e);
    //       console.log("2");

    //     },

    //     complete() {
    //       console.log("is completed");CompaniesActions
    //     },
    //   }

    // );

    // console.log("3");


    // this.companyService.save({ name: "test", address: [] }).subscribe({
    //   next: (res: any) => {
    //     this.companies = res
    //     console.log("12");

    //     console.log(res);

    //   },

    //   error: (e: any) => {
    //     console.error(e);
    //     console.log("22");

    //   },

    //   complete() {
    //     console.log("is completed 22");
    //   },
    // });




  }

}
