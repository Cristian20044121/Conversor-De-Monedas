package com.conversor.conversor;

public class CurrencyConverter {

    private final ExchangeRateService exchangeRateService;

    public CurrencyConverter() {
        this.exchangeRateService = new ExchangeRateService(); 
    }

    /**
     * Convierte una cantidad de una moneda a otra basada en la opción proporcionada.
     *
     * @param option Opción seleccionada por el usuario
     * @param amount Cantidad a convertir
     * @return Resultado de la conversión como una cadena de texto
     */
    public String convertCurrency(int option, double amount) {
        if (amount <= 0) {
            return "La cantidad debe ser mayor a cero.";
        }

        String fromCurrency;
        String toCurrency;
        String toCurrencySymbol;

        switch (option) {
            case 1 -> {
                fromCurrency = "USD";
                toCurrency = "ARS";
                toCurrencySymbol = "pesos argentinos";
            }
            case 2 -> {
                fromCurrency = "ARS";
                toCurrency = "USD";
                toCurrencySymbol = "dólares";
            }
            case 3 -> {
                fromCurrency = "USD";
                toCurrency = "BRL";
                toCurrencySymbol = "reales brasileños";
            }
            case 4 -> {
                fromCurrency = "BRL";
                toCurrency = "USD";
                toCurrencySymbol = "dólares";
            }
            case 5 -> {
                fromCurrency = "USD";
                toCurrency = "COP";
                toCurrencySymbol = "pesos colombianos";
            }
            case 6 -> {
                fromCurrency = "COP";
                toCurrency = "USD";
                toCurrencySymbol = "dólares";
            }
            default -> {
                return "Opción no válida. Por favor, seleccione una opción válida del menú.";
            }
        }

        // Obtener la tasa de cambio
        double rate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        if (rate <= 0) {
            return "No se pudo obtener la tasa de cambio. Por favor, intente más tarde.";
        }

        // Calcular la cantidad convertida
        double convertedAmount = amount * rate;

        // Formatear el resultado
        return String.format("El valor de %.2f %s corresponde a %.2f %s", 
                amount, fromCurrency, convertedAmount, toCurrencySymbol);
    }
}
