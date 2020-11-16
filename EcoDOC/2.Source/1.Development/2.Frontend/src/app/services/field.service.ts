import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {ApiHelper} from 'src/app/core/rest/api-helper';
import {map} from 'rxjs/operators';
import { HttpParams} from '@angular/common/http';

import {Constant} from '../core/config/constant';
import { Field } from '../core/model/domain/form';
import {FieldType} from '../core/model/domain/FieldType';
import { FieldProperties } from '../core/model/domain/FieldProperties';
import {aspectField} from '../core/model/domain/aspectField';

@Injectable({
  providedIn: 'root'
})
export class FieldService {

  constructor(
    private apihelper: ApiHelper,
  ) {
  }
  //<------------------ API alfresco ------------------->
  public getAllModelAlfresco(ticKet:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.GETALL+ '?ticKet=' + ticKet);

  }
  public activeModelAlfresco(ticKet:string,name:string,typeAcitve:number){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.ACTIVE+ '?ticKet=' + ticKet+'&name='+name+'&typeActive='+typeAcitve);

  }

  public getAllAspects(ticKet:string,name:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.GET_ALL_ASPECTS+ '?ticKet=' + ticKet+'&name='+name);

  }
  public getAllCustomType(ticKet:string,name:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.GET_ALL_CUSTOM_TYPE+ '?ticKet=' + ticKet+'&name='+name);

  }
  public deleteModelAlfresco(name:string,ticKet:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.DELETE+ '?ticKet=' + ticKet+'&name='+name);

  }
  public getModelDetail(name:string,ticKet:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.GET_DETAIL+ '?ticKet=' + ticKet+'&name='+name);

  }
  public createModelAlfresco(field:Field,ticKet:string){
    let body={
        "author": field.author,
        "name": field.name,
        "description": field.description,
        "namespaceUri": field.namespaceUri,
        "namespacePrefix": field.namespacePrefix,
        "status": "DRAFT",
         "ticKet":ticKet
    }
    return this.apihelper.post(Constant.ALFRESCO_MODEL.CREATE,body);
  }
  public updateModelAlfresco(field:Field,ticKet:string){
    let body={
        "author": field.author,
        "name": field.name,
        "description": field.description,
        "namespaceUri": field.namespaceUri,
        "namespacePrefix": field.namespacePrefix,
         "ticKet":ticKet
    }
    return this.apihelper.post(Constant.ALFRESCO_MODEL.UPDATE,body);
  }
  public createCustypeAlfresco(fieldType:FieldType,ticKet:string,name:string){
    let body={
        "description": fieldType.description,
        "name": fieldType.name,
        "parentName": fieldType.parentName,
        "title": fieldType.title,
        "modelName": name,
         "ticKet":ticKet
    }
    return this.apihelper.post(Constant.ALFRESCO_MODEL.CREATE_CUSTYPE,body);
  }

  public updateCustypeAlfresco(fieldType:FieldType,ticKet:string,name:string){
    let body={
      "description": fieldType.description,
      "name": fieldType.name,
      "parentName": fieldType.parentName,
      "title": fieldType.title,
      "modelName": name,
      "ticKet":ticKet
    }
    console.log(body);
    return this.apihelper.post(Constant.ALFRESCO_MODEL.UPDATE_CUSTYPE,body);
  }
  public deleteCustomType(ticKet:string,name:string,modelName:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.DELETE_CUSTOM_TYPE+ '?ticKet=' + ticKet+'&name='+name+'&modelName='+modelName);
  }
  public getDetailCustomType(ticKet:String,name:string,modelName:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.GET_DETAIL_CUSTOM_TYPE+ '?ticKet=' + ticKet+'&name='+name+'&modelName='+modelName);
  }

  deleteAspects(ticKet:string,name:string,modelName:string){
    return this.apihelper.get(Constant.ALFRESCO_MODEL.DELETE_ASPECTS+ '?ticKet=' + ticKet+'&name='+name+'&modelName='+modelName);

  }

  public createProperties(properties: FieldProperties,ticKet:string,typeName:string,modelName:string, type: string){
    if(properties.indexTokenisationMode==undefined) properties.indexTokenisationMode="FALSE";
    if(properties.facetable==undefined) properties.facetable="FALSE";
    if(properties.title==undefined) properties.title="";
    if(properties.defaultValue==undefined) properties.defaultValue="";
    if(properties.description==undefined) properties.description="";
    if(properties.indexed==undefined) properties.indexed=false;
    if(properties.mandatory==undefined) properties.mandatory=false;
    if(properties.mandatoryEnforced==undefined) properties.mandatoryEnforced=false;
    if(properties.multiValued==undefined) properties.multiValued=false;
    if(properties.dataType==undefined) properties.dataType="d:text";
    let body={
        "name": properties.name,
        "title":properties.title,
        "description":properties.description,
        "multiValued": properties.multiValued,
        "mandatory": properties.mandatory,
        "mandatoryEnforced": properties.mandatoryEnforced,
        "defaultValue": properties.defaultValue,
        "dataType": properties.dataType,
        "indexed": properties.indexed,
        "facetable": properties.facetable,
        "indexTokenisationMode":properties.indexTokenisationMode,
        "typeName":typeName,
        "modelName":modelName,
        "ticKet":ticKet,
        "type": type
    }
    console.log(body)
    return this.apihelper.post(Constant.ALFRESCO_MODEL.CREATE_PROPERTIES,body);
  }
  public updateProperties(properties: FieldProperties,ticKet:string,typeName:string,modelName:string, types: string){
    if(properties.indexTokenisationMode==undefined) properties.indexTokenisationMode="FALSE";
    if(properties.facetable==undefined) properties.facetable="FALSE";
    if(properties.title==undefined) properties.title="";
    if(properties.defaultValue==undefined) properties.defaultValue="";
    if(properties.description==undefined) properties.description="";
    if(properties.indexed==undefined) properties.indexed=false;
    if(properties.mandatory==undefined) properties.mandatory=false;
    if(properties.mandatoryEnforced==undefined) properties.mandatoryEnforced=false;
    if(properties.multiValued==undefined) properties.multiValued=false;
    if(properties.dataType==undefined) properties.dataType="d:text";
    let body={
        "name": properties.name,
        "title":properties.title,
        "description":properties.description,
        "multiValued": properties.multiValued,
        "mandatory": properties.mandatory,
        "mandatoryEnforced": properties.mandatoryEnforced,
        "defaultValue": properties.defaultValue,
        "dataType": properties.dataType,
        "indexed": properties.indexed,
        "facetable": properties.facetable,
        "indexTokenisationMode":properties.indexTokenisationMode,
        "typeName":typeName,
        "modelName":modelName,
        "ticKet":ticKet,
        "types": types
    }
    return this.apihelper.post(Constant.ALFRESCO_MODEL.UPDATE_PROPERTIES,body);
  }
  public deleteProperties(ticKet:string,typeName:string,modelName:string,name:string){

    return this.apihelper.get(Constant.ALFRESCO_MODEL.DELETE_PROPERTIES+'?typeName='+typeName+'&modelName='+modelName+'&ticKet='+ticKet+'&name='+name);
  }

  createAspects(aspects) {
    return this.apihelper.post(Constant.ALFRESCO_MODEL.CREATE_ASPECTS, aspects);
  }

  getOneAspect(ticket: string, modelName: string, aspectsName: string) {
    let params = new HttpParams().set('ticket', ticket).set('modelName', modelName).set('aspectsName', aspectsName );
    console.log(params)
    return this.apihelper.get(Constant.ALFRESCO_MODEL.GET_ONE_ASPECTS, {params: params})
  }

  updateAspects(aspects) {
    return this.apihelper.post(Constant.ALFRESCO_MODEL.UPDATE_ASPECT, aspects);
  }

  // <------------------end---------------------->


  //<--------------- API DB server --------------->
  public activeModelDb(name:string){
    return this.apihelper.get(Constant.FIELDS.ACTIVE+ name);
  }

  createFieldType(fieldType: FieldType) {
    return this.apihelper.post(Constant.FROM_NEW.CREATE_FIELD_TYPE, fieldType);
  }

  public createFielTypeDb(fieldType:FieldType, modelName: string){
    return this.apihelper.post(Constant.FIELDS_TYPE.CREATE + modelName ,fieldType);
  }

  public updateFielTypeDb(fieldType:FieldType, modelName: string){
    return this.apihelper.post(Constant.FIELDS_TYPE.UPDATE + modelName ,fieldType);
  }

  deleteFieldTypeDb(name: string, modelName: string) {
    return this.apihelper.get(Constant.FIELDS_TYPE.DELETE + name + '/' + modelName);
  }

  public updateFielDb(field:Field){
    let body={
      "author": field.author,
      "description":field.description,
      "namespaceUri": field.description,
      "namespacePrefix": field.namespacePrefix,
      "status": "DRAFT"
    }
    return this.apihelper.post(Constant.FIELDS.UPDATE+field.name,body);
  }

  deleteFieldDb(name: string) {
    return this.apihelper.get(Constant.FIELDS.DELETE + name);
  }

  updateActiveFieldType(id: number) {
    const param = new HttpParams().set('id', String(id));
    return this.apihelper.post(Constant.FROM_NEW.UPDATE_ACTIVE_FIELD_TYPE, param).pipe(map(data => data.data));
  }

  public createFielDb(field:Field){
    let body={
      "author": field.author,
      "name": field.name,
      "description":field.description,
      "namespaceUri": field.description,
      "namespacePrefix": field.namespacePrefix,
      "status": "ACTIVE"
    }
    return this.apihelper.post(Constant.FIELDS.CREATE,body);
  }

  createFieldAspectDB(aspects: aspectField, modelName: string) {
    return this.apihelper.post(Constant.FROM_NEW.CREATE_FIELD_ASPECTS + modelName, aspects);
  }

  updateFieldAspectDB(aspects: aspectField, modelName: string) {
    return this.apihelper.post(Constant.FROM_NEW.UPDATE_FIELD_ASPECTS + modelName, aspects);
  }

  deleteFieldAspectDB(name: string, modelName: string) {
    return this.apihelper.get(Constant.FROM_NEW.DELETE_FIELD_ASPECTS + name + '/' + modelName);
  }

  createPropertiesDB(properties: FieldProperties, modelName: string, typeName: string, type: string) {
    return this.apihelper.post(Constant.FROM_NEW.CREATE_FIELD_PROPERTIES + modelName + '/' + typeName + '/' + type, properties);
  }

  updatePropertiesDB(properties: FieldProperties, modelName: string, typeName: string, type: string) {
    return this.apihelper.post(Constant.FROM_NEW.CREATE_FIELD_PROPERTIES + modelName + '/' + typeName + '/' + type, properties);
  }

// <------------------end---------------------->
}
