# ServerUDP

Este proyecto implementa un servidor UDP simple en Java que recibe mensajes de texto de clientes UDP, los procesa, y luego envía una respuesta. Este servidor está diseñado para manejar mensajes de eco: recibe una cadena, la invierte, la convierte a mayúsculas y la envía de vuelta al cliente.

## Comenzando

Para ejecutar el servidor en tu máquina local, necesitarás una versión reciente de Java instalada. Este servidor está diseñado para escuchar en el puerto `54322`.

### Ejecución

Para iniciar el servidor, compila el código fuente y luego ejecútalo desde la línea de comandos:

```bash
javac ServerUDP.java
java ServerUDP
