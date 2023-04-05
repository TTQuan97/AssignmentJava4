package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.ChiTietSanPham;
import com.example.AsignmentJava4.entity.MauSac;
import com.example.AsignmentJava4.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MauSacRepository {

    public List<MauSac> getAll() {
        List<MauSac> list = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM MauSac").getResultList();
            trans.commit();
        }
        return list;
    }

    public MauSac getOne(String id) {
        MauSac mauSac = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            mauSac = session.get(MauSac.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mauSac;
    }

    public void insert(MauSac mauSac) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(mauSac);
            trans.commit();
        }
    }

    public void update(MauSac mauSac) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(mauSac);
            trans.commit();
        }
    }

    public void delete(String id) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            MauSac mauSac = session.get(MauSac.class, id);
            for (ChiTietSanPham chiTietSanPham : mauSac.getSetChiTietSanPham()) {
                chiTietSanPham.setMauSac(null);
                session.update(chiTietSanPham);
            }
            session.delete(mauSac);
            trans.commit();
        }
    }

}
