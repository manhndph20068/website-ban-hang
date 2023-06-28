package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "sanpham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsanpham")
    private Integer idSanPham;

    @Column(name = "tensanpham")
    private String tenSanPham;

    @Column(name = "gia")
    private BigDecimal gia;

    @Column(name = "soluong")
    private Integer soLuong;

    @Column(name = "dungtichnganda")
    private Integer dungTichNganDa;

    @Column(name = "dungtichnganmat")
    private Integer dungTichNganMat;

    @Column(name = "congsuattieuthu")
    private Float congSuatTieuThu;

    @Column(name = "chieucao")
    private Float chieuCao;

    @Column(name = "chieurong")
    private Float chieuRong;

    @Column(name = "chieusau")
    private Float chieuSau;

    @Column(name = "cannang")
    private Float canNang;

    @Column(name = "hang")
    private String hang;

    @Column(name = "kieutu")
    private String kieuTu;

    @Column(name = "namsanxuat")
    private Integer namSanXuat;

    @Column(name = "xuatxu")
    private String xuatXu;

    @Column(name = "hinhanh")
    private String hinhAnh;
}
