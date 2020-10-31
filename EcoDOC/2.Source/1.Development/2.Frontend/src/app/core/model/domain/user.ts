import { NgbDate } from "@ng-bootstrap/ng-bootstrap";

export class User {
  public id: number;
  public photo: string;
  public clientId: number;
  public userName: string;
  public fullName: string;
  public indentity: number;
  public birthday: string;
  public birthday_tmp: NgbDate = new NgbDate(null, null, null);
  public phone: number;
  public email: string;
  public sex: boolean;
  public gender: number;
  public active: boolean;
  public org: number;
  public position: number;
  public lead: boolean;
  public phoneCA: string;
  public phoneCAProvider: string;
  public signature: string;
  public positionModel: any={};
  public address:string;

  public nameToken:string;
  public serialToken:string;
  public startTimeToken:string;
  public expiredTimeToken:string;
  public orgToken:string;
}
