import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-audit-result',
  templateUrl: './audit-result.component.html',
  styleUrls: ['./audit-result.component.css']
})
export class AuditResultComponent implements OnInit {
  
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  homePage(){
    this.router.navigate(["/home"])
  }
}
