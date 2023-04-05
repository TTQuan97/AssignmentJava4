package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.ChucVu;

import java.util.List;

public interface ChucVuService {

    List<ChucVu> getAll();

    ChucVu getOne(String id);

    void insert(ChucVu chucVu);

    void update(ChucVu chucVu);

    void delete(String id);
}
