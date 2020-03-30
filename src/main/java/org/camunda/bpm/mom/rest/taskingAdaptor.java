package org.camunda.bpm.mom.rest;

import org.camunda.bpm.mom.ProcessConstants;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class taskingAdaptor {
  
  @Autowired
  private ProcessEngine camunda;

  @RequestMapping(method=RequestMethod.POST)
  public void placeTaskPOST(String description, int priority, String poc) {
    placeTask(description, priority, poc);
  }

  /**
   * we need a method returning the {@link ProcessInstance} to allow for easier tests,
   * that's why I separated the REST method (without return) from the actual implementaion (with return value)
   */
  public ProcessInstance placeTask(String description, int priority, String poc) {
    return camunda.getRuntimeService().startProcessInstanceByKey(//
        ProcessConstants.PROCESS_KEY_task, //
        Variables //
          .putValue(ProcessConstants.VAR_NAME_DESCRIPTION, description) //
          .putValue(ProcessConstants.VAR_NAME_priority, priority
          
          )
    );
  }
}