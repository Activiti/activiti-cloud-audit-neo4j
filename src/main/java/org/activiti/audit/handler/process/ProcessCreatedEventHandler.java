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
package org.activiti.audit.handler.process;


import org.activiti.api.process.model.events.ProcessRuntimeEvent;
import org.activiti.audit.entity.CloudProcessCreatedEventEntity;
import org.activiti.audit.handler.QueryEventHandler;
import org.activiti.audit.repository.CloudProcessCreatedEventRepository;
import org.activiti.cloud.api.model.shared.events.CloudRuntimeEvent;
import org.activiti.cloud.api.process.model.impl.events.CloudProcessCreatedEventImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProcessCreatedEventHandler implements QueryEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCreatedEventHandler.class);

    @Autowired
    private CloudProcessCreatedEventRepository cloudProcessCreatedEventRepository;

    @Override
    public void handle(CloudRuntimeEvent<?, ?> event) {
        CloudProcessCreatedEventImpl createdProcessEvent = (CloudProcessCreatedEventImpl) event;
        LOGGER.debug("Handling created process" + createdProcessEvent.getEntity().getId());
        CloudProcessCreatedEventEntity cloudProcessCreatedEventEntity = new CloudProcessCreatedEventEntity(createdProcessEvent);
        cloudProcessCreatedEventRepository.save(cloudProcessCreatedEventEntity);
    }

    @Override
    public String getHandledEvent() {
        return ProcessRuntimeEvent.ProcessEvents.PROCESS_CREATED.name();
    }
}
