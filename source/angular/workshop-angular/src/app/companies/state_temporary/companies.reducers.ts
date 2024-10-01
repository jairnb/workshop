import { createReducer, on } from '@ngrx/store';

import { CompanyList } from "../shared/company-list.model";
import { getAllCompanies } from './companies.action';


export const initialState: CompanyList = {
    companies: []
}

export const companyReducer = createReducer(
    initialState,
    on(getAllCompanies, (_state, { companies }) => companies)
  );