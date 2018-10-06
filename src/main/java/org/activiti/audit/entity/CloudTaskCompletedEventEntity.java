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

package org.activiti.audit.entity;

import org.activiti.api.task.model.Task;
import org.activiti.cloud.api.task.model.events.CloudTaskCompletedEvent;
import org.activiti.cloud.api.task.model.impl.events.CloudTaskCompletedEventImpl;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class CloudTaskCompletedEventEntity implements CloudTaskCompletedEvent {

    @Id
    private String id;

    private String appName;

    private String appVersion;

    private String serviceName;

    private String serviceFullName;

    private String serviceType;

    private String serviceVersion;

    private String entityId;

    private Task entity;

    private Long timestamp;

    private TaskEvents eventType;

    @Relationship(type = "BELONGS", direction = Relationship.OUTGOING)
    public CloudProcessCreatedEventEntity cloudProcessCreatedEventEntity;

    public CloudTaskCompletedEventEntity() {
    }

    public CloudTaskCompletedEventEntity(CloudTaskCompletedEventImpl cloudTaskCompletedEvent) {
        appName = cloudTaskCompletedEvent.getAppName();
        appVersion = cloudTaskCompletedEvent.getAppVersion();
        serviceName = cloudTaskCompletedEvent.getServiceName();
        serviceFullName = cloudTaskCompletedEvent.getServiceFullName();
        serviceType = cloudTaskCompletedEvent.getServiceType();
        serviceVersion = cloudTaskCompletedEvent.getServiceVersion();
        entityId = cloudTaskCompletedEvent.getEntityId();
        id = cloudTaskCompletedEvent.getEntityId();
        entity = cloudTaskCompletedEvent.getEntity();
        timestamp = cloudTaskCompletedEvent.getTimestamp();
        eventType = cloudTaskCompletedEvent.getEventType();
    }

    @Override
    public String getAppName() {
        return appName;
    }

    @Override
    public String getAppVersion() {
        return appVersion;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String getServiceFullName() {
        return serviceFullName;
    }

    @Override
    public String getServiceType() {
        return serviceType;
    }

    @Override
    public String getServiceVersion() {
        return serviceVersion;
    }

    @Override
    public String getEntityId() {
        return entityId;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Task getEntity() {
        return entity;
    }

    @Override
    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public TaskEvents getEventType() {
        return eventType;
    }

    public CloudProcessCreatedEventEntity getCloudProcessCreatedEventEntity() {
        return cloudProcessCreatedEventEntity;
    }

    public void setCloudProcessCreatedEventEntity(CloudProcessCreatedEventEntity cloudProcessCreatedEventEntity) {
        this.cloudProcessCreatedEventEntity = cloudProcessCreatedEventEntity;
    }
}
