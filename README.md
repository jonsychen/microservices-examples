# 基于Spring Boot/Spring Cloud 的微服务架构
## 项目介绍
### 预备知识
+ <a href="https://start.spring.io/" target="_blank">创建一个Spring Boot初始项目</a>
+ <a href="https://springcloud.cc/" target="_blank">Spring Cloud 相关项目</a>

### 项目结构
+ config : 配置文件仓库
+ api-config : 配置管理中心
+ api-registry : 服务注册中心
+ api-gateway : 服务网关
+ api-monitor : 服务监控中心
+ api-service1 : 测试服务1
+ api-service2 : 测试服务2

### 项目架构
![image](https://github.com/jonsychen/microservices-examples/blob/master/etc/%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%9E%B6%E6%9E%84.png)

## RUN DEMO
### 运行api-registry
    访问地址：http://localhost:8761/
![image](https://github.com/jonsychen/rest-security-demo/raw/master/etc/gettoken.png)
### 运行api-config
### 运行api-gateway
### 运行api-service1,api-service2
### 运行api-monitor
### 运行结束后，配置中心如下：
![image](https://github.com/jonsychen/microservices-examples/blob/master/etc/registercenter.png)
### 下面开始测试同步/异步接口，同步使用restful，异步使用基于rabbitmq的消息队列实现。
### 示例1(同步)
    1.使用postman通过网关访问service1提供的sayhi服务。
	2.网关收到请求后，解析请求的url，并匹配动态路由表，找到对应的服务名后向注册中心获取service1服务的当前运行的所有实例，再通过客服端负载均衡，将请求发送到指定的server1服务示例上。
	3.service1服务实例收到sayhi请求，同样经过客户端负载均衡后，调用service2服务的指定实例。
	4.service2服务实例收到sayhi请求，开始执行sayhi方法，打印并返回“hi from service2”。
![image](https://github.com/jonsychen/microservices-examples/blob/master/etc/service1_sayhi.png)

### 示例2(异步)
	1.使用postman通过网关访问service1提供的send服务。
	2.网关收到请求后，解析请求的url，并匹配动态路由表，找到对应的服务名后向注册中心获取service1服务的当前运行的所有实例，再通过客服端负载均衡，将请求发送到指定的service1服务示例上。
    3.service1服务实例收到send请求，接收请求参数，并将参数继续发送到指定的队列，等待其他服务处理后续操作，同步返回"message has been sent successfully"。
	4.service2监听指定队列，接收到待处理的消息，打印消息内容。
	5.service2处理完消息后，将处理结果发送到指定队列。
	6.service1监听指定结果通知队列，接收到待处理的消息，打印消息内容。
![image](https://github.com/jonsychen/microservices-examples/blob/master/etc/service1_send.png)

### 示例3（实现动态配置文件的更改）
    1.使用http get "localhost:8881/author", 来使用网关提供的打印author服务。
	2.网关收到打印author的请求，开始打印并返回author为"Jonsy（author.name具体的值定义在配置文件中）。
![image](https://github.com/jonsychen/microservices-examples/blob/master/etc/gateway_author1.png)
	4.修改配置仓库中service1-dev.properties中的author.name为"frank"。
	5.使用http post "localhost:8881/bus/refresh?destination=gateway:**",刷新服务名为gateway的所有服务实例。
![image](https://github.com/jonsychen/microservices-examples/blob/master/etc/gateway_author2.png)
	6.再次使用http get "localhost:8881/author", 来使用网关提供的打印author服务。
	7.网关收到打印author的请求，开始打印并返回author为"frank”（配置修改已生效）
![image](https://github.com/jonsychen/microservices-examples/blob/master/etc/gateway_author3.png)


### 需要注意的地方
    1.这个架构使用rabbitmq作为消息总线，所以需要用户自行安装rabbitmq，并修改配置仓库中的相关配置。
	2.配置中心里面配置的仓库地址，需要修改为自己的仓库地址。
	3.IOC容器中的对象引用配置文件变量的时候，需要在类名上加上@RefreshScope来强制更新，否则动态修改的配置文件内容不会重新加载。

## 联系我
    Email: jonsychen@hotmail.com/i@jonsy.me
    OICQ: 903352005
    WeChat: Jonsychen_2013 
