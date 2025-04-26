package basics;


public class SampleSingleton {

    private static SampleSingleton instance;

    public SampleSingleton(){}

    public static SampleSingleton getInstance() {
        if (instance == null) {
            synchronized (SampleSingleton.class) {
                if (instance == null) {
                    instance = new SampleSingleton();
                }
            }
        }
        return instance;
    }
    //has cons - double checked locking as its more complex


    //bill Pugh implementation -
    // Uses a static inner helper class to ensure lazy loading and thread-safety.
    private static class SingletonHelper {
        // The singleton instance is created when this class is loaded
        private static final SampleSingleton INSTANCE = new SampleSingleton();
    }

    // Public method to provide access to the instance
    public static SampleSingleton getBillPughInstance() {
        return SingletonHelper.INSTANCE;
    }



}

class Main { // to test its singleton , constructor should be private
    public static void main(String[] args) {
        SampleSingleton ins = SampleSingleton.getInstance();
        SampleSingleton ins1 = SampleSingleton.getInstance();
        System.out.println(ins);
        System.out.println(ins1);
    }
}


// Another way is to create enum

// The most robust way to implement a singleton in Java.
//Enums inherently protect against serialization and reflection by Java's design.
// However, enums lack flexibility if your singleton needs to extend a class or implement additional logic.
/*
enum Singleton {
    INSTANCE;

    public void doSomething() {
        // Business logic here
    }
}*/
