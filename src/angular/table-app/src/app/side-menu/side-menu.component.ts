import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.css']
})
export class SideMenuComponent implements OnInit {

	current: number = 0;
  items: any[];
	menus: any[];
  constructor(private httpClient: HttpClient) { }	

  ngOnInit() {
  
  this.httpClient.get<any[]>('http://localhost:8080/menu').subscribe(data => {      
      this.menus = data;
      console.log(this.menus);
    });
  }

	sendViewId(viewId){
	console.log("Inside sendViewId method");
		console.log(viewId);
	}

}
