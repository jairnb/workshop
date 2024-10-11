import { Actions, createEffect, ofType } from '@ngrx/effects';
import { Injectable } from '@angular/core';
import { EMPTY } from 'rxjs';
import { map, exhaustMap, catchError, mergeMap } from 'rxjs/operators';
import { CompanyService } from '../shared/company.service';
import { CompaniesActions } from './companies.action';

@Injectable()
export class CompaniesEffects {

    constructor(
        private actions$: Actions,
        private companyService: CompanyService
    ) { }

    loadCompanies$ = createEffect(() => this.actions$.pipe(
        ofType(CompaniesActions.getAll),
        exhaustMap(() => this.companyService.findAll()
            .pipe(
                map(companies => (CompaniesActions.getAllSuccess(companies))),
                catchError(() => EMPTY)
            ))
    )
    );


}