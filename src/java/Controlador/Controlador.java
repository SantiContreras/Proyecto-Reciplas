/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.Empleado;
import Modelo.EmpleadoDao;
import Modelo.Pedido;
import Modelo.PedidoDao;
import Modelo.Producto;
import Modelo.ProductoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author santi
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDao edao = new EmpleadoDao();
    Cliente cli = new Cliente();
    ClienteDao clidao = new ClienteDao();
    Producto pro = new Producto();
    ProductoDao prodao = new ProductoDao();
    Pedido pe = new Pedido();
    PedidoDao pedao = new PedidoDao();

    List<Pedido> lista = new ArrayList<>();
    int idp;
    int cant;
    int item;
    int cod_pro;
    double precio;
    String Descripcion;
    String numeropedido;
    double Subtotal;
    double TotalPagar;
    String fecha;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {

            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("NuevoPedido")) {   // si la solicitud enviada por la vista fue 'nuevo pedido'.

            switch (accion) {

                case "BuscarCliente":
                    String dni = request.getParameter("dnicliente");
                    cli.setDni(dni);
                    cli = clidao.Buscar(dni);
                    request.setAttribute("cli", cli);
                    request.setAttribute("numeropedido", numeropedido);

                    request.setAttribute("fecha", fecha);// enviamos la solicitudad mediante estos parametros.
                    break;

                case "BuscarProducto":
                    int idp = Integer.parseInt(request.getParameter("cod_pro"));
                    pro.setId_producto(idp);
                    pro = prodao.buscar(idp);
                    request.setAttribute("pro", pro);
                    request.setAttribute("cli", cli);
                    request.setAttribute("fecha", fecha);

                    request.setAttribute("numeropedido", numeropedido);

                    break;
                case "Agregar":
                    request.setAttribute("fecha", fecha);
                    request.setAttribute("pro", pro);
                    request.setAttribute("cli", cli);
                    request.setAttribute("fecha", fecha);
                    request.setAttribute("numeropedido", numeropedido);

                    TotalPagar = 0.0;
                    item = item + 1;
                    cod_pro = pro.getId_producto();
                    Descripcion = request.getParameter("NombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cantidad"));
                    Subtotal = precio * cant;
                    pe = new Pedido(); // instancion un nuevo pedido para ir guardando en la lista
                    pe.setItem(item);
                    pe.setIdpro(cod_pro);
                    pe.setDescripcion(Descripcion);
                    pe.setPrecio(precio);
                    pe.setCantidad(cant);
                    pe.setSubtotal(Subtotal);
                    lista.add(pe); // agregamos a la coleccion
                    for (int i = 0; i < lista.size(); i++) {
                        TotalPagar = TotalPagar + lista.get(i).getSubtotal();
                    }

                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", TotalPagar);

                    break;

                case "GenerarPedido":
                    // guardamos el pedido 
                   
               
                    
                    pe.setIdcliente(cli.getId_cliente());
                    pe.setIdempleado(em.getId_empleado());
                    pe.setNumpedido(String.valueOf(numeropedido));
                    pe.setFecha(fecha);
                    pe.setMonto(TotalPagar);
                    pe.setEstado("1");
                    pedao.guardarPedido(pe);
                    //guardamos el detalle del pedido 
                    idp = Integer.parseInt(pedao.IdPedido());

                    for (int i = 0; i < lista.size(); i++) {
                        pe = new Pedido();
                        pe.setIdpedido(idp);
                        pe.setIdpro(lista.get(i).getIdpro());
                        pe.setCantidad(lista.get(i).getCantidad());
                        pe.setPrecio(lista.get(i).getPrecio());
                        pedao.guardarDetalle(pe);
                    }

                    //actualizamos el stock de productos
                    for (int i = 0; i < lista.size(); i++) {

                        Producto pro = new Producto(); // instanciamos el objeto producto
                        cant = lista.get(i).getCantidad(); // obtenemos la cantidad del producto adquerido
                        int idpro = lista.get(i).getIdpro(); //buscamos el producto para actualizar stock
                        ProductoDao AS = new ProductoDao(); // instanciamos ProductoDao que contiene el metodo actualizar
                        pro = AS.buscar(idpro); //al objeto instanciado le asigno el producto buscado
                        int sac = pro.getStock() - cant; // a la variable sac guardo la diferencia

                    }
                       lista = new ArrayList<>(); // una vs guardado pedido y detalle creamos una nueva lista para disponer la anterior
                   

                    break;

                default:
                    item = 0; // reiniciamos el item para los proximos pedidos de la lista
                    TotalPagar = 0.0; // reiciamos el total para los proximos pedidos
                    fecha = String.valueOf(LocalDate.now()); // obtenemos la fecha en formato local
                    request.setAttribute("fecha", fecha);
                     numeropedido = String.valueOf(pedao.GenerarNumPedido());
                     
                    
                    request.setAttribute("numeropedido", numeropedido);

                    request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);

            }

            request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
