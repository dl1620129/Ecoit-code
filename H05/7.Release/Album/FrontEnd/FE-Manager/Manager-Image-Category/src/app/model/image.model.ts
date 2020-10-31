export class ImageModel{
    imageId: number;
    title: string;
    description: string;
    thuTu: number;
    tacGia: string;
    display: boolean;
    isDaiDien: boolean;
    images: File;
    listImage:File[];
    folderId: number;
    imageFileId: number;
    categoryId: number;
    selected: boolean;
    imageUrl:string;
    constructor(){}
}