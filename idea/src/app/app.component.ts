import { Component } from '@angular/core';
import { IdeaService } from './idea.service';
import { Idea } from './idea';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private ideas: Array<Idea>;
  private toggle: boolean;

  constructor(private ideaService: IdeaService) {

  }

  ngOnInit() {
    this.ideaService.sendGetRequest().subscribe((data: any[]) => {
      this.ideas = data;
    });
  }

  public upvote(event, idea: Idea) {
    this.toggle = !this.toggle;
  }
}
