package com.example.AsignmentJava4.controller;

import com.example.AsignmentJava4.entity.MauSac;
import com.example.AsignmentJava4.service.MauSacService;
import com.example.AsignmentJava4.service.serviceImplement.MauSacServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MauSacController",
        urlPatterns = {
                "/mau-sac/view-all",
                "/mau-sac/delete",
                "/mau-sac/add",
                "/mau-sac/update"})
public class MauSacController extends HttpServlet {
    private MauSacService mauSacService = new MauSacServiceImplement();

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
        String id = request.getParameter("idMauSac");
        mauSacService.delete(id);
        showAll(request, response);
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MauSac> list = mauSacService.getAll();
        request.setAttribute("listMauSac", list);
        request.getRequestDispatcher("/View/mau-sac.jsp").forward(request, response);
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
        String id = request.getParameter("idMauSac");
        MauSac mauSac = mauSacService.getOne(id);
        mauSac.setTen(request.getParameter("tenUpdate"));
        mauSacService.update(mauSac);
        showAll(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSac mauSac = new MauSac();
        mauSac.setTen(request.getParameter("ten"));
        mauSacService.insert(mauSac);
        showAll(request, response);
    }
}
