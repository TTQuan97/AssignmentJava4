package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.ChucVu;
import com.example.AsignmentJava4.entity.CuaHang;
import com.example.AsignmentJava4.repository.ChucVuRepository;
import com.example.AsignmentJava4.service.ChucVuService;

import java.util.List;

public class ChucVuServiceImplement implements ChucVuService {

    private ChucVuRepository chucVuRepo;

    public ChucVuServiceImplement() {
        chucVuRepo = new ChucVuRepository();
    }

    @Override
    public List<ChucVu> getAll() {
        List<ChucVu> list = chucVuRepo.getAll();
        return list;
    }

    @Override
    public ChucVu getOne(String id) {
        ChucVu chucVu = chucVuRepo.getOne(id);
        return chucVu;
    }

    @Override
    public void insert(ChucVu chucVu) {
        chucVu.setMa(autoGenMa());
        chucVuRepo.insert(chucVu);
    }

    @Override
    public void update(ChucVu chucVu) {
        chucVuRepo.update(chucVu);
    }

    @Override
    public void delete(String id) {
        chucVuRepo.delete(id);
    }

    private String autoGenMa() {
        String ma = "BIZ";
        List<ChucVu> list = chucVuRepo.getAll();
        int max = 0;
        for (ChucVu obj : list) {
            if (Integer.parseInt(obj.getMa().substring(3)) > max) {
                max = Integer.parseInt(obj.getMa().substring(3));
            }
        }
        return ma + (max + 1);
    }
}
