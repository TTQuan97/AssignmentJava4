package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.SanPham;
import com.example.AsignmentJava4.repository.SanPhamRepository;
import com.example.AsignmentJava4.service.SanPhamService;

import java.util.List;

public class SanPhamServiceImplement implements SanPhamService {

    SanPhamRepository sanPhamRepo;

    public SanPhamServiceImplement() {
        sanPhamRepo = new SanPhamRepository();
    }

    @Override
    public List<SanPham> getAll() {
        List<SanPham> list = sanPhamRepo.getAll();
        return list;
    }

    @Override
    public void insert(SanPham sanPham) {
        sanPham.setMa(autoGenMa());
        sanPhamRepo.insert(sanPham);
    }

    @Override
    public SanPham getOne(String id) {
        SanPham sanPham = sanPhamRepo.getOne(id);
        return sanPham;
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepo.update(sanPham);
    }

    @Override
    public void delete(SanPham sanPham) {
        sanPhamRepo.delete(sanPham);
    }

    private String autoGenMa() {
        String ma = "PROD";
        List<SanPham> list = sanPhamRepo.getAll();
        int max = 0;
        for (SanPham obj : list) {
            if (Integer.parseInt(obj.getMa().substring(4)) > max) {
                max = Integer.parseInt(obj.getMa().substring(4));
            }
        }
        return ma + (max + 1);
    }
}
