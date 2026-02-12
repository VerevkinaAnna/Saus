package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']" +
                    "//child::button[text()='Add to cart']";
    private final By title = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By cartCounter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Отображение элементов")
    public boolean isTitleIsDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    @Step("Добавляем товары в корзину по названию")
    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Добавляем товары по индексу")
    public void addGoodsToCart(int goodsIndex) {
        driver.findElements(By.xpath("//*[text()='Add to cart']")).get(goodsIndex).click();
    }

    @Step("Подсчет количества добавленных товаров в корзину")
    public String checkCounterValue() {
        return driver.findElement(cartCounter).getText();
    }

    @Step("Проверка изменения цвета cчетчика в корзине")
    public String checkCounterColor() {
        return driver.findElement(cartCounter).getCssValue("background-color");
    }

    @Step("Переключение на корзину")
    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}
