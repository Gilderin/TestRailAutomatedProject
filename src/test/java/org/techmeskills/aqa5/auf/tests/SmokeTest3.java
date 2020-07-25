package org.techmeskills.aqa5.auf.tests;

import org.techmeskills.aqa5.auf.baseEntity.BaseTest;
import org.techmeskills.aqa5.auf.models.Users;
import org.techmeskills.aqa5.auf.models.UsersOriginal;
import org.techmeskills.aqa5.auf.pages.administration.ProjectsPage;
import org.techmeskills.aqa5.auf.steps.AdministrationStep;
import org.techmeskills.aqa5.auf.steps.LoginStep;
import org.techmeskills.aqa5.auf.steps.ProjectStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest3 extends BaseTest {
    public Users usersBuilder;

    @Test
    public void login() {
        UsersOriginal usersOriginal= UsersOriginal.builder().email("").build();
        usersOriginal.setEmail("atrostyanko+master@gmail.com");
        usersOriginal.setPassword("QqtRK9elseEfAk6ilYcJ");

        System.out.println(usersOriginal.toString());
        System.out.println(usersOriginal.hashCode());
        System.out.println(usersOriginal.equals(usersOriginal));
        LoginStep loginStep = new LoginStep(browsersService);

        loginStep.login(usersOriginal.getEmail(),usersOriginal.getPassword());
    }

    @Test(dependsOnMethods = "login")
    public void createProject() {
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.createNewProject("PR02", "Use a single repository with baseline support");
        Assert.assertTrue(browsersService.getDriver().getTitle().equalsIgnoreCase("PR02 - TestRail")
                || browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail"));
    }

    @Test(dependsOnMethods = "createProject")
    public void deleteProject() {
        AdministrationStep administrationStep = new AdministrationStep(browsersService);
        ProjectsPage projectsPage = administrationStep.deleteProject("PR02");
        Assert.assertEquals(projectsPage.messageSuccess.getText(), "Successfully deleted the project.");
    }
}
