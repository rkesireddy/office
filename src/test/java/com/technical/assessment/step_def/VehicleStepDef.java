package com.technical.assessment.step_def;

import com.technical.assessment.page_objects.HomePage;
import com.technical.assessment.util.IOutils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class VehicleStepDef {
    private IOutils iOutils;
    private HomePage homePage;
    private List<String> expected;
    private List<String> actual;

    public VehicleStepDef(IOutils iOutils, HomePage homePage) {
        this.iOutils = iOutils;
        this.homePage = homePage;
    }

    @Given("^I extract reg numbers from input file \"([^\"]*)\"$")
    public void i_extract_reg_numbers_from_input_file(String inputFile) throws IOException, URISyntaxException {
        File filePath = iOutils.loadFileFromResources(inputFile);
        List<String> regNumbers = iOutils.findRegNumber(filePath);
        homePage.setInput(regNumbers);

    }

    @Given("^I extract data from output file \"([^\"]*)\"$")
    public void iExtractDataFromOutputFile(String inputFile) throws IOException, URISyntaxException {
        File filePath = iOutils.loadFileFromResources(inputFile);
        expected = iOutils.readOutputData(filePath);
    }

    @When("^I search for reg number and extract \"([^\"]*)\" information$")
    public void iSearchForRegNumberAndExtractInformation(String vehicleInformation) {
        actual = homePage.vehicleSearch(homePage.getInput());

    }

    @Then("^I compare data against outputFile$")
    public void iCompareDataAgainstOutputFile() {
        expected.forEach(s -> {
            assertThat(actual, hasItem(s));
        });
    }
}
