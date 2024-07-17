# ApiRecyclerViewApp
ApiRecyclerViewApp is an Android application that demonstrates fetching data from an API and displaying it using a LazyColumn from Compose Dependency. The app supports different layouts for tablets in landscape mode and includes all.

## Table of Contents
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Folder Structure](#folder-structure)
- [Usage](#usage)
- [CI/CD](#cicd)
- [Libraries and Tools Used](#libraries-and-tools-used)
- [Testing](#testing)


## Getting Started
These instructions will guide you through setting up and running the project on your local machine.

### Prerequisites
Make sure you have the following software installed on your system:
- [Android Studio](https://developer.android.com/studio)
- [Java Development Kit (JDK) 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)
- An Android device or emulator running Android 5.0 (Lollipop) or higher

### Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/rigoeffector/recycler-view_kotlin/tree/dev
   cd ApiRecyclerViewApp
2. Open the project in Android Studio:

- Launch Android Studio
- Select "Open an existing Android Studio project"
- Navigate to the cloned directory and select it


3. Build the project:

- Allow Android Studio to download any required dependencies and build the project
- Connect an Android device or start an emulator
- Click the Run button in Android Studio to install and run the app on your device/emulator

### Folder Structure (MVVM)
**The project follows a structured organization to maintain clarity and separation of concerns:**

- models: Includes data models used to represent API responses.
- network: Manages API communication and network-related operations.
- screens: Contains activities or fragments representing different screens of the app.
- viewmodel: Houses ViewModel classes responsible for preparing data for the UI and handling business logic.

### Usage

**Once the app is running on your device or emulator:**

- The main screen displays a list of items fetched from the API.
- Clicking on any item in the list navigates to a detailed view of the selected item.
- The app supports both portrait and landscape modes, with a tailored layout for tablets in landscape mode.

### CI/CD

This project uses GitHub Actions for Continuous Integration and Continuous Deployment. The workflow is defined in the .github/workflows/main.yml file.
The CI/CD pipeline includes the following steps:

- Lint Check: Analyzes the code for potential errors and style issues.
- Unit Tests: Runs all unit tests.
- Build Debug APK: for user to test


**To view the CI/CD pipeline:**

- Go to the GitHub repository.
- Click on the "Actions" tab.
- You'll see all the workflow runs, their statuses, and detailed logs.

### Libraries and Tools Used

- Kotlin: The primary programming language for Android development.
- Jetpack Compose (version 1.0.1): Modern toolkit for building native Android UI.
- AndroidX Core KTX (version 1.7.0): Kotlin extensions for 'core' artifact.
- Lifecycle Runtime KTX (version 2.3.1): Lifecycle-aware components for managing UI states.
- Activity Compose (version 1.3.1): Compose integration with Activity.
- Retrofit (version 2.9.0): Type-safe HTTP client for Android and Java.
- Gson (version 2.9.0): Used with Retrofit for JSON serialization/deserialization.
- OkHttp (version 4.9.3): HTTP client that's used by Retrofit.
- OkHttp Logging Interceptor (version 4.9.3): Logs HTTP request and response data.
- Navigation Compose (version 2.4.0-alpha10): Navigation support for Jetpack Compose.
- ViewModel Compose (version 1.0.0-alpha07): Integration of ViewModel with Compose.
- JUnit (version 4.13.2): Testing framework for unit tests.
- Kotlin Test: Kotlin's testing library.
- Kotlinx Coroutines Test (version 1.5.2): Testing utilities for Kotlin coroutines.
- MockK (version 1.12.0): Mocking library for Kotlin.
- AndroidX Test Core (version 1.4.0): Core library for Android tests.
- AndroidX Test Rules (version 1.4.0): Rules for Android tests.
- AndroidX Test Runner (version 1.4.0): Test runner for Android tests.
- Compose UI Test (version 1.0.1): Testing utilities for Compose UI.
- Navigation Testing (version 2.4.0-alpha10): Testing utilities for Navigation component.

Development tools:
- Android Gradle Plugin: For building Android applications.
- Kotlin Gradle Plugin: For Kotlin support in Gradle.
- Android SDK (compileSdk 34, minSdk 21, targetSdk 34): Android Software Development Kit.
- Java Development Kit (JDK) version 11

### Testing

**The project includes both unit tests and instrumented tests to ensure the reliability and correctness of the app.**
1. Unit Test
- Unit tests are located in the test directory and focus on testing individual components, particularly the ViewModel.
  To run unit tests, use the following command:
  ```bash
   ./gradlew test

2. Instrumented tests are located in the androidTest directory and test the UI components and their interactions.

  ```bash
   ./gradlew connectedCheck



