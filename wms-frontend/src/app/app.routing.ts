import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './auth/login.component';
import { EmployeeComponent } from './employee/employee.component';
import { AuthGuard } from './auth/auth.guard';

const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: '', component: EmployeeComponent, canActivate: [AuthGuard] },

    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);