package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.ChiTietSanPham;
import com.example.AsignmentJava4.repository.ChiTietSanPhamRepository;
import com.example.AsignmentJava4.service.ChiTietSanPhamService;

import java.util.List;

public class ChiTietSanPhamServiceImplement implements ChiTietSanPhamService {

    ChiTietSanPhamRepository chiTietSpRepo;

    public ChiTietSanPhamServiceImplement() {
        chiTietSpRepo = new ChiTietSanPhamRepository();
    }

    @Override
    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> list = chiTietSpRepo.getAll();
        return list;
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        ChiTietSanPham chiTietSanPham = chiTietSpRepo.getOne(id);
        return chiTietSanPham;
    }

    @Override
    public void insert(ChiTietSanPham chiTietSanPham) {
        chiTietSpRepo.insert(chiTietSanPham);
    }

    @Override
    public void update(ChiTietSanPham chiTietSanPham) {
        chiTietSpRepo.update(chiTietSanPham);

    }

    @Override
    public void delete(ChiTietSanPham chiTietSanPham) {
        chiTietSpRepo.delete(chiTietSanPham);

    }
}
