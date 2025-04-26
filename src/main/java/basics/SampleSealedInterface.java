package basics;

sealed interface Shape permits Circle, Rectangle, Triangle {
    double area();
}

// Permitted implementations
final class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

final class Rectangle implements Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

final class Triangle implements Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}


public class SampleSealedInterface {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 7);

        System.out.println("Circle area: " + circle.area());
        System.out.println("Rectangle area: " + rectangle.area());
        System.out.println("Triangle area: " + triangle.area());
    }
}

//example subtypes can be final, sealed or non sealed...

sealed interface Animal permits Dog, Cat, Bird {}

final class Dog implements Animal {}

sealed class Cat implements Animal permits PersianCat, SiameseCat {}

non-sealed class Bird implements Animal {}

final class PersianCat extends Cat {}

final class SiameseCat extends Cat {}

class Sparrow extends Bird {} // Allowed because Bird is non-sealed

