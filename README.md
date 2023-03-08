# CVDS-Lab5
## Mateo Olaya Garzón - Andrés Camilo Oñate Quimbayo
--- 
### PARTE I. - JUGANDO A SER UN CLIENTE HTTP

1.Revise la página 36 del RFC del protocoloHTTP,sobre cómo realizar una petición GET.
  Con esto,solicite alservidor el recurso ‘sssss/abc.html’, usando la versión 1.0 deHTTP.
  Asegúrese de presionar ENTER dos veces después de ingresar elcomando. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado       HTTP.
  
  ![image](https://user-images.githubusercontent.com/63562181/223792543-7824463c-1650-40d7-8d28-1430f232a553.png)

  El error generado es 400 Bad Request, el servidor no puede o no procesará la solicitud debido a un aparente error del cliente (p. ej., sintaxis de solicitud mal
  formada, tamaño demasiado grande, marco de mensaje de solicitud no válido o enrutamiento de solicitud engañoso).
  
2.¿Qué otros ódigos de error existen?,¿En qué caso se manejarán?
  - 1xx respuesta informativa : se recibió la solicitud, proceso continuo
  - 2xx exitoso : la solicitud se recibió, entendió y aceptó con éxito
  - Redirección 3xx : es necesario tomar más medidas para completar la solicitud
  - Error de cliente 4xx : la solicitud contiene una sintaxis incorrecta o no se puede cumplir
  - Error del servidor 5xx : el servidor no pudo cumplir con una solicitud aparentemente válida
