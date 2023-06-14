package com.selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GoogleSearchPage;
import pages.GuardianHomePage;
import utils.LoggerUtil;

public class NewsValidationTest extends BaseTest {
    @Test
    public void validateNewsOnTheGuardian() {
        LoggerUtil.info("Starting news validation test");

        GuardianHomePage guardianHomePage = new GuardianHomePage(driver);
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        // Perform the search on Google
        googleSearchPage.enterSearchKeywords("news headline site:theguardian.com");
        googleSearchPage.submitSearch();

        // Get the search results count
        int searchResultsCount = googleSearchPage.getSearchResultsCount();
        LoggerUtil.info("Number of search results: " + searchResultsCount);

        // Get the news headlines from The Guardian homepage
        String[] guardianHeadlines = guardianHomePage.getNewsHeadlines();
        LoggerUtil.info("Number of headlines on The Guardian homepage: " + guardianHeadlines.length);

        // Validate the news headlines
        Assert.assertTrue(searchResultsCount >= 2, "The news is not valid.");
        Assert.assertEquals(searchResultsCount, guardianHeadlines.length, "The number of headlines does not match.");

        LoggerUtil.info("News validation test completed");
    }
}