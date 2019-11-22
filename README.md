# Installation
Add the dependency to your gradle file
```groovy
    dependencies {
        implementation 'com.quantipixels.broadcastreceiver:broadcast-message-manager:0.1.0'
    }
```

# How to use
Step 1. In your Application class, initialize the QPBroadcastReceiver class

	BroadcastMessageManager.init(this);

Step 2. Make your activity or fragment implement QPBroadcastReceiver.BroadcastListener interface and also implement the onReceiveBroadcast method

```java
    class MyActivity extends AppCompatActivity implements BroadcastMessageManager.BroadcastListener {

        @override
        onReceiveBroadcast(Context context, String action, Bundle data) {
            // if multiple broadcast ids
            switch(action) {
                case "test":
                // do something
                // get objects from bundle
                // NOTE: MyCustomObject implements Serializable interface
                MyCustomObject customObject = (MyCustomObject) data.getSerializable("customObject");
                break;
                case "testing":
                // do something
                break;
                case "tester":
                // do something
                break;
            }
        }

    }
```

OR

```java
    class MyFragment extends Fragment implements BroadcastMessageManager.BroadcastListener {

        @override
        onReceiveBroadcast(Context context, String action, Bundle data) {
            // if one broadcast id
            if (action.equals("test") {
                // do something
                // get objects from bundle
                int age = data.getBoolean("age");
                String name = data.getString("name");
            }
        }

    }
```

Step 3. Create a BroadcastMessageManager class var in your activity/fragment class

```java
    private BroadcastMessageManager mBroadcastReceiver;
```

Step 4. In the onCreate method, instantiate the object with one broadcast id

    mBroadcastReceiver = new BroadcastMessageManager(this, "testing");

Or with multiple broadcast ids

    mBroadcastReceiver = new BroadcastMessageManager(this, "testing", "test", "tester");

Step 5. Register the broadcast receiver in your onResume method

```java
    @Override
    protected void onResume() {
        super.onResume();
        mBroadcastReceiver.register();
    }
```
Step 6. Unegister the broadcast receiver in your onStop method

```java
    @Override
    protected void onStop() {
        mBroadcastReceiver.unregister();
        super.onStop();
    }
```

# Sending a broadcast message
With no data

    BroadcastMessageManager.sendBroadcast("test");

With string data

    BroadcastMessageManager.sendBroadcast("test", "name", "Emmanuel");

With int data

    BroadcastMessageManager.sendBroadcast("test", "age", 20);

With bundle data

    Bundle bundle = new Bundle();
    BroadcastMessageManager.sendBroadcast("test", bundle);

With serializable custom object data

    // You can also send custom objects e.g MyCustomObject
    // NOTE: MyCustomObject must implement Serializable interface
    MyCustomObject customObject = new MyCustomObject();
    BroadcastMessageManager.sendBroadcast("test", "customObject", customObject);

