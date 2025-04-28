# Alura Exchange - Conversor de Divisas

Un conversor de monedas sencillo hecho en Java para obtener tasas de cambio en tiempo real.

Este proyecto fue realizado como parte del desafío de Alura Latam, para seguir practicando y afianzando los conocimientos en Java que vistos hasta el momento.

---

## 🛠️ Configuración

- Agregar la librería **Gson** al proyecto. Podés bajarla desde acá:  
  [https://mvnrepository.com/artifact/com.google.code.gson/gson](https://mvnrepository.com/artifact/com.google.code.gson/gson)

- También vamos a necesitar una cuenta gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/), que es la que nos da las tasas de cambio actualizadas.

---

## Mejoras al desafío original

El Desafio original mostraba un menú fijo con combinaciones de monedas, algo así como:

- Dólar Americano a Peso Argentino
- Peso Argentino a Dólar
- Dólar a Real Brasileño
- etc.

La verdad es que eso estaba bueno para practicar, pero yo quise hacerlo un poco más flexible, así que cambié el flujo para que sea más dinámico:

- Primero el usuario elige la **moneda de origen** entre una lista de divisas disponibles (`USD`, `ARS`, `BRL`, `COP`, etc.).
- Después elige la **moneda de destino**, y obviamente no puede elegir la misma que puso como origen.
- El sistema muestra no sólo el código de la moneda, sino también el **nombre**, para que sea más fácil de entender.
- Agregué control de errores: si escribís algo que no es un número o elegís una opción fuera de rango, te avisa y te deja volver a intentar.
- Gracias a estos cambios, ahora se puede convertir cualquier moneda soportada entre sí, **sin necesidad de escribir cada posible combinación entre monedas.**.

La idea fue que el programa sea más fácil de usar, más intuitivo y más parecido a una app real.

---



