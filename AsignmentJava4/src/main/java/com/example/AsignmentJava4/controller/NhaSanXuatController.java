package com.example.AsignmentJava4.controller;

import com.example.AsignmentJava4.entity.NhaSanXuat;
import com.example.AsignmentJava4.service.NhaSanXuatService;
import com.example.AsignmentJava4.service.serviceImplement.NhaSanXuatServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NsxController",
        urlPatterns = {
                "/nha-san-xuat/view-all",
                "/nha-san-xuat/delete",
                "/nha-san-xuat/add",
                "/nha-san-xuat/update"})
public class NhaSanXuatController extends HttpServlet {
    private NhaSanXuatService nhaSanXuatService = new NhaSanXuatServiceImplement();

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
        String id = request.getParameter("idNsx");
        nhaSanXuatService.delete(id);
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhaSanXuat> list = nhaSanXuatService.getAll();
        request.setAttribute("listNhaSanXuat", list);
        request.getRequestDispatcher("/View/nha-san-xuat.jsp").forward(request, response);
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
        String id = request.getParameter("idNsx");
        NhaSanXuat nhaSanXuat = nhaSanXuatService.getOne(id);
        nhaSanXuat.setTen(request.getParameter("tenUpdate"));
        nhaSanXuatService.update(nhaSanXuat);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        nhaSanXuat.setTen(request.getParameter("ten"));
        nhaSanXuatService.insert(nhaSanXuat);
        showAll(request, response);
    }

}
