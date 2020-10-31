export class Task {
  id: number;
  active: boolean;
  taskName: string;
  startDate: Date;
  endDate: Date;
  progress: number;
  description: string;
  taskFieldId: number;
  priorityId: number;
  status: number;
  userAssign: any = {};
  userAssignId: number;
  startDateNgb: any = {};
  endDateNgb: any = {};
  userExcute: any = {};
  userExcutePrimaryId: number;
  taskDocument: any = [];
  approveStatus: number;
  priority: any = {};
  field: any = {};
  taskExecute: any = [];
  docAtt: any = [];
  parentId: number;
  parent: any;
  deadlineWarning: any;
  codeTask: string;
}
