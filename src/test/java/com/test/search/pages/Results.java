package com.test.search.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Results extends PageObject {

    @FindBy(xpath = "//div[@id='search']//h3[@class='LC20lb']")
    public List<WebElement> searchedResults;

    @FindBy(xpath = "//div[@class='logo']")
    public WebElement logo;

    public Results(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfResults(int sec)
    {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
        return searchedResults.size();
    }

    public String getNameOfResult(int index)
    {
        return searchedResults.get(index).getText();
    }

    public void clickLogo()
    {
        logo.click();
    }
}
