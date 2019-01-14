import {Component, Input} from '@angular/core';
import {NavBar} from './nav-bar.component';
import {Photo} from '../models/photo';
import {PhotoService} from '../services/photo.service';
import {ImageComments} from './image-comments.component';
import {UserService} from '../services/user.service';
import {User} from '../models/user';
import {ActivatedRoute, Params} from '@angular/router';

@Component({
  selector: 'image-detail',
  templateUrl: './image-detail.component.html'
})
export class ImageDetail {
  photo: Photo = new Photo();
  like: string;
  user: User;
  photoId: number;

  constructor(private photoService: PhotoService, private userService: UserService, private route: ActivatedRoute){
    this.route.params.forEach((params: Params) => {
      this.photoId = Number.parseInt(params['id']);
    });

    this.photoService.getPhotoById(this.photoId).subscribe(
      photo => {
        this.photo = JSON.parse(JSON.parse(JSON.stringify(photo))._body);
        this.userService.getUserByName(localStorage.getItem("currentUserName")).subscribe(
          user => {
            this.user = JSON.parse(JSON.parse(JSON.stringify(user))._body);
            if (this.user.likedPhotoList.filter(photo => photo.photoId == this.photo.photoId)[0]) {
              this.like="Unlike";
            } else {
              this.like="Like"l;
            }
          },
          error => console.log(error)
        )
      }
    )

  }
}
