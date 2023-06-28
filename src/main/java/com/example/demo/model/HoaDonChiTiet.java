package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "hoadonchitiet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HoaDonChiTiet {

    @Id
    @Column(name = "idhoadon")
    private Integer idHoaDon;

    @Column(name = "idsanpham")
    private Integer idSanPham;

    @Column(name = "dongia")
    private BigDecimal donGia;

    @Column(name = "soluong")
    private Integer soLuong;
}
