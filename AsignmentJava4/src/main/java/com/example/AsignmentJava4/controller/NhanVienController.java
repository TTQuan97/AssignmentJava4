package com.example.AsignmentJava4.controller;

import com.example.AsignmentJava4.entity.NhanVien;
import com.example.AsignmentJava4.service.ChucVuService;
import com.example.AsignmentJava4.service.CuaHangService;
import com.example.AsignmentJava4.service.NhanVienService;
import com.example.AsignmentJava4.service.serviceImplement.ChucVuServiceImplement;
import com.example.AsignmentJava4.service.serviceImplement.CuaHangServiceImplement;
import com.example.AsignmentJava4.service.serviceImplement.NhanVienServiceImplement;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NhanVienController",
        urlPatterns = {
                "/nhan-vien/view-all",
                "/nhan-vien/delete",
                "/nhan-vien/add",
                "/nhan-vien/update"})
public class NhanVienController extends HttpServlet {

    private NhanVienService nhanVienService = new NhanVienServiceImplement();
    private ChucVuService chucVuService = new ChucVuServiceImplement();
    private CuaHangService cuaHangService = new CuaHangServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.showAll(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.showAll(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idNhanVien");
        nhanVienService.delete(nhanVienService.getOne(id));
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonNhanVien = objectMapper.writeValueAsString(nhanVienService.getAll());
        String jsonCuaHang = objectMapper.writeValueAsString(cuaHangService.getAll());
        String jsonChucVu = objectMapper.writeValueAsString(chucVuService.getAll());
        request.setAttribute("jsonNhanVien", jsonNhanVien);
        request.setAttribute("jsonCuaHang", jsonCuaHang);
        request.setAttribute("jsonChucVu", jsonChucVu);
        request.getRequestDispatcher("/View/nhan-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            this.showAll(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idNhanVien");
        NhanVien nhanVien = nhanVienService.getOne(id);
        nhanVien.setHo(request.getParameter("hoUpdate"));
        nhanVien.setTen(request.getParameter("tenUpdate"));
        nhanVien.setTenDem(request.getParameter("tendemUpdate"));
        nhanVien.setGioiTinh(request.getParameter("gioitinhUpdate"));
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        try {
            ngaySinh = formatDate.parse(request.getParameter("ngaysinhUpdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setDiaChi(request.getParameter("diachiUpdate"));
        nhanVien.setSdt(request.getParameter("sdtUpdate"));
        nhanVien.setMatKhau(request.getParameter("matkhauUpdate"));
        nhanVien.setCuaHang(cuaHangService.getOne(request.getParameter("cuahangUpdate")));
        nhanVien.setChucVu(chucVuService.getOne(request.getParameter("chucvuUpdate")));
        nhanVien.setTrangThai(Integer.parseInt(request.getParameter("trangthaiUpdate")));
        nhanVienService.update(nhanVien);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setHo(request.getParameter("ho"));
        nhanVien.setTen(request.getParameter("ten"));
        nhanVien.setTenDem(request.getParameter("tendem"));
        nhanVien.setGioiTinh(request.getParameter("gioitinh"));
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        try {
            ngaySinh = formatDate.parse(request.getParameter("ngaysinh"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        nhanVien.setNgaySinh(ngaySinh);
        nhanVien.setDiaChi(request.getParameter("diachi"));
        nhanVien.setSdt(request.getParameter("sdt"));
        nhanVien.setMatKhau(request.getParameter("matkhau"));
        nhanVien.setCuaHang(cuaHangService.getOne(request.getParameter("cuahang")));
        nhanVien.setChucVu(chucVuService.getOne(request.getParameter("chucvu")));
        nhanVien.setTrangThai(Integer.parseInt(request.getParameter("trangthai")));
        nhanVienService.insert(nhanVien);
        showAll(request, response);
    }
}
