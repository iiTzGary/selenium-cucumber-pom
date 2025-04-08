package page_objects;

import core.Core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch extends Core {

    public GoogleSearch (boolean  navigate){
        if (navigate)
            driver.get("https://www.google.co/");
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "APjFqb")
    WebElement txtSearch;

    @FindBy(how = How.NAME, using = "btnK")
    WebElement btnSearch;

    @FindBy(how = How.TAG_NAME,using = "body")
    WebElement body;



    /**
     * Enters the information to be googled
     * @param text to be entered in the search text field
     * @return true if it is entered successfully otherwise false
     */
    public boolean enterSearchText(final String text){
        try {
            enterText(txtSearch,text);
            clickElement(body);
            return true;
        } catch (Exception e) {
            System.out.println("There was an error when filling in the search text field." + e.getMessage());
            return false;
        }
    }

    /**
     * Clicks on Google search button
     * @return true if it was successfully clicked otherwise false
     */
    public boolean clickOnSearchButton(){
        try {
            clickElementUsingJs(btnSearch);
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred when interacting with search button." + e.getMessage());
            return  false;
        }
    }

    /**
     * Validates that the user had landed in the Google search page by checking the search field
     * @return true if google search page is present otherwise false
     */
    public boolean isGoogleSearchPageDisplayed(){
       return isElementDisplayed(txtSearch);
    }
}
