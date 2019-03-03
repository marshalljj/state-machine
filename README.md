# 状态机
状态机的应用场景很常见，从电商的订单，到oa的工单，多不胜数。开源中也存在许多框架，比如squirrel-foundation，spring-statemachine等。本文参考了以上两个框架，实现了一个简单的状态机，旨在探究状态机的实现原理。

使用流程如下：
1. 配置状态迁移并加载,数据库中建表,并提供startState, event, endState等要素即可,mock代码如下
```java
	//需要动态更新时，可改为从数据库获取配置
    private static List<TransitionProperties> getTransitionPropertiesList() {
        TransitionProperties properties1 = new TransitionProperties("state1", "state2", "event1");
        TransitionProperties properties2 = new TransitionProperties("state1", "state3", "event2");
        TransitionProperties properties3 = new TransitionProperties("state1", "state4", "event2");
        return Lists.newArrayList(properties1,properties2, properties3);
    }
```
2. 初始化machineBuilder
```java
	//需要动态更新时，可改为从数据库获取配置
     private static StateMachineBuilder initStateMachineBuilder() {
        StateMachineBuilder stateMachineBuilder = new StateMachineBuilder();
        List<TransitionProperties> transitionPropertiesList = getTransitionPropertiesList();
        for (TransitionProperties properties: transitionPropertiesList) {
            stateMachineBuilder.addTransition(properties);
        }
        stateMachineBuilder.onTransitionStated(event -> System.out.println("transition started"));
        return stateMachineBuilder;
    }

```
3. 根据初始状态创建machine instance
```java
StateMachine stateMachine = stateMachineBuilder.createInstance("state1");
```
4. 接收事件进行状态迁移
```
State state = stateMachine.onEvent("event1", null);
```
