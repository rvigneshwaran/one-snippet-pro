import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

        // 1. If-Else Statement
        int num = 10;
        if (num % 2 == 0) {
            System.out.println("Number is even.");
        } else {
            System.out.println("Number is odd.");
        }

        // 2. Nested If-Else Statement
        age = 25;
        if (age >= 18) {
            if (age < 60) {
                System.out.println("You are an adult.");
            } else {
                System.out.println("You are a senior citizen.");
            }
        } else {
            System.out.println("You are a minor.");
        }

        // 3. Switch Statement
        String day = "Monday";
        switch (day) {
            case "Monday":
                System.out.println("It's Monday.");
                break;
            case "Tuesday":
                System.out.println("It's Tuesday.");
                break;
            case "Wednesday":
                System.out.println("It's Wednesday.");
                break;
            default:
                System.out.println("It's some other day.");
        }

        // 4. Ternary Operator
        int x = 5;
        int y = (x > 0) ? 10 : -10;
        System.out.println("Value of y: " + y);

        // 5. For Loop
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
        }

        // 6. While Loop
        int j = 1;
        while (j <= 5) {
            System.out.println("Iteration " + j);
            j++;
        }

        // 7. Do-While Loop
        int k = 1;
        do {
            System.out.println("Iteration " + k);
            k++;
        } while (k <= 5);

        // 8. Break Statement
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("Value: " + i);
        }

        // 9. Continue Statement
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Value: " + i);
        }

        // 10. Labeled Statements
        outerLoop:
        for (int i = 1; i <= 3; i++) {
            innerLoop:
            for (int l = 1; l <= 3; l++) {
                if (l == 2) {
                    break outerLoop;
                }
                System.out.println("i: " + i + ", l: " + l);
            }
        }
    }

    // Functions and Return Type
    public static int sum(int a, int b) {
        return a + b;
    }

    // String Based Functions and its usage
    public static void greet(String name) {
        System.out.println("Hello, " + name + "!");
        String str1 = "Hello, World!";
        String str2 = "Java is awesome";
        String str3 = "   Java Programming   ";

        // String Length
        int length = str1.length();
        System.out.println("Length of str1: " + length);

        // Concatenation
        String concat = str1 + " " + str2;
        System.out.println("Concatenated string: " + concat);

        // Comparison
        boolean isEqual = str1.equals(str2);
        System.out.println("Strings str1 and str2 are equal: " + isEqual);

        // Comparison (Ignoring Case)
        boolean isEqualIgnoreCase = str1.equalsIgnoreCase(str2);
        System.out.println("Strings str1 and str2 are equal (ignoring case): " + isEqualIgnoreCase);

        // Substring
        String substring = str1.substring(7);
        System.out.println("Substring from str1: " + substring);

        // Substring (with Start and End Index)
        String substringWithIndex = str2.substring(4, 9);
        System.out.println("Substring from str2 with index: " + substringWithIndex);

        // Trim
        String trimmedString = str3.trim();
        System.out.println("Trimmed string: " + trimmedString);

        // Upper Case
        String upperCaseString = str1.toUpperCase();
        System.out.println("Uppercase string: " + upperCaseString);

        // Lower Case
        String lowerCaseString = str2.toLowerCase();
        System.out.println("Lowercase string: " + lowerCaseString);

        // Replace
        String replacedString = str1.replace("World", "Universe");
        System.out.println("Replaced string: " + replacedString);

        // Split
        String[] splitArray = str2.split(" ");
        System.out.println("Split string array:");
        for (String s : splitArray) {
            System.out.println(s);
        }

        // Contains
        boolean contains = str1.contains("Hello");
        System.out.println("str1 contains 'Hello': " + contains);

        // Starts With
        boolean startsWith = str2.startsWith("Java");
        System.out.println("str2 starts with 'Java': " + startsWith);

        // Ends With
        boolean endsWith = str1.endsWith("!");
        System.out.println("str1 ends with '!': " + endsWith);

        // Index Of
        int indexOf = str2.indexOf("is");
        System.out.println("Index of 'is' in str2: " + indexOf);

        // Last Index Of
        int lastIndexOf = str1.lastIndexOf("l");
        System.out.println("Last index of 'l' in str1: " + lastIndexOf);

        // Empty Check
        boolean isEmpty = str3.isEmpty();
        System.out.println("str3 is empty: " + isEmpty);

        // Character At
        char charAt = str1.charAt(4);
        System.out.println("Character at index 4 in str1: " + charAt);

        // To Char Array
        char[] charArray = str2.toCharArray();
        System.out.println("Char array from str2:");
        for (char c : charArray) {
            System.out.println(c);
        }

        // Replace All
        String replacedAll = str2.replaceAll("a", "o");
        System.out.println("str2 with 'a' replaced by 'o': " + replacedAll);

        // Format
        String formattedString = String.format("The value of pi is %.2f", Math.PI);
        System.out.println("Formatted string: " + formattedString);

        // Join
        String[] words = {"Java", "is", "fun"};
        String joinedString = String.join(" ", words);
        System.out.println("Joined string: " + joinedString);

        // String Builder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        stringBuilder.append(", ");
        stringBuilder.append("World!");
        String stringBuilderString = stringBuilder.toString();
        System.out.println("String from StringBuilder: " + stringBuilderString);

        // String Buffer
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Java");
        stringBuffer.append(" is");
        stringBuffer.append(" awesome");
        String stringBufferString = stringBuffer.toString();
        System.out.println("String from StringBuffer: " + stringBufferString);

        // Reversing a String
        StringBuilder reversedStringBuilder = new StringBuilder(str1).reverse();
        String reversedString = reversedStringBuilder.toString();
        System.out.println("Reversed string: " + reversedString);

        // String Equality (String Pool)
        String str4 = "Hello, World!";
        boolean isSameObject = (str1 == str4);
        System.out.println("str1 and str4 are the same object: " + isSameObject);

        // String Equality (Using Intern)
        String internedStr1 = str1.intern();
        String internedStr4 = str4.intern();
        boolean isInternedEqual = (internedStr1 == internedStr4);
        System.out.println("Interned str1 and interned str4 are the same object: " + isInternedEqual);

        // String Builder (Chaining Methods)
        String chainedMethods = new StringBuilder()
                .append("Hello")
                .append(", ")
                .append("World!")
                .toString();
        System.out.println("String from chained methods: " + chainedMethods);

        // String Conversion (Integer to String)
        int number = 42;
        String numberString = String.valueOf(number);
        System.out.println("Number as string: " + numberString);

        // String Conversion (Double to String)
        double decimal = 3.14;
        String decimalString = String.valueOf(decimal);
        System.out.println("Decimal as string: " + decimalString);

        // String Conversion (Boolean to String)
        boolean flag = true;
        String flagString = String.valueOf(flag);
        System.out.println("Flag as string: " + flagString);
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
