package com.example.demo.service.impl;

import com.example.demo.model.HoaDonChiTiet;
import com.example.demo.repository.IHoaDonChiTietRepository;
import com.example.demo.service.IHoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonChiTietImpl implements IHoaDonChiTietService {
    @Autowired
    private IHoaDonChiTietRepository repository;

    @Override
    public void saveHDCT(HoaDonChiTiet hoaDonChiTiet) {
        repository.save(hoaDonChiTiet);
    }

    @Override
    public Page<Object[]> getTop10PrdTopSeler(Pageable pageable) {
        return repository.getTop10PrdTopSeler(pageable);
    }

    @Override
    public Page<Object[]> getTop10PrdTonKho(Pageable pageable) {
        return repository.getTop10PrdTonKho(pageable);
    }

    @Override
    public Optional<HoaDonChiTiet> getHdById(Integer idHoaDon) {
        return repository.findById(idHoaDon);
    }

    @Override
    public List<Object[]> findHoaDonChiTietByIdHoaDon(Integer idHoaDon) {
        return repository.findHoaDonChiTietByIdHoaDon(idHoaDon);
    }
}
