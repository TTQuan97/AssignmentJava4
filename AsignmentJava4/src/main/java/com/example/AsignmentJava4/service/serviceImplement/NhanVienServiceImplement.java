package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.NhanVien;
import com.example.AsignmentJava4.repository.NhanVienRepository;
import com.example.AsignmentJava4.service.NhanVienService;

import java.util.List;

public class NhanVienServiceImplement implements NhanVienService {

    NhanVienRepository nhanVienRepo;

    public NhanVienServiceImplement() {
        nhanVienRepo = new NhanVienRepository();
    }

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> list = nhanVienRepo.getAll();
        return list;
    }

    @Override
    public NhanVien getOne(String id) {
        NhanVien nhanVien = nhanVienRepo.getOne(id);
        return nhanVien;
    }

    @Override
    public void insert(NhanVien nhanVien) {
        nhanVien.setMa(autoGenMa());
        nhanVienRepo.insert(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepo.update(nhanVien);
    }

    @Override
    public void delete(NhanVien nhanVien) {
        nhanVienRepo.delete(nhanVien);
    }

    private String autoGenMa() {
        String ma = "NV";
        List<NhanVien> list = nhanVienRepo.getAll();
        int max = 0;
        for (NhanVien obj : list) {
            if (Integer.parseInt(obj.getMa().substring(2)) > max) {
                max = Integer.parseInt(obj.getMa().substring(2));
            }
        }
        return ma + (max + 1);
    }
}
