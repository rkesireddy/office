Feature: Vechicle Comparssion

  Scenario:
    Given I extract reg numbers from input file "car_input.txt"
    And I extract data from output file "car_output.txt"
    When I search for reg number and extract "Vehicle Identity" information
    Then I compare data against outputFile
