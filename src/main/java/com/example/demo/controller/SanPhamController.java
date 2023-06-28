package com.example.demo.controller;

import com.example.demo.model.SanPham;
import com.example.demo.repository.ISanPhamRepository;
import com.example.demo.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class SanPhamController {

    @Autowired
    private ISanPhamService service;

    @GetMapping("/manager/san-pham")
    public String viewSanPham(Model model
            , @RequestParam(name = "tenSearch", required = false) String tenSearch
            , @RequestParam(name = "minGia", required = false)BigDecimal minGia
            , @RequestParam(name = "maxGia", required = false)BigDecimal maxGia
            , @RequestParam(defaultValue = "1") int page) {

        List<SanPham> categorySP = service.getAll();

        Page<SanPham> sanPhamList;

        Pageable pageable = PageRequest.of(page - 1, 5);
        if ((tenSearch == null || tenSearch.isBlank()) && (minGia == null && maxGia == null)) {
            sanPhamList = service.getAllSanPham(pageable);
        } else if(tenSearch != null && (minGia == null && maxGia == null)){
            sanPhamList = service.getSanPhamByTen(tenSearch, pageable);
        } else {
            sanPhamList= service.findAllByGiaBetween(minGia,maxGia,pageable);
        }
        model.addAttribute("sanPhamList", sanPhamList);
        model.addAttribute("categorySP", categorySP);
        return "manager/san-pham";
    }

    @RequestMapping("/manager/san-pham/save")
    public String addSanPham(SanPham sanPham, RedirectAttributes redirectAttributes) {
        service.saveSanPham(sanPham);
        redirectAttributes.addFlashAttribute("successMessage","Thêm thành công");
        return "redirect:/manager/san-pham";
    }

    @RequestMapping("/manager/san-pham/update")
    public String updateSanPham(SanPham sanPham, RedirectAttributes redirectAttributes) {
        service.saveSanPham(sanPham);
        redirectAttributes.addFlashAttribute("successMessage","Sửa thành công");
        return "redirect:/manager/san-pham";
    }

    @RequestMapping("/manager/san-pham/detail/{idSanPham}")
    public String detailSanPham(@RequestParam(defaultValue = "1") int page
            ,@PathVariable(name = "idSanPham") Integer idSanPham
            , Model model
    ) {
        Pageable pageable = PageRequest.of(page - 1, 5);

        Optional<SanPham> sanPhamDetail = service.findSanPhamById(idSanPham);
        sanPhamDetail.ifPresent(sanPham -> model.addAttribute("sanPham", sanPham));
        Page<SanPham> sanPhamList = service.getAllSanPham(pageable);
        model.addAttribute("sanPhamList", sanPhamList);
        return "/manager/san-pham";
    }

    @RequestMapping("/manager/san-pham/delete/{idSanPham}")
    public String deleteSanPham(@PathVariable(name = "idSanPham") Integer idSanPham, RedirectAttributes redirectAttributes) {
        service.removeSanPham(idSanPham);
        redirectAttributes.addFlashAttribute("successMessage", "Sản phẩm đã được xóa thành công.");
        return "redirect:/manager/san-pham";
    }

    @RequestMapping("/manager/san-pham/edit/{idSanPham}")
    public String editSanPham(@PathVariable(name = "idSanPham") Integer idSanPham, Model model
    ) {
        Optional<SanPham> sanPhamDetail = service.findSanPhamById(idSanPham);
        sanPhamDetail.ifPresent( sanPham -> model.addAttribute("sanPham", sanPham));
        return "/manager/san-pham-edit";
    }
}