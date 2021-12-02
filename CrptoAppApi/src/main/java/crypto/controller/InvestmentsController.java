package crypto.controller;


import crypto.entity.Investments;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class InvestmentsController extends ControllerBase {
    @GetMapping("/getInvestments")
    public List<Investments> getInvestments(){
        return null;
    }
}
