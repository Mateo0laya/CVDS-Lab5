# CVDS-Lab5
## Mateo Olaya Garzón - Andrés Camilo Oñate Quimbayo
--- 
### PARTE I. - JUGANDO A SER UN CLIENTE HTTP

1.Revise la página 36 del RFC del protocoloHTTP,sobre cómo realizar una petición GET.
  Con esto,solicite alservidor el recurso ‘sssss/abc.html’, usando la versión 1.0 deHTTP.
  Asegúrese de presionar ENTER dos veces después de ingresar elcomando. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado       HTTP.
  
![thumbnail_image](https://user-images.githubusercontent.com/63562181/224107719-6824a551-d5d0-4574-8258-ea02e84060ba.png)

 El error generado es 301 Moved Permanently, es un código de estado de HTTP que indica que el host ha sido capaz de comunicarse con el servidor, pero que el recurso solicitado ha sido movido a otra dirección permanentemente.
  
  
2.¿Qué otros ódigos de error existen?,¿En qué caso se manejarán?
  - 1xx respuesta informativa : se recibió la solicitud, proceso continuo
  - 2xx exitoso : la solicitud se recibió, entendió y aceptó con éxito
  - Redirección 3xx : es necesario tomar más medidas para completar la solicitud
  - Error de cliente 4xx : la solicitud contiene una sintaxis incorrecta o no se puede cumplir
  - Error del servidor 5xx : el servidor no pudo cumplir con una solicitud aparentemente válida

3.Realice una nueva conexión con telnet, esta vez a: Host:www.httpbin.org Ahora,solicite (GET) el recurso /html.¿Qué se obtiene como resultado?

![image](https://user-images.githubusercontent.com/63562181/224108006-6926ca85-c9fa-428d-9332-c3560f4a18be.png)

Se muestra un 200 OK, código de respuesta de estado satisfactorio HTTP 200 OK indica que la solicitud ha tenido éxito.

4. Seleccione el contenido HTML de la respuesta y copielo alcortapapeles CTRL-SHIFT-C. Ejecute elcomando wc (word count) para contar palabrascon la opción -c para       contar el número de caracteres:

![image (1)](https://user-images.githubusercontent.com/63562181/224108148-f24e3fca-2235-47c5-a2f9-baf974ed7b65.png)


Claro está, las peticiones GET son insuficientes en muchoscasos. Investigue:¿Cuál esla diferencia entre los verbos GET y POST?¿Qué otrostipos de
peticiones existen?
- GET: El método GET solicita una representación de un recurso específico. Las peticiones que usan el método GET sólo deben recuperar datos.
- POST: El método POST se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.

Otros:

- HEAD: El método HEAD pide una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta.
- PUT: El modo PUT reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición.
- DELETE: El método DELETE borra un recurso en específico.
- CONNECT: El método CONNECT establece un túnel hacia el servidor identificado por el recurso.
- PATCH: El método PATCH es utilizado para aplicar modificaciones parciales a un recurso.
- OPTIONS: El método OPTIONS es utilizado para describir las opciones de comunicación para el recurso de destino.


6.En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea d comandos: “curl
www.httpbin.org”

![image](https://user-images.githubusercontent.com/63562181/223801369-aaff0192-579c-429f-860e-f253e4ca6f56.png)

Utilice ahora el parámetro -v y con el parámetro -i:

curl -v www.httpbin.org

![image](https://user-images.githubusercontent.com/63562181/223801999-153f3cc2-69eb-4f9a-ada3-15338f0c4418.png)

curl -i www.httpbin.org

![image](https://user-images.githubusercontent.com/63562181/223802179-fdd1b719-e2ec-4752-8d0b-8b0eae694b3e.png)

¿Cuáles son las diferencias con los diferentes parámetros?
Ambos parametros muestran información similar,, sin embargo el parametro -v muestra información adicional acerca del Request realizado como la direccion ip a la cual estamos realizando el GET, el puerto al cual se esta intentando comunicar, etc.

---

### PARTE II. -HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.

1. Para esto,cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp y realice lo siguiente:

Comando:
```
mvn archetype:generate -DgroupId=edu.eci.cvds -DartifactId=WebApp -Dpackage=edu.eci.cvds.servlet -DarchetypeArtifactId=maven-archetype-webapp
```
2. Agregamos las dependecias en el pom.xml y modificamos los valores indicados.

3. Revise en el pom.xml para qué puerto TCP/IP está configurado elservidor embebido de Tomcat (versección de plugins). 

EL servidor embebido de Tomcat esta configurado en el puerto 8080:

![image](https://user-images.githubusercontent.com/63562181/224181841-bb185c8a-5078-4556-8fd5-2cdae390bd43.png)


4. Compile y ejecute la aplicación en elservidor embebido Tomcat, a través de Maven con:

```
mvn package
mvn tomcat7:run
```
![image](https://user-images.githubusercontent.com/63562181/224182658-22f48f90-bc3e-4789-908f-70b5161c56c2.png)

![image](https://user-images.githubusercontent.com/63562181/224182843-bb9e1d04-4d9d-4da6-bbf4-76da70c116a3.png)

5. Abra un navegador, y en la barra de direcciones ponga la URL con la cualse le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá
como host ‘localhost’,como puerto, elconfigurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.

![image](https://user-images.githubusercontent.com/63562181/224201250-8d1d64c9-d855-4c7b-a838-0823d00e7f19.png)


6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando
un parámetro GET (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).

![image](https://user-images.githubusercontent.com/63562181/224201908-09934dc5-9353-4919-b66b-d8a594dfb65e.png)

7. Busque el artefacto gson en el repositorio de maven y agregue la dependencia.
```
<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>

```
8. En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del path de la url.

![image](https://user-images.githubusercontent.com/63562181/224213702-fc1348d3-1dd1-4fc2-a203-aadcc2ae3e9f.png)
 
 
 9. Basado en la respuesta que le da el servicio del punto anterior,cree la clase edu.eci.cvds.servlet.model.Todo con un constructor vacío y
los métodos getter y setter para las propiedades de los"To Dos" que se encuentran en la url indicada.
```
package edu.eci.cvds.servlet.model;

public class Todo{

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo(){
    }

    public int getUserId(){
        return userId;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public boolean getCompleted(){
        return completed;

    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;

    }
}
```
10. Utilice la siguiente clase para consumir el servicio que se encuentra en la dirección url del punto anterior:

![image](https://user-images.githubusercontent.com/63562181/224216581-29894f98-c80a-4632-8c38-696f9115f2da.png)


11. Cree una clase que herede de la clase HttpServlet (similar a SampleServlet), y para la misma sobrescriba el método heredado doGet. Incluya la
anotación @Override para verificar –en tiempo de compilación- que efectivamente se esté sobreescribiendo un método de las superclases.

12. Para indicar en qué URL elservlet interceptará las peticiones GET, agregue al método la anotación @WebServlet, y en dicha anotación, defina la
propiedad urlPatterns, indicando la URL (que usted defina) a la cualse asociará elservlet.

13. Teniendo en cuenta los siguientes métodos disponibles en los objetos ServletRequest y ServletResponse recibidos por el método doGet:

```
package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
    urlPatterns = "/olayaOñate"
)
public class Servlet extends HttpServlet{

    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Writer responseWriter = resp.getWriter();

        try{
            // El id es un entero, Si se le paso un valor al parametro las banderas seran true, se optione con el metodo get de la clase optional
            Optional<String> optId = Optional.ofNullable(req.getParameter("Id")); //Objecto Opcional del parametro Id de la solicitud
            // Si no se paso un valor en el paramtro se le asigna 0
            int id = optId.isPresent() && !optId.get().isEmpty() ? Integer.parseInt(optId.get()) : 0; 
            // Consultando item con la clase Service
            Todo item = Service.getTodo(id);
            // Respondiendo con el código HTTP que equivale a ‘OK’
            resp.setStatus(HttpServletResponse.SC_OK);
            // Tabla
            ArrayList<Todo> todoList = new ArrayList<>();
            todoList.add(item);
            responseWriter.write(Service.todosToHTMLTable(todoList));
            responseWriter.flush();
        }catch(NotFoundException e){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);  
        }catch(NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch(Exception e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
```
14. Una vez hecho esto, verifique el funcionamiento de la aplicación, recompile y ejecute la aplicación.

![image](https://user-images.githubusercontent.com/63562181/224440272-060992c1-95b8-47d9-834b-56c3cba02e1d.png)

15. Intente hacer diferentesconsultas desde un navegador Web para probar las diferentesfuncionalidades.

![image](https://user-images.githubusercontent.com/63562181/224443898-56fcd41d-746b-4915-92fb-8e140625d967.png)

![image](https://user-images.githubusercontent.com/63562181/224443765-09bbf800-602d-4b95-8a4e-6ddc59a0f77f.png)

![image](https://user-images.githubusercontent.com/63562181/224443833-f03632e4-857a-4a27-8b5e-df9414238016.png)

---

### PARTE III.

16. En su servlet,sobreescriba el método doPost, y haga la misma implementación del doGet.

```
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
```

17. Cree el archivo index.html en el directorio src/main/webapp/index.html de la siguiente manera.

18. En la página anterior, cree un formulario que tenga un campo para ingresar un número (si no ha manejado html antes, revise
http://www.w3schools.com/html/ ) y un botón. El formulario debe usarcomo método ‘POST’, y como acción, la ruta relativa del último servletcreado
(es decir la URL pero excluyendo ‘http://localhost:8080/’).

19. Revise este ejemplo de validación de formularios con javascript y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde el
browserse valide que el valor ingresado es un valor numérico.
```
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <script>
            function myFunction() {
                var x = document.getElementById("id").value;
                if (isNaN(x)) {
                    alert("Entrada invalida");
                    return false;
                }
            }
        </script>
    
        <h1>Formulario</h1>

        <form action="http://localhost:8080/olayaOnate" method="post">
            <label for="id">Identificador</label><br>
            <input type="text" id="id" name="id"><br>
            <input type="submit" onclick="myFunction()" value="Submit">
          </form> 
    </body>
</html>
```
20. Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea
mostrada. Ingrese los datos y verifique losresultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia
observa?

Encontramos que al relaizar la solitud la URL es distinta:

![image](https://user-images.githubusercontent.com/63562181/224453233-b062bb5e-f911-4be6-8efc-1793f0d8c2c9.png)

![image](https://user-images.githubusercontent.com/63562181/224453276-632abd6b-f0ca-4ab7-9b5a-f7bbf13c909d.png)



![image](https://user-images.githubusercontent.com/63562181/224453123-c92118d9-7775-4d8b-8a38-b32c065bbd1e.png)
