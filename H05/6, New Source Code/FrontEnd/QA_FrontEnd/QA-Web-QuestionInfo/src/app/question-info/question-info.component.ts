import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import * as Highcharts from 'highcharts';
import { Constants } from '../common/constants';
import { CategoryCount } from '../model/category-count.model';

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
    selector: 'app-question-info',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/QA-Web-QuestionInfo/app/question-info.component.html',
    styleUrls: [],
    providers: [],
})
export class QuestionInfoComponent implements OnInit {
    today = new Date();
    categoryList: CategoryCount[] = new Array();

    constructor(private questionService: QuestionService){};

    ngOnInit() {
        Highcharts.setOptions({
            chart: {
                style: {
                    fontFamily: "-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji'"
                }
            }
        });
        this.questionService.getQuestionInfo().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.categoryList = response.data.categoryData;
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
                        text: 'Thống kê tổng phản hồi trong năm - ' + this.today.getFullYear(),
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
                            name: 'Chờ duyệt',
                            y: response.data.totalPending,
                            sliced: true,
                            selected: true,
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
