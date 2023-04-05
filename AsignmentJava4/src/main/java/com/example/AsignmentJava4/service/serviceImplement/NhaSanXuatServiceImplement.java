package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.NhaSanXuat;
import com.example.AsignmentJava4.repository.NhaSanXuatRepository;
import com.example.AsignmentJava4.service.NhaSanXuatService;

import java.util.List;

public class NhaSanXuatServiceImplement implements NhaSanXuatService {

    NhaSanXuatRepository nsxRepo;

    public NhaSanXuatServiceImplement() {
        nsxRepo = new NhaSanXuatRepository();
    }

    @Override
    public List<NhaSanXuat> getAll() {
        List<NhaSanXuat> list = nsxRepo.getAll();
        return list;
    }

    @Override
    public NhaSanXuat getOne(String id) {
        NhaSanXuat nhaSanXuat = nsxRepo.getOne(id);
        return nhaSanXuat;
    }

    @Override
    public void insert(NhaSanXuat nhaSanXuat) {
        nhaSanXuat.setMa(autoGenMa());
        nsxRepo.insert(nhaSanXuat);
    }

    @Override
    public void update(NhaSanXuat nhaSanXuat) {
        nsxRepo.update(nhaSanXuat);
    }

    @Override
    public void delete(String id) {
        nsxRepo.delete(id);
    }

    private String autoGenMa() {
        String ma = "FACTORY";
        List<NhaSanXuat> list = nsxRepo.getAll();
        int max = 0;
        for (NhaSanXuat obj : list) {
            if (Integer.parseInt(obj.getMa().substring(7)) > max) {
                max = Integer.parseInt(obj.getMa().substring(7));
            }
        }
        return ma + (max + 1);
    }
}
