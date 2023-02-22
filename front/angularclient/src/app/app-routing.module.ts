import { NgModule } from '@angular/core';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { RouterModule, Routes } from '@angular/router';
import { TypeListComponent } from './type-list/type-list.component';
import { TypeFormComponent } from './type-form/type-form.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  { path: '*', component: AppComponent },
  { path: 'users', component: UserListComponent },
  { path: "adduser", component: UserFormComponent },
  { path: "usertypes", component: TypeListComponent },
  { path: "addtype", component: TypeFormComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
