# Android Posts App

This is a simple Android application built with **Kotlin** and **Jetpack Compose** that fetches and displays a list of posts from the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/). The app demonstrates how to integrate a REST API using Retrofit, manage state with a ViewModel, and create a modern UI with Compose.

## Features
- Fetches a list of posts from `https://jsonplaceholder.typicode.com/posts`.
- Displays each post with its title and body in a scrollable list.
- Uses a clean architecture with Retrofit for networking, ViewModel for state management, and Compose for the UI.

## Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Networking**: Retrofit with Gson converter
- **State Management**: ViewModel with LiveData-like state observation
- **Coroutines**: For asynchronous API calls
- **Dependencies**: Managed via Gradle

## How It Works
1. **Data Model (`Post.kt`)**:
   - Defines a `Post` class with fields `userId`, `id`, `title`, and `body` to match the JSON response from the API.
   
2. **Networking (`ApiService.kt`)**:
   - Uses Retrofit to define a `GET /posts` endpoint.
   - `RetrofitClient` sets up the base URL (`https://jsonplaceholder.typicode.com/`) and Gson converter for JSON parsing.

3. **ViewModel (`PostViewModel.kt`)**:
   - Fetches posts using Retrofit in a coroutine scope.
   - Stores the list of posts in a Compose `State` object, which triggers UI updates when the data changes.

4. **UI (`MainActivity.kt`)**:
   - Uses Jetpack Compose to create a `LazyColumn` that displays each post in a `Card`.
   - The `viewModel()` delegate initializes the `PostViewModel` and provides reactive access to the posts.

5. **Permissions**:
   - Requires the `INTERNET` permission in `AndroidManifest.xml` to make network requests.

## Prerequisites
- **Android Studio**: Latest stable version (e.g., Android Studio Koala | 2024.1.1 or newer).
- **Kotlin**: Version 1.9.0 or compatible.
- **Java**: JDK 17 or higher.
- **Emulator or Device**: Running Android API 21 (Lollipop) or higher.

## Dependencies
Defined in `app/build.gradle.kts`:
```
dependencies {
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
}
```

## API Reference
The app uses the [JSONPlaceholder API](https://jsonplaceholder.typicode.com/), a free fake API for testing. The endpoint used is:
- **GET `/posts`**:
  - Returns a list of posts in JSON format.
  - Example response:
```
{
"userId": 1,
"id": 1,
"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
"body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

## Learning Points
- **Jetpack Compose**: A modern way to build UIs in Android declaratively.
- **Retrofit**: Simplifies HTTP requests and JSON parsing.
- **ViewModel**: Manages UI-related data in a lifecycle-aware way.
- **Coroutines**: Handles asynchronous tasks like network calls cleanly.
- **State Management**: Uses Compose’s `State` to update the UI when data changes.

## Potential Improvements
- Add a loading indicator while fetching posts.
- Display error messages for network failures.
- Enhance the UI with more styling or additional post details.
- Implement pull-to-refresh functionality.

## Contributing
Feel free to fork this repository, submit issues, or create pull requests with improvements!

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


