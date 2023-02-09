package com.engeto.invoice2;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    private static final double DISCOUNT = 0.05; // 5% sleva
    public static void main(String[] args) {
        String item; // název zboží (item),
        int quantity; // počet kusů (quantity),
        double weight; // hmotnost jednoho kusu (weight),
        BigDecimal pricePerPiece = BigDecimal.valueOf(1800); //  a cenu jednoho kusu (price per piece),
        LocalDate dateOfIssue; // datum vystavení faktury (date),
        boolean isDiscounted = true; // jestli má zákazníky nárok na slevu (is discounted).

        item = "Trekové boty Sedmimílovky";
        quantity = 3; // pairs
        weight = 0.45; // kg
        dateOfIssue = LocalDate.of(2022, 4, 7);

        // Vypočti a vypiš na obrazovku celkovou hmotnost zásilky
        double totalWeight = weight * quantity;
        System.out.println("Celkova hmotnost zasilky je " + totalWeight + "kg.");

        // Vypočti a vypiš na obrazovku celkovou cenu zásilky.
        BigDecimal totalPrice = pricePerPiece.multiply(BigDecimal.valueOf(quantity));
        System.out.println("Celkova cena zasilky je " + totalPrice + "Kc.");

        totalPrice = totalPrice.add(BigDecimal.valueOf(45));
        System.out.println("Celkova cena zasilky i s dopravou je " + totalPrice + "Kc.");

        if (isDiscounted) {
            totalPrice = totalPrice.multiply(BigDecimal.valueOf(1 - DISCOUNT));
            System.out.println("Tento zakaznik ma slevu. Celkova cena tedy je: " + totalPrice + "Kc.");
        }

        System.out.println("");
        for (int i = 0; i < quantity; i++) {
            System.out.println("Nazev polozky: " + item + ".");
        }

        totalPrice = getTotalPrice(pricePerPiece, 0, quantity, false);
        System.out.println(totalPrice);

        totalPrice = getTotalPrice(pricePerPiece, 45, quantity, false);
        System.out.println(totalPrice);

        totalPrice = getTotalPrice(pricePerPiece, 45, quantity, true);
        System.out.println(totalPrice);

    }

    public static BigDecimal getTotalPrice(BigDecimal pricePerPiece, int transportationPrice, int quantity, boolean isDiscounted) {
        // Vypočti a vypiš na obrazovku celkovou cenu zásilky.
        BigDecimal totalPrice = pricePerPiece.multiply(BigDecimal.valueOf(quantity));
        totalPrice = totalPrice.add(BigDecimal.valueOf(transportationPrice));

        if (isDiscounted) {
            totalPrice = totalPrice.multiply(BigDecimal.valueOf(1 - DISCOUNT));
        }

        return totalPrice;
    }

}
