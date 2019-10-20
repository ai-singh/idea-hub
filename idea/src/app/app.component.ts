import { Component } from '@angular/core';
import { IdeaService } from './idea.service';
import { Idea } from './idea';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  ideas: Array<Idea>;
  private toggle: boolean;
  private now: Date = new Date();

  constructor(private ideaService: IdeaService) {

  }

  ngOnInit() {
    this.getData();
  }

  public getData() {
    this.ideaService.sendGetRequest().subscribe((data: any[]) => {
      this.ideas = data;
    });
  }

  public upvote(event, idea: Idea) {
    if(!idea.upvote) {
      idea.upvotes += 1;
    }
    console.log(this.ideaService.sendPostRequest(idea));
    this.getData();
  }
}
