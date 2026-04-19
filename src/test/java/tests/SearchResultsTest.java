package tests;


import org.testng.annotations.Test;
import pages.SearchResultsPage;

import static base.BaseTest.getDriver;

public class SearchResultsTest {


    @Test()
    public void searchResultsTest() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.clickSearchButton();
    }
}
