package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private int weightBox;
    private final List<T> listBox = new ArrayList<>();

    public ParcelBox(int weightBox) {
        this.weightBox = weightBox;
    }

    public void addParcel(T parcel) {
        System.out.println("Вес коробки: " + weightBox);
        if (parcel.getWeight() <= weightBox) {
            listBox.add(parcel);
            weightBox -= parcel.getWeight();
            System.out.println("Оставшийся вес в коробке: " + weightBox);
        } else {
            System.out.println("Превышен максимальный вес коробки! Посылка весом "
                    + parcel.getWeight() + " не добавлена!");
        }
    }

    public List<T> getAllParcels() {
        return listBox;
    }

    public int getWeightBox() {
        return weightBox;
    }
}
