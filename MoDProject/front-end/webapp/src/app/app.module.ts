import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './site/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './site/login/login.component';
import { HeaderComponent } from './site/header/header.component';
import { EditUserComponent } from './site/edit-user/edit-user.component';
import { HomeComponent } from './home/home.component';
import { CompanyDisplayComponent } from './stock/company-display/company-display.component';
import { SearchComponent } from './stock/search/search.component';
import { AdminFileUploadComponent } from './stock/admin-file-upload/admin-file-upload.component';
import { StockExchangeComponent } from './stock/stock-exchange/stock-exchange.component';
import { AddStockExchangeComponent } from './stock/add-stock-exchange/add-stock-exchange.component';
import { EditStockExchangeComponent } from './stock/edit-stock-exchange/edit-stock-exchange.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    EditUserComponent,
    HomeComponent,
    CompanyDisplayComponent,
    SearchComponent,
    AdminFileUploadComponent,
    StockExchangeComponent,
    AddStockExchangeComponent,
    EditStockExchangeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
