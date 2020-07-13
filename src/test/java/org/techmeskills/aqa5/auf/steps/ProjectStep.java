package org.techmeskills.aqa5.auf.steps;

import io.qameta.allure.Step;
import org.techmeskills.aqa5.auf.baseEntity.BaseStep;
import org.techmeskills.aqa5.auf.core.BrowsersService;
import org.techmeskills.aqa5.auf.pages.AddProjectPage;
import org.techmeskills.aqa5.auf.pages.DashboardPage;
import org.techmeskills.aqa5.auf.pages.LoginPage;

public class ProjectStep extends BaseStep {

    public ProjectStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step
    public void createNewProject(String name, String type) {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.addProjectButton.click();

        AddProjectPage addProjectPage = new AddProjectPage(browsersService);
        addProjectPage.name.sendKeys(name);

        switch (type) {
            case "Use a single repository for all cases (recommended)":
                addProjectPage.suiteModeSingle.click();
                break;
            case "Use a single repository with baseline support":
                addProjectPage.suiteModeSingleBaseline.click();
                break;
            case "Use multiple test suites to manage cases":
                addProjectPage.suiteModeMulti.click();
                break;
        }

        addProjectPage.addProjectButton.submit();
    }
}
