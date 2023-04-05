package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.KhachHang;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> getAll();

    KhachHang getOne(String id);

    void insert(KhachHang khachHang);

    void update(KhachHang khachHang);

    void delete(KhachHang khachHang);
}
