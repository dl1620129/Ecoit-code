// import { Attachment } from './attachment';

import {Attachment} from "./attachment";

export class TaskDocument {
  id: number;
  active: boolean;
  createDate: Date;
  updateDate: Date;
  createBy: number;
  updateBy: Date;
  taskId: number;
  docId: string;
  documentIn: any;
  documentOut: any;
  typeDocument: boolean;
}
