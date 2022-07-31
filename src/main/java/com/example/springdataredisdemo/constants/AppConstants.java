package com.example.springdataredisdemo.constants;

/**
 * <p>
 * Name: AppConstants<br>
 * Description: Which is used to handle the application constants
 * </p>
 */

public final class AppConstants {

  // SF History Table Update End Point
  public static final String EMPLOYEE = "employee";
  public static final String EMPLOYEE_BY_ID = "/{id}";

  // Controller layer related Constants
  public static final String EMPLOYEE_RETRIEVAL_SUCCESS_MESSAGE = "Employee(s) Retrieval Success";
  public static final String EMPLOYEE_RETRIEVAL_FAILED_MESSAGE = "Employee(s) Retrieval Failed";
  public static final String EMPLOYEE_UPDATION_SUCCESS_MESSAGE = "Employee Updation Success";
  public static final String EMPLOYEE_UPDATION_FAILED_MESSAGE = "Employee Updation Failed";

  public static final String EMPLOYEE_CREATION_SUCCESS_MESSAGE = "Employee Creation Success";
  public static final String EMPLOYEE_CREATION_FAILED_MESSAGE = "Employee Creation Failed";

  public static final String EMPLOYEE_DELETION_SUCCESS_MESSAGE = "Employee Deletion Success";
  public static final String EMPLOYEE_DELETION_FAILED_MESSAGE = "Employee Deletion Failed";
  public static final String NO_EMPLOYEE_FOUND_MESSAGE = "No employee(s) found";

  private AppConstants() {
    // Default constructor
  }
}
