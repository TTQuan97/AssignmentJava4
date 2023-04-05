package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.ChiTietSanPham;
import com.example.AsignmentJava4.entity.DongSanPham;
import com.example.AsignmentJava4.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DongSanPhamRepository {

    public List<DongSanPham> getAll() {
        List<DongSanPham> listDongSanPham = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            listDongSanPham = session.createQuery("FROM DongSanPham").getResultList();
        }
        return listDongSanPham;
    }

    public DongSanPham getOne(String id) {
        DongSanPham dongSanPham = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            dongSanPham = session.get(DongSanPham.class, id);
        }
        return dongSanPham;
    }

    public void insert(DongSanPham dongSanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(dongSanPham);
            trans.commit();
        }
    }

    public void update(DongSanPham dongSanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(dongSanPham);
            trans.commit();
        }
    }

    public void delete(String id) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            DongSanPham dongSanPham = session.get(DongSanPham.class, id);
            for (ChiTietSanPham chiTietSanPham : dongSanPham.getSetChiTietSanPham()) {
                chiTietSanPham.setDongSanPham(null);
                session.update(dongSanPham);
            }
            session.delete(dongSanPham);
            trans.commit();
        }
    }


}
