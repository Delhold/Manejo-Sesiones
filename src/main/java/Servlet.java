import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
//GENEREMOS NUESTRO PATH PARA PODER LLAMARLO
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    //SOBREESCRIBIMOS EL METODO "DOGET"
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //CREAMOS LA SESION MEDIANTE "HTTPsession"
        HttpSession session = req.getSession();
        //CREAMOS UNA VARIABLE DE TIPO STRING PARA PODER CMBIAR LO QUE NOSOTROS QUERAMOS
        String titulo= null;
        //CONTADOR DE VISITAS DE TIPO "INTEGER"
        Integer contadorVisitas=(Integer) session.getAttribute("contadorVisitas");
        //EVALUAMOS SI ES LA PRIMERA VEZ
        //que ingresa a la aplicacion
        if(contadorVisitas==null){
            contadorVisitas=1;
            titulo="Bienvenido a mi acplicacion por primera vez";
            //CASO CONTRARIO EL VALOR DEL CONTADOR COMO YA
            //EXISTE VA A PASAR AL "ELSE"
        }else {
            //CON EL CONTADOR COMO YA EXISTE SE VA A SUMAR Y MOSTRAR
            //EN PANTALLA
            contadorVisitas=contadorVisitas+1;
            titulo="Bienvenido a mi aplicacion nuevamente";
        }
        //SETEAMOS O AGREMAOS LOS NUEVOS VALORES A LA SESION "SESSION.SETATRIBUTTE"
        session.setAttribute("contadorVisitas", contadorVisitas);
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.printf("<meta charset=\"utf-8\">");
        out.printf("<title> Hola Mundo </title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Titulo: "+titulo+"</h1>");
        out.print("<h1>Contador de Visitas: "+contadorVisitas+"</h1>");
        out.print("</body>");
        out.print("</html>");
    }
//mediante sesiones yo tengo un pequeño formulario : nombre del producto, cantidad del producto, valor unitario y valor total.
//y mediante sesiones mostrar la informacion de una factura
    //Servlet tiene que procesar toda la tipo factura
}
