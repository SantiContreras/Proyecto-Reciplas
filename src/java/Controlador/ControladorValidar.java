/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
@WebServlet(name = "ControladorValidar", urlPatterns = {"/ControladorValidar"})
public class ControladorValidar extends HttpServlet {

    Empleado emp = new Empleado();
    EmpleadoDao empdao = new EmpleadoDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorValidar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorValidar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("Ingresar")) {
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            emp = empdao.Validar(user, pass);

            if (emp.getUser() != null) {
                request.setAttribute("usuario_logueado", emp);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
