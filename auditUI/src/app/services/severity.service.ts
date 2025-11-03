import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, ObservedValueOf } from 'rxjs';
import { AuditRequest } from '../interfaces/AuditRequest';
import { AuditResponse } from '../interfaces/auditResponse';
import { ProjectAudit } from '../interfaces/ProjectAudit';

@Injectable({
  providedIn: 'root'
})
export class SeverityService {

  constructor(private http:HttpClient) { }

  getProjectsByUname():Observable<ProjectAudit[]>{
    return this.http.get<ProjectAudit[]>("http://localhost:8084/severity/getProjects/"+localStorage.getItem('username'),
    { headers:new HttpHeaders({'Authorization': "Bearer "+localStorage.getItem('token')})})
  }

  getAuditResponse(projectAudit:AuditRequest):Observable<AuditResponse>{
    //projectAudit={projectId:0,projectName:"",projectManagerName:"",applicationOwnername:"", auditDetails:{auditType:"x",auditDate:new Date(),questions:[]}}
    return this.http.put<AuditResponse>("http://localhost:8084/severity/ProjectExecutionStatus",projectAudit,
    { headers:new HttpHeaders({'Authorization': "Bearer "+localStorage.getItem('token'),'content-type':'application/json'})}
    )
  }

}
