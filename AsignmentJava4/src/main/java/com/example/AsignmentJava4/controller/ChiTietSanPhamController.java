package com.example.AsignmentJava4.controller;

import com.example.AsignmentJava4.entity.ChiTietSanPham;
import com.example.AsignmentJava4.service.ChiTietSanPhamService;
import com.example.AsignmentJava4.service.DongSanPhamService;
import com.example.AsignmentJava4.service.KhachHangService;
import com.example.AsignmentJava4.service.MauSacService;
import com.example.AsignmentJava4.service.NhaSanXuatService;
import com.example.AsignmentJava4.service.NhanVienService;
import com.example.AsignmentJava4.service.SanPhamService;
import com.example.AsignmentJava4.service.serviceImplement.ChiTietSanPhamServiceImplement;
import com.example.AsignmentJava4.service.serviceImplement.DongSanPhamImplement;
import com.example.AsignmentJava4.service.serviceImplement.KhachHangServiceImplement;
import com.example.AsignmentJava4.service.serviceImplement.MauSacServiceImplement;
import com.example.AsignmentJava4.service.serviceImplement.NhaSanXuatServiceImplement;
import com.example.AsignmentJava4.service.serviceImplement.NhanVienServiceImplement;
import com.example.AsignmentJava4.service.serviceImplement.SanPhamServiceImplement;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "ChiTietSpController",
        urlPatterns = {
                "/chi-tiet-san-pham/view-all",
                "/chi-tiet-san-pham/add",
                "/chi-tiet-san-pham/update",
                "/chi-tiet-san-pham/delete"
        })
public class ChiTietSanPhamController extends HttpServlet {

    private ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamServiceImplement();
    private SanPhamService sanPhamService = new SanPhamServiceImplement();
    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImplement();
    private MauSacService mauSacService = new MauSacServiceImplement();
    private DongSanPhamService dongSanPhamService = new DongSanPhamImplement();
    private NhanVienService nhanVienService = new NhanVienServiceImplement();
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
        String id = request.getParameter("idChiTietSp");
        chiTietSanPhamService.delete(chiTietSanPhamService.getOne(id));
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonChiTietSp = objectMapper.writeValueAsString(chiTietSanPhamService.getAll());
        String jsonSanPham = objectMapper.writeValueAsString(sanPhamService.getAll());
        String jsonNsx = objectMapper.writeValueAsString(nhaSanXuatService.getAll());
        String jsonMauSac = objectMapper.writeValueAsString(mauSacService.getAll());
        String jsonDongSp = objectMapper.writeValueAsString(dongSanPhamService.getAll());
        String jsonNhanVien = objectMapper.writeValueAsString(nhanVienService.getAll());
        String jsonKhachHang = objectMapper.writeValueAsString(khachHangService.getAll());
        request.setAttribute("jsonChiTietSp", jsonChiTietSp);
        request.setAttribute("jsonSanPham", jsonSanPham);
        request.setAttribute("jsonNsx", jsonNsx);
        request.setAttribute("jsonMauSac", jsonMauSac);
        request.setAttribute("jsonDongSp", jsonDongSp);
        request.setAttribute("jsonNhanVien", jsonNhanVien);
        request.setAttribute("jsonKhachHang", jsonKhachHang);
        request.getRequestDispatcher("/View/trang-chu.jsp").forward(request, response);
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
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setId(request.getParameter("idChiTietSp"));
        chiTietSanPham.setSanPham(sanPhamService.getOne(request.getParameter("sanphamUpdate")));
        chiTietSanPham.setDongSanPham(dongSanPhamService.getOne(request.getParameter("dongspUpdate")));
        chiTietSanPham.setMauSac(mauSacService.getOne(request.getParameter("mausacUpdate")));
        chiTietSanPham.setNhaSanXuat(nhaSanXuatService.getOne(request.getParameter("nsxUpdate")));
        chiTietSanPham.setNamBH(Integer.parseInt(request.getParameter("nambhUpdate")));
        chiTietSanPham.setSoLuongTon(Integer.parseInt(request.getParameter("soluongtonUpdate")));
        chiTietSanPham.setGiaNhap(new BigDecimal(request.getParameter("gianhapUpdate")));
        chiTietSanPham.setGiaBan(new BigDecimal(request.getParameter("giabanUpdate")));
        chiTietSanPham.setMoTa((request.getParameter("motaUpdate")));
        chiTietSanPhamService.update(chiTietSanPham);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setSanPham(sanPhamService.getOne(request.getParameter("sanpham")));
        chiTietSanPham.setDongSanPham(dongSanPhamService.getOne(request.getParameter("dongsp")));
        chiTietSanPham.setMauSac(mauSacService.getOne(request.getParameter("mausac")));
        chiTietSanPham.setNhaSanXuat(nhaSanXuatService.getOne(request.getParameter("nhaSanXuat")));
        chiTietSanPham.setNamBH(Integer.parseInt(request.getParameter("nambh")));
        chiTietSanPham.setSoLuongTon(Integer.parseInt(request.getParameter("soluongton")));
        chiTietSanPham.setGiaNhap(new BigDecimal(request.getParameter("gianhap")));
        chiTietSanPham.setGiaBan(new BigDecimal(request.getParameter("giaban")));
        chiTietSanPham.setMoTa((request.getParameter("mota")));
        chiTietSanPhamService.insert(chiTietSanPham);
        showAll(request, response);
    }
}
