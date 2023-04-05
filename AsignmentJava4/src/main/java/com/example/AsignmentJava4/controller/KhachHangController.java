package com.example.AsignmentJava4.controller;


import com.example.AsignmentJava4.entity.KhachHang;
import com.example.AsignmentJava4.service.KhachHangService;
import com.example.AsignmentJava4.service.serviceImplement.KhachHangServiceImplement;
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

@WebServlet(name = "KhachHangController",
        urlPatterns = {
                "/khach-hang/view-all",
                "/khach-hang/delete",
                "/khach-hang/add",
                "/khach-hang/update"})
public class KhachHangController extends HttpServlet {

    private KhachHangService khachHangService = new KhachHangServiceImplement();

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
        String id = request.getParameter("idKhachHang");
        khachHangService.delete(khachHangService.getOne(id));
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonKhachHang = objectMapper.writeValueAsString(khachHangService.getAll());
        request.setAttribute("jsonKhachHang", jsonKhachHang);
        request.getRequestDispatcher("/View/khach-hang.jsp").forward(request, response);
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
        String id = request.getParameter("idKhachHang");
        KhachHang khachHang = khachHangService.getOne(id);
        khachHang.setHo(request.getParameter("hoUpdate"));
        khachHang.setTen(request.getParameter("tenUpdate"));
        khachHang.setTenDem(request.getParameter("tendemUpdate"));
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        try {
            ngaySinh = formatDate.parse(request.getParameter("ngaysinhUpdate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        khachHang.setNgaySinh(ngaySinh);
        khachHang.setSdt(request.getParameter("sdtUpdate"));
        khachHang.setDiaChi(request.getParameter("diachiUpdate"));
        khachHang.setThanhPho(request.getParameter("thanhphoUpdate"));
        khachHang.setQuocGia(request.getParameter("quocgiaUpdate"));
        khachHang.setMatKhau(request.getParameter("matkhauUpdate"));
        khachHangService.update(khachHang);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang khachHang = new KhachHang();
        khachHang.setHo(request.getParameter("ho"));
        khachHang.setTen(request.getParameter("ten"));
        khachHang.setTenDem(request.getParameter("tendem"));
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        try {
            ngaySinh = formatDate.parse(request.getParameter("ngaysinh"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        khachHang.setNgaySinh(ngaySinh);
        khachHang.setSdt(request.getParameter("sdt"));
        khachHang.setDiaChi(request.getParameter("diachi"));
        khachHang.setThanhPho(request.getParameter("thanhpho"));
        khachHang.setQuocGia(request.getParameter("quocgia"));
        khachHang.setMatKhau(request.getParameter("matkhau"));
        khachHangService.insert(khachHang);
        showAll(request, response);

    }
}
