package com.example.AsignmentJava4.controller;

import com.example.AsignmentJava4.entity.ChucVu;
import com.example.AsignmentJava4.service.ChucVuService;
import com.example.AsignmentJava4.service.serviceImplement.ChucVuServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChucVuController",
        urlPatterns = {
                "/chuc-vu/view-all",
                "/chuc-vu/delete",
                "/chuc-vu/add",
                "/chuc-vu/update"})
public class ChucVuController extends HttpServlet {

    private ChucVuService chucVuService = new ChucVuServiceImplement();

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
        String id = request.getParameter("idChucVu");
        chucVuService.delete(id);
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> list = chucVuService.getAll();
        request.setAttribute("listChucVu", list);
        request.getRequestDispatcher("/View/chuc-vu.jsp").forward(request, response);
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
        String id = request.getParameter("idChucVu");
        ChucVu chucVu = chucVuService.getOne(id);
        chucVu.setTen(request.getParameter("tenUpdate"));
        chucVuService.update(chucVu);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu chucVu = new ChucVu();
        chucVu.setTen(request.getParameter("ten"));
        chucVuService.insert(chucVu);
        showAll(request, response);
    }
}
