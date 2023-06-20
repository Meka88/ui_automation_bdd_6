package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.Project4Pages;
import utils.Driver;

import java.util.List;

public class Project04Steps {
    WebDriver driver;
    Project4Pages project4Pages;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        project4Pages = new Project4Pages();
    }

    @Given("the user is on {string}")
    public void theUserIsOn(String url) {
        driver.get(url);
    }



    @Then("the user should see the {string} heading")
    public void the_user_should_see_the_heading(String str) {
        Assert.assertTrue(project4Pages.header.isDisplayed());
        Assert.assertEquals(project4Pages.header.getText(),str);
    }

    @And("the user should see the table with the headers below")
    public void the_user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
        List<String> expectedResult = dataTable.asList();
        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertTrue(project4Pages.tableHeaders.get(i).isDisplayed());
            Assert.assertEquals(project4Pages.tableHeaders.get(i).getText(), expectedResult.get(i));
        }

    }

    @Then("the user should see the table with the rows below")
    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
        List<List<String>> expectedResult = dataTable.asLists();
        int index = 0;
        for (int i = 0; i < expectedResult.size(); i++) {
            for (int j = 0; j < expectedResult.get(i).size(); j++) {
                Assert.assertTrue(project4Pages.tableRows.get(i).isDisplayed()); // iPhone
                Assert.assertEquals(project4Pages.tableRows.get(i).getText(), expectedResult.get(i).get(j)); // 1
            }
        }

    }

    @Then("the user should see the {string} button is enabled")
    public void the_user_should_see_the_button_is_enabled(String btn) {
        switch (btn){
            case "ADD PRODUCT":
                Assert.assertTrue(project4Pages.addProductBtn.isEnabled());
                break;
            case "X":
                break;
            case "SUBMIT":
                break;
            default:
                throw new NotFoundException("Not Found given element");
        }

    }

    @Then("the user should see the {string} text displayed")
    public void the_user_should_see_the_text_displayed(String str) {
        Assert.assertTrue(project4Pages.total.isDisplayed());
        Assert.assertEquals(project4Pages.total.getText(),str);
    }


    @Then("the user should see the {string} modal with its heading")
    public void the_user_should_see_the_modal_with_its_heading(String string) {
        Assert.assertTrue(project4Pages.addProductHeading.isDisplayed());
        Assert.assertEquals(project4Pages.addProductHeading.getText(),string);

    }

    @Then("the user should see the {string} label")
    public void the_user_should_see_the_label(String str) {
        switch (str){
            case "Please select the quantity":
                Assert.assertTrue(project4Pages.product_quantity.isDisplayed());
                Assert.assertEquals(project4Pages.product_quantity.getText(),str);
                break;
            case "Please enter the name of the product":
                Assert.assertTrue(project4Pages.product_name.isDisplayed());
                Assert.assertEquals(project4Pages.product_name.getText(),str);
                break;
            case "Please enter the price of the product":
                Assert.assertTrue(project4Pages.product_price.isDisplayed());
                Assert.assertEquals(project4Pages.product_price.getText(),str);
                break;
            default:
                throw new NotFoundException("bla bla bla");

        }
    }

    @Then("the user should see the {string} input box is enabled")
    public void the_user_should_see_the_input_box_is_enabled(String str) {
        switch (str) {
            case "Quantity":
                Assert.assertTrue(project4Pages.quantityInput.isEnabled());
                break;
            case "Product":
                Assert.assertTrue(project4Pages.productInput.isEnabled());
                break;
            case "Price":
                Assert.assertTrue(project4Pages.priceInput.isEnabled());
                break;
            default:
                throw new NotFoundException("bla bla bla");

        }
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        switch (string){
            case "ADD PRODUCT":
                project4Pages.addProductBtn.click();
                break;
            case "X":
                project4Pages.deleteButton.click();
                break;
            case "SUBMIT":
                project4Pages.submitBTN.click();
                break;
            default:
                throw new NotFoundException("Not Found given element");
        }
    }

    @Then("the user should not see the {string} modal")
    public void the_user_should_not_see_the_modal(String str) {
        try {
            Assert.assertFalse(project4Pages.modalPageExists.isDisplayed());
        } catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @When("the user enters the quantity as {string}")
    public void the_user_enters_the_quantity_as(String string) {
        project4Pages.quantityInput.sendKeys(string);
    }

    @When("the user enters the product as {string}")
    public void the_user_enters_the_product_as(String str) {
        project4Pages.productInput.sendKeys(str);

    }

    @When("the user enters the price as {string}")
    public void the_user_enters_the_price_as(String str) {
        project4Pages.priceInput.sendKeys(str);

    }

    @Then("the user should see the table with the new row below")
    public void the_user_should_see_the_table_with_the_new_row_below(DataTable dataTable) {
        List<String> expectedResult = dataTable.asList();
        for (int i = 0; i < expectedResult.size(); i++) {
            Assert.assertTrue(project4Pages.newRow.get(i).isDisplayed());
            Assert.assertEquals(project4Pages.newRow.get(i).getText(), expectedResult.get(i));
        }
    }


}