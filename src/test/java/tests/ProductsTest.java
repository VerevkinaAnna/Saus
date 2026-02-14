package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Тестирование интернет-площадки")
@Feature("Проверка добавления товаров в корзину")
@Story("уникальных товаров")
@Severity(SeverityLevel.NORMAL)
@Owner("Anna Ver 2406ag@gmail.com")
@TmsLink("Saus")

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Onesie", "Sauce Labs Fleece Jacket");

    @Test(description = "Проверка добавления товаров в корзину")
    public void checkGoodsAdded() {
        System.out.println("ProductsTest.correct!!!!!in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.isTitleIsDisplayed());
        assertEquals(productsPage.checkTitleName(), "Products");

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

        assertEquals(productsPage.checkCounterValue(), "3");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}
