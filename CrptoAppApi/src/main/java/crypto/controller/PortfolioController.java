package crypto.controller;

import crypto.entity.Portfolio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class PortfolioController  extends ControllerBase{
    @GetMapping("/{userId}/getportfolio")
    public Portfolio getPortfolio() {
        return null;
    }
    @PostMapping("/{userId}/createportfolio")
    public Portfolio createPortfolio() {
        return null;
    }
}
