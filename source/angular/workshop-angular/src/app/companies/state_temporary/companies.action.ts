import { createAction, createActionGroup, emptyProps, props } from '@ngrx/store';
import { CompanyList } from '../shared/company-list.model';


export const getAllCompanies = createAction('[Company Service] All Companies', props<{ companies: CompanyList }>());

export const CompaniesActions = createActionGroup({
    source: 'Companies Page',
    events: {
        getAll: emptyProps(),
        getAllSuccess: (companies: CompanyList) => ({ companies }),
    },
});