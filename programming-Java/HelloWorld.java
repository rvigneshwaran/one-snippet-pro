import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.*;
import java.util.*;

enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
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
    public static void demonstateCollection() {
        List<Integer> numbersList = new ArrayList<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);

        for (int number : numbersList) {
            System.out.println(number);
        }

        // List Examples
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Durian");
        System.out.println("List: " + list);

        // Accessing elements in a List
        System.out.println("First element: " + list.get(0));
        System.out.println("Last element: " + list.get(list.size() - 1));

        // Modifying elements in a List
        list.set(1, "Blueberry");
        System.out.println("Modified List: " + list);

        // Removing elements from a List
        list.remove(2);
        System.out.println("List after removal: " + list);

        // Iterating over a List using enhanced for loop
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // Set Examples
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println("Set: " + set);

        // Checking if an element exists in a Set
        boolean contains = set.contains(3);
        System.out.println("Set contains 3: " + contains);

        // Removing an element from a Set
        set.remove(2);
        System.out.println("Set after removal: " + set);

        // Iterating over a Set using Iterator
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Map Examples
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        System.out.println("Map: " + map);

        // Accessing values in a Map
        int age = map.get("Bob");
        System.out.println("Bob's age: " + age);

        // Modifying values in a Map
        map.put("Charlie", 40);
        System.out.println("Modified Map: " + map);

        // Removing entries from a Map
        map.remove("Alice");
        System.out.println("Map after removal: " + map);

        // Iterating over a Map using keySet()
        Set<String> keys = map.keySet();
        for (String key : keys) {
            int value = map.get(key);
            System.out.println(key + ": " + value);
        }

        // Queue Examples
        Queue<String> queue = new LinkedList<>();
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");
        System.out.println("Queue: " + queue);

        // Accessing elements in a Queue
        String element = queue.peek();
        System.out.println("First element: " + element);

        // Removing elements from a Queue
        String removedElement = queue.poll();
        System.out.println("Removed element: " + removedElement);
        System.out.println("Queue after removal: " + queue);

        // Iterating over a Queue using while loop
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // Deque Examples
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("Apple");
        deque.addLast("Banana");
        deque.addLast("Cherry");
        System.out.println("Deque: " + deque);

        // Accessing elements in a Deque
        String firstElement = deque.getFirst();
        String lastElement = deque.getLast();
        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);

        // Removing elements from a Deque
        String removedFirst = deque.removeFirst();
        String removedLast = deque.removeLast();
        System.out.println("Removed first element: " + removedFirst);
        System.out.println("Removed last element: " + removedLast);
        System.out.println("Deque after removal: " + deque);

        // Iterating over a Deque using descendingIterator()
        Iterator<String> descendingIterator = deque.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }

        // Stack Examples
        Stack<String> stack = new Stack<>();
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        System.out.println("Stack: " + stack);

        // Accessing elements in a Stack
        String topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // Removing elements from a Stack
        String poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after removal: " + stack);

        // Iterating over a Stack using for loop
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }

        // Collections Class Examples
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(2);
        System.out.println("Numbers before sorting: " + numbers);
        Collections.sort(numbers);
        System.out.println("Numbers after sorting: " + numbers);

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.println("Names: " + names);
        Collections.reverse(names);
        System.out.println("Reversed Names: " + names);

        Collections.shuffle(numbers);
        System.out.println("Shuffled Numbers: " + numbers);

        // LinkedList Examples
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        System.out.println("LinkedList: " + linkedList);

        linkedList.addFirst("Orange");
        linkedList.addLast("Grape");
        System.out.println("LinkedList after adding: " + linkedList);

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("LinkedList after removal: " + linkedList);

        // TreeSet Examples
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        System.out.println("TreeSet: " + treeSet);

        // Accessing elements in a TreeSet
        int firstElementTreeSet = treeSet.first();
        int lastElementTreeSet = treeSet.last();
        System.out.println("First element: " + firstElementTreeSet);
        System.out.println("Last element: " + lastElementTreeSet);

        // Removing elements from a TreeSet
        treeSet.remove(2);
        System.out.println("TreeSet after removal: " + treeSet);

        // Iterating over a TreeSet using Iterator
        Iterator<Integer> treeSetIterator = treeSet.iterator();
        while (treeSetIterator.hasNext()) {
            System.out.println(treeSetIterator.next());
        }

        // HashMap Examples
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Cherry", 30);
        System.out.println("HashMap: " + hashMap);

        // Accessing values in a HashMap
        int appleQuantity = hashMap.get("Apple");
        System.out.println("Quantity of Apple: " + appleQuantity);

        // Modifying values in a HashMap
        hashMap.put("Banana", 25);
        System.out.println("Modified HashMap: " + hashMap);

        // Removing entries from a HashMap
        hashMap.remove("Cherry");
        System.out.println("HashMap after removal: " + hashMap);

        // Iterating over a HashMap using keySet()
        Set<String> hashMapKeys = hashMap.keySet();
        for (String key : hashMapKeys) {
            int value = hashMap.get(key);
            System.out.println(key + ": " + value);
        }

        // HashSet Examples
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        System.out.println("HashSet: " + hashSet);

        // Checking if an element exists in a HashSet
        boolean containsApple = hashSet.contains("Apple");
        System.out.println("HashSet contains Apple: " + containsApple);

        // Removing an element from a HashSet
        hashSet.remove("Banana");
        System.out.println("HashSet after removal: " + hashSet);

        // Iterating over a HashSet using enhanced for loop
        for (String elementHashset : hashSet) {
            System.out.println(elementHashset);
        }

        // TreeMap Examples
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Apple", 5);
        treeMap.put("Banana", 3);
        treeMap.put("Cherry", 2);
        System.out.println("TreeMap: " + treeMap);

        // Accessing values in a TreeMap
        int bananaQuantity = treeMap.get("Banana");
        System.out.println("Quantity of Banana: " + bananaQuantity);

        // Modifying values in a TreeMap
        treeMap.put("Cherry", 10);
        System.out.println("Modified TreeMap: " + treeMap);

        // Removing entries from a TreeMap
        treeMap.remove("Apple");
        System.out.println("TreeMap after removal: " + treeMap);

        // Iterating over a TreeMap using entrySet()
        Set<Map.Entry<String, Integer>> treeMapEntries = treeMap.entrySet();
        for (Map.Entry<String, Integer> entry : treeMapEntries) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }

        // LinkedHashSet Examples
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // Removing an element from a LinkedHashSet
        linkedHashSet.remove("Banana");
        System.out.println("LinkedHashSet after removal: " + linkedHashSet);

        // Iterating over a LinkedHashSet using Iterator
        Iterator<String> linkedHashSetIterator = linkedHashSet.iterator();
        while (linkedHashSetIterator.hasNext()) {
            System.out.println(linkedHashSetIterator.next());
        }

        // PriorityQueue Examples
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("Apple");
        priorityQueue.offer("Banana");
        priorityQueue.offer("Cherry");
        System.out.println("PriorityQueue: " + priorityQueue);

        // Accessing elements in a PriorityQueue
        String headElement = priorityQueue.peek();
        System.out.println("Head element: " + headElement);

        // Removing elements from a PriorityQueue
        String removedElementPQueue = priorityQueue.poll();
        System.out.println("Removed element: " + removedElementPQueue);
        System.out.println("PriorityQueue after removal: " + priorityQueue);

        // Iterating over a PriorityQueue using forEach()
        priorityQueue.forEach(System.out::println);

        // ArrayDeque Examples
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("Apple");
        arrayDeque.add("Banana");
        arrayDeque.add("Cherry");
        System.out.println("ArrayDeque: " + arrayDeque);

        // Accessing elements in an ArrayDeque
        String firstElementArrayDeque = arrayDeque.getFirst();
        String lastElementArrayDeque = arrayDeque.getLast();
        System.out.println("First element: " + firstElementArrayDeque);
        System.out.println("Last element: " + lastElementArrayDeque);

        // Removing elements from an ArrayDeque
        String removedFirstArrayDeque = arrayDeque.removeFirst();
        String removedLastArrayDeque = arrayDeque.removeLast();
        System.out.println("Removed first element: " + removedFirstArrayDeque);
        System.out.println("Removed last element: " + removedLastArrayDeque);
        System.out.println("ArrayDeque after removal: " + arrayDeque);

        // Iterating over an ArrayDeque using descendingIterator()
        Iterator<String> descendingIteratorArrayDeque = arrayDeque.descendingIterator();
        while (descendingIteratorArrayDeque.hasNext()) {
            System.out.println(descendingIteratorArrayDeque.next());
        }

        // BitSet Examples
        BitSet bitSet1 = new BitSet(8);
        BitSet bitSet2 = new BitSet(8);

        bitSet1.set(0);
        bitSet1.set(2);
        bitSet1.set(4);
        bitSet1.set(6);

        bitSet2.set(1);
        bitSet2.set(3);
        bitSet2.set(5);
        bitSet2.set(7);

        System.out.println("BitSet 1: " + bitSet1);
        System.out.println("BitSet 2: " + bitSet2);

        bitSet1.and(bitSet2);
        System.out.println("BitSet 1 AND BitSet 2: " + bitSet1);

        bitSet1.or(bitSet2);
        System.out.println("BitSet 1 OR BitSet 2: " + bitSet1);

        // EnumSet Examples
        EnumSet<Day> daysOfWeek = EnumSet.allOf(Day.class);
        System.out.println("Days of Week: " + daysOfWeek);

        EnumSet<Day> workingDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Working Days: " + workingDays);

        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);

        // IdentityHashMap Examples
        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put("One", 1);
        identityHashMap.put(new String("One"), 2);
        System.out.println("IdentityHashMap: " + identityHashMap);

        // WeakHashMap Examples
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key1 = 1;
        Integer key2 = 2;
        weakHashMap.put(key1, "Value 1");
        weakHashMap.put(key2, "Value 2");
        System.out.println("WeakHashMap: " + weakHashMap);

        key1 = null;
        System.gc();
        System.out.println("WeakHashMap after garbage collection: " + weakHashMap);

        // LinkedHashMap Examples
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Two", 2);
        linkedHashMap.put("Three", 3);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Access Order Mode
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        accessOrderMap.put("One", 1);
        accessOrderMap.put("Two", 2);
        accessOrderMap.put("Three", 3);
        System.out.println("Access Order LinkedHashMap: " + accessOrderMap);

        accessOrderMap.get("Two");
        accessOrderMap.get("One");
        System.out.println("Access Order LinkedHashMap after access: " + accessOrderMap);

        // TreeMap with Comparator Examples
        TreeMap<String, Integer> treeMapGen = new TreeMap<>(Comparator.reverseOrder());
        treeMapGen.put("One", 1);
        treeMapGen.put("Two", 2);
        treeMapGen.put("Three", 3);
        System.out.println("TreeMap with Comparator: " + treeMapGen);

        // ArrayDeque as Stack Examples
        ArrayDeque<String> stackArrayDeque = new ArrayDeque<>();
        stackArrayDeque.push("One");
        stackArrayDeque.push("Two");
        stackArrayDeque.push("Three");
        System.out.println("Stack (ArrayDeque): " + stackArrayDeque);

        String poppedElementArrayDeque = stackArrayDeque.pop();
        System.out.println("Popped element: " + poppedElementArrayDeque);
        System.out.println("Stack after pop: " + stackArrayDeque);

        // ArrayDeque as Queue Examples
        ArrayDeque<String> queueArrayDeque = new ArrayDeque<>();
        queueArrayDeque.offer("One");
        queueArrayDeque.offer("Two");
        queueArrayDeque.offer("Three");
        System.out.println("Queue (ArrayDeque): " + queueArrayDeque);

        String polledElement = queue.poll();
        System.out.println("Polled element: " + polledElement);
        System.out.println("Queue after poll: " + queue);

        // LinkedList as Stack Examples
        LinkedList<String> stackUsingLinkedList = new LinkedList<>();
        stackUsingLinkedList.push("One");
        stackUsingLinkedList.push("Two");
        stackUsingLinkedList.push("Three");
        System.out.println("Stack (LinkedList): " + stackUsingLinkedList);

        String poppedElementUsingLinkedList = stackUsingLinkedList.pop();
        System.out.println("Popped element (LinkedList): " + poppedElementUsingLinkedList);
        System.out.println("Stack after pop (LinkedList): " + stackUsingLinkedList);

        // LinkedList as Queue Examples
        LinkedList<String> queueUsingLinkedList = new LinkedList<>();
        queueUsingLinkedList.offer("One");
        queueUsingLinkedList.offer("Two");
        queueUsingLinkedList.offer("Three");
        System.out.println("Queue (LinkedList): " + queueUsingLinkedList);

        String polledElementUsingLinkedList = queueUsingLinkedList.poll();
        System.out.println("Polled element (LinkedList): " + polledElementUsingLinkedList);
        System.out.println("Queue after poll (LinkedList): " + queueUsingLinkedList);

        // EnumMap Examples
        EnumMap<Day, String> enumMap = new EnumMap<>(Day.class);
        enumMap.put(Day.MONDAY, "Monday");
        enumMap.put(Day.TUESDAY, "Tuesday");
        enumMap.put(Day.WEDNESDAY, "Wednesday");
        System.out.println("EnumMap: " + enumMap);

        // CopyOnWriteArrayList Examples
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("One");
        copyOnWriteArrayList.add("Two");
        copyOnWriteArrayList.add("Three");
        System.out.println("CopyOnWriteArrayList: " + copyOnWriteArrayList);

        // CopyOnWriteArraySet Examples
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add("One");
        copyOnWriteArraySet.add("Two");
        copyOnWriteArraySet.add("Three");
        System.out.println("CopyOnWriteArraySet: " + copyOnWriteArraySet);

        // ConcurrentHashMap Examples
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("One", 1);
        concurrentHashMap.put("Two", 2);
        concurrentHashMap.put("Three", 3);
        System.out.println("ConcurrentHashMap: " + concurrentHashMap);

        // ConcurrentSkipListMap Examples
        ConcurrentSkipListMap<String, Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put("One", 1);
        concurrentSkipListMap.put("Two", 2);
        concurrentSkipListMap.put("Three", 3);
        System.out.println("ConcurrentSkipListMap: " + concurrentSkipListMap);

        // ConcurrentLinkedQueue Examples
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.offer("One");
        concurrentLinkedQueue.offer("Two");
        concurrentLinkedQueue.offer("Three");
        System.out.println("ConcurrentLinkedQueue: " + concurrentLinkedQueue);

        // BlockingQueue Examples
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("One");
        blockingQueue.offer("Two");
        blockingQueue.offer("Three");
        System.out.println("BlockingQueue: " + blockingQueue);

        try {
            blockingQueue.put("Four");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("BlockingQueue after put: " + blockingQueue);

        try {
            String removedElementBlockingQueue = blockingQueue.take();
            System.out.println("Removed element: " + removedElementBlockingQueue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("BlockingQueue after take: " + blockingQueue);

        // BlockingDeque Examples
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(3);
        blockingDeque.offer("One");
        blockingDeque.offer("Two");
        blockingDeque.offer("Three");
        System.out.println("BlockingDeque: " + blockingDeque);

        try {
            blockingDeque.putFirst("Zero");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("BlockingDeque after putFirst: " + blockingDeque);

        try {
            String removedLastElement = blockingDeque.takeLast();
            System.out.println("Removed last element: " + removedLastElement);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("BlockingDeque after takeLast: " + blockingDeque);

        // PriorityQueue with Comparator Examples
        PriorityQueue<Integer> priorityQueueWithComparator = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueueWithComparator.offer(3);
        priorityQueueWithComparator.offer(1);
        priorityQueueWithComparator.offer(2);
        System.out.println("PriorityQueue with Comparator: " + priorityQueueWithComparator);

        // Deque as Stack Examples
        Deque<String> stackUsingDeque = new ArrayDeque<>();
        stackUsingDeque.push("One");
        stackUsingDeque.push("Two");
        stackUsingDeque.push("Three");
        System.out.println("Stack (Deque): " + stackUsingDeque);

        String poppedElementUsingDeque = stackUsingDeque.pop();
        System.out.println("Popped element (Deque): " + poppedElementUsingDeque);
        System.out.println("Stack after pop (Deque): " + stackUsingDeque);

        // Deque as Queue Examples
        Deque<String> queueUsingDeque = new ArrayDeque<>();
        queueUsingDeque.offer("One");
        queueUsingDeque.offer("Two");
        queueUsingDeque.offer("Three");
        System.out.println("Queue (Deque): " + queueUsingDeque);

        String polledElementUsingDeque = queueUsingDeque.poll();
        System.out.println("Polled element (Deque): " + polledElementUsingDeque);
        System.out.println("Queue after poll (Deque): " + queueUsingDeque);

        // NavigableSet Examples
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.add(5);
        navigableSet.add(2);
        navigableSet.add(7);
        navigableSet.add(1);
        navigableSet.add(8);
        System.out.println("NavigableSet: " + navigableSet);

        System.out.println("Lower (4): " + navigableSet.lower(4));
        System.out.println("Higher (4): " + navigableSet.higher(4));
        System.out.println("Floor (4): " + navigableSet.floor(4));
        System.out.println("Ceiling (4): " + navigableSet.ceiling(4));

        // NavigableMap Examples
        NavigableMap<String, Integer> navigableMap = new TreeMap<>();
        navigableMap.put("One", 1);
        navigableMap.put("Two", 2);
        navigableMap.put("Three", 3);
        System.out.println("NavigableMap: " + navigableMap);

        System.out.println("Lower key (\"Two\"): " + navigableMap.lowerKey("Two"));
        System.out.println("Higher key (\"Two\"): " + navigableMap.higherKey("Two"));
        System.out.println("Floor key (\"Two\"): " + navigableMap.floorKey("Two"));
        System.out.println("Ceiling key (\"Two\"): " + navigableMap.ceilingKey("Two"));

        // ConcurrentMap Examples
        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("One", 1);
        concurrentMap.put("Two", 2);
        concurrentMap.put("Three", 3);
        System.out.println("ConcurrentMap: " + concurrentMap);

        // SortedSet Examples
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(5);
        sortedSet.add(2);
        sortedSet.add(7);
        sortedSet.add(1);
        sortedSet.add(8);
        System.out.println("SortedSet: " + sortedSet);

        System.out.println("First element: " + sortedSet.first());
        System.out.println("Last element: " + sortedSet.last());
        System.out.println("Head Set (5): " + sortedSet.headSet(5));
        System.out.println("Tail Set (5): " + sortedSet.tailSet(5));
        System.out.println("Sub Set (2-7): " + sortedSet.subSet(2, 7));

        // SortedMap Examples
        SortedMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("One", 1);
        sortedMap.put("Two", 2);
        sortedMap.put("Three", 3);
        System.out.println("SortedMap: " + sortedMap);

        System.out.println("First key: " + sortedMap.firstKey());
        System.out.println("Last key: " + sortedMap.lastKey());
        System.out.println("Head Map (\"Two\"): " + sortedMap.headMap("Two"));
        System.out.println("Tail Map (\"Two\"): " + sortedMap.tailMap("Two"));
        System.out.println("Sub Map (\"One\"-\"Three\"): " + sortedMap.subMap("One", "Three"));

        // Creating Optionals
        Optional<String> emptyOptional = Optional.empty();
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");

        // Checking if an Optional is Present
        boolean isPresent = nonEmptyOptional.isPresent();
        System.out.println("Is Present: " + isPresent);

        // Getting the Value from an Optional
        String value = nonEmptyOptional.get();
        System.out.println("Value: " + value);

        // Handling an Empty Optional with orElse
        String orElseValue = emptyOptional.orElse("Default Value");
        System.out.println("OrElse Value: " + orElseValue);

        // Handling an Empty Optional with orElseGet
        String orElseGetValue = emptyOptional.orElseGet(() -> "Default Value from Supplier");
        System.out.println("OrElseGet Value: " + orElseGetValue);

        // Throwing an Exception for an Empty Optional with orElseThrow
        String orElseThrowValue = emptyOptional.orElseThrow(IllegalStateException::new);

        // Transforming the Value of an Optional with map
        Optional<String> transformedOptional = nonEmptyOptional.map(optionalValue -> optionalValue.toUpperCase());
        System.out.println("Transformed Value: " + transformedOptional.orElse("No Value"));

        // Applying Optional Logic with ifPresent
        nonEmptyOptional.ifPresent(optionalValue -> System.out.println("If Present: " + optionalValue));

        // Filtering an Optional with filter
        Optional<String> filteredOptional = nonEmptyOptional.filter(optionalValue -> optionalValue.length() > 5);
        System.out.println("Filtered Value: " + filteredOptional.orElse("No Value"));

        // Chaining Optional Operations
        Optional<String> chainedOptional = nonEmptyOptional
                .filter(optionalValue -> value.length() > 5)
                .map(optionalValue -> value.substring(0, 5))
                .flatMap(optionalValue -> Optional.of(value + "!!!"));
        System.out.println("Chained Value: " + chainedOptional.orElse("No Value"));
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

    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    static void cleanup() {
        System.out.println("Performing cleanup...");
    }

    static void readData(String filename) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filename);
    }

    static void readMultipleFiles() throws IOException {
        IOException exception1 = null;
        IOException exception2 = null;
        IOException exception3 = null;

        try {
            readData("file1.txt");
        } catch (IOException e) {
            exception1 = e;
        }

        try {
            readData("file2.txt");
        } catch (IOException e) {
            exception2 = e;
        }

        try {
            readData("file3.txt");
        } catch (IOException e) {
            exception3 = e;
        }

        if (exception1 != null) {
            exception1.addSuppressed(exception2);
            exception1.addSuppressed(exception3);
            throw exception1;
        }
    }

    static void processFile(String filename) throws IOException {
        try {
            readData(filename);
        } catch (FileNotFoundException e) {
            throw new IOException("File not found", e);
        }
    }

    static void validateName(String name) throws InvalidNameException {
        if (name.length() < 3) {
            throw new InvalidNameException("Invalid name: " + name);
        }
    }

    static class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    static void recurse() {
        recurse();
    }

    public static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
            return -1;
        }
    }

    // Exception Handling
    public static void demonstrateExceptionHandling() {
        // Catching Multiple Exceptions
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[4]);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Exception caught: " + e);
        }

        // Custom Exception
        try {
            int age = -5;
            if (age < 0) {
                throw new InvalidAgeException("Invalid age: " + age);
            }
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Finally Block
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Exception caught while closing reader: " + e);
            }
        }

        // Custom Finally Block
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            cleanup();
        }

        // Propagating Exceptions
        try {
            readData("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e);
        }

        // Try-With-Resources
        try (BufferedReader reader2 = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader2.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Exception caught: " + e);
        }

        // Suppressed Exceptions
        try {
            readMultipleFiles();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e);
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("Suppressed Exception: " + throwable);
            }
        }

        // Rethrowing Exceptions
        try {
            processFile("file.txt");
        } catch (IOException e) {
            System.out.println("Exception caught: " + e);
        }

        // Handling Exception in a Loop
        String[] names = {"Alice", "Bob", "Charlie"};
        for (String name : names) {
            try {
                validateName(name);
            } catch (InvalidNameException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }

        // Catching Errors
        try {
            recurse();
        } catch (StackOverflowError e) {
            System.out.println("Exception caught: " + e);
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
        // Runnable Lambda
        Runnable runnable = () -> System.out.println("Hello from Runnable Lambda!");
        runnable.run();

        // Single Abstract Method (SAM) Interface
        Consumer<String> consumer = message -> System.out.println("Consumer Lambda: " + message);
        consumer.accept("Hello, World!");

        // Functional Interface as Parameter
        greet("John", name -> System.out.println("Hello, " + name + "!"));

        // Lambda with Multiple Parameters
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("Addition Result: " + add.apply(5, 3));

        // Predicate Lambda
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        // UnaryOperator Lambda
        UnaryOperator<Integer> square = number -> number * number;
        System.out.println("Square of 5: " + square.apply(5));

        // BinaryOperator Lambda
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        System.out.println("Multiplication Result: " + multiply.apply(5, 3));

        // Lambda with Statement Block
        Function<Integer, String> evenOdd = number -> {
            if (number % 2 == 0) {
                return "Even";
            } else {
                return "Odd";
            }
        };
        System.out.println("Is 7 even or odd? " + evenOdd.apply(7));

        // Lambda with Exception Handling
        Function<Integer, Integer> divideByZero = number -> {
            try {
                return number / 0;
            } catch (ArithmeticException e) {
                System.out.println("Exception caught: " + e);
                return -1;
            }
        };
        System.out.println("Result: " + divideByZero.apply(10));

        // Method Reference
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.forEach(System.out::println);

        // Lambda with Instance Method Reference
        GreetingService greetingService = new GreetingService();
        greet("John", greetingService::sayHello);

        // Lambda with Constructor Reference
        Supplier<PersonLambda> personSupplier = PersonLambda::new;
        PersonLambda person = personSupplier.get();
        person.setName("Alice");
        System.out.println("Person: " + person.getName());
    }

    static void greet(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    static class GreetingService {
        void sayHello(String name) {
            System.out.println("Hello, " + name + "!");
        }
    }

    static class PersonLambda {
        private String name;

        public PersonLambda() {
        }

        public PersonLambda(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Functional Interfaces
    @FunctionalInterface
    interface Operation {
        int perform(int a, int b);
    }

    public static void functionalInterfaceDemo(){
        // Functional Interfaces
        // Predicate
        Predicate<Integer> isPositive = num -> num > 0;
        System.out.println("Is 5 positive? " + isPositive.test(5));

        // BiPredicate
        BiPredicate<String, Integer> isStringLengthValid = (str, len) -> str.length() == len;
        System.out.println("Is 'Hello' of length 5? " + isStringLengthValid.test("Hello", 5));

        // Consumer
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello");

        // BiConsumer
        BiConsumer<String, Integer> printFormatted = (str, num) -> System.out.println(str + ": " + num);
        printFormatted.accept("Count", 10);

        // Supplier
        Supplier<Double> getRandomNumber = Math::random;
        System.out.println("Random number: " + getRandomNumber.get());

        // Function
        Function<Integer, String> convertToString = Object::toString;
        System.out.println("String representation of 10: " + convertToString.apply(10));

        // BiFunction
        BiFunction<String, Integer, Boolean> isStringLengthGreaterThan = (str, len) -> str.length() > len;
        System.out.println("Is 'Hello' length greater than 3? " + isStringLengthGreaterThan.apply("Hello", 3));

        // UnaryOperator
        UnaryOperator<Integer> square = num -> num * num;
        System.out.println("Square of 5: " + square.apply(5));

        // BinaryOperator
        BinaryOperator<Integer> sum = Integer::sum;
        System.out.println("Sum of 5 and 3: " + sum.apply(5, 3));

        // IntPredicate
        IntPredicate isEven = num -> num % 2 == 0;
        System.out.println("Is 10 even? " + isEven.test(10));

        // LongPredicate
        LongPredicate isPositiveLong = num -> num > 0;
        System.out.println("Is 1000 positive? " + isPositiveLong.test(1000));

        // DoublePredicate
        DoublePredicate isNegativeDouble = num -> num < 0;
        System.out.println("Is -3.14 negative? " + isNegativeDouble.test(-3.14));

        // IntConsumer
        IntConsumer printSquare = num -> System.out.println("Square: " + (num * num));
        printSquare.accept(5);

        // LongConsumer
        LongConsumer printCube = num -> System.out.println("Cube: " + (num * num * num));
        printCube.accept(3);

        // DoubleConsumer
        DoubleConsumer printSquareRoot = num -> System.out.println("Square Root: " + Math.sqrt(num));
        printSquareRoot.accept(25);

        // IntSupplier
        IntSupplier getRandomNumberInRange = () -> (int) (Math.random() * 100);
        System.out.println("Random number in range [0, 100): " + getRandomNumberInRange.getAsInt());

        // LongSupplier
        LongSupplier getCurrentTimeInMillis = System::currentTimeMillis;
        System.out.println("Current time in milliseconds: " + getCurrentTimeInMillis.getAsLong());

        // DoubleSupplier
        DoubleSupplier getPiValue = () -> Math.PI;
        System.out.println("Pi value: " + getPiValue.getAsDouble());

        // IntFunction
        IntFunction<String> convertToHex = Integer::toHexString;
        System.out.println("Hex representation of 15: " + convertToHex.apply(15));

        // LongFunction
        LongFunction<String> convertToBinary = Long::toBinaryString;
        System.out.println("Binary representation of 10: " + convertToBinary.apply(10));

        // DoubleFunction
        DoubleFunction<String> formatDecimal = num -> String.format("%.2f", num);
        System.out.println("Formatted decimal: " + formatDecimal.apply(3.14159));

        // ToIntFunction
        ToIntFunction<String> getStringLength = String::length;
        System.out.println("Length of 'Hello': " + getStringLength.applyAsInt("Hello"));

        // ToLongFunction
        ToLongFunction<String> convertToLong = Long::parseLong;
        System.out.println("Long value of '1000': " + convertToLong.applyAsLong("1000"));

        // ToDoubleFunction
        ToDoubleFunction<String> convertToDouble = Double::parseDouble;
        System.out.println("Double value of '3.14': " + convertToDouble.applyAsDouble("3.14"));

        // IntUnaryOperator
        IntUnaryOperator incrementByFive = num -> num + 5;
        System.out.println("Increment 10 by 5: " + incrementByFive.applyAsInt(10));

        // LongUnaryOperator
        LongUnaryOperator decrementByTen = num -> num - 10;
        System.out.println("Decrement 20 by 10: " + decrementByTen.applyAsLong(20));

        // DoubleUnaryOperator
        DoubleUnaryOperator squareRoot = Math::sqrt;
        System.out.println("Square root of 100: " + squareRoot.applyAsDouble(100));

        // IntBinaryOperator
        IntBinaryOperator multiply = (a, b) -> a * b;
        System.out.println("Multiply 5 by 3: " + multiply.applyAsInt(5, 3));

        // LongBinaryOperator
        LongBinaryOperator add = Long::sum;
        System.out.println("Add 1000 and 2000: " + add.applyAsLong(1000, 2000));

        // DoubleBinaryOperator
        DoubleBinaryOperator divide = (a, b) -> a / b;
        System.out.println("Divide 10 by 2: " + divide.applyAsDouble(10, 2));
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

        // Thread creation and start
        Thread thread1 = new Thread(() -> System.out.println("Hello from Thread 1"));
        thread1.start();

        // Sleeping a thread
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Hello from Thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();

        // Joining threads
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Hello from Thread 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Hello from Thread 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread priority
        Thread thread5 = new Thread(() -> System.out.println("Hello from Thread 5 (Low Priority)"));
        Thread thread6 = new Thread(() -> System.out.println("Hello from Thread 6 (High Priority)"));

        thread5.setPriority(Thread.MIN_PRIORITY);
        thread6.setPriority(Thread.MAX_PRIORITY);

        thread5.start();
        thread6.start();

        // Thread synchronization with synchronized keyword
        Counter counter = new Counter();

        Thread thread7 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread8 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread7.start();
        thread8.start();

        try {
            thread7.join();
            thread8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter value: " + counter.getCount());

        // Thread synchronization with wait() and notify()
        Message message = new Message();

        Thread thread9 = new Thread(() -> {
            synchronized (message) {
                try {
                    message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Message received: " + message.getContent());
            }
        });

        Thread thread10 = new Thread(() -> {
            synchronized (message) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                message.setContent("Hello, World!");
                message.notify();
            }
        });

        thread9.start();
        thread10.start();

        // Thread interruption
        Thread thread11 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread 11 is running...");
            }
            System.out.println("Thread 11 is interrupted.");
        });

        thread11.start();
        thread11.interrupt();

        // ThreadLocal
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

        Thread thread12 = new Thread(() -> {
            threadLocal.set(10);
            System.out.println("Thread 12: " + threadLocal.get());
        });

        Thread thread13 = new Thread(() -> {
            threadLocal.set(20);
            System.out.println("Thread 13: " + threadLocal.get());
        });

        thread12.start();
        thread13.start();

        try {
            thread12.join();
            thread13.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Thread pool
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.execute(() -> System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName()));
        }

        executor.shutdown();
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
    public static <T> void printGenricList(List<T> list) {
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

        demonstateCollection();

        // Example 1: Inheritance
        Character jonSnow = new Character("Jon Snow", "Night's Watch");
        jonSnow.displayHouse();

        // Example 2: Polymorphism
        Character aryaStark = new Assassin("Arya Stark", "House Stark");
        aryaStark.displayHouse();

        // Example 3: Encapsulation
        Weapon weapon = new Weapon();
        weapon.setName("Needle");
        weapon.setDamage(100);
        weapon.displayDetails();

        // Example 4: Abstraction
        Beast dragon = new Dragon();
        dragon.makeSound();

        // Example 5: Interface
        Skill fightingSkill = new FightingSkill();
        fightingSkill.train();
        fightingSkill.attack();

        // Example 6: Method Overriding
        Character tyrionLannister = new Character("Tyrion Lannister", "House Lannister");
        tyrionLannister.displayHouse();

        Assassin jaqenHghar = new Assassin("Jaqen H'ghar", "Faceless Men");
        jaqenHghar.displayHouse();

        // Example 7: Abstract Class
        Creature creature = new Direwolf();
        creature.makeSound();

        // Example 8: Method Overloading
        MasterOfWhispers varys = new MasterOfWhispers();
        varys.spy("Daenerys Targaryen");
        varys.spy("Cersei Lannister", 10);

        // Example 9: Class Hierarchy
        ValyrianSteelWeapon longclaw = new Sword("Longclaw", 10.5);
        ValyrianSteelWeapon needle = new Dagger("Needle", 5.0);
        longclaw.useWeapon();
        needle.useWeapon();

        // Example 10: Constructors
        Skills swordsmanship = new Skills("Swordsmanship");
        System.out.println("Skill Name: " + swordsmanship.getName());

        Skills archery = new Skills("Archery", 80);
        System.out.println("Archery Skill: " + archery.getName() + ", Level: " + archery.getLevel());


        demonstrateExceptionHandling();

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

        functionalInterfaceDemo();

        launchThread();

        Car car = new Car();
        car.start();
        car.stop();
        Vehicle.repair();

        EnglishGreeting englishGreeting = new EnglishGreeting();
        englishGreeting.sayHello();

        // Default and Static Methods
        Wizard harry = new Wizard("Harry Potter");
        harry.castSpell("Expelliarmus");
        harry.flyOnBroomstick();

        Witch hermione = new Witch("Hermione Granger");
        hermione.castSpell("Wingardium Leviosa");
        hermione.potionBrewing();

        Witch ron = new Witch("Ron Weasley");
        ron.castSpell("Lumos");
        ron.apparate();

        Magician.duel(harry, hermione);
        Magician.duel(ron, harry);

        MagicalCreature unicorn = new MagicalCreature("Unicorn");
        unicorn.makeSound();

        MagicalCreature phoenix = new MagicalCreature("Phoenix");
        phoenix.makeSound();

        EnchantedObject wand = new EnchantedObject("Wand");
        wand.use();

        EnchantedObject broomstick = new EnchantedObject("Broomstick");
        broomstick.use();

        Potion polyjuicePotion = new Potion("Polyjuice Potion");
        polyjuicePotion.brew();

        Potion felixFelicis = new Potion("Felix Felicis");
        felixFelicis.brew();

        Spell fireballSpell = new Spell("Fireball Spell");
        fireballSpell.cast();

        Spell levitationSpell = new Spell("Levitation Spell");
        levitationSpell.cast();

        PotionShop potionShop = new PotionShop();
        potionShop.sellPotion(polyjuicePotion);
        potionShop.sellPotion(felixFelicis);

        DuelingClub duelingClub = new DuelingClub();
        duelingClub.organizeDuel(harry, ron);
        duelingClub.organizeDuel(hermione, ron);

        DefenseAgainstDarkArts.teacherPresent();
        DefenseAgainstDarkArts.learnSpell("Patronus Charm");

        HogwartsLocation hogwarts = new HogwartsLocation();
        hogwarts.enter(harry);
        hogwarts.enter(hermione);

        QuidditchGame quidditchGame = new QuidditchGame();
        quidditchGame.play();

        StudyGroup studyGroup = new StudyGroup();
        studyGroup.study(harry);
        studyGroup.study(ron);

        OrderOfThePhoenix.orderMember(harry);
        OrderOfThePhoenix.orderMember(hermione);

        Horcrux.create(harry);
        Horcrux.create(hermione);


        printStringLength();

        sendHttpRequest();

        String dayOfWeek = getDayOfWeek(3);
        System.out.println("Day of Week: " + dayOfWeek);

        Person person = new Person("John", 30);
        System.out.println("Person: " + person);

        // Advanced Concepts Examples

        // Example 1: Generic Class
        Box<String> wandBox = new Box<>("Elder Wand");
        String content = wandBox.getContent();
        System.out.println("Wand: " + content);

        // Example 2: Generic Method
        String[] spells = {"Expelliarmus", "Lumos", "Expecto Patronum"};
        List<String> spellList = arrayToList(spells);
        System.out.println("Spells: " + spellList);

        // Example 3: Bounded Type Parameter
        String mostPowerfulSpell = getMax(spells);
        System.out.println("Most Powerful Spell: " + mostPowerfulSpell);

        // Example 4: Multiple Type Parameters
        Pair<String, Integer> harryPair = new Pair<>("Harry Potter", 17);
        String name = harryPair.getFirst();
        Integer ageG = harryPair.getSecond();
        System.out.println("Name: " + name + ", Age: " + ageG);

        // Example 5: Generic Interface
        Calculator<Integer> intCalculator = new IntegerCalculator();
        int sum = intCalculator.add(7, 4);
        System.out.println("Spell Count: " + sum);

        Calculator<Double> doubleCalculator = new DoubleCalculator();
        double product = doubleCalculator.multiply(2.5, 4.0);
        System.out.println("Product: " + product);

        // Example 6: Generic Wildcards
        List<String> spellBook = new ArrayList<>();
        spellBook.add("Expelliarmus");
        spellBook.add("Lumos");
        spellBook.add("Expecto Patronum");

        List<Integer> wandLengths = new ArrayList<>();
        wandLengths.add(13);
        wandLengths.add(11);
        wandLengths.add(9);

        printGenricList(spellBook);
        printGenricList(wandLengths);

        // Example 7: Generic Bounds with Interfaces
        Wand elderWand = new Wand("Elder Wand", 15.0);
        Broom nimbus2000 = new Broom("Nimbus 2000", 10.5);
        System.out.println("Elder Wand Length: " + calculateLength(elderWand));
        System.out.println("Nimbus 2000 Length: " + calculateLength(nimbus2000));

        // Example 8: Generic Bounds with Classes
        List<Wand> wandList = new ArrayList<>();
        wandList.add(new Wand("Holly Wand", 13.0));
        wandList.add(new Wand("Vine Wand", 11.5));

        List<Broom> broomList = new ArrayList<>();
        broomList.add(new Broom("Firebolt", 12.0));
        broomList.add(new Broom("Cleansweep Seven", 10.0));

        printItems(wandList);
        printItems(broomList);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        printList(numbers);

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        filterAndPrint(names);

        // Example 1: Stream creation
        Stream<String> stream1 = Stream.of("Winter", "is", "coming");
        stream1.forEach(System.out::println);

        // Example 2: Stream from array
        String[] namesCharacters = {"Jon Snow", "Arya Stark", "Tyrion Lannister"};
        Stream<String> stream2 = Arrays.stream(namesCharacters);
        stream2.forEach(System.out::println);

        // Example 3: Stream from collection
        List<String> characters = Arrays.asList("Daenerys Targaryen", "Cersei Lannister", "Sansa Stark");
        Stream<String> stream3 = characters.stream();
        stream3.forEach(System.out::println);

        // Example 4: Stream from range
        IntStream stream4 = IntStream.range(1, 5);
        stream4.forEach(System.out::println);

        // Example 5: Stream from random numbers
        Random random = new Random();
        DoubleStream stream5 = random.doubles(3);
        stream5.forEach(System.out::println);

        // Example 6: Stream from generated values
        Stream<String> stream6 = Stream.generate(() -> "Hodor").limit(3);
        stream6.forEach(System.out::println);

        // Example 7: Filter elements
        List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numberss.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Example 8: Map elements
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers);

        // Example 9: Sort elements
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);

        // Example 10: Reduce elements
        Optional<Integer> sumOptional = numbers.stream()
                .reduce((a, b) -> a + b);
        sumOptional.ifPresent(value -> System.out.println("Sum: " + value));

        // Example 11: Count elements
        long count = numbers.stream().count();
        System.out.println("Count: " + count);

        // Example 12: Find minimum and maximum elements
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        min.ifPresent(value -> System.out.println("Minimum: " + value));

        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        max.ifPresent(value -> System.out.println("Maximum: " + value));

        // Example 13: Any and All Match
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 5);
        System.out.println("Any match > 5: " + anyMatch);

        boolean allMatch = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All match > 0: " + allMatch);

        // Example 14: Distinct elements
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5);
        List<Integer> distinctNumbers = duplicateNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);

        // Example 15: Skip and Limit elements
        List<Integer> skipLimitNumbers = numbers.stream()
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Skip and limit numbers: " + skipLimitNumbers);

        // Example 16: FlatMap elements
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        List<Integer> flattenedNumbers = nestedNumbers.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened numbers: " + flattenedNumbers);

        // Example 17: Group elements by criteria
        Map<String, List<String>> charactersByHouse = characters.stream()
                .collect(Collectors.groupingBy(s -> s.split(" ")[1]));
        System.out.println("Characters by House: " + charactersByHouse);

        // Example 18: Partition elements by condition
        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even-Odd Partition: " + evenOddPartition);

        // Example 19: Joining elements into a string
        String characterNames = characters.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Character names: " + characterNames);

        // Example 20: Peeking into the stream
        List<Integer> peekedNumbers = numbers.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("Peeked numbers: " + peekedNumbers);

        // Additional Examples:
        // Example 21: Summing elements
        int sumOfNumbers = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of numbers: " + sumOfNumbers);

        // Example 22: Finding average
        OptionalDouble average = numbers.stream().mapToDouble(Integer::doubleValue).average();
        average.ifPresent(value -> System.out.println("Average: " + value));

        // Example 23: Finding first element
        Optional<Integer> firstElement = numbers.stream().findFirst();
        firstElement.ifPresent(value -> System.out.println("First element: " + value));

        // Example 24: Finding any element
        Optional<Integer> anyElement = numbers.stream().findAny();
        anyElement.ifPresent(value -> System.out.println("Any element: " + value));

        // Example 25: Combining streams
        Stream<Integer> combinedStream = Stream.concat(numbers.stream(), evenNumbers.stream());
        List<Integer> combinedList = combinedStream.collect(Collectors.toList());
        System.out.println("Combined list: " + combinedList);

        // Example 26: Parallel stream
        List<Integer> squaredNumbersParallel = numbers.parallelStream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared numbers (Parallel): " + squaredNumbersParallel);

        // Example 27: Stream from string characters
        String sentenceDetails = "A Lannister always pays his debts.";
        List<java.lang.Character> characterList = sentenceDetails.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Characters: " + characterList);

        // Example 28: Stream from file
        // Replace the path with the actual file path
        // Path path = Paths.get("file.txt");
        // Stream<String> streamFromFile = Files.lines(path

        java.util.Optional<String> optionalName = java.util.Optional.of("John");
        processOptional(optionalName);


        // Creating Records
        record Character(String name, String house) {}
        Character harry = new Character("Harry Potter", "Gryffindor");
        System.out.println(harry);

        // Accessing Record Components
        String name = harry.name();
        String house = harry.house();
        System.out.println("Name: " + name);
        System.out.println("House: " + house);

        // Updating Record Components
        Character updatedHarry = harry.withHouse("Hufflepuff");
        System.out.println(updatedHarry);

        // Equals and HashCode
        record Book(String title, String author) {}
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling");
        Book book2 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling");
        System.out.println("Equals: " + book1.equals(book2));
        System.out.println("HashCode (book1): " + book1.hashCode());
        System.out.println("HashCode (book2): " + book2.hashCode());

        // toString
        System.out.println(book1);

        // Copying Record Instances
        Book copiedBook = book1;
        System.out.println("Copied Book: " + copiedBook);

        // Destructuring Records
        record Location(int x, int y) {}
        Location diagonAlley = new Location(5, 10);
        var (x, y) = diagonAlley;
        System.out.println("x: " + x + ", y: " + y);

        // Inheritance with Records
        record Wizard(String name, String house, String wand) extends Character(name, house) {}
        Wizard hermione = new Wizard("Hermione Granger", "Gryffindor", "Vine wood");
        System.out.println(hermione);

        // Record Constructors
        record Spell(String name, String type) {
            Spell {
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Invalid spell name");
                }
            }
        }
        Spell expelliarmus = new Spell("Expelliarmus", "Charm");
        System.out.println(expelliarmus);

        // Static Members in Records
        record School(String name, String location) {
            static School hogwarts() {
                return new School("Hogwarts School of Witchcraft and Wizardry", "Scotland");
            }
        }
        School hogwarts = School.hogwarts();
        System.out.println("Hogwarts: " + hogwarts);

        // Custom Methods in Records
        record QuidditchTeam(String name, String house) {
            String getMotto() {
                return "Catch the Snitch!";
            }
        }
        QuidditchTeam gryffindorTeam = new QuidditchTeam("Gryffindor Quidditch Team", "Gryffindor");
        System.out.println("Motto: " + gryffindorTeam.getMotto());

        // Implementing Interfaces with Records
        interface MagicalItem {
            void use();
        }
        record Wand(String wood, String core) implements MagicalItem {
            public void use() {
                System.out.println("Waving the wand!");
            }
        }
        Wand elderWand = new Wand("Elder", "Thestral tail hair");
        elderWand.use();

        
    }

    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class Message {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    interface WizardingWorldCharacter {
        void castSpell(String spellName);
    }

    static class Wizard implements WizardingWorldCharacter {
        private String name;

        public Wizard(String name) {
            this.name = name;
        }

        public void flyOnBroomstick() {
            System.out.println(name + " is flying on a broomstick.");
        }

        @Override
        public void castSpell(String spellName) {
            System.out.println(name + " casts the spell: " + spellName);
        }
    }

    static class Witch implements WizardingWorldCharacter {
        private String name;

        public Witch(String name) {
            this.name = name;
        }

        public void potionBrewing() {
            System.out.println(name + " is brewing a potion.");
        }

        public void apparate() {
            System.out.println(name + " is apparating to a different location.");
        }

        @Override
        public void castSpell(String spellName) {
            System.out.println(name + " casts the spell: " + spellName);
        }
    }

    interface Magician {
        static void duel(WizardingWorldCharacter character1, WizardingWorldCharacter character2) {
            System.out.println(character1.getClass().getSimpleName() + " and " + character2.getClass().getSimpleName() + " are dueling.");
        }
    }

    static class MagicalCreature {
        private String name;

        public MagicalCreature(String name) {
            this.name = name;
        }

        public void makeSound() {
            System.out.println("The " + name + " makes a sound.");
        }
    }

    static class EnchantedObject {
        private String name;

        public EnchantedObject(String name) {
            this.name = name;
        }

        public void use() {
            System.out.println("Using the " + name + ".");
        }
    }

    static class Potion {
        private String name;

        public Potion(String name) {
            this.name = name;
        }

        public void brew() {
            System.out.println("Brewing the " + name + " potion.");
        }
    }

    static class Spell {
        private String name;

        public Spell(String name) {
            this.name = name;
        }

        public void cast() {
            System.out.println("Casting the spell: " + name);
        }
    }

    static class PotionShop {
        public void sellPotion(Potion potion) {
            System.out.println("Selling the " + potion.name + ".");
        }
    }

    static class DuelingClub {
        public void organizeDuel(WizardingWorldCharacter character1, WizardingWorldCharacter character2) {
            System.out.println("Organizing a duel between " + character1.getClass().getSimpleName() + " and " + character2.getClass().getSimpleName());
        }
    }

    static class DefenseAgainstDarkArts {
        public static void teacherPresent() {
            System.out.println("Defense Against the Dark Arts teacher is present.");
        }

        public static void learnSpell(String spellName) {
            System.out.println("Learning the spell: " + spellName);
        }
    }

    static class HogwartsLocation {
        public void enter(WizardingWorldCharacter character) {
            System.out.println(character.getClass().getSimpleName() + " enters Hogwarts.");
        }
    }

    static class QuidditchGame {
        public void play() {
            System.out.println("Playing Quidditch!");
        }
    }

    static class StudyGroup {
        public void study(WizardingWorldCharacter character) {
            System.out.println(character.getClass().getSimpleName() + " is studying.");
        }
    }

    static class OrderOfThePhoenix {
        public static void orderMember(WizardingWorldCharacter character) {
            System.out.println(character.getClass().getSimpleName() + " is an Order of the Phoenix member.");
        }
    }

    static class Horcrux {
        public static void create(WizardingWorldCharacter character) {
            System.out.println(character.getClass().getSimpleName() + " creates a Horcrux.");
        }
    }

    
    static class Box<T> {
        private T content;

        public Box(T content) {
            this.content = content;
        }

        public T getContent() {
            return content;
        }
    }

    static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    static <T extends Comparable<T>> T getMax(T[] array) {
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    static class Pair<K, V> {
        private K first;
        private V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }

    interface Calculator<T> {
        T add(T a, T b);

        T multiply(T a, T b);
    }

    static class IntegerCalculator implements Calculator<Integer> {
        @Override
        public Integer add(Integer a, Integer b) {
            return a + b;
        }

        @Override
        public Integer multiply(Integer a, Integer b) {
            return a * b;
        }
    }

    static class DoubleCalculator implements Calculator<Double> {
        @Override
        public Double add(Double a, Double b) {
            return a + b;
        }

        @Override
        public Double multiply(Double a, Double b) {
            return a * b;
        }
    }

    static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    static abstract class MagicalItem {
        private String name;

        public MagicalItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Wand extends MagicalItem {
        private double length;

        public Wand(String name, double length) {
            super(name);
            this.length = length;
        }

        public double getLength() {
            return length;
        }
    }

    static class Broom extends MagicalItem {
        private double speed;

        public Broom(String name, double speed) {
            super(name);
            this.speed = speed;
        }

        public double getSpeed() {
            return speed;
        }
    }

    static <T extends MagicalItem> double calculateLength(T item) {
        if (item instanceof Wand) {
            Wand wand = (Wand) item;
            return wand.getLength();
        } else if (item instanceof Broom) {
            Broom broom = (Broom) item;
            return broom.getSpeed();
        }
        return 0.0;
    }

    static void printItems(List<? extends MagicalItem> items) {
        for (MagicalItem item : items) {
            System.out.println("Name: " + item.getName());
        }
    }


    static class Character {
        private String name;
        private String house;

        public Character(String name, String house) {
            this.name = name;
            this.house = house;
        }

        public void displayHouse() {
            System.out.println(name + " belongs to " + house + ".");
        }
    }

    static class Assassin extends Character {
        public Assassin(String name, String house) {
            super(name, house);
        }

        @Override
        public void displayHouse() {
            System.out.println("An assassin from " + super.house + ".");
        }
    }

    static class Weapon {
        private String name;
        private int damage;

        public void setName(String name) {
            this.name = name;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public void displayDetails() {
            System.out.println("Weapon Name: " + name);
            System.out.println("Damage: " + damage);
        }
    }

    static abstract class Beast {
        public abstract void makeSound();
    }

    static class Dragon extends Beast {
        @Override
        public void makeSound() {
            System.out.println("Dragon's roar!");
        }
    }

    interface Skill {
        void train();

        void attack();
    }

    static class FightingSkill implements Skill {
        @Override
        public void train() {
            System.out.println("Training in fighting skill.");
        }

        @Override
        public void attack() {
            System.out.println("Attacking with fighting skill.");
        }
    }

    static abstract class Creature {
        public abstract void makeSound();
    }

    static class Direwolf extends Creature {
        @Override
        public void makeSound() {
            System.out.println("Direwolf's howl!");
        }
    }

    static class MasterOfWhispers {
        public void spy(String target) {
            System.out.println("Spying on " + target);
        }

        public void spy(String target, int duration) {
            System.out.println("Spying on " + target + " for " + duration + " days.");
        }
    }

    static abstract class ValyrianSteelWeapon {
        private String name;

        public ValyrianSteelWeapon(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract void useWeapon();
    }

    static class Sword extends ValyrianSteelWeapon {
        private double length;

        public Sword(String name, double length) {
            super(name);
            this.length = length;
        }

        @Override
        public void useWeapon() {
            System.out.println("Swinging the sword!");
        }
    }

    static class Dagger extends ValyrianSteelWeapon {
        private double length;

        public Dagger(String name, double length) {
            super(name);
            this.length = length;
        }

        @Override
        public void useWeapon() {
            System.out.println("Stabbing with the dagger!");
        }
    }

    static class Skills {
        private String name;
        private int level;

        public Skills(String name) {
            this.name = name;
        }

        public Skills(String name, int level) {
            this.name = name;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }
    }

}
