package page_objects;

import core.Core;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LinkedInProfile extends Core {

    public LinkedInProfile(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//section[@aria-labelledby='public_profile_activities-follow-modal-modal-header']/button/icon")
    WebElement btnDismiss;

    @FindBy(how = How.CSS,using = ".profile")
    WebElement sectionProfile;

    /**
     * Clicks on dismiss button from modal windows
     */
    public void clickOnDismissButton(){
        clickElementUsingActions(btnDismiss);
    }

    /**
     * Validates that section is displayed
     * @return true if it is displayed otherwise false
     */
    public boolean isSectionDisplayed(){
        return isElementDisplayed(sectionProfile);
    }
}
