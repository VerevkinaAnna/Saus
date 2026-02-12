package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Epic("Тестирование интернет-площадки")
@Feature("Проверка добавления товаров в корзину")
@Story("уникальных товаров")
@Severity(SeverityLevel.NORMAL)
@Owner("Anna Ver 2406ag@gmail.com")
@TmsLink("Saus")

public class LoginTest extends BaseTest {
    @Test(description = "Проверка авторизации незаблокированного пользователя",
            invocationCount = 1, priority = 1, enabled = true)
    public void correctLogin() {
        System.out.println("LoginTest.correct!!!!!in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(withAdminPermission());

        assertTrue(productsPage.isTitleIsDisplayed(), "Заголовок не виден");
        assertEquals(productsPage.checkTitleName(), PRODUCTS.getDisplayName(), "Неверный заголовок");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {"", password, "Epic sadface: Username is required"},
                {user, "", "Epic sadface: Password is required"},
                {"Standard_user", password, "Epic sadface: Username and password do not match " +
                        "any user in this service"}
        };
    }

    @Test(dataProvider = "incorrectLoginData", description = "Проверка авторизации заблокированного пользователя",
            invocationCount = 1, priority = 2)
    public void incorrectLogin(String user, String password, String errorMsg) {
        System.out.println("LoginTest.incorrect!!!!!in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(), errorMsg, "Неверный текст сообщения об ошибке");
    }
}
