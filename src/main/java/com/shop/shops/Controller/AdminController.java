package com.shop.shops.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shop.shops.Model.Category;
import com.shop.shops.service.categoryService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private categoryService categoryService;

    @RequestMapping("/index")
    public String indexHandler() {
        return "/admin/index";
    }

    @RequestMapping("/AddProduct")
    public String AddProductHandler() {
        return "/admin/AddProduct";
    }

    @RequestMapping("/Category")
    public String categoryHandler() {
        return "/admin/Category";
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveCategory(
            @ModelAttribute Category category,
            @RequestParam("file") MultipartFile file,
            HttpSession session) {

        String fileName = file != null ? file.getOriginalFilename() : "product_img.jpeg";
        category.setProductName(fileName);

        boolean existsCategory = categoryService.existCategory(category.getProductName());
        if (existsCategory) {
            session.setAttribute("message", "Category AllReady Exists...");
        } else {
            Category savedCategory = categoryService.saveCategory(category);
            if (ObjectUtils.isEmpty(savedCategory)) {
                session.setAttribute("message", "Not Saved Internal Server error");
            } else {
                session.setAttribute("message", "Saved Sucessfully..");
            }
        }
        categoryService.saveCategory(category);
        return "redircet:/Category";
    }

}
