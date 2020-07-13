package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;
import org.techmeskills.aqa5.auf.steps.ProjectStep;

public class LoginPage extends BasePageFactory {
    private String URL = "https://aqa5master.testrail.io/";

    @FindBy(id = "name")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "button_primary")
    public WebElement loginButton;
    @FindBy(id = "button_primary")
    public WebElement identifyPage;


    public LoginPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
       return identifyPage.isDisplayed();
    }

    public ProjectStep loginButtonClick(){
        loginButton.click();
        return new ProjectStep(browsersService);
    }
}
