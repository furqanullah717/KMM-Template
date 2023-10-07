# Kotlin Multiplatform (KMP) Compose Boilerplate

This Kotlin Multiplatform (KMP) Compose Boilerplate project is designed to kickstart your cross-platform development journey by providing a solid foundation with the following features:

- **Kotlin Multiplatform (KMP):** Develop shared code that can run on multiple platforms such as Android, iOS, and more.

- **Jetpack Compose UI:** Use the power of Compose for building user interfaces in a declarative way.

- **Moko MVVM:** Implement the MVVM (Model-View-ViewModel) architecture with the Moko library to organize your code.

- **Resource Management:** Manage and access platform-specific resources in a cross-platform manner.

- **Precompose Navigation:** Set up a basic navigation system for your Compose-based UI.
- 
- **Ktor:** Set up basic network calls for the app.

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- [Android Studio](https://developer.android.com/studio) with Kotlin support.
- [Xcode](https://developer.apple.com/xcode/) for iOS development (if targeting iOS).
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) or another Kotlin-friendly IDE for shared code development.


## Project Structure
The project is structured as follows:

- **androidApp:** Android-specific code and Compose UI.
- **iosApp:** iOS-specific code and UI (Swift/Kotlin Multiplatform).
- **shared:** Shared Kotlin code.
- **data:** Data layer, including repositories and data models.
- **presentation:** Presentation layer, including view models and UI logic.
- **resources:** Shared resources like images, and strings.

## Configure Resources
Place your platform-specific resources (images, fonts, etc.) in the appropriate folders under the `resources` directory. Use the `ResourceProvider` class to access these resources in a cross-platform way.

## Precompose Navigation
The project includes basic navigation setup using a `NavController` in the Android app module. You can extend this navigation setup as needed for your project.

## Build and Run
- Build and run the Android app using Android Studio.
- Build and run the iOS app using Xcode.

## Usage
This boilerplate is designed to be a starting point for your KMP Compose project. You can:

- Define your shared logic and data models in the `shared` module.
- Implement platform-specific UI using Compose in the `androidApp` and `iosApp` modules.
- Customize the navigation and UI structure to fit your project requirements.
- Add platform-specific dependencies or libraries as needed.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contributing
Feel free to contribute to this project by creating issues, submitting pull requests, or providing feedback.

## Acknowledgments
- [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Moko MVVM](https://github.com/icerockdev/moko-mvvm)
- [Ktor](https://ktor.io/)

## Contact
If you have any questions or need further assistance, please don't hesitate to reach out to furqanullah717@gmail.com.

