import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../../services/login.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Usuario } from '../../../models/usuario.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public myForm:FormGroup;
  constructor(private formBuilder:FormBuilder, 
    private loginService : LoginService,private usr:Usuario,private router: Router) { }

  ngOnInit() {
    this.myForm = this.formBuilder.group({
      correo:['',[Validators.required,Validators.email]],
      pass:['',Validators.required]
    });
  }

  async Login()
  {
    let user = <Usuario>await this.loginService.getLogin(this.myForm.value).toPromise();
    console.log(user);
    if(user.id!=null)
    {
      this.loginService.setLoginInfo(user);
      this.router.navigate(['/home']);
    }
    else
    {
      alert("usuario o contraseña incorrectos"); 
    }
  }
}
