import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { provideStore, provideState } from '@ngrx/store';
import { reducers, metaReducers } from './reducers';
import { companyReducer } from './companies/state_temporary/companies.reducers';
import { provideEffects } from '@ngrx/effects';
import { CompaniesEffects } from './companies/state_temporary/companies.effects';

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideClientHydration(),
    provideHttpClient(withFetch()),
    provideStore(reducers, { metaReducers }),
    provideState({ name: 'companies', reducer: companyReducer }),
    provideEffects(CompaniesEffects)
]
};
