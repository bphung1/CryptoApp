package crypto.controller;


import crypto.entity.Investment;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class InvestmentsController extends ControllerBase {
    @GetMapping("/getInvestments")
    public List<Investment> getInvestments(){
        return null;
    }
}
