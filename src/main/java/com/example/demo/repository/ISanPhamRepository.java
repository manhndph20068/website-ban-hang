package com.example.demo.repository;

import com.example.demo.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ISanPhamRepository extends JpaRepository<SanPham, Integer> {
//    List<SanPham> getByTenSanPhamContains(String keyword);

    Page<SanPham> getByTenSanPhamContains(String keyword, Pageable pageable);

    Page<SanPham> findAllByGiaBetween(BigDecimal minGia, BigDecimal maxGia, Pageable pageable);

}
