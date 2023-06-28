package com.example.demo.service.impl;

import com.example.demo.model.GioHang;
import com.example.demo.model.SanPham;
import com.example.demo.service.IGioHangService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GioHangServiceImpl implements IGioHangService {
    private GioHang gioHang = new GioHang();

    @Override
    public void themSanPhamVaoGioHang(Integer maSanPham, Integer soLuongChoVao) {
        Map<Integer,Integer> sanPhamTrongGio = gioHang.getSanPhamTrongGioHang();

        if(sanPhamTrongGio.containsKey(maSanPham)){
            Integer soLuongHienCo = sanPhamTrongGio.get(maSanPham);
            Integer soLuongMoi = soLuongHienCo+soLuongChoVao;
            sanPhamTrongGio.put(maSanPham,soLuongMoi);
        }else{
            sanPhamTrongGio.put(maSanPham,soLuongChoVao);
        }
    }

    @Override
    public void xoaSanPhamKhoiGioHang(Integer maSanPham) {
        Map<Integer, Integer> sanPhamTrongGio = gioHang.getSanPhamTrongGioHang();

        if (sanPhamTrongGio.containsKey(maSanPham)) {
            sanPhamTrongGio.remove(maSanPham);
        }
    }

    @Override
    public Map<Integer, Integer> laySanPhamTrongGio() {
        return gioHang.getSanPhamTrongGioHang();
    }
}
