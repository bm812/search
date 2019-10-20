package com.test.search.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends PageObject {

    @FindBy(xpath = "//input[@name='q']")
    public WebElement inputField;

    @FindBy(xpath = "(//input[@name='btnK'])[last()]")
    public WebElement findBtn;

    public Search(WebDriver driver) {
        super(driver);
    }

    public String getSearchFieldToolTip()
    {
        return inputField.getAttribute("title");
    }

    public void searchBy(String text)
    {
        inputField.sendKeys(text, Keys.ENTER);
    }
}
