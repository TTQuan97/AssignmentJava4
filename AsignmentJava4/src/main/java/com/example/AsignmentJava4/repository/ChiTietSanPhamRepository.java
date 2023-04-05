package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.ChiTietSanPham;
import com.example.AsignmentJava4.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ChiTietSanPhamRepository {

    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> list = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            list = session.createQuery("FROM ChiTietSanPham ").getResultList();
        }
        return list;
    }

    public ChiTietSanPham getOne(String id) {
        ChiTietSanPham chiTietSanPham = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            chiTietSanPham = session.get(ChiTietSanPham.class, id);
        }
        return chiTietSanPham;
    }

    public void insert(ChiTietSanPham chiTietSanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(chiTietSanPham);
            trans.commit();
        }
    }

    public void update(ChiTietSanPham chiTietSanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(chiTietSanPham);
            trans.commit();
        }
    }

    public void delete(ChiTietSanPham chiTietSanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.delete(chiTietSanPham);
            trans.commit();
        }
    }

}
