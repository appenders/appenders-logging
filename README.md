# Appenders (internal) Logging

This project provides a very simple implementation of "binding-less" logger.

Log4j2 StatusLogger is used by default, but any other logging implementation can be set instead.

# Usage

```java
InternalLogging.getLogger().info("Hello, World"); // Will use Log4j2 StatusLogger if Log4j2 jars are available 
```

or

```java
InternalLogging.setLogger(new Logger() {
        @Override
        public void warn(String messageFormat, Object... parameters) {
            // Your logging implementation
        }
}; 

InternalLogging.getLogger().warn("Hello, World");
```
