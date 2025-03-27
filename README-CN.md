# eventrix

[English Version](./README_EN.md) | [中文版](./README_CN.md)

🚧 **WIP：该项目仍在持续开发中，欢迎贡献和反馈！** 🚧

**eventrix** 是一个灵活、可扩展的事件追踪库，用于在应用中实现高效的事件管理与埋点功能。它支持多种事件处理器、拦截器的灵活配置和组合，提供了简洁的 API 来追踪用户行为、性能指标等，并且支持自定义事件模板和逻辑处理。

## 主要特性

- **灵活的事件处理**：支持多个事件处理器，能够根据不同的需求进行自定义事件逻辑。
- **高效的拦截器链**：通过拦截器对事件进行过滤、修改或日志记录，支持链式操作。
- **简洁的 API**：通过简洁易用的 API 快速接入并开始使用。
- **可扩展性**：支持动态添加事件处理器和拦截器，满足不同场景的需求。
- **支持多种平台**：适用于 Android、iOS 和跨平台的项目。

## 安装

```groovy

dependencies {
    implementation 'com.mcgrady.xlabs.analytics:eventrix:1.0.0'
}
```

## 使用示例

### 1. 创建事件处理器

自定义事件处理器并实现 `EventrixHandler` 接口。

```kotlin

class FirebaseEventrixHandler : EventrixHandler {
    override fun process(eventName: String, params: Map<String, Any>?): Boolean {
        // 处理事件逻辑
        return true
    }

    override fun interceptor(eventName: String, params: Map<String, Any>?): Boolean {
        // 与 Firebase 进行事件集成
        return true
    }
}
```

### 2. 创建事件拦截器

事件拦截器用于在事件流动中修改或记录事件数据。

```kotlin

class LoggingEventrixInterceptor : EventrixInterceptor {
    override fun intercept(eventName: String, params: Map<String, Any>?, next: (String, Map<String, Any>?) -> Boolean): Boolean {
        println("Logging event: $eventName with params: $params")
        return next(eventName, params)
    }
}
```

### 3. 注册事件处理器和拦截器

在 `eventrix` 中注册事件处理器和拦截器。

```kotlin

val eventrix = Eventrix()

// 注册处理器
eventrix.registerHandler(FirebaseEventrixHandler())

// 注册拦截器
eventrix.registerInterceptor(LoggingEventrixInterceptor())

// 追踪事件
eventrix.track("user_signup", mapOf("method" to "Google"))
```

### 4. 追踪事件

使用 `trackEvent` 方法追踪事件。

```kotlin

eventrix.track("purchase", mapOf("item" to "Laptop", "price" to 999))
```

## 设计模式

**eventrix** 使用以下设计模式来提供灵活、可扩展的事件追踪解决方案：

- **拦截器模式 (Interceptor Pattern)**: 允许对事件流进行过滤、修改或日志记录。
- **构建者模式 (Builder Pattern)**: 动态构建和定制事件内容，灵活管理事件模板。
- **责任链模式 (Chain of Responsibility)**: 事件通过多个拦截器进行处理，每个拦截器决定是否处理该事件或将其传递给下一个。
- **工厂模式 (Factory Pattern)**: 动态创建和注册不同类型的事件处理器，避免紧耦合。

## 优点

- **简洁易用**：通过简洁的 API 和设计，快速实现事件追踪功能。
- **高可扩展性**：支持灵活的拦截器和处理器注册，易于扩展新的事件追踪需求。
- **灵活控制**：支持对事件进行过滤、修改和日志记录，提供强大的灵活性。
- **优化性能**：通过责任链模式，避免了冗余的事件处理，提升了性能和可维护性。

## 贡献

欢迎提交 Issues 和 Pull Requests，帮助我们改进这个库！如果你有好的建议或遇到问题，随时提出。

## 许可证

MIT License