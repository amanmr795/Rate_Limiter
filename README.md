# Sliding Window Rate Limiter (Java)

A simple and extensible **Sliding Window Rate Limiter** built in Java. This project demonstrates how to throttle user requests based on time and request limits using concurrent data structures.

## 🚀 Features

- Supports **10 requests per user per second** (configurable)
- Implements **Sliding Window Algorithm**
- Handles **multiple users** with dynamic creation
- Thread-safe using `ConcurrentHashMap` and `ConcurrentLinkedQueue`
- Designed with interface-based extensibility

## 📦 Tech Stack

- Java 8+
- IntelliJ IDEA (for development)
- No external dependencies

## 🧠 How It Works

Each user is assigned a `SlidingWindow` rate limiter that:
- Tracks timestamps of each request
- Rejects new requests if limit is reached within the sliding time window
- Automatically resets as time progresses


