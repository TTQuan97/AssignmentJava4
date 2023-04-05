package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.KhachHang;
import com.example.AsignmentJava4.repository.KhachHangRepository;
import com.example.AsignmentJava4.service.KhachHangService;

import java.util.List;

public class KhachHangServiceImplement implements KhachHangService {

    private KhachHangRepository khachHangRepo;

    public KhachHangServiceImplement() {
        khachHangRepo = new KhachHangRepository();
    }

    @Override
    public List<KhachHang> getAll() {
        List<KhachHang> list = khachHangRepo.getAll();
        return list;
    }

    @Override
    public KhachHang getOne(String id) {
        KhachHang khachHang = khachHangRepo.getOne(id);
        return khachHang;
    }

    @Override
    public void insert(KhachHang khachHang) {
        khachHang.setMa(autoGenMa());
        khachHangRepo.insert(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachHangRepo.update(khachHang);
    }

    @Override
    public void delete(KhachHang khachHang) {
        khachHangRepo.delete(khachHang);
    }

    private String autoGenMa() {
        String ma = "CUS";
        List<KhachHang> list = khachHangRepo.getAll();
        int max = 0;
        for (KhachHang obj : list) {
            if (Integer.parseInt(obj.getMa().substring(3)) > max) {
                max = Integer.parseInt(obj.getMa().substring(3));
            }
        }
        return ma + (max + 1);
    }
}
