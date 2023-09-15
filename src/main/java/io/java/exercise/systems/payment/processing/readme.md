### Payment processing system

1) Reliability:
    1) Business Level:
        1) Reconciliation
        2) Payment Status
        3) Handle Delay
    2) Technical Level:
        1) Redundancy
        2) Persistence Queues
        3) Retry Strategies
        4) Idempotency
        5) Fault Tolerance

```gherkin
Given customer payment details
When customer orders the payment
Then given amount should be transferred from
customer account to merchants account
```

### HLF:

Client places an order --> creates an order events-->
consumed by payment service --> Payment service
stores the event into the database and integrates
with PSP (Payment service provider) by providing
payment details and amount in currency. Once the PSP
provides the update the same needs to be updated in
user's wallet and goes into it's DB. After wallet
service being updated the payment service calls the
Ledger service.

### Communication Patters:

1) Synchronous:
    1) This type of connection is not fault-tolerant and latency will be introduced.
    2) Scaling and performance is not issue and the
       service has to wait for the response for another service.
    3) It introduces the tight coupling.

2) Asynchronous:
   1) This pattern is better to handle the spikes in the user traffic. We have queue the events and process them in order using kafka.
   2) Kafka is used in 7 out of 10 banks and financial institutions. 
   3) Tolerate to failures
   4) Tolerate to latencies.
   5) Fraud detection and analytics can also be done

### Dealing with System failures:
1) System failures
2) Functional bugs
3) Invalid events which can't be processed.

### Guarantee Transaction completion:
If using microservices the use choreography saga to
achieve atomicity in the system.

### Dealing with transient failures:
1) Retry strategies
   1) Number of retries
   2) Time interval between retries 
      1) Fixed interval
      2) Incremental interval
      3) Exponential backoff strategy -- recommended
2) Timeout
   1) To avoid unwanted waiting time
   2) How big the timeout value should be
3) Fallbacks
   1) Circuit breaker
4) Idempotency 
   1) We can achieve this by adding a idempotent key in http header. Use UUID as keys
   2) To support this we can use unique key constrain in any database. If rows gets inserted then it's a unique payment request else do not process the request and return with latest status. 
   3) If concurrent request comes with same queue then process only one and fail others with 429 (too many requests)
   
### Making use od distributed systems:
1) Redundancy: Using replication -- Improves availability and reliability
### Protect Data:
1) Encrypting data-at-rest
2) Encrypt data in transit - Use TLS protocol 
3) Use HTTPS
4) Two factor authentication
5) Keep updating software, libraries and OS with latest security patches
6) Backup data

### Monitoring data integrity:

