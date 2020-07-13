package org.techmeskills.aqa5.auf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class AddProjectPage extends BasePageFactory {
    @FindBy(id = "accept")
    public WebElement addProjectButton;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "suite_mode_single")
    public WebElement suiteModeSingle;
    @FindBy(id = "suite_mode_single_baseline")
    public WebElement suiteModeSingleBaseline;
    @FindBy(id = "suite_mode_multi")
    public WebElement suiteModeMulti;
    @FindBy(id = "accept")
    public WebElement identifyPage;

    public AddProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return identifyPage.isDisplayed();
    }

}
