import { createAction, props } from '@ngrx/store';
import { CompanyList } from '../shared/company-list.model';


export const getAllCompanies = createAction('[Company Service] All Companies', props<{companies: CompanyList}>());

