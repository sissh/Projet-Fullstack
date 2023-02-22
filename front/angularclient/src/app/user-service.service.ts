import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user';
import { UserType } from './user-type'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080/';
  }

  public findAllUsers(): Observable<User []> {
    return this.http.get<User []>(this.url+"users");
  }

  public findAllTypes(): Observable<UserType []> {
    return this.http.get<UserType []>(this.url+"usertypes");
  }

  public saveUser(user: User) {
    return this.http.post<User>(this.url+"users", user, {responseType: 'text' as 'json'});
  }

  public saveType(type: UserType) {
    return this.http.post<UserType>(this.url+"usertypes", type, {responseType: 'text' as 'json'});
  }

  public editUser(user: User) {
    return this.http.post<User>(this.url+"edituser/"+user.id, user, {responseType: 'text' as 'json'});
  }

  public editType(type: UserType) {
    return this.http.post<UserType>(this.url+"edittype/", type, {responseType: 'text' as 'json'});
  }

  public deleteUser(user: User) {
    return this.http.post<User>(this.url+"deleteuser/"+user.id, user, {responseType: 'text' as 'json'});
  }

  public deleteType(type: UserType) {
    return this.http.post<UserType>(this.url+"deletetype/", type, {responseType: 'text' as 'json'});
  }


}
