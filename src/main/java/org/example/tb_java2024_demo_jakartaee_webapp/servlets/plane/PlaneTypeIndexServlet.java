package org.example.tb_java2024_demo_jakartaee_webapp.servlets.plane;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.PlaneType;
import org.example.tb_java2024_demo_jakartaee_webapp.services.PlaneTypeServices;

import java.io.IOException;
import java.util.List;

@WebServlet("/planeType")
public class PlaneTypeIndexServlet extends HttpServlet {

    @Inject
    PlaneTypeServices planeTypeServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<PlaneType> planeTypes = planeTypeServices.getAll();
        req.setAttribute("planeTypes", planeTypes);
        req.getRequestDispatcher("/WEB-INF/pages/planeType/planeTypeIndex.jsp").forward(req,res);
    }
}
