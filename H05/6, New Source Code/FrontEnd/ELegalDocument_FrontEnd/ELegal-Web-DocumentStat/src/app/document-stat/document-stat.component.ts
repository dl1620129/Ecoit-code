import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../service/document.service';
import * as Highcharts from 'highcharts';
import { Constants } from '../common/constants';

declare const Liferay: any;

declare var require: any;
let Boost = require('highcharts/modules/boost');
let noData = require('highcharts/modules/no-data-to-display');
let More = require('highcharts/highcharts-more');

Boost(Highcharts);
noData(Highcharts);
More(Highcharts);
noData(Highcharts);

@Component({
    selector: 'app-document-stat',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-DocumentStat/app/document-stat.component.html',
    styleUrls: [],
    providers: [],
})
export class DocumentStatComponent implements OnInit {
    today = new Date();

    constructor(private documentService: DocumentService){};

    ngOnInit() {
        this.documentService.getDocumentsStat().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let options: any = {
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    credits: {
                        enabled: false
                    },
                    title: {
                        text: 'Thống kê tổng văn bản trong năm - ' + this.today.getFullYear(),
                        style: {
                            fontWeight: 'bold',
                            fontSize: '20px',
                            fontFamily: 'sans-serif'
                        } 
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    accessibility: {
                        point: {
                            valueSuffix: '%'
                        }
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                format: '<b>{point.name}</b>: {point.y} / {point.percentage:.1f} %',
                                style: {
                                    fontWeight: 'bold',
                                    fontSize: '14px',
                                    fontFamily: 'sans-serif'
                                }
                            }
                        }
                    },
                    series: [{
                        name: '',
                        colorByPoint: true,
                        data: [{
                            name: 'Bản nháp',
                            y: response.data.totalDraft,
                            sliced: true,
                            selected: true
                        }, {
                            name: 'Chờ duyệt',
                            y: response.data.totalPending
                        }, {
                            name: 'Đã duyệt',
                            y: response.data.totalApproved
                        }, {
                            name: 'Hủy duyệt',
                            y: response.data.totalApprovedDenied
                        }, {
                            name: 'Xuất bản',
                            y: response.data.totalPublish
                        }, {
                            name: 'Hủy xuất bản',
                            y: response.data.totalPublishDenied
                        }]
                    }]
                };
                Highcharts.chart('chartContainer', options);
            } else {
                alert(Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}
