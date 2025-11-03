import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserRegister } from '../interfaces/UserRegister';
import { AuditServiceService } from '../services/audit-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user:UserRegister={uid:0,name:"",uname:"",password:"",role:"",isAccountLocked:false}

  constructor(private service:AuditServiceService,private router:Router) { }

  ngOnInit(): void {
  }
  setRole(e:any){
    if(e.target.checked==true){
      this.user.role="ROLE_admin"
    }
    else{
      this.user.role="ROLE_user"
    }
  }
  // setRole(e:any){
  //   alert(e.target.value)
  //   this.user.role=e.target.value
  // }
  register(){
    this.service.register(this.user).subscribe(
      data=>{
        this.router.navigate(['login'])
      },
      error=>{
        alert("username already exit")
      }
    )
  }

}