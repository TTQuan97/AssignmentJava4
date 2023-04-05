package com.example.AsignmentJava4.controller;

import com.example.AsignmentJava4.entity.CuaHang;
import com.example.AsignmentJava4.service.CuaHangService;
import com.example.AsignmentJava4.service.serviceImplement.CuaHangServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CuaHangController",
        urlPatterns = {
                "/cua-hang/view-all",
                "/cua-hang/delete",
                "/cua-hang/add",
                "/cua-hang/update"})
public class CuaHangController extends HttpServlet {

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
        String id = request.getParameter("idCuaHang");
        cuaHangService.delete(id);
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CuaHang> list = cuaHangService.getAll();
        request.setAttribute("listCuaHang", list);
        request.getRequestDispatcher("/View/cua-hang.jsp").forward(request, response);
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
        String id = request.getParameter("idCuaHang");
        CuaHang cuaHang = cuaHangService.getOne(id);
        cuaHang.setTen(request.getParameter("tenUpdate"));
        cuaHang.setDiaChi(request.getParameter("diachiUpdate"));
        cuaHang.setThanhPho(request.getParameter("thanhphoUpdate"));
        cuaHang.setQuocGia(request.getParameter("quocgiaUpdate"));
        cuaHangService.update(cuaHang);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang cuaHang = new CuaHang();
        cuaHang.setTen(request.getParameter("ten"));
        cuaHang.setDiaChi(request.getParameter("diachi"));
        cuaHang.setThanhPho(request.getParameter("thanhpho"));
        cuaHang.setQuocGia(request.getParameter("quocgia"));
        cuaHangService.insert(cuaHang);
        showAll(request, response);
    }
}
