import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    // Variables and Constants
    public static final double PI = 3.14159;
    public static String name = "John";

    // Null Safety
    public static String nullableName = null;

    // Control Flow
    public static void checkAge(int age) {
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a minor.");
        }
    }

    // Functions and Return Type
    public static int sum(int a, int b) {
        return a + b;
    }

    // String Concatenation
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Collections and Iteration
    public static void iterateList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    // Object-Oriented Programming
    static class Animal {
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public void makeSound() {
            System.out.println("The animal makes a sound.");
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }

    // Exception Handling
    public static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
            return -1;
        }
    }

    // Anonymous Classes
    public static void greetAnonymousClass() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class!");
            }
        };

        runnable.run();
    }

    // Lambdas
    public static void greetLambda() {
        Runnable runnable = () -> System.out.println("Hello from lambda!");
        runnable.run();
    }

    // Functional Interfaces
    @FunctionalInterface
    interface Operation {
        int perform(int a, int b);
    }

    public static int calculate(int a, int b, Operation operation) {
        return operation.perform(a, b);
    }

    // Threads
    public static void launchThread() {
        Thread thread = new Thread(() -> {
            System.out.println("Inside thread");
        });

        thread.start();
    }

    // Java 8: Default and Static Methods in Interfaces
    interface Vehicle {
        void start();

        default void stop() {
            System.out.println("Vehicle stopped.");
        }

        static void repair() {
            System.out.println("Vehicle repaired.");
        }
    }

    static class Car implements Vehicle {
        @Override
        public void start() {
            System.out.println("Car started.");
        }
    }

    // Java 9: Private Methods in Interfaces
    interface Greeting {
        default void sayHello() {
            greet();
        }

        private void greet() {
            System.out.println("Hello!");
        }
    }

    static class EnglishGreeting implements Greeting {
    }

    // Java 10: Local Variable Type Inference
    public static void printStringLength() {
        var text = "Hello, World!";
        System.out.println("Length: " + text.length());
    }

    // Java 11: HTTP Client API
    public static void sendHttpRequest() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.example.com/data"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }

    // Java 14: Switch Expressions
    public static String getDayOfWeek(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> throw new IllegalArgumentException("Invalid day");
        };
    }

    // Java 16: Records
    public record Person(String name, int age) {
    }

    // Advanced Concepts

    // Generics
    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
    }

    // Streams
    public static void filterAndPrint(List<String> names) {
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }

    // Optional
    public static void processOptional(java.util.Optional<String> optionalName) {
        if (optionalName.isPresent()) {
            System.out.println("Name: " + optionalName.get());
        } else {
            System.out.println("No name available.");
        }
    }

    public static void main(String[] args) {
        System.out.println("PI: " + PI);
        System.out.println("Name: " + name);

        if (nullableName != null) {
            System.out.println("Nullable Name: " + nullableName);
        }

        int age = 25;
        System.out.println("Age: " + age);

        checkAge(age);

        int sumResult = sum(5, 3);
        System.out.println("Sum: " + sumResult);

        greet("Alice");

        iterateList();

        Cat cat = new Cat("Whiskers");
        cat.makeSound();

        String text = "Hello, World!";
        System.out.println("Text: " + text);

        int divideResult = divide(10, 2);
        System.out.println("Result: " + divideResult);

        greetAnonymousClass();
        greetLambda();

        int additionResult = calculate(5, 3, (a, b) -> a + b);
        System.out.println("Addition Result: " + additionResult);

        launchThread();

        Car car = new Car();
        car.start();
        car.stop();
        Vehicle.repair();

        EnglishGreeting englishGreeting = new EnglishGreeting();
        englishGreeting.sayHello();

        printStringLength();

        sendHttpRequest();

        String dayOfWeek = getDayOfWeek(3);
        System.out.println("Day of Week: " + dayOfWeek);

        Person person = new Person("John", 30);
        System.out.println("Person: " + person);

        // Advanced Concepts Examples

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        printList(numbers);

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        filterAndPrint(names);

        java.util.Optional<String> optionalName = java.util.Optional.of("John");
        processOptional(optionalName);
    }
}
