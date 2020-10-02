package com.test.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class LoginStepDefinition {

	@Given("^When user landing the login page$")
	public void launchLoginPage() throws Throwable {
		System.out.println("User in Login page");
	}

	@When("^Enter valid user name \"([^\"]*)\" and password \"([^\"]*)\" and click login button$")
	public void login(String username, String password) throws Throwable {
		System.out.println("User enter valid user name :"+username+" and password :"+password+"and click login button");
	}

	@Then("^User sucessfully login and Home page should be displayed$")
	public void verifyHomePageIsDisplyed() throws Throwable {
		System.out.println("Home page is dispalyed");
	}

	@And("^User profile icon displyed$")
	public void verifyUserIconIsDisplayed() throws Throwable {
		System.out.println("User icon displyed");
	}

	@And("^Displayed \"([^\"]*)\" modules$")
	public void verifyUserModules(String module) throws Throwable {
		if(module.equalsIgnoreCase("ALL")) {
			System.out.println("Admin login worked");
		}else {
			System.out.println("Non admin login worked");
		}
	}

}
