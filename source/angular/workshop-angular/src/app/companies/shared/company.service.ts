import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CompanyList } from './company-list.model';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http: HttpClient) { }

  getCompanies(): Observable<CompanyList> {
    return this.http
      .get<CompanyList>(
        'http://localhost:8085/api/v1/company'
      )
      .pipe(map((company) => company || {}));
  }
}
