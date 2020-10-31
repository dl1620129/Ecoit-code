import { Injectable } from '@angular/core';
import { Workbook } from 'exceljs';
import * as fs from 'file-saver';

@Injectable({
  providedIn: 'root'
})
export class ExportService {

  constructor() {
  }
  public generateExcelDocumentIn(title, header, data, filename) {
    // Create workbook and worksheet
    let workbook = new Workbook();
    let worksheet = workbook.addWorksheet('Thống kê');
    // Add Row and formatting
    let titleRow = worksheet.addRow([title]);
    titleRow.font = {size: 16, bold: true };
    titleRow.alignment = {vertical: 'middle'};
    worksheet.addRow([]);
    const options = {hour12 : true, hour: 'numeric', minute: 'numeric', weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    let temp = new Date();
    let subTitleRow = worksheet.addRow(['Ngày giờ thống kê : ' + temp.toLocaleDateString('vi-VI', options)]);
    worksheet.mergeCells('A1:J2');
    worksheet.mergeCells('A3:J3');
    // Blank Row
    worksheet.addRow([]);
    // Add Header Row
    let headerRow = worksheet.addRow(header);

    // Cell Style : Fill and Border
    headerRow.eachCell((cell, number) => {
      cell.fill = {
        type: 'pattern',
        pattern: 'solid',
        fgColor: { argb: 'e9f9f7' },
        bgColor: { argb: 'e9f9f7' }
      }
      cell.font = {bold: true }
      cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
    })
    // Add Data and Conditional Formatting
    data.forEach(d => {
      let row = worksheet.addRow(d);
      row.eachCell((cell, number) => {
        cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
        // cell.alignment = {wrapText: true};
      });
    }
    );
    worksheet.getColumn(1).width = 5; // STT
    worksheet.getColumn(1).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(2).width = 15; // Số đến
    worksheet.getColumn(2).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(3).width = 15; // Ngày văn bản
    worksheet.getColumn(3).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(4).width = 15; // Ngày vào sổ
    worksheet.getColumn(4).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(5).width = 20; // Ngày nhận văn bản
    worksheet.getColumn(5).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(6).width = 20; // Số ký hiệu
    worksheet.getColumn(6).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(7).width = 40; // Trích yếu
    worksheet.getColumn(7).alignment = {wrapText: true, vertical: 'middle', horizontal: 'left'};

    worksheet.getColumn(8).width = 30; // Đơn vị ban hành
    worksheet.getColumn(8).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(9).width = 30; // Đơn vị XL
    worksheet.getColumn(9).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(10).width = 15; // Hạn xử lý
    worksheet.getColumn(10).alignment = {vertical: 'middle', horizontal: 'center'};
    worksheet.addRow([]);
    workbook.xlsx.writeBuffer().then((data) => {
      let blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      fs.saveAs(blob, filename + '_' + new Date().getTime() + '.xlsx');
    })
  }

  public generateExcelDocumentOut(title, header, data, filename) {
    // Create workbook and worksheet
    let workbook = new Workbook();
    let worksheet = workbook.addWorksheet('Thống kê');
    // Add Row and formatting
    let titleRow = worksheet.addRow([title]);
    titleRow.font = {size: 16, bold: true };
    titleRow.alignment = {vertical: 'middle'};
    worksheet.addRow([]);
    const options = {hour12 : true, hour: 'numeric', minute: 'numeric', weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    let temp = new Date();
    let subTitleRow = worksheet.addRow(['Ngày giờ thống kê : ' + temp.toLocaleDateString('vi-VI', options)]);
    worksheet.mergeCells('A1:J2');
    worksheet.mergeCells('A3:J3');
    // Blank Row
    worksheet.addRow([]);
    // Add Header Row
    let headerRow = worksheet.addRow(header);

    // Cell Style : Fill and Border
    headerRow.eachCell((cell, number) => {
      cell.fill = {
        type: 'pattern',
        pattern: 'solid',
        fgColor: { argb: 'e9f9f7' },
        bgColor: { argb: 'e9f9f7' }
      }
      cell.font = {bold: true }
      cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
    })
    // Add Data and Conditional Formatting
    data.forEach(d => {
      let row = worksheet.addRow(d);
      row.eachCell((cell, number) => {
        cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
        // cell.alignment = {wrapText: true};
      });
    }
    );
    worksheet.getColumn(1).width = 5; // STT
    worksheet.getColumn(1).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(2).width = 15; // Số/Ký hiệu
    worksheet.getColumn(2).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(3).width = 25; // Người soạn thảo
    worksheet.getColumn(3).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(4).width = 15; // Ngày tạo
    worksheet.getColumn(4).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(5).width = 20; // Ngày ban hành
    worksheet.getColumn(5).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(6).width = 20; // Loại văn bản
    worksheet.getColumn(6).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(7).width = 40; // Trích yếu
    worksheet.getColumn(7).alignment = {wrapText: true, vertical: 'middle', horizontal: 'left'};

    worksheet.getColumn(8).width = 20; // Độ mật
    worksheet.getColumn(8).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(9).width = 20; // Trạng thái
    worksheet.getColumn(9).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(10).width = 20; // Nhận để biết
    worksheet.getColumn(10).alignment = {vertical: 'middle', horizontal: 'center'};
    worksheet.addRow([]);
    workbook.xlsx.writeBuffer().then((data) => {
      let blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      fs.saveAs(blob, filename + '_' + new Date().getTime() + '.xlsx');
    })
  }

  public generateExcelTask(title, header, data, filename) {
    // Create workbook and worksheet
    let workbook = new Workbook();
    let worksheet = workbook.addWorksheet('Thống kê');
    // Add Row and formatting
    let titleRow = worksheet.addRow([title]);
    titleRow.font = {size: 16, bold: true };
    titleRow.alignment = {vertical: 'middle'};
    worksheet.addRow([]);
    const options = {hour12 : true, hour: 'numeric', minute: 'numeric', weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    let temp = new Date();
    let subTitleRow = worksheet.addRow(['Ngày giờ thống kê : ' + temp.toLocaleDateString('vi-VI', options)]);
    worksheet.mergeCells('A1:J2');
    worksheet.mergeCells('A3:J3');
    // Blank Row
    worksheet.addRow([]);
    // Add Header Row
    let headerRow = worksheet.addRow(header);

    // Cell Style : Fill and Border
    headerRow.eachCell((cell, number) => {
      cell.fill = {
        type: 'pattern',
        pattern: 'solid',
        fgColor: { argb: 'e9f9f7' },
        bgColor: { argb: 'e9f9f7' }
      };
      cell.font = {bold: true };
      cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
    });
    // Add Data and Conditional Formatting
    data.forEach(d => {
        let row = worksheet.addRow(d);
        row.eachCell((cell, number) => {
          cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
          // cell.alignment = {wrapText: true};
        });
      }
    );
    worksheet.getColumn(1).width = 5; // STT
    worksheet.getColumn(1).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(2).width = 40; // Tên công việc
    worksheet.getColumn(2).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(3).width = 15; // Lĩnh vực
    worksheet.getColumn(3).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(4).width = 15; // Độ ưu tiên
    worksheet.getColumn(4).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(5).width = 15; // tiến độ
    worksheet.getColumn(5).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(6).width = 20; // Ngày bắt đầu
    worksheet.getColumn(6).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(7).width = 20; // Ngày kết thúc
    worksheet.getColumn(7).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(8).width = 40; // Nội dung
    worksheet.getColumn(8).alignment = {wrapText: true, vertical: 'middle', horizontal: 'left'};

    worksheet.getColumn(9).width = 20; // Người thực hiện
    worksheet.getColumn(9).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(10).width = 20; // Người giao việc
    worksheet.getColumn(10).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(11).width = 20; // Nhận để biết
    worksheet.getColumn(11).alignment = {vertical: 'middle', horizontal: 'center'};
    worksheet.addRow([]);
    workbook.xlsx.writeBuffer().then((data) => {
      let blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      fs.saveAs(blob, filename + '_' + new Date().getTime() + '.xlsx');
    })
  }

  public generateExcelBusinessLog(title, header, data, filename) {
    // Create workbook and worksheet
    let workbook = new Workbook();
    let worksheet = workbook.addWorksheet('Thống kê');
    // Add Row and formatting
    let titleRow = worksheet.addRow([title]);
    titleRow.font = {size: 16, bold: true };
    titleRow.alignment = {vertical: 'middle'};
    worksheet.addRow([]);
    const options = {hour12 : true, hour: 'numeric', minute: 'numeric', weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    let temp = new Date();
    let subTitleRow = worksheet.addRow(['Ngày giờ thống kê : ' + temp.toLocaleDateString('vi-VI', options)]);
    worksheet.mergeCells('A1:G2');
    worksheet.mergeCells('A3:G3');
    // Blank Row
    worksheet.addRow([]);
    // Add Header Row
    let headerRow = worksheet.addRow(header);

    // Cell Style : Fill and Border
    headerRow.eachCell((cell, number) => {
      cell.fill = {
        type: 'pattern',
        pattern: 'solid',
        fgColor: { argb: 'e9f9f7' },
        bgColor: { argb: 'e9f9f7' }
      }
      cell.font = {bold: true }
      cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
    })
    // Add Data and Conditional Formatting
    data.forEach(d => {
      let row = worksheet.addRow(d);
      row.eachCell((cell, number) => {
        cell.border = { top: { style: 'thin' }, left: { style: 'thin' }, bottom: { style: 'thin' }, right: { style: 'thin' } }
        // cell.alignment = {wrapText: true};
      });
    }
    );
    worksheet.getColumn(1).width = 5; // STT
    worksheet.getColumn(1).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(2).width = 25; // Tên đăng nhập
    worksheet.getColumn(2).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(3).width = 25; // IP Thiết bị
    worksheet.getColumn(3).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(4).width = 20; // Hành động
    worksheet.getColumn(4).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(5).width = 20; // Loại Đối Tượng
    worksheet.getColumn(5).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.getColumn(6).width = 40; // Nội Dung
    worksheet.getColumn(6).alignment = {wrapText: true, vertical: 'middle', horizontal: 'left'};

    worksheet.getColumn(7).width = 20; // Thời Gian
    worksheet.getColumn(7).alignment = {wrapText: true, vertical: 'middle', horizontal: 'center'};

    worksheet.addRow([]);
    workbook.xlsx.writeBuffer().then((data) => {
      let blob = new Blob([data], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
      fs.saveAs(blob, filename + '_' + new Date().getTime() + '.xlsx');
    })
  }
}
