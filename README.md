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
