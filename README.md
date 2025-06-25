# 🛍️ Product Catalog Android App
A modern and responsive Android app built using Kotlin and XML. This application fetches a list of products from a remote API using Retrofit, and displays them on the home screen via a RecyclerView. Tapping on a product navigates to a detailed screen showing comprehensive information including the product name, description, tags, reviews, price, and more. The app is built using MVVM architecture and leverages Dagger Hilt for dependency injection.

# ✨ Features
- 📦 **Product Listing** – Clean grid/list view of products using RecyclerView
- 🔍 **Product Details Page** – View full details like name, description, price, reviews, etc.
- 🔁 **API Integration** – Powered by Retrofit for efficient network operations.
- 🧱 **MVVM Architecture** – Clean separation of concerns using the MVVM pattern.
- 🔄 **Real-time Data** – Fetches latest product data from API
- 💉 **Dagger Hilt** – For dependency injection across the app components.
- 🎨 **Material Design** – Modern and intuitive UI

# 📸 Screenshots
![home page](https://github.com/user-attachments/assets/d458e13c-9129-497b-bf59-c16f01cb4082)
![details page](https://github.com/user-attachments/assets/d9e9bfad-1173-4034-8ea6-66a37fb86b7e)
![details page 2](https://github.com/user-attachments/assets/90685586-7188-4594-8e13-a1f845c8d824)

# ⚙️ Tech Stack
- **Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **UI**: XML Layouts
- **Dependency Injection**: Dagger Hilt
- **Networking**: Retrofit
- **UI Components**: RecyclerView, Material Design
- **Asynchronous Programming**: Coroutines
- **Data Binding**: ViewBinding

# 📂 Project Structure
- **data/**: Contains repositories, models and remote data sources
- **di/**: Dagger Hilt dependency injection modules
- **domain/**: Business logic, use cases and domain models
- **ui/**: Activities, Fragments, ViewModels and adapters
- **Constants.kt**: Application-wide constant values

# 🚀 Getting Started
1. Clone the repository
2. Open the project in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or physical device

# 🔧 Requirements
- Android Studio Hedgehog or later
- Minimum SDK: 24
- Target SDK: 34
- Gradle Version: 8.0+

# 🤝 Contributing
Contributions are welcome! If you'd like to fix a bug or add a feature, feel free to fork the repository and submit a pull request. Make sure your code adheres to the existing architecture and coding standards.
