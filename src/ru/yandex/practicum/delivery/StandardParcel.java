package ru.yandex.practicum.delivery;

import java.util.Objects;

//стандартная посылка
public class StandardParcel extends Parcel{

    private static final int PRICE_BASE_STANDARD = 2;

    public StandardParcel(String deliveryAddress, String description, int sendDay, int weight) {
        super(deliveryAddress, description, sendDay, weight);
    }

    @Override
    public int getPriceBase() {
        return PRICE_BASE_STANDARD;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        StandardParcel standardParcel = (StandardParcel) object;
        return Objects.equals(deliveryAddress,standardParcel.deliveryAddress)
                && Objects.equals(description, standardParcel.description)
                && sendDay == standardParcel.sendDay
                && weight == standardParcel.weight;
    }

    @Override
    public String toString() {
        return "стандартная посылка: " + description;
    }
}
