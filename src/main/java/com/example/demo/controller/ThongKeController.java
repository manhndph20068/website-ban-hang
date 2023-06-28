package com.example.demo.controller;

import com.example.demo.service.IHoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThongKeController {

    @Autowired
    private IHoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/top-seler")
    public String getTop10Products(Model model, @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page -1, 10); // Lấy 10 sản phẩm đầu tiên
        Page<Object[]> top10Products = hoaDonChiTietService.getTop10PrdTopSeler(pageable);
        model.addAttribute("top10Products", top10Products);
        return "manager/top";
    }

    @GetMapping("/top-ton-kho")
    public String getTop10ProdTonkho(Model model, @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page -1, 10); // Lấy 10 sản phẩm đầu tiên
        Page<Object[]> top10Products = hoaDonChiTietService.getTop10PrdTonKho(pageable);
        model.addAttribute("top10Products", top10Products);
        return "manager/top-ton-kho";
    }
}
