import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TradingviewRoutingModule } from './tradingview-routing.module';
import { TradingviewComponent } from './tradingview/tradingview.component';


@NgModule({
  declarations: [TradingviewComponent],
  imports: [
    CommonModule,
    TradingviewRoutingModule
  ]
})
export class TradingviewModule { }
