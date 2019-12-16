import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './site/register/register.component';
import { LoginComponent } from './site/login/login.component';

const routes: Routes = [
  { path: '', component:RegisterComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component:LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
