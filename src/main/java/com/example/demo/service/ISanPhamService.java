package com.example.demo.service;

import com.example.demo.model.SanPham;
import com.example.demo.service.impl.SanPhamServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ISanPhamService{

    Page<SanPham> getAllSanPham(Pageable pageable);

    List<SanPham> getAll();

    Page<SanPham> getSanPhamByTen(String keyword, Pageable pageable);

    Page<SanPham> findAllByGiaBetween(BigDecimal minGia, BigDecimal maxGia, Pageable pageable);

    void saveSanPham(SanPham sanPham);

    void removeSanPham(Integer id);

    Optional<SanPham> findSanPhamById(Integer id);
}
