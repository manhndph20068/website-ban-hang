package com.example.demo.repository;

import com.example.demo.model.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    @Query("""
                SELECT h.idSanPham, s.tenSanPham, s.gia, SUM(h.soLuong) AS tongSoLuong
                FROM HoaDonChiTiet h
                INNER JOIN SanPham s ON h.idSanPham = s.idSanPham
                GROUP BY h.idSanPham, s.tenSanPham, s.gia
                ORDER BY tongSoLuong DESC
            """)
    Page<Object[]> getTop10PrdTopSeler(Pageable pageable);

    @Query("""
            SELECT s.idSanPham, s.tenSanPham, s.gia
            FROM SanPham s
            LEFT JOIN HoaDonChiTiet h ON s.idSanPham = h.idSanPham
            WHERE h.idSanPham IS NULL
            """)
    Page<Object[]> getTop10PrdTonKho(Pageable pageable);

    @Query("""
                SELECT h.idHoaDon, h.idSanPham, s.tenSanPham, h.soLuong, h.donGia
                FROM HoaDonChiTiet h
                INNER JOIN SanPham s ON h.idSanPham = s.idSanPham
                WHERE h.idHoaDon = :idHoaDon
            """)
    List<Object[]> findHoaDonChiTietByIdHoaDon(@Param("idHoaDon") Integer idHoaDon);
}
