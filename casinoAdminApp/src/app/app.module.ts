import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { UsersComponent } from './users/users.component';
import { RegisterComponent } from './register/register.component';
import { UserSearchComponent } from './users/user-search/user-search.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {AppRoutingModule} from './app-routing.Module';
import { HomeComponent } from './home/home.component';
import {DataStorageService} from './shared/data-storage.service';
import {UserService} from './shared/user.service';
import {ContactFilterPipe} from './shared/ContactFilter.pipe';
import { EmailFilterPipe} from './shared/EmailFilter.pipe';
import {NameFilterPipe} from './shared/NameFilter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    UsersComponent,
    RegisterComponent,
    UserSearchComponent,
    HomeComponent,
    ContactFilterPipe,
    EmailFilterPipe,
    NameFilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    ReactiveFormsModule,


  ],
  providers: [DataStorageService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
