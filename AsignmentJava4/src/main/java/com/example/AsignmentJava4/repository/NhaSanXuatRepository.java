package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.ChiTietSanPham;
import com.example.AsignmentJava4.entity.NhaSanXuat;
import com.example.AsignmentJava4.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NhaSanXuatRepository {

    public List<NhaSanXuat> getAll() {
        List<NhaSanXuat> list = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM NhaSanXuat").getResultList();
            trans.commit();
        }
        return list;
    }

    public NhaSanXuat getOne(String id) {
        NhaSanXuat nhaSanXuat = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            nhaSanXuat = session.get(NhaSanXuat.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhaSanXuat;
    }

    public void insert(NhaSanXuat nhaSanXuat) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(nhaSanXuat);
            trans.commit();
        }
    }

    public void update(NhaSanXuat nhaSanXuat) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(nhaSanXuat);
            trans.commit();
        }
    }

    public void delete(String id) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            NhaSanXuat nhaSanXuat = session.get(NhaSanXuat.class, id);
            for (ChiTietSanPham chiTietSanPham : nhaSanXuat.getSetChiTietSanPham()) {
                chiTietSanPham.setNhaSanXuat(null);
                session.update(chiTietSanPham);
            }
            session.delete(nhaSanXuat);
            trans.commit();
        }
    }
}
