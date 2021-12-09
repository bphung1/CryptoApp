import { Component, OnInit } from '@angular/core';
import { Portfolio } from 'src/app/model/portfolio';
import { Investment } from 'src/app/model/investment';
import { Agent } from 'src/app/api/agent';

@Component({
  selector: 'app-investment-page',
  templateUrl: './investment-page.component.html',
  styleUrls: ['./investment-page.component.css']
})
export class InvestmentPageComponent implements OnInit {

portfolio : Portfolio;
investments : Investment[];
isLoaded = false;

  constructor(private service: Agent) { }

  ngOnInit(): void {
    this.getInvestmentByPortfolio();
  }

  getInvestmentByPortfolio() {
    this.isLoaded = false;
    this.service.portfolioFromAPI.then(portfolio =>{
        this.portfolio = portfolio;
    })
    .then(() => {
      this.service.getInvestment(this.portfolio.portfolioId).then(investments => {
        this.investments = investments;
        this.isLoaded = true;
        console.log(this.investments);
      })
    })

  }

}
