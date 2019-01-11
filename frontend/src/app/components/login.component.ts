import {Component} from '@angular/core';
import {Observable} from 'rxjs';
import {LoginService} from '../services/login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html'
})

export class Login {
  private model = {'username':'', 'password':''};
  private currentUserName;

  constructor (private LoginService: LoginService) {
    this.currentUserName=localStorage.getItem("currentUserName");
  }

  onSubmit() {
    this.LoginService.sendCredential(this.model).subscribe(
      data => {
                localStorage.setItem("token", JSON.parse(JSON.stringify(data))._body);
                this.LoginService.sendToken(localStorage.getItem("token")).subscribe(
                  data => {
                            this.currentUserName=this.model.username;
                            localStorage.setItem("currentUserName", this.model.username);
                            this.model.username='';
                            this.model.password='';
                          },
                  error => console.log(error)
                );
              },
      error => console.log(error)
    );
  }

}
