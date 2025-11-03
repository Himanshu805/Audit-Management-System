import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuditServiceService } from '../services/audit-service.service';
import { User } from '../interfaces/User';
import { JwtResponse } from '../interfaces/JwtResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser:User={username:"",password:""}
  constructor(private router:Router,private service:AuditServiceService) { }

  ngOnInit(): void {

  }
  onSubmit(){
     this.service.login(this.loginUser).subscribe(
       (data:JwtResponse)=>{
        this.service.setTokenUsername(data.jwtToken,this.loginUser.username)
      }
    )
    this.router.navigate(['/home']);
  }

}
