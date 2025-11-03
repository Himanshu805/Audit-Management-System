import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CheckList } from '../interfaces/checklist';

@Injectable({
  providedIn: 'root'
})
export class ChecklistService {

  constructor(private http:HttpClient) { }

  getQuestions(auditType:string):Observable<CheckList[]>{
    return this.http.get<CheckList[]>("http://localhost:8082/checklist/getQuestions/"+auditType,
    { headers:new HttpHeaders({'Authorization': "Bearer "+localStorage.getItem('token')})});
  }
}
