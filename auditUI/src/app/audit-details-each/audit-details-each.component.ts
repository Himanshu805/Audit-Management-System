import { Component, Input, OnInit } from '@angular/core';
import { ProjectAudit } from '../interfaces/ProjectAudit';

@Component({
  selector: 'app-audit-details-each',
  templateUrl: './audit-details-each.component.html',
  styleUrls: ['./audit-details-each.component.css']
})
export class AuditDetailsEachComponent implements OnInit {

  @Input() project:ProjectAudit={projectId:0,projectName:"",projectManagerName:"",applicationOwnername:"", auditDetails:[]}
  constructor() { }

  ngOnInit(): void {
  }

}
