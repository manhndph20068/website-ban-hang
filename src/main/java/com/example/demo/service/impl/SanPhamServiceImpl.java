package com.example.demo.service.impl;

import com.example.demo.model.SanPham;
import com.example.demo.repository.ISanPhamRepository;
import com.example.demo.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements ISanPhamService {
    @Autowired
    private ISanPhamRepository repository;

    @Override
    public Page<SanPham> getAllSanPham(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<SanPham> getAll() {
        return repository.findAll();
    }


    @Override
    public Page<SanPham> getSanPhamByTen(String keyword, Pageable pageable) {
        return repository.getByTenSanPhamContains(keyword, pageable);
    }

    @Override
    public Page<SanPham> findAllByGiaBetween(BigDecimal minGia, BigDecimal maxGia, Pageable pageable) {
        return repository.findAllByGiaBetween(minGia, maxGia, pageable);
    }

    @Override
    public void saveSanPham(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public void removeSanPham(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<SanPham> findSanPhamById(Integer id) {
        return repository.findById(id);
    }
}
