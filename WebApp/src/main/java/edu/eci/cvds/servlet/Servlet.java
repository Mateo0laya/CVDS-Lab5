package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.Todo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(
    urlPatterns = "/olayaOnate"
)
public class Servlet extends HttpServlet{

    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Writer responseWriter = resp.getWriter();
        String mssg = "";
        try{
            // El id es un entero, Si se le paso un valor al parametro las banderas seran true, se optione con el metodo get de la clase optional
            Optional<String> optId = Optional.ofNullable(req.getParameter("id")); //Objecto Opcional del parametro Id de la solicitud
            // Si no se paso un valor en el paramtro se le asigna 0
            // Consultando item con la clase Service
            Todo item = Service.getTodo(Integer.parseInt(optId.get()));
            // Respondiendo con el código HTTP que equivale a ‘OK’
            resp.setStatus(HttpServletResponse.SC_OK);
            // Tabla
            ArrayList<Todo> todoList = new ArrayList<>();
            todoList.add(item);
            mssg = Service.todosToHTMLTable(todoList);
        }catch(FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            mssg = Service.getErrorMessageToHTML(404, "Item no encontrado");
        }catch(NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mssg = Service.getErrorMessageToHTML(400, "Requerimiento invalido");
        }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mssg = Service.getErrorMessageToHTML(500, "Error interno en el servidor");
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mssg = Service.getErrorMessageToHTML(400, "Requerimiento invalido");
        }finally{
            responseWriter.write(mssg);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Writer responseWriter = resp.getWriter();
        String mssg = "";
        try{
            // El id es un entero, Si se le paso un valor al parametro las banderas seran true, se optione con el metodo get de la clase optional
            Optional<String> optId = Optional.ofNullable(req.getParameter("id")); //Objecto Opcional del parametro Id de la solicitud
            // Si no se paso un valor en el paramtro se le asigna 0
            // Consultando item con la clase Service
            Todo item = Service.getTodo(Integer.parseInt(optId.get()));
            // Respondiendo con el código HTTP que equivale a ‘OK’
            resp.setStatus(HttpServletResponse.SC_OK);
            // Tabla
            ArrayList<Todo> todoList = new ArrayList<>();
            todoList.add(item);
            mssg = Service.todosToHTMLTable(todoList);
        }catch(FileNotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            mssg = Service.getErrorMessageToHTML(404, "Item no encontrado");
        }catch(NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mssg = Service.getErrorMessageToHTML(400, "Requerimiento invalido");
        }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            mssg = Service.getErrorMessageToHTML(500, "Error interno en el servidor");
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mssg = Service.getErrorMessageToHTML(400, "Requerimiento invalido");
        }finally{
            responseWriter.write(mssg);
        }
    }
}