package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_objects.GoogleSearch;
import page_objects.GoogleSearchResult;
import page_objects.LinkedInProfile;

public class GoogleSearchSD {

    GoogleSearch googleSearch = new GoogleSearch(true);
    GoogleSearchResult googleSearchResult = new GoogleSearchResult();
    LinkedInProfile linkedInProfile = new LinkedInProfile();

    @Given("The user is on the google page")
    public void userIsOnGooglePage(){
        Assert.assertTrue("Google search page was not displayed.",googleSearch.isGoogleSearchPageDisplayed());
    }

    @When("perform the google search")
    public void performTheGoogleSearch() {
        Assert.assertTrue("There was an error when the information was enter in the search text field.",googleSearch.enterSearchText("gary pacheco linkedin"));
        Assert.assertTrue("There was an error when clicking on search button.",googleSearch.clickOnSearchButton());
        Assert.assertTrue("There was an error clicking the first link from search result.",googleSearchResult.clickOnSearchResultLink());
        linkedInProfile.clickOnDismissButton();

    }

    @Then("The user should see the expected homepage")
    public void userShouldSeeTheExpectedHomepage() {
       Assert.assertTrue("The linkedIn page was not displayed.",linkedInProfile.isSectionDisplayed());
    }
}
