package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.NhaSanXuat;

import java.util.List;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAll();

    NhaSanXuat getOne(String id);

    void insert(NhaSanXuat nhaSanXuat);

    void update(NhaSanXuat nhaSanXuat);

    void delete(String id);
}
