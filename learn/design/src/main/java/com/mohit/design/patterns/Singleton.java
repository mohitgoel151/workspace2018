package com.mohit.design.patterns;

import java.io.Serializable;

/**
 * Issue with double locking:
 * http://www.javaworld.com/article/2074979/java-concurrency/double-checked-locking--clever--but-broken.html
 */
public final class Singleton implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -220779545372668149L;

    private static volatile Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * Protect it from deserialization use case This method is called immediately
     * after an object of this class is deserialized. This method returns the
     * singleton instance.
     * 
     * @return
     */
    protected Singleton readResolve() {
        return getInstance();
    }

    // ************ Approach 2 ************

    // When the singleton class is loaded, SingletonHelper class is not loaded into
    // memory and only when someone calls
    // the getInstance method, this class gets loaded and creates the Singleton
    // class instance.
    
//  When the initialized object is a static field of a class with no other methods or fields, 
//  the JVM effectively performs lazy initialization automatically. In the following example, 
//  the Resource will not be constructed until the field resource is first referenced by another class, 
//  and any memory writes that result from resource's initialization are automatically visible to all threads:
  
//  The initialization will be performed when the JVM initializes the class. Since MySingleton has no other fields or methods, 
//  class initialization occurs when the resource field is first referenced.

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance2() {
        return SingletonHelper.INSTANCE;
    }

}
