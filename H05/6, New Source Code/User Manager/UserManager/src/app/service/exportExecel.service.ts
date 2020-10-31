import { Injectable } from '@angular/core';
import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';
import { Workbook } from 'exceljs';
const EXCEL_TYPE = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';
const EXCEL_EXTENSION = '.xlsx';
@Injectable({ providedIn: 'root' })
export class ExcelService {
    constructor() { }
    public exportAsExcelFile(json: any[], excelFileName: string): void {
        console.log(json);
        const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(json);
        const workbook: XLSX.WorkBook = { Sheets: { 'data': worksheet }, SheetNames: ['data'] };
        const excelBuffer: any = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
        this.saveAsExcelFile(excelBuffer, excelFileName);
    }
    
    // public exportAsExcelFile(json: any[], excelFileName: string,headersArray: any[]): void {
    //     console.log(headersArray);
    //     const header = headersArray;
    //     const data = json;
    //     let workbook = new Workbook();
    //     let worksheet = workbook.addWorksheet(excelFileName);
    //     let headerRow = worksheet.addRow(header);
    //     headerRow.eachCell((cell:any, number:any) => {
    //       cell.fill = {
    //         type: 'pattern',
    //         pattern: 'solid',
    //         fgColor: { argb: 'FFFFFF00' },
    //         bgColor: { argb: 'FF0000FF' }
    //       }
    //       cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
    //     })
    //     data.forEach((element) => {
    //       let eachRow : any[];
    //       headersArray.forEach((headers) => {
    //         eachRow.push(element[headers])
    //       })
    //       if (element.isDeleted === "Y") {
    //         let deletedRow = worksheet.addRow(eachRow);
    //         deletedRow.eachCell((cell:any, number:any) => {
    //           cell.font = { name: 'Calibri', family: 4, size: 11, bold: false, strike: true };
    //         })
    //       } else {
    //         worksheet.addRow(eachRow);
    //       }
    //     })
    //     worksheet.getColumn(3).width = 15;
    //     worksheet.getColumn(4).width = 20;
    //     worksheet.getColumn(5).width = 30;
    //     worksheet.getColumn(6).width = 30;
    //     worksheet.getColumn(7).width = 10;
    //     worksheet.addRow([]);
    //     workbook.xlsx.writeBuffer().then((data:any) => {
    //       let blob = new Blob([data], { type: EXCEL_TYPE });
    //       FileSaver.saveAs(blob, excelFileName + '_export_' + new Date().getTime() + EXCEL_EXTENSION);
    //     })
    //   }
    
    private saveAsExcelFile(buffer: any, fileName: string): void {
        const data: Blob = new Blob([buffer], { type: EXCEL_TYPE });
        FileSaver.saveAs(data, fileName + '_export_' + new Date().getTime() + EXCEL_EXTENSION);
    }
}