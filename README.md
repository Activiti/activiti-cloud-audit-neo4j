# Activiti cloud audit neo4j

This project has been generated using the spring initializer tool (https://start.spring.io). In dependencies box we added Neo4j.

#What it does
Activiti 7 along side with a lot of cool things introduce a messaging system based on Spring Cloud Streams, the objective is to catch the events fired by the engine to store them in a graph structure inside Neo4j Graph DB.

Events covered:
- PROCESS_CREATED
- TASK_COMPLETED

TODO:
- PROCESS_STARTED
- PROCESS_COMPLETED
- PROCESS_CANCELLED
- PROCESS_SUSPENDED
- PROCESS_RESUMED
- TASK_ASSIGNED
- TASK_COMPLETED
- TASK_CREATED
- TASK_ACTIVATED
- TASK_SUSPENDED
- TASK_CANCELLED
- TASK_CANDIDATE_GROUP_ADDED
- TASK_CANDIDATE_GROUP_REMOVED
- TASK_CANDIDATE_GROUP_ADDED,
- TASK_CANDIDATE_GROUP_REMOVED;
- VARIABLE_CREATED
- VARIABLE_DELETED
- ACTIVITY_STARTED
- ACTIVITY_COMPLETED
- ACTIVITY_CANCELLED
- SEQUENCE_FLOW_TAKEN
