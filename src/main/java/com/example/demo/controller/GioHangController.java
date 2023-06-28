package com.example.demo.controller;

import com.example.demo.model.HoaDon;
import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.model.SanPham;
import com.example.demo.repository.IHoaDonRepository;
import com.example.demo.service.IGioHangService;
import com.example.demo.service.IHoaDonChiTietService;
import com.example.demo.service.IHoaDonService;
import com.example.demo.service.ISanPhamService;
import com.example.demo.util.IdHoaDonGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
public class GioHangController {

    @Autowired
    private IGioHangService gioHangService;

    @Autowired
    private ISanPhamService sanPhamService;

    @Autowired
    private IHoaDonService hoaDonService;

    @Autowired
    private IHoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/cart")
    public String viewGioHang(Model model) {
        Map<Integer, Integer> sanPhamTrongGio = gioHangService.laySanPhamTrongGio();
        Map<Integer, SanPham> sanPhamMap = new HashMap<>();
        List<SanPham> sanPhamList = sanPhamService.getAll();
        for (SanPham sanPham : sanPhamList) {
            sanPhamMap.put(sanPham.getIdSanPham(), sanPham);
        }
        model.addAttribute("sanPhamTrongGio", sanPhamTrongGio);
        model.addAttribute("sanPhamMap", sanPhamMap);
        return "/manager/gio-hang";
    }

    @RequestMapping("/add/{idSanPham}")
    public String themSanPhamVaoGioHang(@PathVariable(name = "idSanPham") Integer idSanPham) {
        gioHangService.themSanPhamVaoGioHang(idSanPham, 1);
        return "redirect:/cart";
    }

    @RequestMapping("/delete-cart/{idSanPham}")
    public String xoaSPTrongGioHang(@PathVariable(name = "idSanPham") Integer idSanPham) {
        gioHangService.xoaSanPhamKhoiGioHang(idSanPham);
        return "redirect:/cart";
    }

    @RequestMapping("/tao-hoa-don")
    public String taoHoaDon(@RequestParam("productId") List<Integer> productId
            , @RequestParam("quantity") List<Integer> quantity
            , @RequestParam("price") List<BigDecimal> price
                            ,Model model
    ) {
        UUID uuid = UUID.randomUUID();
        Integer idHoaDon = Math.abs(uuid.hashCode());
        System.out.println(idHoaDon);
        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdHoaDon(idHoaDon);
        hoaDon.setMaHoaDon("HD" + idHoaDon);
        hoaDon.setNgayTao(new Date());
        hoaDonService.saveHoaDon(hoaDon);

        for (int i = 0; i < productId.size(); i++) {
            Integer idSpHDCT = productId.get(i);
            Integer soLuongHDCT = quantity.get(i);
            BigDecimal priceHDCT = price.get(i);

            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setIdHoaDon(idHoaDon);
            hoaDonChiTiet.setIdSanPham(idSpHDCT);
            hoaDonChiTiet.setSoLuong(soLuongHDCT);
            hoaDonChiTiet.setDonGia(priceHDCT);

            hoaDonChiTietService.saveHDCT(hoaDonChiTiet);

            SanPham updateSanPham = new SanPham();
            Optional sanPham = sanPhamService.findSanPhamById(idSpHDCT);
            if (sanPham.isPresent()) {
                SanPham sanPhamHT = (SanPham) sanPham.get();
                Integer soLuongHienTai = sanPhamHT.getSoLuong();
                BigDecimal giaHienTai = sanPhamHT.getGia();
                String anh = sanPhamHT.getHinhAnh();
                String tenHienTai = sanPhamHT.getTenSanPham();
                Integer soLuongMoi = soLuongHienTai - soLuongHDCT;
                updateSanPham.setIdSanPham(idSpHDCT);
                updateSanPham.setSoLuong(soLuongMoi);
                updateSanPham.setTenSanPham(tenHienTai);
                updateSanPham.setGia(giaHienTai);
                updateSanPham.setHinhAnh(anh);
            }

            sanPhamService.saveSanPham(updateSanPham);

        }

        return "redirect:/detail-order/" + idHoaDon;
    }



}
