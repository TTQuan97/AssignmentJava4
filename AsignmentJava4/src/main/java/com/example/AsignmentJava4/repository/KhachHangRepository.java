package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.KhachHang;
import com.example.AsignmentJava4.utility.HibernateUtility;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> list = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhachHang ");
            list = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public KhachHang getOne(String id) {
        KhachHang khachHang = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            khachHang = session.get(KhachHang.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return khachHang;
    }

    public void insert(KhachHang khachHang) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(khachHang);
            trans.commit();
        }
    }

    public void update(KhachHang khachHang) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(khachHang);
            trans.commit();
        }
    }

    public void delete(KhachHang khachHang) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.delete(khachHang);
            trans.commit();
        }
    }
}
