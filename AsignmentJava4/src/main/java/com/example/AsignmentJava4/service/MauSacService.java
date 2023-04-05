package com.example.AsignmentJava4.service;

import com.example.AsignmentJava4.entity.MauSac;

import java.util.List;

public interface MauSacService {

    List<MauSac> getAll();

    MauSac getOne(String id);

    void insert(MauSac mauSac);

    void update(MauSac mauSac);

    void delete(String id);
}
