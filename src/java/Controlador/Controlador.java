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

import Modelo.Producto;
import Modelo.ProductoDao;

import Modelo.Sistema;
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

    ClienteDao clidao = new ClienteDao();
    Empleado em = new Empleado();
    EmpleadoDao edao = new EmpleadoDao();
    Cliente cli = new Cliente();
    ProductoDao prodao = new ProductoDao();

    Producto pro = new Producto();

    Pedido pe = new Pedido();

    Sistema sist = new Sistema();

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
    String Pago;
    int ide;
    int idc;

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
                    cli = sist.Buscar(dni);
                    request.setAttribute("cli", cli);
                    request.setAttribute("numeropedido", numeropedido);

                    request.setAttribute("fecha", fecha);// enviamos  estos parametros.
                    break;

                case "BuscarProducto":
                    int idp = Integer.parseInt(request.getParameter("cod_pro"));
                    pro.setId_producto(idp);
                    pro = sist.buscar(idp);
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
                    pe = new Pedido(); // creamos un nuevo pedido para ir guardando en la lista
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

                    Pago = request.getParameter("txtpago");
                    pe.setIdcliente(cli.getId_cliente());
                    pe.setIdempleado(em.getId_empleado());
                    pe.setNumpedido(String.valueOf(numeropedido));
                    pe.setFecha(fecha);
                    pe.setMonto(TotalPagar);
                    pe.setEstado("1");
                    pe.setPago(Pago);
                    sist.guardarPedido(pe);
                    //guardamos el detalle del pedido 
                    idp = Integer.parseInt(sist.IdPedido());

                    for (int i = 0; i < lista.size(); i++) {
                        pe = new Pedido();
                        pe.setIdpedido(idp);
                        pe.setIdpro(lista.get(i).getIdpro());
                        pe.setCantidad(lista.get(i).getCantidad());
                        pe.setPrecio(lista.get(i).getPrecio());
                        sist.guardarDetalle(pe);
                    }

                    //actualizamos el stock de productos
                    for (int i = 0; i < lista.size(); i++) {

                        Producto prod = new Producto(); // instanciamos el objeto producto
                        cant = lista.get(i).getCantidad(); // obtenemos la cantidad del producto adquerido
                        int idpro = lista.get(i).getIdpro(); //buscamos el producto para actualizar stock
                        Sistema AS = new Sistema(); // instanciamos sistema que contiene el metodo actualizar
                        prod = AS.buscar(idpro); //al objeto instanciado le asigno el producto buscado
                        int sac = prod.getStock() - cant; // a la variable sac guardo la diferencia
                        AS.actualizarstock(idpro, sac);

                    }
                    lista = new ArrayList<>(); // una vs guardado pedido y detalle creamos una nueva lista para disponer la anterior

                    break;

                default:
                    pe = new Pedido();
                    item = 0; // reiniciamos el item para los proximos pedidos de la lista
                    TotalPagar = 0.0; // reiciamos el total para los proximos pedidos
                    fecha = String.valueOf(LocalDate.now()); // obtenemos la fecha en formato local
                    request.setAttribute("fecha", fecha);
                    numeropedido = String.valueOf(sist.GenerarNumPedido());

                    request.setAttribute("numeropedido", numeropedido);

                    request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);

            }

            request.getRequestDispatcher("RegistrarPedido.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtnombre");
                    String dni = request.getParameter("txtdni");
                    String user = request.getParameter("txtusuario");
                    String email = request.getParameter("txtcorreo");
                    String estado = request.getParameter("txtestado");
                    em.setDni(dni);
                    em.setEmail(email);
                    em.setEs(estado);
                    em.setUser(user);
                    em.setNom(nom);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":

                    String dni1 = request.getParameter("txtdni");
                    String nom1 = request.getParameter("txtnombre");
                    String user1 = request.getParameter("txtusuario");
                    String email1 = request.getParameter("txtcorreo");
                    String es1 = request.getParameter("txtestado");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setUser(user1);
                    em.setEmail(email1);
                    em.setEs(es1);
                    em.setId_empleado(ide);
                    edao.Actualizar(em);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);

                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {

            switch (accion) {
                case "Listar":
                    List lista = clidao.Listar();
                    request.setAttribute("cliente", lista);

                    break;

                case "Agregar":
                    String dni = request.getParameter("txtdni");
                    String tel = request.getParameter("txttelefono");
                    String dir = request.getParameter("txtdireccion");
                    String nom = request.getParameter("txtnombre");
                    cli.setDni(dni);
                    cli.setDir(dir);
                    cli.setNom(nom);
                    cli.setTel(tel);
                    clidao.Agregar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    clidao.Eliminar(idc);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente cl = clidao.editar(idc);
                    request.setAttribute("clientes", cl);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":

                    String dni2 = request.getParameter("txtdni");
                    String tel2 = request.getParameter("txttelefono");
                    String dir2 = request.getParameter("txtdireccion");
                    String nom2 = request.getParameter("txtnombre");
                    cli.setDir(dir2);
                    cli.setDni(dni2);
                    cli.setNom(nom2);
                    cli.setTel(tel2);
                    cli.setId_cliente(idc);
                    clidao.Actualizar(cli);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {

            switch (accion) {
                case "Listar":
                    List lista = prodao.listar();
                    request.setAttribute("productos", lista);

                    break;

                case "Agregar":
                    String nom = request.getParameter("txtnombre");
                    double pre = Double.parseDouble(request.getParameter("txtprecio"));
                    int stock = Integer.parseInt(request.getParameter("txtstock"));
                    String es = request.getParameter("txtestado");
                   
                    pro.setNombre(nom);
                    pro.setPrecio(pre);
                    pro.setStock(stock);
                    pro.setEstado(es);
                  
                    prodao.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    prodao.eliminar(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    Producto pr = prodao.listarId(idp);
                    request.setAttribute("producto", pr);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":

                   
                    String nom1 = request.getParameter("txtnombre");
                    double pre1 = Double.parseDouble(request.getParameter("txtprecio"));
                    int stock1 = Integer.parseInt(request.getParameter("txtstock"));
                    String es1 = request.getParameter("txtestado");
                    pro.setNombre(nom1);
                    
                    pro.setPrecio(pre1);
                    pro.setStock(stock1);
                    pro.setEstado(es1);
                    pro.setId_producto(idp);
                    prodao.Actualizar(pro);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);
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
