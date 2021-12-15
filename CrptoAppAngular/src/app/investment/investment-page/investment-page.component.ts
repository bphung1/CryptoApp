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
  filteredInvestments = new Map<string, number[]>();
   total=0;    
   value; 
   
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
        this.filterInvestments();
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

filterInvestments() {

  console.log("test test");
  console.log(this.investments);

  //ABOVE BUT BETTER
  let usedCryptNames = new Set<string>(); //MAKE SET OF CRYPTONAMES
  for (let currInvest of this.investments) {
      usedCryptNames.add(currInvest.cryptoName);
  }

  for(let name of usedCryptNames) {

      let investmentsForCrypto = this.investments.filter(investment => investment.cryptoName == name);

      let investAmtForCrypto = investmentsForCrypto.reduce((investAmtSum, currInv) => investAmtSum + currInv.investedAmount, 0);
      let sharesForCrypto = investmentsForCrypto.reduce((sharesSum, currInv) => sharesSum + currInv.shares, 0);

      console.log(name + " : " + investAmtForCrypto + " : " + sharesForCrypto)

      this.filteredInvestments.set(name, [investAmtForCrypto, sharesForCrypto]);

  }

}

  
  
}






