import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './site/register/register.component';
import { LoginComponent } from './site/login/login.component';
import { EditUserComponent } from './site/edit-user/edit-user.component';
import { HomeComponent } from './home/home.component';
import { CompanyDisplayComponent } from './stock/company-display/company-display.component';
import { AdminFileUploadComponent } from './stock/admin-file-upload/admin-file-upload.component';
import { LoginGuard } from './site/login.guard';
import { StockExchangeComponent } from './stock/stock-exchange/stock-exchange.component';
import { AddStockExchangeComponent } from './stock/add-stock-exchange/add-stock-exchange.component';
import { EditStockExchangeComponent } from './stock/edit-stock-exchange/edit-stock-exchange.component';

const routes: Routes = [
  { path: '', component:HomeComponent },
  { path: 'home', component:HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component:LoginComponent},
  { path: 'edit-user/:name', component:EditUserComponent, canActivate:[LoginGuard]},
  { path: 'company-display', component:CompanyDisplayComponent, canActivate:[LoginGuard]},
  { path: 'upload-file', component:AdminFileUploadComponent, canActivate:[LoginGuard]},
  { path: 'stock-exchange', component:StockExchangeComponent, canActivate:[LoginGuard]},
  { path: 'add-stock-exchange', component:AddStockExchangeComponent, canActivate:[LoginGuard]},
  { path: 'edit-stock-exchange/:id', component:EditStockExchangeComponent, canActivate:[LoginGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
