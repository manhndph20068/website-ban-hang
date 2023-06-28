package com.example.demo.controller;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.service.IHoaDonChiTietService;
import com.example.demo.service.IHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HoaDonController {
    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IHoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/view-hoa-don")
    public String viewHoaDon(Model model, @RequestParam(defaultValue = "1") int page){
        Pageable pageable = PageRequest.of(page -1, 10);

        Page<HoaDon> hoaDonPage =  hoaDonService.findAllByOrderByNgayTaoDesc(pageable);
        model.addAttribute("hoaDonPage",hoaDonPage);

        return "/manager/view-hoa-don";
    }

    @GetMapping("/detail-order/{idHoaDon}")
    public String viewHDCT(Model model,@PathVariable(name = "idHoaDon") Integer idHoaDon){
        List<Object[]> cthd = hoaDonChiTietService.findHoaDonChiTietByIdHoaDon(idHoaDon);
        model.addAttribute("cthd",cthd);
        return "/manager/view-hdct";
    }
}
