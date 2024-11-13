import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FrontEndServiceServiceService } from 'src/app/services/front-end-service-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-laptop-component',
  templateUrl: './laptop-component.component.html',
  styleUrls: ['./laptop-component.component.css']
})
export class LaptopComponentComponent {


  constructor(private _http:HttpClient,private _fs:FrontEndServiceServiceService){

  }

 
//1.INSERTION PURPOSE
  InsertData(data:any){
   
    
   this._fs.addUser(data.value).subscribe()  
  //here value=id+brand+price 
  
  }


//2.DELETION PURPOSE
  delete(data){

    this._fs.delete(data.value.id).subscribe()
  }

  



//3.UPDATE PURPOSE


  updateRecord(data) {

    this._fs.getUpdate(data.value).subscribe();

  }

 //Another way for updating
    // updateRecord(form: NgForm) {
  //   const laptop = {
  //     id: form.value.id,
  //     brand:form.value.brand,
  //     price: form.value.price
  
  //   };
  
  //   this._fs.getUpdate(laptop).subscribe(response => {
  //     console.log('Update response:', response);
  //   });
  // }


//4.GET WHOLE DATA PURPOSE
  data3:any
  showTable:boolean=false;
getData(){

  this._fs.getData().subscribe(
    (sucess)=>{

     this.data3=sucess;
                  // console.log(this.data3);
     this.showTable=true;
    }
  )
}

//SEARCHING BY BRAND PURPOSE
data4:any;
showTable12:boolean=false;

searching_data(data){

  this._fs.search_brand(data.value.brand).subscribe(

    (sucess)=>{
      // console.log(sucess);

      this.data4=sucess;
      this.showTable12=true;
    }
  )
}


//SEARCHING BY PRICE PURPOSE
data5:any;
showTable123:boolean=false;

searching_price(data){

  this._fs.search_price(data.value.price).subscribe(

    (sucess)=>{
      // console.log(sucess);

      this.data5=sucess;
      this.showTable123=true;
    }
  )
}


 alertfun(){

  alert('DATA-SUBMITTED-SUCCESSFULLY');
}








}
