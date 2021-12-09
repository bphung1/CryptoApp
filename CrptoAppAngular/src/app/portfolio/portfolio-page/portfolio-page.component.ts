import { Component, OnInit } from '@angular/core';
import { Agent } from 'src/app/api/agent';
import { Portfolio } from 'src/app/model/portfolio';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-portfolio-page',
  templateUrl: './portfolio-page.component.html',
  styleUrls: ['./portfolio-page.component.css']
})
export class PortfolioPageComponent implements OnInit {
  user: User;
  portfolio: Portfolio;
  isLoading = false;

  constructor(private service: Agent) { }

  ngOnInit(): void {
    this.isLoading = false;
    this.service.userFromAPI
    .then(user => {
      this.user = user;
      this.isLoading = true;
    })
    .then(() => {
      this.service.getPortfolio(this.user.userid)
        .then(portfolio => this.portfolio = portfolio)
    });
  }

}
