package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.TitleNaming.CART;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Тестирование интернет-площадки")
@Feature("Проверка добавления товаров в корзину")
@Story("уникальных товаров")
@Severity(SeverityLevel.NORMAL)
@Owner("Anna Ver 2406ag@gmail.com")
@TmsLink("Saus")

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Onesie";

    @Test(description = "Просмотр корзины")
    public void checkGoodsAdded() {
        System.out.println("CartTest.correct!!!!!in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.checkTitleName(), PRODUCTS.getDisplayName());

        productsPage.addGoodsToCart(goodsName);
        productsPage.switchToCart();

        assertEquals(cartPage.checkTitleName(), CART.getDisplayName());
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
