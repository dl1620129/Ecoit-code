import {CategoryType} from "./category-type";
import {User} from "./user";

export class CalendarJoin {
  user: User;
  userId: number;
  isOwner: boolean;
  isKnow: boolean;
  isPrepare: boolean;
  prepareNote: string;
  active: boolean
}
