Feature: Testing aoe webpage
@wip
  Scenario: Recruiter testing
    Given Visit website at www.aoe.com
    When Hover on the Career section
    Then Click the Vacancies
    And Filter the offerings by entering ‘frontend’ as keyword
    Then Check the returned list for the keyword
    And Open the first entry which is displayed
    Then Check that the content of this job offering is being displayed
