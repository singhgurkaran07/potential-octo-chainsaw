package basics;

@FunctionalInterface
public interface SampleFunctionalInterface {
    void execute(); // only single abstract method allowed

    // adding another abstract method  --> void anotherMethod(); would result in
    // Compilation error: Not a functional interface

    //Without the FunctionalInterface annotation, this compiles with multiple abstract methods
    // but is no longer a valid functional interface.


    //Best Practices
    //Use @FunctionalInterface to make your intent clear and enforce the contract of a functional interface.
    //While it’s not mandatory, it’s a good practice for maintaining code clarity and avoiding unintended errors.
}
