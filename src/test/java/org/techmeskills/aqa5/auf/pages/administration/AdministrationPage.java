package org.techmeskills.aqa5.auf.pages.administration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.techmeskills.aqa5.auf.baseEntity.BasePage;
import org.techmeskills.aqa5.auf.baseEntity.BasePageFactory;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.elements.UIElement;

public class AdministrationPage extends BasePageFactory {
    @FindBy(xpath = "//div[@class = 'info-box-title']/a[. = 'Projects']")
    public WebElement projectLink;
    @FindBy(xpath = "//h1[. = 'Administration']")
    public WebElement identifyPage;

    public AdministrationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/overview");
    }

    public boolean isPageOpened() {
        return identifyPage.isDisplayed();
    }

}
