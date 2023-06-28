package com.example.demo.service;

import com.example.demo.model.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHoaDonService {

    void saveHoaDon(HoaDon hoaDon);

    Page<HoaDon> findAllByOrderByNgayTaoDesc(Pageable pageable);
}
