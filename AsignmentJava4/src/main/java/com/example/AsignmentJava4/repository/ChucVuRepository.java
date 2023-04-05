package com.example.AsignmentJava4.repository;

import com.example.AsignmentJava4.entity.ChucVu;
import com.example.AsignmentJava4.entity.NhanVien;
import com.example.AsignmentJava4.utility.HibernateUtility;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ChucVuRepository {

    public List<ChucVu> getAll() {
        List<ChucVu> list = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Query query = session.createQuery("FROM ChucVu ");
            list = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ChucVu getOne(String id) {
        ChucVu chucVu = null;
        try (Session session = HibernateUtility.getFactory().openSession()) {
            chucVu = session.get(ChucVu.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return chucVu;
    }

    public void insert(ChucVu chucVu) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.persist(chucVu);
            trans.commit();
        }
    }

    public void update(ChucVu chucVu) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            session.merge(chucVu);
            trans.commit();
        }
    }

    public void delete(String id) {
        try (Session session = HibernateUtility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChucVu chucVu = session.get(ChucVu.class, id);
            for (NhanVien nhanVien : chucVu.getSetNhanVien()) {
                nhanVien.setChucVu(null);
                session.update(nhanVien);
            }
            session.delete(chucVu);
            trans.commit();
        }
    }
}
