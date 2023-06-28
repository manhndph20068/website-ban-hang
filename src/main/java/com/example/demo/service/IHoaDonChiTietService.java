package com.example.demo.service;

import com.example.demo.model.HoaDonChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IHoaDonChiTietService {

    void saveHDCT(HoaDonChiTiet hoaDonChiTiet);

    Page<Object[]> getTop10PrdTopSeler(Pageable pageable);

    Page<Object[]> getTop10PrdTonKho(Pageable pageable);

    Optional<HoaDonChiTiet> getHdById(Integer idHoaDon);

    List<Object[]> findHoaDonChiTietByIdHoaDon(@Param("idHoaDon") Integer idHoaDon);
}
