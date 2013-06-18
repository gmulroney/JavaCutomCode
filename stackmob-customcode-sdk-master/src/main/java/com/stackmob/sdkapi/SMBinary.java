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

import java.util.Arrays;

/**
 * A Binary value
 */
public class SMBinary extends SMValue<byte[]> {

  private final String fileName;
  private final String contentType;

  /**
   * Create a new SMBinary
   * @param value the byte array containing binary payload
   * @param filename name associated with binary payload
   * @param contentType content type of  binary payload
   */
  public SMBinary(String filename, String contentType, byte[] value) {
    super(value);
    this.fileName = filename;
    this.contentType = contentType;
  }

  public String getFilename() {
    return fileName;
  }

  public String getContentType() {
    return contentType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    SMBinary smBinary = (SMBinary) o;

    if (contentType != null ? !contentType.equals(smBinary.contentType) : smBinary.contentType != null) return false;
    if (fileName != null ? !fileName.equals(smBinary.fileName) : smBinary.fileName != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
    result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
    return result;
  }
}
