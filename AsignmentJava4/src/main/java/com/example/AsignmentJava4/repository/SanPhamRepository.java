package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.SanPham;
import com.example.AsignmentJava4.utility.HibernateUtility;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SanPhamRepository {

    public List<SanPham> getAll() {
        List<SanPham> listSp = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Query query = session.createQuery("FROM SanPham ");
            listSp = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listSp;
    }

    public SanPham getOne(String id) {
        SanPham sanPham = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            sanPham = session.get(SanPham.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sanPham;
    }

    public void insert(SanPham sanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(sanPham);
            trans.commit();
        }
    }

    public void update(SanPham sanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(sanPham);
            trans.commit();
        }
    }

    public void delete(SanPham sanPham) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.delete(sanPham);
            trans.commit();
        }
    }


}
