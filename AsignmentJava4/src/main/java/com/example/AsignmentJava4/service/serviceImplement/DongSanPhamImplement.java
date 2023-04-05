package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.DongSanPham;
import com.example.AsignmentJava4.repository.DongSanPhamRepository;
import com.example.AsignmentJava4.service.DongSanPhamService;

import java.util.List;

public class DongSanPhamImplement implements DongSanPhamService {

    DongSanPhamRepository dongSpRepo;

    public DongSanPhamImplement() {
        dongSpRepo = new DongSanPhamRepository();
    }

    @Override
    public List<DongSanPham> getAll() {
        List<DongSanPham> list = dongSpRepo.getAll();
        return list;
    }

    @Override
    public DongSanPham getOne(String id) {
        DongSanPham dongSanPham = dongSpRepo.getOne(id);
        return dongSanPham;
    }

    @Override
    public void insert(DongSanPham dongSanPham) {
        dongSanPham.setMa(autoGenMa());
        dongSpRepo.insert(dongSanPham);
    }

    @Override
    public void update(DongSanPham dongSanPham) {
        dongSpRepo.update(dongSanPham);
    }

    @Override
    public void delete(String id) {
        dongSpRepo.delete(id);
    }

    private String autoGenMa() {
        String ma = "TYPE";
        List<DongSanPham> list = dongSpRepo.getAll();
        int max = 0;
        for (DongSanPham obj : list) {
            if (Integer.parseInt(obj.getMa().substring(4)) > max) {
                max = Integer.parseInt(obj.getMa().substring(4));
            }
        }
        return ma + (max + 1);
    }
}
