package com.shop.shops.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String indexHandler() {
        return "Index";
    }

    @RequestMapping("/login")
    public String LoginHandler() {
        return "Login";
    }

    @RequestMapping("/register")
    public String RegisterHandler() {
        return "Register";
    }

    @RequestMapping("/home")
    public String homeHandler() {
        return "home";
    }

    @RequestMapping("/product")
    public String productHandler() {
        return "product";
    }

    @RequestMapping("/products")
    public String viewProductHandler() {
        return "viewProduct";
    }
}