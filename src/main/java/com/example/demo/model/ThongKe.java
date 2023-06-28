package com.example.demo.model;

import java.math.BigDecimal;

public class ThongKe {
    private Integer idSanPham;
    private String tenSanPham;
    private BigDecimal donGia;
    private Long tongSoLuong;

    public ThongKe(Integer idSanPham, String tenSanPham, BigDecimal donGia, Long tongSoLuong) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.tongSoLuong = tongSoLuong;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public Long getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(Long tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }
}
