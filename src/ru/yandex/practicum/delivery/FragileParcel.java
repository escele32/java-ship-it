package ru.yandex.practicum.delivery;

import java.util.Objects;

//хрупкая посылка
public class FragileParcel extends Parcel implements Trackable {

    private static final int PRICE_BASE_FRAGILE = 4;

    public FragileParcel(String deliveryAddress, String description, int sendDay, int weight) {
        super(deliveryAddress, description, sendDay, weight);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку.");
        super.packageItem();
    }

    @Override
    public int getPriceBase() {
        return PRICE_BASE_FRAGILE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation + ".");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FragileParcel fragileParcel = (FragileParcel) object;
        return Objects.equals(deliveryAddress,fragileParcel.deliveryAddress)
                && Objects.equals(description, fragileParcel.description)
                && sendDay == fragileParcel.sendDay
                && weight == fragileParcel.weight;
    }

    @Override
    public String toString() {
        return "хрупкая посылка: " + description;
    }

}
