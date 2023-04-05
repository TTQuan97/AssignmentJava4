package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.ChiTietSanPham;

import java.util.List;

public interface ChiTietSanPhamService {

    List<ChiTietSanPham> getAll();

    ChiTietSanPham getOne(String id);

    void insert(ChiTietSanPham chiTietSanPham);

    void update(ChiTietSanPham chiTietSanPham);

    void delete(ChiTietSanPham chiTietSanPham);
}
