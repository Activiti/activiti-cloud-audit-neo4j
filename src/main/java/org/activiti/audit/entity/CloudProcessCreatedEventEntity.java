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

import org.activiti.api.process.model.ProcessInstance;
import org.activiti.cloud.api.process.model.events.CloudProcessCreatedEvent;
import org.activiti.cloud.api.process.model.impl.events.CloudProcessCreatedEventImpl;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class CloudProcessCreatedEventEntity implements CloudProcessCreatedEvent {

    @Id
    private String id;

    private String appName;

    private String appVersion;

    private String serviceName;

    private String serviceFullName;

    private String serviceType;

    private String serviceVersion;

    private String entityId;

    private ProcessInstance entity;

    private Long timestamp;

    private ProcessEvents eventType;

    private CloudProcessCreatedEventImpl cloudProcessCreatedEvent;

    public CloudProcessCreatedEventEntity() {
    }

    public CloudProcessCreatedEventEntity(CloudProcessCreatedEventImpl cloudProcessCreatedEvent) {
        this.cloudProcessCreatedEvent = cloudProcessCreatedEvent;
        appName = cloudProcessCreatedEvent.getAppName();
        appVersion = cloudProcessCreatedEvent.getAppVersion();
        serviceName = cloudProcessCreatedEvent.getServiceName();
        serviceFullName = cloudProcessCreatedEvent.getServiceFullName();
        serviceType = cloudProcessCreatedEvent.getServiceType();
        serviceVersion = cloudProcessCreatedEvent.getServiceVersion();
        entityId = cloudProcessCreatedEvent.getEntityId();
        id = cloudProcessCreatedEvent.getId();
        entity = cloudProcessCreatedEvent.getEntity();
        timestamp = cloudProcessCreatedEvent.getTimestamp();
        eventType = cloudProcessCreatedEvent.getEventType();
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
    public ProcessInstance getEntity() {
        return entity;
    }

    @Override
    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public ProcessEvents getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "CloudProcessCreatedEventEntity{" +
                ", appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceFullName='" + serviceFullName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", serviceVersion='" + serviceVersion + '\'' +
                ", entityId='" + entityId + '\'' +
                ", id='" + id + '\'' +
                ", entity=" + entity +
                ", timestamp=" + timestamp +
                ", eventType=" + eventType +
                ", cloudProcessCreatedEvent=" + cloudProcessCreatedEvent +
                '}';
    }
}
