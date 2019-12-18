import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './site/register/register.component';
import { LoginComponent } from './site/login/login.component';
import { EditUserComponent } from './site/edit-user/edit-user.component';
import { StockPageComponent } from './stock/stock-page/stock-page.component';

const routes: Routes = [
  { path: '', component:RegisterComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component:LoginComponent},
  { path: 'edit-user/:name', component:EditUserComponent},
  { path: 'stock-page', component:StockPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
