package com.example.AsignmentJava4.utility;

import com.example.AsignmentJava4.entity.ChiTietSanPham;
import com.example.AsignmentJava4.entity.ChucVu;
import com.example.AsignmentJava4.entity.CuaHang;
import com.example.AsignmentJava4.entity.DongSanPham;
import com.example.AsignmentJava4.entity.KhachHang;
import com.example.AsignmentJava4.entity.MauSac;
import com.example.AsignmentJava4.entity.NhaSanXuat;
import com.example.AsignmentJava4.entity.NhanVien;
import com.example.AsignmentJava4.entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtility {
    private static final SessionFactory factory;

    static {
        Configuration config = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "quanttph19447");
        properties.put(Environment.PASS, "123456789");
        properties.put(Environment.SHOW_SQL, "true");
        config.setProperties(properties);
        config.addAnnotatedClass(ChiTietSanPham.class);
        config.addAnnotatedClass(ChucVu.class);
        config.addAnnotatedClass(CuaHang.class);
        config.addAnnotatedClass(DongSanPham.class);
        config.addAnnotatedClass(KhachHang.class);
        config.addAnnotatedClass(MauSac.class);
        config.addAnnotatedClass(NhanVien.class);
        config.addAnnotatedClass(NhaSanXuat.class);
        config.addAnnotatedClass(SanPham.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return factory;
    }

}
