package com.workintech.w3d1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MarketCartApp {

    private ArrayList<String> groceryList = new ArrayList<>();

    public void startApp() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("0: Çıkış");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman çıkar");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Uygulama kapatılıyor...");
                    break;
                case 1:
                    addItems(scanner);
                    break;
                case 2:
                    removeItems(scanner);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }

    private void addItems(Scanner scanner) {
        scanner.nextLine(); // Clear the newline character from previous input
        System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
        String input = scanner.nextLine();
        String[] itemsToAdd = input.split(",\\s*");

        for (String item : itemsToAdd) {
            if (!groceryList.contains(item.trim())) {
                groceryList.add(item.trim());
            }
        }

        Collections.sort(groceryList);
        printSorted();
    }

    private void removeItems(Scanner scanner) {
        scanner.nextLine(); // Clear the newline character from previous input
        System.out.println("Çıkarılmasını istediğiniz elemanları giriniz:");
        String input = scanner.nextLine();
        String[] itemsToRemove = input.split(",\\s*");

        for (String item : itemsToRemove) {
            groceryList.remove(item.trim());
        }

        Collections.sort(groceryList);
        printSorted();
    }

    private void printSorted() {
        System.out.println("------- Pazar Arabası Listesi -------");
        for (String item : groceryList) {
            System.out.println(item);
        }
        System.out.println("------------------------------------");
    }
}
