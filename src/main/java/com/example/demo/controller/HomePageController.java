package com.example.demo.controller;

import com.example.demo.model.SanPham;
import com.example.demo.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    private ISanPhamService sanPhamService;

    @GetMapping("/home")
    public String viewHome(Model model
    ) {
        List<SanPham> sanPhamList = sanPhamService.getAll();
        model.addAttribute("sanPham",sanPhamList);
        return "/manager/home-page";
    }
}
