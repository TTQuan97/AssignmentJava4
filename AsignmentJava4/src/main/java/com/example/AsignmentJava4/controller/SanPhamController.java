package com.example.AsignmentJava4.controller;

import com.example.AsignmentJava4.entity.SanPham;
import com.example.AsignmentJava4.service.SanPhamService;
import com.example.AsignmentJava4.service.serviceImplement.SanPhamServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamController",
        urlPatterns = {
                "/san-pham/view-all",
                "/san-pham/delete",
                "/san-pham/add",
                "/san-pham/update"})
public class SanPhamController extends HttpServlet {

    private SanPhamService sanPhamService = new SanPhamServiceImplement();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("view-all")) {
            this.showAllSanPham(request, response);
        } else if (uri.contains("delete")) {
            this.deleteSanPham(request, response);
        } else {
            this.showAllSanPham(request, response);
        }
    }

    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idSanPham");
        sanPhamService.delete(new SanPham(id, null, null));
        showAllSanPham(request, response);
    }

    private void showAllSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> listSanPham = sanPhamService.getAll();
        request.setAttribute("listSanPham", listSanPham);
        request.getRequestDispatcher("/View/san-pham.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSanPham(request, response);
        } else if (uri.contains("update")) {
            this.updateSanPham(request, response);
        } else {
            this.showAllSanPham(request, response);
        }
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idSanPham");
        SanPham sanPham = sanPhamService.getOne(id);
        sanPham.setTen(request.getParameter("tenUpdate"));
        sanPhamService.update(sanPham);
        showAllSanPham(request, response);
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham sanPham = new SanPham();
        sanPham.setTen(request.getParameter("ten"));
        sanPhamService.insert(sanPham);
        showAllSanPham(request, response);
    }
}
