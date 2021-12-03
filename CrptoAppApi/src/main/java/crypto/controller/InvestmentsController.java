package crypto.controller;


import crypto.entity.Investment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class InvestmentsController extends ControllerBase {
    @GetMapping("/getInvestments/{portfolioId}")
    public List<Investment> getInvestments(@PathVariable int portfolioId){
        return null;
    }

}
