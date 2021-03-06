/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.audit.handler.task;


import org.activiti.api.task.model.events.TaskRuntimeEvent;
import org.activiti.audit.entity.CloudProcessCreatedEventEntity;
import org.activiti.audit.entity.CloudTaskCompletedEventEntity;
import org.activiti.audit.handler.QueryEventHandler;
import org.activiti.audit.repository.CloudProcessCreatedEventRepository;
import org.activiti.audit.repository.CloudTaskCompletedEventRepository;
import org.activiti.cloud.api.model.shared.events.CloudRuntimeEvent;
import org.activiti.cloud.api.task.model.impl.events.CloudTaskCompletedEventImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskCompletedEventHandler implements QueryEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskCompletedEventHandler.class);

    @Autowired
    private CloudTaskCompletedEventRepository cloudTaskCompletedEventRepository;

    @Autowired
    private CloudProcessCreatedEventRepository cloudProcessCreatedEventRepository;

    public TaskCompletedEventHandler() {

    }

    @Override
    public void handle(CloudRuntimeEvent<?, ?> event) {
        CloudTaskCompletedEventImpl taskCompletedEvent = (CloudTaskCompletedEventImpl) event;
        LOGGER.debug("Handling completed task" + taskCompletedEvent.getEntity().getId());

        CloudProcessCreatedEventEntity cloudProcessCreatedEvent = cloudProcessCreatedEventRepository.findByEntityId(taskCompletedEvent.getEntity().getProcessInstanceId());

        CloudTaskCompletedEventEntity cloudTaskCompletedEventEntity = new CloudTaskCompletedEventEntity(taskCompletedEvent);
        cloudTaskCompletedEventEntity.setCloudProcessCreatedEventEntity(cloudProcessCreatedEvent);

        cloudTaskCompletedEventRepository.save(cloudTaskCompletedEventEntity);
    }

    @Override
    public String getHandledEvent() {
        return TaskRuntimeEvent.TaskEvents.TASK_COMPLETED.name();
    }
}
