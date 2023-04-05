package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.NhanVien;

import java.util.List;

public interface NhanVienService {

    List<NhanVien> getAll();

    NhanVien getOne(String id);

    void insert(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(NhanVien nhanVien);
}
