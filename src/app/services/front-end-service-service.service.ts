import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class FrontEndServiceServiceService {

  constructor(private _http: HttpClient) {}

  url = 'http://localhost:8080/employees';

  ngOnInit() {}

  getEmployeesDataFromService(): Observable<any> {
    return this._http.get(this.url);
  }



  
//  PROJECT  RELATED FUNCTIONS  

//INSERTION
   url1 = 'http://localhost:8080/save';

   public addUser(data):Observable<any>{

    return this._http.post(this.url1,data);
   }

//DELETION
  //  url2 = 'http://localhost:8080/delete/id';
  public delete(id){
    return this._http.delete("http://localhost:8080/delete/"+id)
  }

//GET ALL DATA (SELECT)
  ulr3='http://localhost:8080/getv2';
  public getData(){
    return this._http.get(this.ulr3)
  }

  

//UPDATION PURPOSE
  url4='http://localhost:8080/update';

  public getUpdate(laptop: any) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this._http.put(this.url4, laptop, { headers });
  }


  //SEARCH BY BRAND

 // url5='http://localhost:8080/search/{brand}';
public search_brand(data){
  return this._http.get('http://localhost:8080/search/'+data);

}

//SEARCH BY PRICE

 // url5='http://localhost:8080/search/{price}';
public search_price(data){
  return this._http.get('http://localhost:8080/search1/'+data);

}
}
