### System Designing

## Users:

* Who will use the system?
* How the system will be used?

1) User/Customer is the center focus of any application. How are they going to use the application.

## Scalability

* How many read queries per second?
* How much data being queried per request?
* Can there be any traffic spikes? How big would that be?

1) How system will scale in case of more number of users use it.
2) Scale should handle both read and write part of the application.
3) Application should handle well the growing amount of data and user traffic.
4) Eventual or immediate consistency of data and data replication.

## Performance

* What is expected write to read delay?
* What is expected to p99 read latency to the system?

1) How application will perform with growing traffic and data.
2) It should perform well in every scenario.

## Cost

## High availability

### Data and application both:

### Important pillars of any application

```csv
User, Scalability, Performance, Availability, Cost
```

### Capture Functional Requirement - API

* Design the API first which includes public methods and signatures for read and write requirements.

### Capture Non-Functional Requirements:

* Scalable - With the traffic and data grows
* Highly Performant
* Highly Available
* CAP Theorem - what to choose and when

### High level architecture:

* Start with something simple.
    * We need a database to store the data
    * A service to handle the requests and interact with data. Say processing service
    * Another service to query the data
* Data Model:
    * Next step define the data model and how are we going to store them.

### Where to store data

* Which database to use and why
    * SQL Database (MySQL)
        * Both SQL and Non-SQL databases scale and perform well.
        * Evaluate database against non functional requirements.
        * Database should scale well for read and writes.
        * Fast and guarantee high availability.
        * How to achieve strong consistency.
        * How easy it is to change the schema in the future.
          ![Screen Shot 2023-09-10 at 12.25.28 PM.png](resources%2FScreen%20Shot%202023-09-10%20at%2012.25.28%20PM.png)
* Note - It's difficult to implement.
    * No SQL Database (Apache Cassandra)
        * Split the data into shards, also known as Nodes
        * We don't need configuration server like Zookeeper to maintain the list of shards.
        * Using gossip protocol the shards will share data with next 3 shards.
        * Each shard knows about each other so Client proxy does not need to route the request to a particular node.
        * Use round robing or closest server to store the data and consistent hashing

### How to store data:

* When storing data in relational databases we start with `noun`. We then convert these `nouns` into the `tables` and
  use `foreign keys` to define the relation between tables.
* No-SQL Databases does not think about `nouns`. They think about how the queries will be used in the system.

### APIs:

![Screen Shot 2023-09-10 at 1.08.11 PM.png](resources%2FScreen%20Shot%202023-09-10%20at%201.08.11%20PM.png)

* State Management:
    * While streaming if the machine fails then how to store the state.
        * Reprocess the events from shard. It works if processing interval is short and less data to be processed.

![Screen Shot 2023-09-10 at 1.28.16 PM.png](resources%2FScreen%20Shot%202023-09-10%20at%201.28.16%20PM.png)

### Distributed Components:

* Partitioner Service Client:
    * Blocking
        * Blocking: One thread per connection
        * Multicore machines can handle hundreds of connections each
    * Non blocking:
        * Increases the throughput using the queues
        * Increases the complexity
    * Buffering and batching:
    * Timeouts
        * Connection timeout (10ms)
        * Request timeout (dependents upon latency)
        * Retry for failed requests (exponential backoff strategy and jitter algorithms)
        * Circuit breaker
* Load Balancer
    * Consistent hashing
    * Round Robin
        * Network protocols
        * Uses DNS to look up the machines
* Partitioner Service and Partitions
    * It's a service which receives the event from client and process them
    * Partition strategy
        * Hash based strategy - Not so good for high volume data. It could introduce hot partition. Events related to one popular aggregate will go to same partition.
    * Service discovery: For service to discover the partitions.
        * Server side discovery:
          * Using the load balancer
        * Client side discovery
          * Every server instance register themselves at a common place called service registry
          * Service registry is another highly available web server which performs the healthcheck of the instances.
          * Client then queries the service registry and obtain a list of available servers.
          * Zookeeper and Netflix eureka are the examples of service registry
        * Replication:
          * Single leader replication
          * Multi leader replication
          * Leaderless replication
        * Message format:
          * Text based
            * XML, CSV, JSON
          * Binary
            * Thrift, Avro - requires schema
            
![app-flow.png](resources%2Fapp-flow.png)

### Tools and technologies:
![tools.png](resources%2Ftools.png)