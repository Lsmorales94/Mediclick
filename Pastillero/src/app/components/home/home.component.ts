import { Component } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  title = 'AngularMaterialGettingStarted';
  nombreUsuario = "";
  constructor(private loginService : LoginService, private router: Router){}
  
  ngOnInit() {
    this.nombreUsuario = this.loginService.getUserName();
  }
  isMenuOpen = false;
  contentMargin = 240;

  task: string[] = []
  
  onToolbarMenuToggle() {
    console.log('On toolbar toggled', this.isMenuOpen);
    this.isMenuOpen = !this.isMenuOpen;

    if(!this.isMenuOpen) {
      this.contentMargin = 70;
    } else {
      this.contentMargin = 240;
    }
  }
  logOut(){
    this.router.navigate(['/login']);
  }
}