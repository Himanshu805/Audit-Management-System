import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interfaces/User';
import { JwtResponse } from '../interfaces/JwtResponse';
import { getLocaleWeekEndRange } from '@angular/common';
import { UserRegister } from '../interfaces/UserRegister';

@Injectable({
  providedIn: 'root'
})
export class AuditServiceService {
  
  constructor(private http: HttpClient) { }

  register(u:UserRegister):Observable<String>{
    return this.http.post<String>('http://localhost:8081/user/register',u);
  }
  login(u:User):Observable<JwtResponse>{
    return this.http.post<JwtResponse>('http://localhost:8081/user/login',u);
  }
  setTokenUsername(token:string,username:string){
    localStorage.setItem('token',token)
    localStorage.setItem('username',username)
  }

}
