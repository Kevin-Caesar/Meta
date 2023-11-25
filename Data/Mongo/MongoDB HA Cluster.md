# MongoDB HA Cluster

## Read/Write Concern

### Read Concern

todo

### Write Concern

todo

## Replication

副本集（Replica Set）是一组mongod进程，用于提供mongo集群的数据冗余能力和高可用特性。

### Members

| Role                | Description                                      |
|---------------------|--------------------------------------------------|
| 主节点（Primary）   | 主节点用于处理所有的写操作                       |
| 从节点（Secondary） | 从节点复制主节点的操作以保持数据同步             |
| 冲裁节点（Arbiter） | 冲裁节点不保有数据，不参与选主，只进行选主投票。 |

![P-S-S](https://www.mongodb.com/docs/v6.0/images/replica-set-read-write-operations-primary.bakedsvg.svg "三节点主从模式")

![P-S-A](https://www.mongodb.com/docs/v6.0/images/replica-set-primary-with-secondary-and-arbiter.bakedsvg.svg "三节点主从冲裁模式")

### Data Synchronization

todo

### Election

副本集使用选举来决定Primary角色的归属，副本集会在下面几种情况下触发选举：

- 增加一个节点到副本集
- 初始化一个副本集
- 使用```rs.setDown()```和```rs.reconfig()```执行副本集维护命令
- 从节点与主节点失联（主节点宕机），时间超过默认超时时间（默认10秒）



### Architecture

对于生产系统而言，标准的副本集包含三个成员，用于提供数据冗余和容错能力。
相关策略如下：

- 节点数量：
  - 一个副本集可以拥有**50个成员**，其中投票成员个数**不超过7个**。
  - 建议副本集部署的成员数量为**奇数**，确保投票成员的个数为**奇数**

注意：如果副本集中如果只有**两个或更少的数据节点**，你需要优先为副本集设置集群写配置（cluster wide write concern），具体命令如下：

```javascript
db.adminCommand({
  "setDefaultRWConcern" : 1,
  "defaultWriteConcern" : {
    "w" : 2
  },
  "defaultReadConcern" : { "level" : "majority" }
})
```

上述命令需要在admin数据库中运行。对副本集而言需要在主节点mongod实例上运行；对于分片而言则需要在mongos上运行。
  
### Deployment

## Sharding

mongos/router
configs
shard0
shard1
shard2
...

### Architecture

### Components
