package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.NhanVien;
import com.example.AsignmentJava4.utility.HibernateUtility;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> list = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Query query = session.createQuery("FROM NhanVien ");
            list = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public NhanVien getOne(String id) {
        NhanVien nhanVien = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            nhanVien = session.get(NhanVien.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhanVien;
    }

    public void insert(NhanVien nhanVien) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(nhanVien);
            trans.commit();
        }
    }

    public void update(NhanVien nhanVien) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(nhanVien);
            trans.commit();
        }
    }

    public void delete(NhanVien nhanVien) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.delete(nhanVien);
            trans.commit();
        }
    }
}
