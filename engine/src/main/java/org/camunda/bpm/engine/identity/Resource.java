/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.identity;

/**
 * <p>Resources are entities for which a user or a group is authorized. Examples of 
 * resources are applications, process-definitions, process-instances, tasks ...</p> 
 * 
 * <p>A resource has a type and an id. The type ({@link #setResourceType(String)}) 
 * allows to group all resources of the same kind. A resource id is the identifier of 
 * an indivuidual resource instance ({@link #setResourceId(String)}). For example:
 * the resource type could be "processDefinition" and the resource-id could be the 
 * id of an individual process definition.</p>  
 * 
 * <p>See {@link Resources} for a set of built-in resource constants.</p>
 * 
 * @author Daniel Meyer
 * @see Resources
 *
 */
public interface Resource {
  
  /** returns the name of the resource */
  String getName();
  
  /** returns the id of the resource */
  String getId();

}
