export class LinksModel{
    linksid: number;
    groupid: number;
    created: Date;
    modified: Date;
    linksgroupid: number;
    name: string;
    decription: string;
    url: string;
    imageid: number;
    hasimage:Boolean;
    position: number;
    show:Boolean;
    icon:Boolean;
    parentId: number;
    selected:boolean;
    constructor(){}
}