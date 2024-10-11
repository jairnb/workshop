import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CompanyList } from './company-list.model';
import { Company } from "./company.model";
import { environment } from '../../../environments/environment';

// const httpOptions = {
//   headers: new HttpHeaders ({
//     "Access-Control-Allow-Origin": "**"
//   })
// }


@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<CompanyList> {
    return this.http
      .get<CompanyList>(
        environment.company_service_url
      )
      .pipe(map((company) => company || {}));
  }


  save(company: Company): Observable<any> {
    return this.http
      .post<any>(
        environment.company_service_url,
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
