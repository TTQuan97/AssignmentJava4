package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.CuaHang;
import com.example.AsignmentJava4.repository.CuaHangRepository;
import com.example.AsignmentJava4.service.CuaHangService;

import java.util.List;

public class CuaHangServiceImplement implements CuaHangService {

    private CuaHangRepository cuaHangRepo;

    public CuaHangServiceImplement() {
        cuaHangRepo = new CuaHangRepository();
    }

    @Override
    public List<CuaHang> getAll() {
        List<CuaHang> list = cuaHangRepo.getAll();
        return list;
    }

    @Override
    public CuaHang getOne(String id) {
        CuaHang cuaHang = cuaHangRepo.getOne(id);
        return cuaHang;
    }

    @Override
    public void insert(CuaHang cuaHang) {
        cuaHang.setMa(autoGenMa());
        cuaHangRepo.insert(cuaHang);
    }

    @Override
    public void update(CuaHang cuaHang) {
        cuaHangRepo.update(cuaHang);
    }

    @Override
    public void delete(String id) {
        cuaHangRepo.delete(id);
    }

    private String autoGenMa() {
        String ma = "STORE";
        List<CuaHang> list = cuaHangRepo.getAll();
        int max = 0;
        for (CuaHang obj : list) {
            if (Integer.parseInt(obj.getMa().substring(5)) > max) {
                max = Integer.parseInt(obj.getMa().substring(5));
            }
        }
        return ma + (max + 1);
    }
}
