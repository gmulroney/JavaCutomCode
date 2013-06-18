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

package com.stackmob.sdkapi;

public class SMIncrement extends SMUpdate {

  private final String field;
  private final SMInt value;

  /**
   * Creates a new increment operation
   * @param field the field on which to operate
   * @param value the value to increment by
   */
  public SMIncrement(String field, SMInt value) {
    this.field = field;
    this.value = value;
  }

  /**
   * Creates a new increment operation
   * @param field the field on which to operate
   * @param value the value to increment by
   */
  public SMIncrement(String field, long value) {
    this(field, new SMInt(value));
  }

  /**
   * Gets the field on which to execute this action.
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * Gets the value to increment by
   * @return the value
   */
  public SMInt getValue() {
    return value;
  }

}
