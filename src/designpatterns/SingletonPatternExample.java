package designpatterns;
/*
    Singleton Design Pattern :-
        1. Creational design pattern
        2. Only one instance of the class should exist
        3. Other classes should be able to get instance of Singleton class
        4. Used in Logging, Cache, Session, Drivers

        Implementation :-
            1. Constructor should be private
            2. public method to return the singleton instance
            3. Instance type - private static

        Initialisation Type :-
            1. Eager initialisation
            2. Lazy initialisation
            3. Thread safe method initialisation
            4. Thread safe block initialisation
 */

class SingletonEagar {
    // Instance already initialised, Hence Eager Initialisation
    private static SingletonEagar instance = new SingletonEagar();

    private SingletonEagar(){}

    public static SingletonEagar getInstance() {
        return instance;
    }
}

// Instance created whenever first call to getInstance take place. Hence Lazy Initialisation
// This is not thread safe if more than one user call this at the same time for first time.
class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy(){}


    public static SingletonLazy getInstance() {
        if(instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }
}

// Only one thread can access it at a time hence Thread Safe. ( 'synchronized' keyword)
// But this also synchronizes for read access as well which is not necessary
class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){}

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if(instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

// This only makes instance creation block synchronized
// Hence instance read access can happen without synchronization
class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized(){}

    public static SingletonSynchronized getInstance() {
        if(instance == null) {
            synchronized (SingletonSynchronized.class) {
                if(instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance);

        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1);

        // Both above instances are same
    }
}
