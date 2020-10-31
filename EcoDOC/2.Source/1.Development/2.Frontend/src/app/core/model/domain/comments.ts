// import { Attachment } from './attachment';

import { Attachment } from "./attachment";

export class Comments {
  id: number;
  active: boolean;
  createDate: Date;
  updateDate: Date;
  createBy: number;
  updateBy: Date;
  docId: number;
  comment: string = '';
  userPosition: string;
  userId: number;
  attachments: Attachment[]
  userFullName: string
}
