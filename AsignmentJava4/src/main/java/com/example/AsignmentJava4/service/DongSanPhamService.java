package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.DongSanPham;

import java.util.List;

public interface DongSanPhamService {

    List<DongSanPham> getAll();

    DongSanPham getOne(String id);

    void insert(DongSanPham dongSanPham);

    void update(DongSanPham dongSanPham);

    void delete(String id);
}
