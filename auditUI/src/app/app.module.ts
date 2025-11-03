import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AuditHomeComponent } from './audit-home/audit-home.component';
import { RegisterComponent } from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { AuditComponent } from './audit/audit.component';
import { QuestionsComponent } from './questions/questions.component';
import { FormsModule } from '@angular/forms';
import { QuestionComponent } from './question/question.component';
import { AuditResultComponent } from './audit-result/audit-result.component';
import { AuditDetailsComponent } from './audit-details/audit-details.component';
import { HttpClientModule } from '@angular/common/http';
import { AuditDetailsEachComponent } from './audit-details-each/audit-details-each.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AuditHomeComponent,
    RegisterComponent,
    HeaderComponent,
    AuditComponent,
    QuestionsComponent,
    QuestionComponent,
    AuditResultComponent,
    AuditDetailsComponent,
    AuditDetailsEachComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
