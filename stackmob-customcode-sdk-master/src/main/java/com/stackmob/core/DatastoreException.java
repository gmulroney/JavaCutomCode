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

package com.stackmob.core;

/**
 * Thrown when an error has occurred with the datastore.
 */
public class DatastoreException extends Exception {

  private static final long serialVersionUID = -9157024418055866143L;

  /**
   * Constructs a new datastore exception with the specified detail message.
   *
   * @param message the message
   */
  public DatastoreException(String message) {
    super(message);
  }

  /**
   * Constructs a new datastore exception with the specified detail message and cause.
   *
   * @param message the message
   * @param cause the cause
   */
  public DatastoreException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new datastore exception with the specified cause.
   *
   * @param cause the cause
   */
  public DatastoreException(Throwable cause) {
    super(cause);
  }

}
