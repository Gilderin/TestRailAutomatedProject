package org.techmeskills.aqa5.auf.tests;


import org.openqa.selenium.*;
import org.techmeskills.aqa5.auf.baseEntity.BaseTest;
import org.techmeskills.aqa5.auf.models.Projects;
import org.techmeskills.aqa5.auf.models.Users;
import org.techmeskills.aqa5.auf.pages.administration.ProjectsPage;
import org.techmeskills.aqa5.auf.steps.AdministrationStep;
import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.techmeskills.aqa5.auf.steps.ProjectStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest1 extends BaseTest {
    @Test
    public void login() {
        Users users=new Users("atrostyanko+master@gmail.com", "QqtRK9elseEfAk6ilYcJ");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginV(users);
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        Projects projects=new Projects("PR01", "Use a single repository for all cases (recommended)");
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProjectV(projects);
        Assert.assertTrue(browsersService.getDriver().getTitle().equalsIgnoreCase("PR01 - TestRail")
                || browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail"));
    }

    @Test(dependsOnMethods = "createProject")
    public void deleteProject() {
        AdministrationStep administrationStep = new AdministrationStep(browsersService);
        ProjectsPage projectsPage = administrationStep.deleteProject("PR01");
        Assert.assertThrows(TimeoutException.class, () -> projectsPage.getProjectItemLink("PR01"));
    }
}
