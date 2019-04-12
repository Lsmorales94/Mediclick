import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Usuario } from '../../../models/usuario.model';

/* import { TipoUsuario } from 'src/app/models/tipousuario.model'; */

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

/*   tipoUsuarios: Array<TipoUsuario>; */
public myForm:FormGroup;
  constructor(private formBuilder:FormBuilder, private loginService: LoginService,private usr :Usuario) {
    /* this.getTipoUsuario(); */
  }

  ngOnInit() {
    this.myForm = this.formBuilder.group({
      nombre:['',Validators.required],
      apellido:['',Validators.required],
      correo:['',[Validators.required,Validators.email]],
      pass:['',Validators.required]
    });
  }
  async registrarse()
  {
    
    let currentUser = <Usuario>this.myForm.value;
    console.log(currentUser);
    let newUser = <Usuario>await this.loginService.add(currentUser).toPromise();
    if(newUser.id != null)
    {
     alert("Usuario Registrado correctamente"); 
    }
  }
/* 
  getTipoUsuario(){
    this.loginService.getTipoUsuario().subscribe( resp =>{
      this.tipoUsuarios = resp;
    });
  }
 */
}
