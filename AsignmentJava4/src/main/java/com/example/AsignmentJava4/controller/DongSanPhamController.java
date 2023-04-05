package com.example.AsignmentJava4.controller;


import com.example.AsignmentJava4.entity.DongSanPham;
import com.example.AsignmentJava4.service.DongSanPhamService;
import com.example.AsignmentJava4.service.serviceImplement.DongSanPhamImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DongSpController",
        urlPatterns = {
                "/dong-san-pham/view-all",
                "/dong-san-pham/delete",
                "/dong-san-pham/add",
                "/dong-san-pham/update"})
public class DongSanPhamController extends HttpServlet {
    private DongSanPhamService dongSanPhamService = new DongSanPhamImplement();

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
        String id = request.getParameter("idDongSp");
        dongSanPhamService.delete(id);
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DongSanPham> list = dongSanPhamService.getAll();
        request.setAttribute("listDongSanPham", list);
        request.getRequestDispatcher("/View/dong-san-pham.jsp").forward(request, response);
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
        String id = request.getParameter("idDongSp");
        DongSanPham dongSanPham = dongSanPhamService.getOne(id);
        dongSanPham.setTen(request.getParameter("tenUpdate"));
        dongSanPhamService.update(dongSanPham);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSanPham dongSanPham = new DongSanPham();
        dongSanPham.setTen(request.getParameter("ten"));
        dongSanPhamService.insert(dongSanPham);
        showAll(request, response);
    }
}
