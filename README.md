This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

# Compose Multiplatform App (Work In Progress)
This the CMP App, i wanna cover all the require "things" in the world of iOS and Android using CMP, i will play with networking, push notif, hardware, camera, video and many more. the Movie and E-commerce feature is mostly just playing with Ui, fetching data and others, but in CMP Playground i will cover how to implement Camera, Video, Push notif, and more. I hope this repo help others who need to learn more about Compose Multiplatform


### Structural design pattern
The app is built with the Model-View-ViewModel (MVVM) is its structural design pattern that separates objects into three distinct groups:
- Models hold application data. They’re usually structs or simple classes.
- Views display visual elements and controls on the screen. They’re typically subclasses of UIView.
- View models transform model information into values that can be displayed on a view. They’re usually classes, so they can be passed around as references.


## Tech Stack.
- Kotlin
- Jetpack Compose
- Koin
- Navigation Component Compose (Official) *I don't like using third party for navigation because it's the most important things in Mobile App. At least with official it will receive frequent update
- Shared ViewModel using Koin and Navigation Compose *Yes we can use the same ViewModel for iOS and Android
- Of course it's multi module app (Modularization)
- And more .....

#### Better to have Mac Machine, 

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…


|                                          iOS                                            |                                         Android                                        |
| :------------------------------------------------------------------------------------:  | :------------------------------------------------------------------------------------: |
|  ![](.fleet/iOS)   |  ![](.fleet/android)  |
