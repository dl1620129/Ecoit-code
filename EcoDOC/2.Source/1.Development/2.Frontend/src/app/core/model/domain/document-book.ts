import {CategoryType} from "./category-type";

export class DocumentBook {
  id: number;
  name: string;
  startNumber: number;
  currentNumber: number;
  bookType: number;
  numberOrSign: string;
  active: boolean;
  year: number;
}

export class DocumentBookSearch {
  type: number;
  status: boolean;
  name: string
}

