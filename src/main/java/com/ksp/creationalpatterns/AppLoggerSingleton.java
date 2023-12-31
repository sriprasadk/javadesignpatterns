package com.ksp.creationalpatterns;

/**
 * The Singleton pattern is used when you want to ensure that a class has only one instance and provides a global point of access to that instance throughout the application. Here's a use case where a Singleton might be beneficial in Java:


 * @author kakar
 *
 */
public class AppLoggerSingleton {
    // Private static variable to hold the single instance of the class
    private static AppLoggerSingleton instance;

    // Private constructor to prevent instantiation from outside
    private AppLoggerSingleton() {}

    // Public static method to get the single instance of the class
    public static AppLoggerSingleton getInstance() {
        if (instance == null) {
            instance = new AppLoggerSingleton();
        }
        return instance;
    }

    // Other methods or variables can be added here
    public void log() {
        System.out.println("App Loggger Message");
    }
    
    public static void main(String[] args) {
        // Get the instance of Singleton
        AppLoggerSingleton singletonInstance = AppLoggerSingleton.getInstance();

        // Use the singletonInstance to call its methods
        singletonInstance.log();
    }
}
