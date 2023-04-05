package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.CuaHang;

import java.util.List;

public interface CuaHangService {

    List<CuaHang> getAll();

    CuaHang getOne(String id);

    void insert(CuaHang cuaHang);

    void update(CuaHang cuaHang);

    void delete(String id);
}
