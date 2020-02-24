#  微服务调用场景

说明：一个服务调用了另外一个服务，这是两台Tomcat之间的交互。

### 模块

#### 1. 服务提供者

user-service

+ 属于eureka-client

+ user-service将服务注册到Eureka注册中心。

#### 2. 服务调用者

consumer-demo

+ 属于eureka-client 

+ 通过Eureka注册中心动态获取服务，当然也需要先注册到Eureka。

**注** 所有的eureka-client既可作为服务提供者，也调用其他服务。

#### 3. Eureka注册中心

eureka-server管理所有服务。

+ 配置多个Eureka服务端集群启动，高可用的Eureka服务。

#### 4. 负载均衡Robbin

使用Robbin组件实现负载均衡。







