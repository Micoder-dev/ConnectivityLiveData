# ConnectivityLiveData
[![](https://jitpack.io/v/Micoder-dev/ConnectivityLiveData.svg)](https://jitpack.io/#Micoder-dev/ConnectivityLiveData)

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
		repositories {
			...
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
