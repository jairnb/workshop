import { Routes } from '@angular/router';
import { CompanyComponent } from './company/company.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'company', component: CompanyComponent}
];
