package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(50);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(70);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    trackParcels();
                    break;
                case 5:
                    showBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Состояние отчета для всех посылок, поддерживающих трекинг.");
        System.out.println("5 — Показать содержимое коробки.");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже
    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Какой тип посылки желаете отправить:");
        System.out.println("1 - стандартная, 2 - хрупкая, 3 - скоропортящаяся.");
        int typeParcel = scanner.nextInt();
        scanner.nextLine(); // Сброс символа новой строки
        if ((typeParcel < 1) || (typeParcel > 3)) {
            System.out.println("Некорректный ввод типа посылки!");
            return;
        }
        System.out.println("Введите краткое описание:");
        String descriptionParcel = scanner.nextLine();
        System.out.println("Введите вес посылки:");
        int weightParcel = scanner.nextInt();
        scanner.nextLine(); // Сброс символа новой строки
        System.out.println("Введите адрес места назначения посылки:");
        String deliveryAddressParcel = scanner.nextLine();
        System.out.println("Введите день месяца, в который посылка была отправлена:");
        int sendDayParcel = scanner.nextInt();
        scanner.nextLine(); // Сброс символа новой строки

        switch (typeParcel) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(
                        deliveryAddressParcel,
                        descriptionParcel,
                        sendDayParcel,
                        weightParcel);
                allParcels.add(standardParcel);
                standardBox.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(
                        deliveryAddressParcel,
                        descriptionParcel,
                        sendDayParcel,
                        weightParcel);
                allParcels.add(fragileParcel);
                trackableParcels.add(fragileParcel); // Добавление в список трекинговых посылок
                fragileBox.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("Введите сколько дней посылка может храниться:");
                int timeToLiveParcel = scanner.nextInt();
                scanner.nextLine(); // Сброс символа новой строки
                PerishableParcel perishableParcel = new PerishableParcel(deliveryAddressParcel,
                        descriptionParcel,
                        sendDayParcel,
                        weightParcel,
                        timeToLiveParcel);
                allParcels.add(perishableParcel);
                perishableBox.addParcel(perishableParcel);
                break;
        }

    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost(parcel.weight);
        }
        System.out.println("Общая стоимость всех доставок: " + sum + ".");
    }

    private static void trackParcels() {
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void showBoxContents() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 - стандартная");
        System.out.println("2 - хрупкая");
        System.out.println("3 - скоропортящаяся");
        int boxType = scanner.nextInt();
        scanner.nextLine(); // Сброс символа новой строки

        switch (boxType) {
            case 1:
                System.out.println(standardBox.getAllParcels());
                break;
            case 2:
                System.out.println(fragileBox.getAllParcels());
                break;
            case 3:
                System.out.println(perishableBox.getAllParcels());
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }
    }

}

