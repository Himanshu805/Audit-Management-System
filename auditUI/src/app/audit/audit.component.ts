import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuditRequest } from '../interfaces/AuditRequest';
import { AuditResponse } from '../interfaces/auditResponse';
import { CheckList } from '../interfaces/checklist';
import { ProjectAudit } from '../interfaces/ProjectAudit';
import { ChecklistService } from '../services/checklist.service';
import { SeverityService } from '../services/severity.service';

@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styleUrls: ['./audit.component.css']
})
export class AuditComponent implements OnInit {

  showAuditType:boolean=false
  showQuestions:boolean=false

  projects:ProjectAudit[]=[]
  selectedProject:ProjectAudit={projectId:0,projectName:"",projectManagerName:"",applicationOwnername:"", auditDetails:[]}
 
  auditTypes=["Internal","SOX"]
  selectedAuditType:string="";
  
  auditRequest:AuditRequest={projectName:"",projectManagerName:"",applicationOwnername:"", auditDetails:{auditType:"",auditDate:new Date,questions:[]}}
  questions:CheckList[]=[]
  auditResponse:AuditResponse={auditId:0,projectExecutionStatus:"",remedialActionDuration:""}

  constructor(private router:Router,private severityService:SeverityService,private checklistService:ChecklistService) { }

  loadProjects(){
    this.severityService.getProjectsByUname().subscribe(
      (data:ProjectAudit[])=>this.projects=data
      ,error=>{
        alert("session expired")
        this.router.navigate(["login"])
      }
      
    )
  }

  getQuestions(){
    this.checklistService.getQuestions(this.selectedAuditType).subscribe(
      (data:CheckList[])=>this.questions=data
      ,error=>{
        alert("session expired")
        this.router.navigate(["login"])
      }
      
    )
  }

  ngOnInit(): void {
    this.loadProjects()
  }

  showAuditTypeFun(e:any){
    if(!("select".endsWith(e.target.value) && "select".startsWith(e.target.value))){
      for(let i=0;i<this.projects.length;i++){
        if(this.projects[i].projectName.match(e.target.value)){
          this.selectedProject=this.projects[i];
        }
      }
      this.showAuditType=true;
    }
    else{
      this.showAuditType=false
    }
  }

  showQuestionsFun(e:any){

    if(!("select".endsWith(e.target.value) && "select".startsWith(e.target.value))){
      this.selectedAuditType=e.target.value
      this.getQuestions();
      this.showQuestions=true;
    }
    else{
      this.selectedAuditType=""
      this.showQuestions=false
    }
  }

  setAnswers(e:CheckList[]){
    this.questions=e
  }

  performAudit(){
    this.auditRequest.projectName=this.selectedProject.projectName
    this.auditRequest.projectManagerName=this.selectedProject.projectManagerName
    this.auditRequest.applicationOwnername=this.selectedProject.applicationOwnername
    this.auditRequest.auditDetails.auditType=this.selectedAuditType
    this.auditRequest.auditDetails.auditDate=new Date();
    this.auditRequest.auditDetails.questions=this.questions
    
    for(let i=0;i<this.questions.length;i++){
      if(this.questions[i].answer==undefined){
        this.questions[i].answer="no"
      }
    }

    this.severityService.getAuditResponse(this.auditRequest).subscribe(
      (data:AuditResponse)=>this.auditResponse=data
      ,error=>{
        alert("session expired")
        this.router.navigate(["login"])
      }
      
    )
    
    this.router.navigate(['auditDetails'])
  }

}
