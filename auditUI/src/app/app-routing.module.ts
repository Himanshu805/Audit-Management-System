import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuditDetailsComponent } from './audit-details/audit-details.component';
import { AuditHomeComponent } from './audit-home/audit-home.component';
import { AuditResultComponent } from './audit-result/audit-result.component';
import { AuditComponent } from './audit/audit.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { QuestionComponent } from './question/question.component';
import { QuestionsComponent } from './questions/questions.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {path:'',redirectTo:'login',pathMatch:'full'},
  {path:'register',component:RegisterComponent},
  { path : 'login', component:LoginComponent},
  { path : 'home', component:AuditHomeComponent},
  {path:'header',component:HeaderComponent},
  {path:'audit',component:AuditComponent},
  {path:'questions',component:QuestionsComponent},
  {path:'question',component:QuestionComponent},
  {path:"auditResult",component:AuditResultComponent},
  {path:"auditDetails",component:AuditDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
