import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CompanyList } from './company-list.model';
import { Company } from "./company.model";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<CompanyList> {
    return this.http
      .get<CompanyList>(
        'http://localhost:8085/api/v1/company'
      )
      .pipe(map((company) => company || {}));
  }


  save(company: Company): Observable<any> {
    return this.http
    .post<any>(
      'http://localhost:8085/api/v1/company',
      company
    );
   
  }

  findById() {

  }

  update() {

  }

  delete() {

  }

}
