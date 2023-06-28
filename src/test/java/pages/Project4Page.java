package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project4Page {
    public Project4Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".mb-5")
    public WebElement mainHeading;

    @FindBy(css = "tr>th")
    public List<WebElement> modalHeading;

    @FindBy(id = "total_amount")
    public WebElement totalAmount;

    @FindBy(id = "add_product_btn")
    public WebElement addProductButton;

    @FindBy(id = "modal_title")
    public WebElement modalCardTitle;

    @FindBy(css = ".input")
    public List<WebElement> inputBox;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(css = ".delete")
    public WebElement closeButton;

    @FindBy(css = ".modal label")
    public List<WebElement> inputLabels;

    @FindBy(id = "main_heading")
    public WebElement pageHeading;

    @FindBy(css = "table")
    public WebElement table;
}