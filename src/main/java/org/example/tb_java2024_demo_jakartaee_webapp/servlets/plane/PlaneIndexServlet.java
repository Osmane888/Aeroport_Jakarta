package org.example.tb_java2024_demo_jakartaee_webapp.servlets.plane;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.tb_java2024_demo_jakartaee_webapp.entities.Plane;
import org.example.tb_java2024_demo_jakartaee_webapp.services.PlaneServices;

import java.io.IOException;
import java.util.List;

@WebServlet("/plane")
public class PlaneIndexServlet extends HttpServlet {

    @Inject
    private PlaneServices avionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Plane> avions = avionService.getAll();
        req.setAttribute("planes", avions);
        req.getRequestDispatcher("/WEB-INF/pages/plane/planeIndex.jsp").forward(req, resp);
    }
}