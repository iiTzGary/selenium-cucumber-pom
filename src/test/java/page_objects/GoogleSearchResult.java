package page_objects;

import core.Core;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResult extends Core {

    public GoogleSearchResult(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[./h3[contains(text(),'Gary Pacheco - Senior QA Automation Engineer - Resolvit')]]")
    WebElement lnkMatchingSearchCriteria;

    /**
     *Clicks on the link that matches the search criteria
     */
    public boolean clickOnSearchResultLink(){
        try {
            waitForElementToBeClickable(lnkMatchingSearchCriteria);
            clickElement(lnkMatchingSearchCriteria);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
