package com.kn.aes.saml;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    
    @GetMapping("/hello")
    public String mainpage() {
        return "home";
    }
    
    @GetMapping("/secured/hello")
    public String secured(@AuthenticationPrincipal(expression = "name") String name, Authentication auth, Model model) {
        model.addAttribute("username", name);
        return "hello";
    }
    
    @GetMapping("/samlprofile")
	public String home(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal,Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("attributes", principal.getAttributes());
		model.addAttribute("authorities", auth.getAuthorities());
		return "welcome";
	}
}