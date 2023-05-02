# ConnectivityLiveData
[![](https://jitpack.io/v/Micoder-dev/ConnectivityLiveData.svg)](https://jitpack.io/#Micoder-dev/ConnectivityLiveData)

The ConnectivityLiveData library provides a simple way to monitor network connectivity status changes in an Android application using LiveData. It is available on Jitpack and can be added to an Android project by following the instructions provided below.

## Prerequisites

Add this in your root `settings.gradle`:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

	// Add this jitpack URL
        maven { url 'https://jitpack.io' }

    }
}
```

## Dependency

This library is available on [Jitpack](https://jitpack.io/#Micoder-dev/ConnectivityLiveData)

Add this to your module's `build.gradle` file (make sure the version matches the Jitpack URL badge above):

```gradle
dependencies {
        ...
        implementation 'com.github.Micoder-dev:ConnectivityLiveData:Tag'
}
```

## Usage

To implement the **ConnectivityLiveData**:

``` Kotlin

class MainActivity : AppCompatActivity() {

    // Declare a property for LiveData that tracks network connectivity
    private lateinit var connectivityLiveData: ConnectivityLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Call the function to check network connectivity
        checkConnection()
	
    }

    // Function to check network connectivity using LiveData
    private fun checkConnection() {

        // Initialize the LiveData property with the application context
        connectivityLiveData = ConnectivityLiveData(application)

        // Observe changes to the network connectivity status
        connectivityLiveData.observe(this) { isAvailable ->

            // Check if network connectivity is available or not
            when(isAvailable) {
                true -> (Has Network Connection) // Do Something
                false -> (No Network Connection) // Do Something
            }
        }
    }
}

```

## Screenshots

**Handling Network Connectivity using Lottie Animation Dialog**

<table>
  <tr>
    <td>
      <img src="https://micoder-dev.github.io/files/connectivity/2.jpg" width="240" alt="Screenshot 2">
     	<p>Network Not Available</br>(False -> Shows Lottie)</p>
    </td>
    <td>
      <img src="https://micoder-dev.github.io/files/connectivity/1.jpg" width="240" alt="Screenshot 1">
	<p>Network Available</br>(True -> Hides Lottie)</p>
    </td>
  </tr>
