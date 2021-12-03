package crypto.controller;

import crypto.entity.Portfolio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class PortfolioController  extends ControllerBase{
    @GetMapping("/{userId}/getportfolio")
    public Portfolio getPortfolio(@PathVariable int userId) {
        return null;
    }
    @PostMapping("/{userId}/createportfolio")
    public Portfolio createPortfolio(@PathVariable int userId) {
        return null;
    }
}
