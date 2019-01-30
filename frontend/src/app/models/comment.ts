import {Photo} from './photo';
import {User} from './User';

export class Comment{
  commentId: number;
  photo: Photo;
  userName: string;
  content: string;
  photoId: number;
}
