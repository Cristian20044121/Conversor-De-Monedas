# Conversor de Monedas 💱

Este proyecto es una aplicación de consola desarrollada en Java para realizar conversiones entre diferentes monedas utilizando tasas de cambio actualizadas desde una API externa. 🌍✨

## Características 🛠️

- Convierte entre las siguientes monedas:
  1. **Dólar (USD)** a **Peso Argentino (ARS)** 🇺🇸➡️🇦🇷
  2. **Peso Argentino (ARS)** a **Dólar (USD)** 🇦🇷➡️🇺🇸
  3. **Dólar (USD)** a **Real Brasileño (BRL)** 🇺🇸➡️🇧🇷
  4. **Real Brasileño (BRL)** a **Dólar (USD)** 🇧🇷➡️🇺🇸
  5. **Dólar (USD)** a **Peso Colombiano (COP)** 🇺🇸➡️🇨🇴
  6. **Peso Colombiano (COP)** a **Dólar (USD)** 🇨🇴➡️🇺🇸

- Usa la API [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio en tiempo real 🌐.
  
## Uso 📖

1. Ejecuta el programa y selecciona la conversión deseada del menú.
2. Ingresa la cantidad a convertir.
3. Obtén el resultado con el monto convertido. 💸

### Ejemplo de salida 🖥️

```
⋆♡⋆》𝘊𝘖𝘕𝘝𝘌𝘙𝘚𝘖𝘙 𝘋𝘌 𝘔𝘖𝘕𝘌𝘋𝘈𝘚《⋆♡⋆
1) Dólar >>> Peso Argentino
2) Peso Argentino >>> Dólar
3) Dólar >>> Real Brasileño
4) Real Brasileño >>> Dólar
5) Dólar >>> Peso Colombiano
6) Peso Colombiano >>> Dólar
7) Salir

Elija una opción válida: 1
Ingrese la cantidad a convertir: 24
El valor de 24.00 USD corresponde a 25068.00 pesos argentinos
```

## Estructura del Proyecto 🗂️

- `Conversor.java`: Punto de entrada del programa.
- `CurrencyConverter.java`: Clase que maneja las conversiones de moneda.
- `ExchangeRateService.java`: Clase que se conecta a la API para obtener las tasas de cambio.
- `RateResponse.java`: Clase para mapear la respuesta de la API.
- `pom.xml`: Archivo de configuración de Maven.

## Tecnologías Utilizadas 💻

- Lenguaje: **Java** ☕
- Construcción: **Maven** 📦
- Librería JSON: **Gson** 🛠️
- API: **ExchangeRate-API** 🌐

## Autor ✍️

Desarrollado por **Cristian** 👨‍💻
