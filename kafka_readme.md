## Download Kafka
```
Get it from here https://kafka.apache.org/downloads
```
## Start Zookeeper
**For Unix/MAC**

```
Go to /bin and then execute the below
> ./zookeeper-server-start.sh ../config/zookeeper.properties
```
**For Windows**

```
Go to \bin\windows and then execute the below
> zookeeper-server-start.bat ..\..\config\zookeeper.properties
```
## Start Kafka Broker
**For Unix/MAC**

```
Go to /bin and then execute the below
> ./kafka-server-start.sh ../config/server.properties
```

**For Windows**

```
Go to \bin\windows and then execute the below
> kafka-server-start.bat ..\..\config\server.properties
```
## Create Topic
create a topic named "my-topic" with a single partition and only one replica

**For Unix/MAC**

```
Go to /bin and then execute the below
> ./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic my-topic
```

**For Windows**

```
Go to \bin\windows and then execute the below
> kafka-topics.bat --create --topic <topic-name> localhost:2181 --replication-factor 1 --partitions 1 --topic my-topic
```

## How to check the configuration of all the topics in a broker ?
**Windows**

```
Go to \bin\windows and then execute the below
kafka-topics.bat --describe --zookeeper localhost:2181
```

**MAC:**

```
Go to /bin and then execute the below
./kafka-topics.sh --describe --zookeeper localhost:2181
```

## How to check the configuration of a particular topic?
**For Windows**

```
Go to \bin\windows and then execute the below
kafka-topics.bat --describe --topic my-topic --zookeeper localhost:2181
```
**For MAC/Unix:**  

```
Go to /bin and then execute the below
./kafka-topics.sh --describe --topic my-topic --zookeeper localhost:2181
```

## How to check the list of topics
**For MAC/Unix:**  

```
bin/kafka-topics.sh --list --zookeeper localhost:2181
```
**For Windows:**

```
Go to \bin\windows and then execute the below
kafka-topics.bat --broker-list localhost:9092 --topic <topic-name>
```

Example:  

```
kafka-topics.bat --broker-list localhost:9092 --topic my-topic
```

## How to instantiate console Producer?

**For Windows:**

```
Go to \bin\windows and then execute the below
kafka-console-producer.bat --broker-list localhost:9092 --topic <topic-name>
```

Example:  

```
kafka-console-producer.bat --broker-list localhost:9092 --topic my-topic
```

**For MAC/Unix**  

```
Go to /bin and then execute the below
./kafka-console-producer.sh --broker-list localhost:9092 --topic <topic-name>
```

Example :

```
./kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic
```

## How to instantiate a Console Consumer?

**For Windows**

```
kafka-console-producer.bat --bootstrap-server localhost:9092  --topic <topic name> --group test --from-beginning
```

Example:  

```
kafka-console-consumer.bat --bootstrap-server localhost:9092  --topic my-topic --group test --from-beginning

```

**For MAC/Unix** 
 
```
Go to /bin and then execute the below
./kafka-console-consumer.sh --bootstrap-server localhost:9092  --topic my-topic --group test --from-beginning
```

Example:  

```
Go to /bin and then execute the below
./kafka-console-consumer.sh --zookeeper localhost:2181 --topic my-topic --from-beginning
```

## How to delete a topic?

**For Windows**

```
kafka-topics.bat --delete --zookeeper localhost:2181 --topic <topic_name>
```

**For MAC:**

```
./kafka-topics.sh --delete --zookeeper localhost:2181 --topic <topic_name>
```

## How to alter the configuration of a topic ?

**For Windows:**

```
kafka-topics.bat --zookeeper localhost:2181 --alter --topic <topic-name> --partitions 4
```
Example:

```
kafka-topics.bat --zookeeper localhost:2181 --alter --topic my-topic --partitions 4
```

**For MAC**  

```
Go to /bin and then execute the below
./kafka-topics.sh --zookeeper localhost:2181 --alter --topic <topic-name> --partitions 4
```
Example:

```
./kafka-topics.sh --zookeeper localhost:2181 --alter --topic my-topic --partitions 4
```
