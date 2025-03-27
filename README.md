# eventrix

[English Version](./README_EN.md) | [中文版](./README_CN.md)

🚧 **WIP: This project is under active development. Contributions and feedback are welcome!** 🚧

**eventrix** is a flexible and extensible event tracking library for efficiently managing events and tracking user behavior within applications. It supports multiple event handlers and interceptors, allowing you to configure and combine them based on your needs. It offers a clean API for tracking user actions, performance metrics, and more. Additionally, it supports customizable event templates and processing logic.

## Key Features

- **Flexible Event Handling**: Supports multiple event handlers that allow for custom event logic as needed.
- **Efficient Interceptor Chain**: Interceptors can filter, modify, or log events in a chain-like structure.
- **Simple API**: Provides a simple and easy-to-use API to quickly integrate and start using.
- **Extensibility**: Dynamically add event handlers and interceptors to meet various requirements.
- **Cross-Platform Support**: Suitable for Android, iOS, and cross-platform projects.

## Installation

```groovy
dependencies {
    implementation 'com.mcgrady.xlabs.analytics:eventrix:1.0.0'
}
```

## Usage Example

### 1. Create an Event Handler

Create a custom event handler by implementing the `EventrixHandler` interface.

```
kotlin


复制编辑
class FirebaseEventrixHandler : EventrixHandler {
    override fun process(eventName: String, params: Map<String, Any>?): Boolean {
        // Event processing logic
        return true
    }

    override fun interceptor(eventName: String, params: Map<String, Any>?): Boolean {
        // Event integration with Firebase
        return true
    }
}
```

### 2. Create an Event Interceptor

Interceptors modify or log event data before it reaches the event handlers.

```kotlin

class LoggingEventrixInterceptor : EventrixInterceptor {
    override fun intercept(eventName: String, params: Map<String, Any>?, next: (String, Map<String, Any>?) -> Boolean): Boolean {
        println("Logging event: $eventName with params: $params")
        return next(eventName, params)
    }
}
```

### 3. Register Handlers and Interceptors

In `Eventrix`, register event handlers and interceptors.

```kotlin

val eventrix = Eventrix()

// Register handler
eventrix.registerHandler(FirebaseEventrixHandler())

// Register interceptor
eventrix.registerInterceptor(LoggingEventrixInterceptor())

// Track event
eventrix.trackEvent("user_signup", mapOf("method" to "Google"))
```

### 4. Track Events

Track events using the `trackEvent` method.

```kotlin

eventrix.trackEvent("purchase", mapOf("item" to "Laptop", "price" to 999))
```

## Design Patterns

**Eventrix** employs the following design patterns to provide a flexible and extensible event tracking solution:

- **Interceptor Pattern**: Allows filtering, modifying, or logging event data before processing.
- **Builder Pattern**: Dynamically builds and customizes event content, managing event templates flexibly.
- **Chain of Responsibility Pattern**: Events pass through multiple interceptors, where each interceptor can decide whether to process the event or pass it to the next in the chain.
- **Factory Pattern**: Dynamically creates and registers different types of event handlers, reducing tight coupling.

## Advantages

- **Simple and Easy to Use**: Provides a clean API and design, allowing for quick event tracking implementation.
- **Highly Extensible**: Supports flexible registration of interceptors and handlers, easily adding new event tracking needs.
- **Flexible Control**: Supports event filtering, modification, and logging, offering powerful flexibility.
- **Performance Optimization**: The use of the Chain of Responsibility pattern avoids redundant event handling, improving performance and maintainability.

## Contributing

We welcome issues and pull requests to help improve this library! Feel free to submit suggestions or report issues you encounter.

## License

MIT License
