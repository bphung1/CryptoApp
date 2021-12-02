package crypto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class PortfolioController  extends ControllerBase{
    @GetMapping("/getportfolio")
    public String getPortfolio() {
        return "Hello World";
    }
    @PostMapping("/createportfolio")
    public String createPortfolio() {
        return "Hello World";
    }
}
