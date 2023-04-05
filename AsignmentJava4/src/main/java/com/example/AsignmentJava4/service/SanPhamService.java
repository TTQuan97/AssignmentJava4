package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    void insert(SanPham sanPham);

    SanPham getOne(String id);

    void update(SanPham sanPham);

    void delete(SanPham sanPham);
}
