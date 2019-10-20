import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Idea } from './idea';

@Injectable({
  providedIn: 'root'
})
export class IdeaService {

  private REST_API_SERVER = "http://localhost:8080/";
  constructor(private httpClient: HttpClient) {
  }

  public sendGetRequest() {
    const params = new HttpParams({fromString : 'id=1234'});
    return this.httpClient.get(this.REST_API_SERVER + "home", {params});
  }

  public sendPostRequest(idea: Idea) {
    console.log(idea);
    let ideaJSON = {
      cunyId: 1234,
      id: idea.id,
      upvotes: idea.upvotes
    };
    return this.httpClient.post<Idea>(this.REST_API_SERVER + "save", ideaJSON).subscribe(res =>  {
      console.log(res);
    });
  }
}
