package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class Project4Pages {
    public Project4Pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".is-size-2")
    public WebElement header;

    @FindBy(css =".header")
    public List<WebElement> tableHeaders;

    @FindBy(css = "tbody tr td")
    public List<WebElement> tableRows;

    @FindBy(id = "add_product_btn")
    public WebElement addProductBtn;

    @FindBy(id = "total_amount")
    public WebElement total;

    //2ND TEST CASE

    @FindBy(id = "modal_title")
    public WebElement addProductHeading;

    @FindBy(css = ".delete")
    public WebElement deleteButton;

    @FindBy(id ="submit")
    public  WebElement submitBTN;

    @FindBy(css = "label[for='product_quantity']")
    public WebElement product_quantity;

    @FindBy(css = "label[for='product_name']")
    public WebElement product_name;

    @FindBy(css = "label[for='product_price']")
    public WebElement product_price;

    @FindBy(id = "quantity")
    public WebElement quantityInput;

    @FindBy(id = "product")
    public WebElement productInput;

    @FindBy(id = "price")
    public WebElement priceInput;

    @FindBy(css = "modal-card-body")
    public WebElement modalPageExists;

    @FindBy(css = "tr:nth-child(4) td")
    public List<WebElement> newRow;
}