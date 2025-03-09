package dev.test;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", true);
            model.addAttribute("errorMessage", error);
        }

        if (logout != null) {
            model.addAttribute("logout", true);
            model.addAttribute("logoutMessage", logout);
        }

        CsrfToken crfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (crfToken != null) {
            model.addAttribute("csrf", crfToken);
        }

        return "pages/login";
    }

    @GetMapping("/")
    public String home() {
        return "pages/home";
    }
}
