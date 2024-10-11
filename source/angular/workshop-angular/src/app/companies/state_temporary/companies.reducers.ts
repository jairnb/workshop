import { createReducer, on } from '@ngrx/store';

import { CompanyList } from "../shared/company-list.model";
import { CompaniesActions, getAllCompanies } from './companies.action';


export const initialState: CompanyList = {
    companies: []
}

export const companyReducer = createReducer(
    initialState,
    on(getAllCompanies, (_state, { companies }) => companies),


    on(CompaniesActions.getAll, (state) => ({ ...state })),
    on(CompaniesActions.getAllSuccess, (_state, { companies }) => ({
        ..._state,
        companies: companies.companies,
    })),
);