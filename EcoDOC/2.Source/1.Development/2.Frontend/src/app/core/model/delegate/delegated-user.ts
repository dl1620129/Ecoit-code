import { Attachment } from '../domain/attachment';
export class DelegatedUser {
  id: number
  userName: string
  fullName: string
  type: string
  fromId: number
  delegateId: number
  attachments: Attachment[]
  positionName
}
