/*
 * Copyright © 2012 - 2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.integrationtest.functional.spin.dataformat;

import java.io.IOException;
import org.camunda.bpm.integrationtest.functional.spin.XmlSerializable;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author Svetlana Dorokhova.
 */
public class XmlSerializableJsonDeserializer extends JsonDeserializer<XmlSerializable> {

  @Override
  public XmlSerializable deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    XmlSerializable xmlSerializable = new XmlSerializable();
    xmlSerializable.setProperty(p.getValueAsString());
    return xmlSerializable;
  }

}
