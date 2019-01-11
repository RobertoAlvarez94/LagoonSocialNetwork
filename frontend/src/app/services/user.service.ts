import {User} from '../models/user';
import {Injectable} from '@angular/core';
import {Photo} from '../models/photo';
import {Http, Headers} from '@angular/http';

@Injectable()
export class UserService {
  users: User[];

  constructor (private http: Http) {}

  getUsers(){

  }

  getUsersById(id: string){

  }

  getUserByName(username: string){
    let tokenUrl1 = "http://localhost:8080/rest/user/userName";
    let headers = new Headers({'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage});

    return this.http.post(tokenUrl1, username, {headers: headers});
  }
}
