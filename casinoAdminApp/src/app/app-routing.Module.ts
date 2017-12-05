import {NgModule} from '@angular/core';
import {Router, RouterModule, Routes} from '@angular/router';
import {HeaderComponent} from './header/header.component';
import {RegisterComponent} from './register/register.component';
import {UsersComponent} from './users/users.component';
import {HomeComponent} from './home/home.component';


const appRoutes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'header', component: HeaderComponent },
  { path: 'register', component : RegisterComponent},
  { path: 'users', component: UsersComponent },
  {path : 'home' , component: HomeComponent}
];





@NgModule({
  imports : [RouterModule.forRoot(appRoutes)],
  exports : [RouterModule]
})
export  class AppRoutingModule {


}




