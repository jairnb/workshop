import { createFeatureSelector } from "@ngrx/store";
import { CompanyList } from "../shared/company-list.model";



export const allCompanies = createFeatureSelector<CompanyList>('companies');