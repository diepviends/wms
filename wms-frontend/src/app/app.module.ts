import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login.component';
import { EmployeeComponent } from './employee/employee.component';

import { AuthGuard } from './auth/auth.guard';

import { AuthService } from './auth/auth.service';
import { EmployeeService } from './employee/employee.service';

import { routing } from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [
    AuthGuard,
    AuthService,
    EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
