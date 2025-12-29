package ru.yandex.practicum.delivery;

import java.util.Objects;

//скоропортящаяся посылка
public class PerishableParcel extends Parcel{

    private static final int PRICE_BASE_PERISHABLE = 3;
    private final int timeToLive;

    public PerishableParcel(String deliveryAddress, String description, int sendDay, int weight, int timeToLive) {
        super(deliveryAddress, description, sendDay, weight);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if (sendDay + timeToLive >= currentDay) {
            System.out.println("Посылка не испортилась!");
            return false;
        }
        System.out.println("Посылка испортилась!");
        return true;
    }

    @Override
    public int getPriceBase() {
        return PRICE_BASE_PERISHABLE;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PerishableParcel perishableParcel = (PerishableParcel) object;
        return Objects.equals(deliveryAddress,perishableParcel.deliveryAddress)
                && Objects.equals(description, perishableParcel.description)
                && sendDay == perishableParcel.sendDay
                && weight == perishableParcel.weight
                && timeToLive == perishableParcel.timeToLive;
    }

    @Override
    public String toString() {
        return "скоропортящаяся посылка: " + description;
    }

}
