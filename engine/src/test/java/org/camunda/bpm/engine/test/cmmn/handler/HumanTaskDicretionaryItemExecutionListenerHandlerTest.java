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
package org.camunda.bpm.engine.test.cmmn.handler;

import org.camunda.bpm.engine.impl.cmmn.handler.HumanTaskItemHandler;
import org.camunda.bpm.engine.impl.cmmn.model.CmmnActivity;
import org.camunda.bpm.engine.test.cmmn.handler.specification.AbstractExecutionListenerSpec;
import org.camunda.bpm.model.cmmn.instance.DiscretionaryItem;
import org.camunda.bpm.model.cmmn.instance.HumanTask;
import org.camunda.bpm.model.cmmn.instance.PlanningTable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Thorben Lindhauer
 *
 */
@RunWith(Parameterized.class)
public class HumanTaskDicretionaryItemExecutionListenerHandlerTest extends CmmnElementHandlerTest {

  @Parameters(name = "testListener: {0}")
  public static Iterable<Object[]> data() {
    return ExecutionListenerCases.TASK_OR_STAGE_CASES;
  }

  protected HumanTask humanTask;
  protected PlanningTable planningTable;
  protected DiscretionaryItem discretionaryItem;
  protected HumanTaskItemHandler handler = new HumanTaskItemHandler();

  protected AbstractExecutionListenerSpec testSpecification;

  public HumanTaskDicretionaryItemExecutionListenerHandlerTest(AbstractExecutionListenerSpec testSpecification) {
    this.testSpecification = testSpecification;
  }

  @Before
  public void setUp() {
    humanTask = createElement(casePlanModel, "aHumanTask", HumanTask.class);

    planningTable = createElement(casePlanModel, "aPlanningTable", PlanningTable.class);

    discretionaryItem = createElement(planningTable, "DI_aHumanTask", DiscretionaryItem.class);
    discretionaryItem.setDefinition(humanTask);

  }

  @Test
  public void testCaseExecutionListener() {
    // given:
    testSpecification.addListenerToElement(modelInstance, humanTask);

    // when
    CmmnActivity activity = handler.handleElement(discretionaryItem, context);

    // then
    testSpecification.verify(activity);
  }

}
