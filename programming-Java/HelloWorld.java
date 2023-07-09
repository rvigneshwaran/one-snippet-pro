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
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

import javax.naming.InvalidNameException;

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

        demonstateCollection();

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
