# ProductBrowser – Kotlin Multiplatform

## Overview

ProductBrowser is a **Kotlin Multiplatform (KMP)** application that allows users to browse products, view detailed product information, and search products using a remote API.

The project demonstrates **shared business logic across Android and iOS** using modern technologies such as **Compose Multiplatform, Ktor, and Clean Architecture**.

---

# Business Requirements

The application supports the following features:

### 1. Product List
- Displays a list of products fetched from a remote API.
- Each item shows:
    - Product name
    - Price
    - Thumbnail image.

### 2. Product Detail
- Users can tap a product to view detailed information.
- The detail screen displays:
    - Title
    - Description
    - Brand
    - Price
    - Rating.

### 3. Product Search
- Users can search products using keywords.
- Search results are retrieved using an API-based search.

### 4. Loading & Error Handling
- Loading indicators are shown while data is being fetched.
- Errors are handled gracefully.

---

# Project Architecture

The project follows **Clean Architecture + MVVM** principles with clear separation of concerns.

```
composeApp
 ├── data
 │     ├── dto
 │     ├── mapper
 │     └── repository
 │
 ├── domain
 │     ├── model
 │     ├── repository
 │     └── usecase
 │
 ├── network
 │     └── ApiService
 │
 ├── navigation
 │     └── AppNavigation
 │
 ├── ui
 │     ├── productlist
 │     └── productdetail
 │
 └── di
       └── Koin Modules
```

### Architecture Layers

#### Presentation Layer
- Compose Multiplatform UI
- ViewModels
- Navigation

#### Domain Layer
- Business logic
- UseCases
- Domain models

#### Data Layer
- Repository implementations
- DTO models
- API integration

---

# Technologies Used

- Kotlin Multiplatform
- Compose Multiplatform
- Ktor Client
- Koin (Dependency Injection)
- Kotlinx Serialization
- Coroutines & Flow
- Clean Architecture
- MVVM

---

# Running the Application

## Android

1. Open the project in **Android Studio (latest version)**.
2. Sync Gradle.
3. Select the **Android run configuration**.
4. Run the application on:
    - Android Emulator, or
    - Physical Android device.

---

## iOS

1. Open the project in **Android Studio**.
2. Run the **iOS simulator target**.

Alternatively:

1. Open the generated Xcode project:

```
iosApp/iosApp.xcodeproj
```

2. Run the application on:
    - iOS Simulator
    - Physical iPhone device.

---

# Running Tests

Unit tests are implemented in the shared module.

Location:

```
composeApp/src/commonTest
```

Run tests using:

```
./gradlew test
```

Or run from Android Studio:

```
Right Click Test → Run
```

---

# Trade-offs and Assumptions

### Shared Business Logic
Business logic and networking were implemented in the shared module to maximize **code reuse between Android and iOS**.

### DTO Flexibility
Some API DTO fields such as `brand`, `rating`, and `description` were made **nullable** to handle inconsistent API responses.

### Navigation
Typed navigation was used to provide **type-safe navigation and avoid manual argument parsing**.

### Image Loading
Coil was used for image loading because of its **Compose support and multiplatform compatibility**.

### Minimal UI Styling
UI design focuses primarily on functionality rather than complex styling.

---

# Possible Improvements

- Pagination support for large product lists
- Offline caching (Room / SQLDelight)
- Shimmer loading UI
- Improved error handling
- UI tests
- Product image gallery

---