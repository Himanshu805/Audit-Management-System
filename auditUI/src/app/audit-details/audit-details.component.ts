import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProjectAudit } from '../interfaces/ProjectAudit';
import { SeverityService } from '../services/severity.service';

@Component({
  selector: 'app-audit-details',
  templateUrl: './audit-details.component.html',
  styleUrls: ['./audit-details.component.css']
})
export class AuditDetailsComponent implements OnInit {
  projects:ProjectAudit[]=[]
  constructor(private severityService:SeverityService,private router:Router) { }

  ngOnInit(): void {
    this.getProjectAudits()
  }

  getProjectAudits(){
    this.severityService.getProjectsByUname().subscribe(
      (data:ProjectAudit[])=>this.projects=data
      ,error=>{
        alert("session expired")
        this.router.navigate(["login"])
      }
      
    )
  }

}
