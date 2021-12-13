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

  constructor(private service: Agent) {}
  results=0;
   total=0;    
   value; 
   values;
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
         this.findsum(this.investments); 
        this.isLoaded = true;
        console.log(this.investments);
      })
    })

  }

  
  findsum(investments){
      
  this.value=this.investments    
  console.log(this.value);  
  for(let j=0;j<investments.length;j++){   
       this.total+= this.value[j].investedAmount 
       console.log(this.total) 
  }
}
find(investments){
  let map = this.investments.reduce((prev, next) =>{
    if (next.cryptoName in prev) {
      prev[next.cryptoName].investedAmount += next.investedAmount;
    } else {
       prev[next.cryptoName] = next;
    }
    return prev;
  }, {});
  
  let results = Object.keys(map).map(cryptoName => map[cryptoName]);
  
  console.log(results);

}





}
