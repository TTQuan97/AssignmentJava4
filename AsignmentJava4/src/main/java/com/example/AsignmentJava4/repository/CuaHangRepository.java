package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.CuaHang;
import com.example.AsignmentJava4.entity.NhanVien;
import com.example.AsignmentJava4.utility.HibernateUtility;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CuaHangRepository {

    public List<CuaHang> getAll() {
        List<CuaHang> list = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Query query = session.createQuery("FROM CuaHang ");
            list = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public CuaHang getOne(String id) {
        CuaHang cuaHang = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            cuaHang = session.get(CuaHang.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cuaHang;
    }

    public void insert(CuaHang cuaHang) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(cuaHang);
            trans.commit();
        }
    }

    public void update(CuaHang cuaHang) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(cuaHang);
            trans.commit();
        }
    }

    public void delete(String id) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            CuaHang cuaHang = session.get(CuaHang.class, id);
            for (NhanVien nhanVien : cuaHang.getSetNhanVien()) {
                nhanVien.setCuaHang(null);
                session.update(nhanVien);
            }
            session.delete(cuaHang);
            trans.commit();
        }
    }
}
