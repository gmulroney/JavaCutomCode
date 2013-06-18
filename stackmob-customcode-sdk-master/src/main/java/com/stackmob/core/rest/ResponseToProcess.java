/**
 * Copyright 2011-2013 StackMob
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stackmob.core.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the response to an API request. When returned, the response map will be processed into a JSON string and
 * returned as a proper API response by StackMob.
 */
public class ResponseToProcess {

  private final int responseStatus;

  private final Map<String, ?> responseMap;
  private final String responseString;
  private final byte[] responseByteArray;

  public enum FieldType {MAP, STRING, BYTE_ARRAY}
  private final FieldType responseField;

  private final Map<String, String> responseHeaders;

  /**
   * Creates a new API response to process.
   *
   * @param responseCode the HTTP response code
   * @param responseMap the response map
   * @param responseHeaders the response headers
   */
  public ResponseToProcess(int responseCode, Map<String, ?> responseMap, Map<String, String> responseHeaders) {
    this.responseStatus = responseCode;
    this.responseMap = responseMap;
    this.responseHeaders = responseHeaders;

    this.responseField = FieldType.MAP;
    this.responseString = "";
    this.responseByteArray = new byte[0];
  }

  /**
   * Creates a new API response to process.
   *
   * @param responseCode the HTTP response code
   * @param responseString the response String
   * @param responseHeaders the response headers
   */
  public ResponseToProcess(int responseCode, String responseString, Map<String, String> responseHeaders) {
    this.responseStatus = responseCode;
    this.responseString = responseString;
    this.responseHeaders = responseHeaders;

    this.responseField = FieldType.STRING;
    this.responseMap = new HashMap<String, Object>();
    this.responseByteArray = new byte[0];
  }

  /**
   * Creates a new API response to process.
   *
   * @param responseCode the HTTP response code
   * @param responseByteArray the response byte array
   * @param responseHeaders the response headers
   */
  public ResponseToProcess(int responseCode, byte[] responseByteArray, Map<String, String> responseHeaders) {
    this.responseStatus = responseCode;
    this.responseByteArray = responseByteArray;
    this.responseHeaders = responseHeaders;

    this.responseField = FieldType.BYTE_ARRAY;
    this.responseMap = new HashMap<String, Object>();
    this.responseString = "";
  }

  /**
   * Creates a new API response to process.
   *
   * @param responseCode the HTTP response code
   * @param responseMap the response map
   */
  public ResponseToProcess(int responseCode, Map<String, ?> responseMap) {
    this(responseCode, responseMap, new HashMap<String, String>());
  }

  /**
   * Creates a new API response to process.
   *
   * @param responseCode the HTTP response code
   * @param responseString the response string
   */
  public ResponseToProcess(int responseCode, String responseString) {
    this(responseCode, responseString, new HashMap<String, String>());
  }

  /**
   * Creates a new API response to process.
   *
   * @param responseCode the HTTP response code
   * @param responseByteArray the response map
   */
  public ResponseToProcess(int responseCode, byte[] responseByteArray) {
    this(responseCode, responseByteArray, new HashMap<String, String>());
  }

  /**
   * Creates a new API response to process.
   * 
   * @param responseCode the HTTP response code
   */
  public ResponseToProcess(int responseCode) {
    this(responseCode, new HashMap<String, Object>());
  }

  /**
   * Returns the HTTP response code.
   *
   * @return the response code
   */
  public int getResponseCode() {
    return responseStatus;
  }

  /**
   * Returns the response map.
   *
   * @return the response map
   */
  public Map<String, ?> getResponseMap() {
    return responseMap;
  }

  /**
   * Returns the response String.
   *
   * @return the response String
   */
  public String getResponseString() {
    return responseString;
  }

  /**
   * Returns the response byte array.
   *
   * @return the response byte array
   */
  public byte[] getResponseByteArray() {
    return responseByteArray;
  }

  /**
   * Returns the response byte array.
   *
   * @return the response byte array
   */
  public FieldType getResponseField() {
    return responseField;
  }

  /**
   * Returns the response headers.
   *
   * @return the response headers
   */
  public Map<String, String> getResponseHeaders() {
    return responseHeaders;
  }

}
