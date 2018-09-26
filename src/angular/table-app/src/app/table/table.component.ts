import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {HttpParams} from "@angular/common/http";

interface TableModel {
    
    columnNames: string[];
    data: string[];
}

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})

export class TableComponent implements OnInit {

	getAllData: boolean;
	headers: string[];
	datas: string[];

  constructor(private httpClient: HttpClient, ) { }

  ngOnInit() {
  	this.headers = [];
  	this.datas= [];
  }


	getData(){
	console.log("Inside getData method");
	this.getAllData = !this.getAllData;
	var params = new HttpParams().set('getAllData', this.getAllData.toString()); 
	this.httpClient.get<TableModel>('http://localhost:8080/data', {params}).subscribe(data => {      
      this.headers = data.columnNames;
      this.datas = data.data;
      console.log(this.datas);
    });
	}
	
}
