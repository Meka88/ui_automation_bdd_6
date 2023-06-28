package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Project4Page;
import utils.Driver;
import utils.TableHandler;

import java.util.List;

public class Project04Steps {
    WebDriver driver;
    Project4Page project4Page;
    //Project05Page project05Page;

    @Before
    public void setDriver(){
        driver = Driver.getDriver();
        project4Page = new Project4Page();
    }

    @Then("the user should see the {string} heading")
    public void theUserShouldSeeTheHeading(String headingText) {
        switch (headingText){
            case "Inventory":
                Assert.assertTrue(headingText, project4Page.mainHeading.isDisplayed());
                Assert.assertEquals(headingText, project4Page.mainHeading.getText());
                break;
//            case "Pagination":
//                Assert.assertTrue(project05Page.mainHeading.isDisplayed());
//                Assert.assertEquals(headingText, project05Page.mainHeading.getText());
//                break;
//            case "World City Populations 2022":
//                Assert.assertTrue(project05Page.subHeading.isDisplayed());
//                Assert.assertEquals(headingText, project05Page.subHeading.getText());
//                break;
            default:
        }

    }


    @And("the user should see the table with the headers below")
    public void theUserShouldSeeTheTableWithTheHeadersBelow(DataTable dataTable) {
        List<String> headerText = dataTable.asList();

        for (int i = 0; i < headerText.size(); i++) {
            Assert.assertEquals(headerText.get(i), project4Page.modalHeading.get(i).getText());
        }
    }


    @And("the user should see the table with the rows below")
    public void theUserShouldSeeTheTableWithTheRowsBelow(DataTable dataTable) {
        List<List<String>> expectedTable = dataTable.asLists();
        List<List<WebElement>> actualTable = TableHandler.getTableData(project4Page.table);

        for (int i = 0; i < expectedTable.size(); i++) {
            for (int j = 0; j < expectedTable.get(i).size(); j++) {
                Assert.assertEquals(expectedTable.get(i).get(j), actualTable.get(i).get(j).getText());
            }
        }
    }

    @Then("the user should see the {string} button is enabled")
    public void the_user_should_see_the_button_is_enabled(String button) {
        switch (button){
            case "ADD PRODUCT":
                Assert.assertTrue(project4Page.addProductButton.isEnabled());
                break;
            case "X":
                Assert.assertTrue(project4Page.closeButton.isEnabled());
                break;
            case "SUBMIT":
                Assert.assertTrue(project4Page.submitButton.isEnabled());
                break;
            default:
        }
    }

    @Then("the user should see the {string} text displayed")
    public void the_user_should_see_the_text_displayed(String total) {
        Assert.assertEquals(total, project4Page.totalAmount.getText());
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        switch (button){
            case "ADD PRODUCT":
                project4Page.addProductButton.click();
                break;
            case "X":
                project4Page.closeButton.click();
                break;
            case "SUBMIT":
                project4Page.submitButton.click();
                break;
            default:
        }
    }

    @Then("the user should see the {string} modal with its heading")
    public void theUserShouldSeeTheModalWithItsHeading(String headingText) {
        Assert.assertEquals(headingText, project4Page.modalCardTitle.getText());
    }

    @And("the user should see the {string} label")
    public void theUserShouldSeeTheLabel(String label) {
        switch (label){
            case "Please select the quantity":
                Assert.assertTrue(project4Page.inputLabels.get(0).isDisplayed());
                break;
            case "Please enter the name of the product":
                Assert.assertTrue(project4Page.inputLabels.get(1).isDisplayed());
                break;
            case "Please enter the price of the product":
                Assert.assertTrue(project4Page.inputLabels.get(2).isDisplayed());
                break;
            default:
        }
    }

    @And("the user should see the {string} input box is enabled")
    public void theUserShouldSeeTheInputBoxIsEnabled(String inputBox) {
        switch (inputBox) {
            case "Quantity":
                Assert.assertTrue(project4Page.inputBox.get(0).isEnabled());
                break;
            case "Product":
                Assert.assertTrue(project4Page.inputBox.get(1).isEnabled());
                break;
            case "Price":
                Assert.assertTrue(project4Page.inputBox.get(2).isEnabled());
                break;
            default:
        }
    }

    @Then("the user should not see the Add New Product modal")
    public void theUserShouldNotSeeTheModal() {
        try {
            Assert.assertFalse(project4Page.modalCardTitle.isDisplayed());
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @And("the user enters the {string} as {string}")
    public void theUserEntersTheAs(String details, String input) {
        switch (details){
            case "Quantity":
                project4Page.inputBox.get(0).sendKeys(input);
                break;
            case "Product":
                project4Page.inputBox.get(1).sendKeys(input);
                break;
            case"Price":
                project4Page.inputBox.get(2).sendKeys(input);
                break;
            default:
        }
    }

    @Then("the user should see the table with the new row below")
    public void theUserShouldSeeTheTableWithTheNewRowBelow(DataTable dataTable) {
        List<String> expectedRow = dataTable.asList();

        for (int i = 0; i < expectedRow.size(); i++) {
            Assert.assertEquals(expectedRow.get(i), TableHandler.getTableRow(4).get(i).getText());
        }
    }

}