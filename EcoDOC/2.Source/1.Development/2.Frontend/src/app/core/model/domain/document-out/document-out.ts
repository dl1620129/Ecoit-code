import { Attachment } from './../attachment';

export class DocumentOut {
	id: number;
	bookId: number;
	numberOrSign: string;
	dateIssued: string;
	dateArrival: string;
	numberArrival: number;
	numberSupport: number;
	docTypeId: number;
	docFieldsId: number;
	urgentId: number;
	securityId: number;
	methodReceiptId: number;
	statusReceiptId: number;
	docStatusId: number;
	legalDoc: boolean;
	rqRely: boolean;
	feedback: boolean;
	sendEnvelope: boolean;
	orgIssuedId: number;
	orgIssuedName: string;
	personSign: string;
	personEnter: string;
	placeSend: string;
	deadline: string;
	dayLeft: number;
	preview: string;
	attachments: Attachment[];
	active: boolean;
	node: number;
	files: File;
}
