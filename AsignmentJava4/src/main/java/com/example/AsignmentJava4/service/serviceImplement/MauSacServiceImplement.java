package com.example.AsignmentJava4.service.serviceImplement;

import com.example.AsignmentJava4.entity.MauSac;
import com.example.AsignmentJava4.repository.MauSacRepository;
import com.example.AsignmentJava4.service.MauSacService;

import java.util.List;

public class MauSacServiceImplement implements MauSacService {

    MauSacRepository mauSacRepository;

    public MauSacServiceImplement() {
        mauSacRepository = new MauSacRepository();
    }

    @Override
    public List<MauSac> getAll() {
        List<MauSac> list = mauSacRepository.getAll();
        return list;
    }

    @Override
    public MauSac getOne(String id) {
        MauSac mauSac = mauSacRepository.getOne(id);
        return mauSac;
    }

    @Override
    public void insert(MauSac mauSac) {
        mauSac.setMa(autoGenMa());
        mauSacRepository.insert(mauSac);
    }

    @Override
    public void update(MauSac mauSac) {
        mauSacRepository.update(mauSac);
    }

    @Override
    public void delete(String id) {
        mauSacRepository.delete(id);
    }

    private String autoGenMa() {
        String ma = "COLOR";
        List<MauSac> list = mauSacRepository.getAll();
        int max = 0;
        for (MauSac obj : list) {
            if (Integer.parseInt(obj.getMa().substring(5)) > max) {
                max = Integer.parseInt(obj.getMa().substring(5));
            }
        }
        return ma + (max + 1);
    }
}
