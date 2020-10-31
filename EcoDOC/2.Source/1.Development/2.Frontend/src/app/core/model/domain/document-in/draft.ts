import { DocumentType } from './document-type';
import { Category } from '../category';
import { User } from '../user';
import { DocumentOut } from '../document-out/document-out';
import { Attachment } from '../attachment';
import { ReceiveToKnow } from './receive-to-know';
import { ReceiveToKnowDto } from './receive-to-know-dto';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';

export enum RECEIVE_TYPE {
  user = 'USER',
  org = 'ORG',
}

export class Draft {
  attachmentType = {
    document: 'RELATE',
    draft: 'DRAFT',
    comment: 'COMMENT'
  };

  constructor() {}

  id: number;
  docOutId: number;
  numberInBook: number
  orgCreateName: string;
  userCreateName: string;
  nodeId: number;
  docTypeId: number;
  docType: Category;
  docFieldId: number;
  docField: Category;
  securityId: number;
  security: Category;
  urgentId: number ;
  bookId: number;
  book: Category;
  preview: string;
  listReceive: ReceiveToKnow[];
  autoIssued: boolean;
  replyDoc: boolean;
  bookName: string;
  // listReplyDocId: number[];
  replyDocIds: string;
  listReplyDoc: DocumentOut[];
  draftFiles = [];
  documentFiles = [] 
  encrypt: boolean

  numberOrSign: string;
  status: string;
  dateIssued: NgbDate;
  dateArrival: string;
  numberArrival: number;
  numberSupport: number;
  docFieldsId: number;
  methodReceiptId: number;
  statusReceiptId: number;
  docStatusId: number;
  legalDoc: boolean;
  rqRely: boolean;
  feedback: boolean;
  sendEnvelope: boolean;
  orgIssuedId: number;
  orgIssuedName: string;
  personEnterId: number;
  personSign: string;
  personEnter: string;
  placeSend: string;
  deadline: string;
  dayLeft: number;
  attachments: Attachment[];
  active: boolean;
  files: File;
  issuedOnPortal: boolean;
  directiveDoc: boolean;
  personEnterName: string;
  docUrgentName: string;
  docFieldsName: string;
  docTypeName: string;
  docStatusName: string;
  docSecurityName: string;
  listSignerIds: string;
  listSigners: any[];
  receiveToKnowDtos: ReceiveToKnowDto[] = []
  hasSigner: boolean
  separateAttactment() {
    this.documentFiles = this.attachments.filter(file => file.attachmentType == this.attachmentType.document)
    this.draftFiles = this.attachments.filter(file => file.attachmentType == this.attachmentType.draft)
  }

  combileAllInAttachment() {
    this.attachments = this.draftFiles.concat(this.documentFiles)
  }

  convertListReceiveToDto() {
    this.receiveToKnowDtos = []

    for (let receive of this.listReceive) {

      let receiveToKnowDto = new ReceiveToKnowDto()

      Object.assign(receiveToKnowDto, receive)

      if (receive.type == RECEIVE_TYPE.user) {
        receiveToKnowDto.name = receive.fullName
        receiveToKnowDto.receiveId = receive.receiveId
      }

      if (receive.type == RECEIVE_TYPE.org) {
        receiveToKnowDto.name = receive.orgName
        receiveToKnowDto.receiveId = receive.receiveId
      }
      
      console.log('bb', this.receiveToKnowDtos)

      this.receiveToKnowDtos.push(receiveToKnowDto)

      // receiveToKnowDto.id = receiveId
    }
  }

  convertListReceiveDtoToListReceive() {
    this.listReceive = []

    for (let receiveDto of this.receiveToKnowDtos) {

      let receiveToKnow = new ReceiveToKnow()

      Object.assign(receiveToKnow, receiveDto)

      if (receiveDto.type == RECEIVE_TYPE.user) {
        // receiveToKnow.name =  receiveDto.fullNam
        receiveToKnow.type = RECEIVE_TYPE.user
        receiveToKnow.receiveId = receiveDto.receiveId
      }

      if (receiveDto.type == RECEIVE_TYPE.org) {
        // receiveToKnow.type = receive.orgName
        receiveToKnow.type = RECEIVE_TYPE.org
        receiveToKnow.receiveId = receiveDto.receiveId
      }
      
      this.listReceive.push(receiveToKnow)
      console.log("bb2", this.listReceive)

      // receiveToKnowDto.id = receiveId
    }
  }
}
