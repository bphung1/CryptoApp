import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agent } from 'src/app/api/agent';
import { Crypto } from 'src/app/model/crypto';
import { Portfolio } from 'src/app/model/portfolio';
import { Transaction } from 'src/app/model/transaction';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-buy-page',
  templateUrl: './buy-page.component.html',
  styleUrls: ['./buy-page.component.css']
})
export class BuyPageComponent implements OnInit {

  cryptoRates: Crypto[];
  isloaded=false;
  cryptoList=new Map<string,number>();
  UserFromService:User;
  portFolio:Portfolio;
  transaction:Transaction= {portfolioId: 0, transactionAmount: 0,cryptoName:"",transactionType:"buy"};

  
  constructor(private service:Agent,private router: Router) { 
  }

  ngOnInit(): void {
    this.service.getCrypto()
    .then(cryptos => {
      this.cryptoRates = cryptos;
      this.service.portfolioFromAPI.then(
        portfolio => {
          this.portFolio=portfolio;
          this.isloaded=true;
        }
      )
    })

  }

  backToPortfolio() {
    this.router.navigate(['portfolio']);
  }

  checkValues(e:any){
    let val=0;
      if(e.target.checked==true){
        val=parseInt((document.getElementById(e.target.value) as HTMLInputElement).value);
         this.cryptoList.set(e.target.value,val);
      }else{
         this.cryptoList.delete(e.target.value);
      }
  }

  updateValues(e:any){
    if(this.cryptoList.has(e.target.id)){
      this.cryptoList.set(e.target.id,parseInt(e.target.value));
    }   
  }

  verifyBalance():boolean{
    let total=0;
   this.cryptoList.forEach((value: number, key: string) => {
     total+=value;
   })
   if(this.portFolio.nonInvestedBalance<total){
     alert("insuffisant balance");
     return false;
   }
   return true;
  }

  buyCrypto() {    

    if(this.verifyBalance()){
      this.cryptoList.forEach((value: number, key: string) => {
        this.transaction.portfolioId=this.portFolio.portfolioId;
        this.transaction.cryptoName=key;
        this.transaction.transactionAmount=value;
  
        this.service.addTransaction(this.transaction).then(
          portfolio=>{
            if(portfolio!=undefined){
            alert("you bought $"+value+" of "+key);
            }else{
            alert("transaction failed ");
            }
            this.router.navigate(['investment']);
          })
        });        
      }

    }
}
