package com.conversor.conversor;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Conversor de monedas mejorado
 * @author Cristian
 */
public class Conversor {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int option;
            
            do {
                printMenu();
                
                try {
                    System.out.print("Elija una opción válida: ");
                    option = scanner.nextInt();
                    
                    if (option >= 1 && option <= 6) {
                        System.out.print("Ingrese la cantidad a convertir: ");
                        double amount = scanner.nextDouble();
                        
                        if (amount < 0) {
                            System.out.println("La cantidad debe ser positiva. Intente de nuevo.\n");
                            continue;
                        }
                        
                        CurrencyConverter converter = new CurrencyConverter();
                        String result = converter.convertCurrency(option, amount);
                        System.out.println(result);
                    } else if (option != 7) {
                        System.out.println("Opción no válida. Intente de nuevo.\n");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número válido.\n");
                    scanner.nextLine();
                    option = -1;
                }
            } while (option != 7);
            
            System.out.println("Gracias por usar el conversor de monedas. ¡Hasta pronto!");
        }
    }

    /**
     * Imprime el menú de opciones del conversor.
     */
    private static void printMenu() {
        System.out.println("𝘊𝘖𝘕𝘝𝘌𝘙𝘚𝘖𝘙 𝘋𝘌 𝘔𝘖𝘕𝘌𝘋𝘈𝘚");
        System.out.println("1) Dólar >>> Peso Argentino");
        System.out.println("2) Peso Argentino >>> Dólar");
        System.out.println("3) Dólar >>> Real Brasileño");
        System.out.println("4) Real Brasileño >>> Dólar");
        System.out.println("5) Dólar >>> Peso Colombiano");
        System.out.println("6) Peso Colombiano >>> Dólar");
        System.out.println("7) Salir\n");
    }
}
