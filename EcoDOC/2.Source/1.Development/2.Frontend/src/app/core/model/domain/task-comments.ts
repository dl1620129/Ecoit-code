import {TaskCommentAtt} from "./task-comment-att";

export class TaskComments {
  id: number;
  active: boolean;
  createDate: Date;
  updateDate: Date;
  createBy: number;
  updateBy: Date;
  taskId: number;
  comment: string;
  userPosition: string;
  userId: number;
  attachments: TaskCommentAtt[]
}
