package ru.yandex.practicum.delivery;

//посылка
public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String deliveryAddress, String description, int sendDay, int weight) {
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.sendDay = sendDay;
        this.weight = weight;
    }

    protected abstract int getPriceBase();

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована.");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress + ".");
    }

    public int calculateDeliveryCost(int weight) {
        System.out.println("Стоимость отправки посылки: " + weight * getPriceBase());
        return weight * getPriceBase();
    }

    public int getWeight() {
        return weight;
    }
}
