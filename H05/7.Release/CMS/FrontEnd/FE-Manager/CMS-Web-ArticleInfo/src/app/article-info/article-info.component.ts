import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../service/article.service';
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
    selector: 'app-article-info',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-ArticleInfo/app/article-info.component.html',
    styleUrls: [],
    providers: [],
})
export class ArticleInfoComponent implements OnInit {
    today = new Date();

    constructor(private articleService: ArticleService){};

    ngOnInit() {
        Highcharts.setOptions({
            chart: {
                style: {
                    fontFamily: "-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, 'Noto Sans', sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji', 'Segoe UI Symbol', 'Noto Color Emoji'"
                }
            }
        });
        this.articleService.getArticlesInfo().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let options: any = {
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title: {
                        text: 'Thống kê tổng bài viết trong năm - ' + this.today.getFullYear()
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
                                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                            }
                        }
                    },
                    series: [{
                        name: '',
                        colorByPoint: true,
                        data: [{
                            name: 'Bản nháp',
                            y: response.data.toltalDraf,
                            sliced: true,
                            selected: true
                        }, {
                            name: 'Chờ duyệt',
                            y: response.data.toltalPending
                        }, {
                            name: 'Đã duyệt',
                            y: response.data.toltalAppove
                        }, {
                            name: 'Hủy duyệt',
                            y: response.data.toltalApproveDenied
                        }, {
                            name: 'Xuất bản',
                            y: response.data.toltalPublish
                        }, {
                            name: 'Hủy xuất bản',
                            y: response.data.toltalPublishDenied
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
