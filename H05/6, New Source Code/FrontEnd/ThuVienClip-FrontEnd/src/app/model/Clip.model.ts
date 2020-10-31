export class ClipModel{
    id: number;
	groupId: number;
	companyId: number;
	createDate: Date  ;
	createByUser: string;
	modifiedDate: Date   ;
	modifiedByUser: string;
	title: string;
	description: string;
	clipAttachId: number;
	imageAttachId: number;
	viewCount: number;
	likeCount: number;
	categoryId: number;
    isAudio: Boolean;
    display: Boolean;
	nguonVideo: string;
	tacGia: string;
	thoiLuongVideo: string;
	isDaiDien: Boolean;
	clipFileId: number;
	folderId: number;
	videos: File;
	selected: boolean;
    constructor(){}
}