package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;



public class DeliveryCostTest {

    private static final StandardParcel standardParcelTest = new StandardParcel(
            "moscow",
            "stoun",
            3,
            5);
    private static final FragileParcel fragileParcelTest = new FragileParcel(
            "adler",
            "botl",
            1,
            3);
    private static final PerishableParcel perishableParcelTest = new PerishableParcel(
            "sochi",
            "cookie",
            6,
            2,
            5);

    @Test
    public void costStandardParcel() {
        int price = standardParcelTest.calculateDeliveryCost(standardParcelTest.getWeight());
        Assertions.assertEquals(10, price);

    }

    @Test
    public void costFragileParcel() {
        int price = fragileParcelTest.calculateDeliveryCost(fragileParcelTest.getWeight());
        Assertions.assertEquals(12, price);
    }

    @Test
    public void costPerishableParcel() {
        int price = perishableParcelTest.calculateDeliveryCost(perishableParcelTest.getWeight());
        Assertions.assertEquals(6, price);
    }

    @Test
    public void checkingIsExpired() {
        boolean isExpectedExpired1 = perishableParcelTest.isExpired(11);
        Assertions.assertFalse(isExpectedExpired1);
        boolean isExpectedExpired2 = perishableParcelTest.isExpired(20);
        Assertions.assertTrue(isExpectedExpired2);
    }

    @Test
    public void checkAddNewParcelBox() {
        ParcelBox<StandardParcel> standardBoxTest = new ParcelBox<>(10);
        StandardParcel standardParcel1 = new StandardParcel(
                "bryansk",
                "table",
                6,
                3);
        StandardParcel standardParcel2 = new StandardParcel(
                "tokyo",
                "sofa",
                9,
                4);
        StandardParcel standardParcel3 = new StandardParcel(
                "chicago",
                "wardrobe",
                5,
                6);

        standardBoxTest.addParcel(standardParcel1);
        Assertions.assertEquals(7, standardBoxTest.getWeightBox());
        standardBoxTest.addParcel(standardParcel2);
        Assertions.assertEquals(3, standardBoxTest.getWeightBox());
        standardBoxTest.addParcel(standardParcel3);
    }

}
