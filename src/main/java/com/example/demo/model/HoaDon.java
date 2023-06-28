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

import java.util.Date;

@Entity
@Table(name = "hoadon")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDon {

    @Id
    @Column(name = "idhoadon")
    private Integer idHoaDon;

    @Column(name = "mahoadon")
    private String maHoaDon;

    @Column(name = "ngaytao")
    private Date ngayTao;

}
