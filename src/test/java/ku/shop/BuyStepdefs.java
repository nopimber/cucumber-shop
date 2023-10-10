package ku.shop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Natthanan Sriwichean 6410450931
public class BuyStepdefs {

    private ProductCatalog catalog;
    private Order order;

    @Given("Prepare Service")
    public void prepare_service() {
        catalog = new ProductCatalog();
        order = new Order();
    }

    @Given("a product {string} with price {double} and stock of {int} exists")
    public void a_product_exists(String name, double price, int stock) {
        catalog.addProduct(name, price, stock);
    }

    @When("I buy {string} with quantity {int}")
    public void i_buy_with_quantity(String name, int quantity) {
        Product prod = catalog.getProduct(name);
        order.addItem(prod, quantity);
    }

    @Then("total should be {float}")
    public void total_should_be(double total) {
        assertEquals(total, order.getTotal());
    }

    @Then("{string} in stock should be {int}")
    public void product_in_stock_should_be(String product, int stock) {
        Product prod = catalog.getProduct(product);
        assertEquals(stock, prod.getStock());
    }
}

