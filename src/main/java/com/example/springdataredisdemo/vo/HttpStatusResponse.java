package com.example.springdataredisdemo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Response class for public http requests
 * 
 * @since v2.10
 */
public class HttpStatusResponse {

  private static HttpStatusResponse httpResponse;
  @JsonInclude(Include.NON_NULL)
  private Integer totalRecords;
  private Integer statusCode;
  private String description;
  private Object data;

  private transient Object error;
  @JsonInclude(Include.NON_NULL)
  private String customCode;

  /**
   * Default constructor
   */
  private HttpStatusResponse() {
    super();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer i) {
    this.statusCode = i;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Integer getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }

  public Object getError() {
    return error;
  }

  public void setError(Object error) {
    this.error = error;
  }

  public String getCustomCode() {
    return customCode;
  }

  public void setCustomCode(String customCode) {
    this.customCode = customCode;
  }

  /**
   * Get instance of HttpStatus Response
   * 
   * @return HttpStatusResponse
   */
  public static HttpStatusResponse getInstance() {
    if (httpResponse == null) {
      httpResponse = new HttpStatusResponse();
    }
    return httpResponse;
  }

  /**
   * Method returns the response object with code,data and description.
   * 
   * @param total Records - Total Records of the response
   * @param code - Status code
   * @param description - Response description
   * @param data - Actual data
   * @return httpResponse
   */
  public static HttpStatusResponse setHttpResponse(Integer totalRecords, Integer code,
      String description, Object data) {
    httpResponse = new HttpStatusResponse();
    httpResponse.setTotalRecords(totalRecords);
    httpResponse.setStatusCode(code);
    httpResponse.setDescription(description);
    httpResponse.setData(data);
    return httpResponse;
  }

  /**
   * Method returns the response object with code,data and description.
   * 
   * @param code - Status code
   * @param description - Response description
   * @param data - Actual data
   * @return httpResponse
   */
  public static HttpStatusResponse setHttpResponse(Integer code, String description, Object data) {
    httpResponse = new HttpStatusResponse();
    httpResponse.setTotalRecords(null);
    httpResponse.setStatusCode(code);
    httpResponse.setDescription(description);
    httpResponse.setData(data);
    return httpResponse;
  }

  /**
   * Method returns the response object with code,data and description.
   * 
   * @param code - Status code
   * @param description - Response description
   * @param data - Actual data
   * @param cutomCode
   * @return httpResponse
   */
  public static HttpStatusResponse setHttpResponse(Integer code, String description, Object data,
      String cutomCode) {
    httpResponse = new HttpStatusResponse();
    httpResponse.setTotalRecords(null);
    httpResponse.setStatusCode(code);
    httpResponse.setDescription(description);
    httpResponse.setData(data);
    httpResponse.setCustomCode(cutomCode);
    return httpResponse;
  }

  /**
   * Method returns the response object with code,error and description.
   *
   * @param code - Status code
   * @param description - Response description
   * @param error - Actual error
   * @return httpResponse
   */
  public static HttpStatusResponse setHttpErrorResponse(Integer code, String description,
                                                        Object error) {
    httpResponse = new HttpStatusResponse();
    httpResponse.setTotalRecords(null);
    httpResponse.setStatusCode(code);
    httpResponse.setDescription(description);
    httpResponse.setError(error);
    return httpResponse;
  }
}
