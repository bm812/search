package com.test.search.tests;

import com.test.search.pages.Results;
import com.test.search.pages.Search;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class SearchTests extends BasicTest {

    @Test(priority = 0)
    public void Test1_search(){
        String textForSearch = "something";

        new Search(driver).searchBy(textForSearch);
        String result = new Results(driver).getNameOfResult(0);
        assertTrue("First result contains search value",
                Pattern.compile(Pattern.quote(textForSearch), Pattern.CASE_INSENSITIVE).matcher(result).find());
    }

    @Test(priority = 1)
    public void Test2_tooltip(){
        String toolTipExpected = "Поиск";

        String toolTipActual = new Search(driver).getSearchFieldToolTip();
        assertTrue("First result contains search value",
                Pattern.compile(Pattern.quote(toolTipExpected), Pattern.CASE_INSENSITIVE).matcher(toolTipActual).find());
    }

    @Test(priority = 2)
    public void Test3_logo(){
        Results results = new Results(driver);
        results.clickLogo();
        assertEquals("Empty results after click on Logo", 0, results.getNumberOfResults(1));
    }
}
