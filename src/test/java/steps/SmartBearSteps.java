package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.SmartBearLoginPage;
import pages.SmartBearMainPage;
import utils.Driver;
import utils.DropdownHandler;
import utils.TableHandler;
import utils.Waiter;

import java.util.List;


public class SmartBearSteps {

    WebDriver driver;
    SmartBearLoginPage smartBearLoginPage;
    SmartBearMainPage smartBearMainPage;
    List<WebElement> tableRow;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearMainPage = new SmartBearMainPage();
    }

    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);
    }

    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        smartBearLoginPage.loginBox.sendKeys(username);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        smartBearLoginPage.passwordBox.sendKeys(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        smartBearLoginPage.loginButton.click();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String message) {
        Assert.assertEquals(message, smartBearLoginPage.errorMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void user_should_be_routed_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Then("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable items) {
        for (int i = 0; i < items.asList().size(); i++) {
            Assert.assertEquals(items.asList().get(i), smartBearMainPage.menuItems.get(i).getText());
        }
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        switch(button){
            case "Check All":
                smartBearMainPage.CheckAllButton.click();
                break;
            case "Uncheck All":
                smartBearMainPage.uncheckAllButton.click();
                break;
            case "Process":
                smartBearMainPage.processButton.click();
                break;
            case "Delete Selected":
                smartBearMainPage.deleteSelected.click();
                break;
            default:
                throw new NotFoundException("This button doesn't exist!");
        }
    }

    @Then("all rows should be checked")
    public void all_rows_should_be_checked() {
       Assert.assertTrue(smartBearMainPage.checkBoxes.isSelected());
    }

    @Then("all rows should be unchecked")
    public void all_rows_should_be_unchecked() {
        Assert.assertFalse(smartBearMainPage.checkBoxes.isSelected());
    }

    @When("user clicks on {string} menu item")
    public void user_clicks_Order_on_menu_item(String option) {
        switch(option){
            case "Order":
                smartBearMainPage.menuItems.get(2).click();
                break;
            case "View all orders":
                smartBearMainPage.menuItems.get(0).click();
                break;
            default:
                throw new NotFoundException("This menu option doesn't exist!");
        }
    }

    @When("user selects {string} as product")
    public void user_selects_as_product(String product) {
        DropdownHandler.selectByVisibleText(smartBearMainPage.dropdown, product);
    }

    @When("user enters 2 as quantity")
    public void user_enters_as_quantity() {
       smartBearMainPage.quantityBox.sendKeys("2");
    }

    @When("user enters all address information")
    public void user_enters_all_address_information(DataTable addressInfo) {
        for (int i = 0; i < addressInfo.asList().size(); i++) {
            smartBearMainPage.inputs.get(i).sendKeys(addressInfo.asList().get(i));
        }
        Waiter.pause(3);
    }

    @When("user enters all payment information")
    public void user_enters_all_payment_information() {
        smartBearMainPage.visaOption.click();
        smartBearMainPage.cardNumber.sendKeys("2332345676547893");
        smartBearMainPage.expireDate.sendKeys("21/25");
    }

    @Then("user should see their order displayed in the table")
    public void user_should_see_their_order_displayed_in_the_table() {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertTrue(tableRow.get(i).isDisplayed());
        }
    }

    @Then("validate all information entered displayed correct with the order")
    public void validate_all_information_entered_displayed_correct_with_the_order(DataTable orderInfo) {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertEquals(orderInfo.asList().get(i), tableRow.get(i).getText());
        }
    }
    @Then("validate all orders are deleted from the List of All Orders")
    public void validate_all_orders_are_deleted_from_the() {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertFalse(tableRow.get(i).isDisplayed());
        }
    }
    @Then("validate user sees {string} message")
    public void validate_user_sees_message(String message) {
        Assert.assertEquals(message, smartBearMainPage.message.getText());
    }


}

