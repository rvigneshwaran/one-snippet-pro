object HelloWorld {
 
   def main(args: Array[String]) {
                  
      // Prints the content inside the quotes
      println("Hello World")
 
      //Syntax for variable declarion
      //Immutable varible can be declared with "val" and mutable varibale can be declared with "var"
      //val or val VariableName : DataType = [Initial Value]
 
      // Data Types (Byte,Short,Int,Long,Float,Double,Char,String,Boolean,unit,null,nothing,any,anyref)
      val decimalInstance = 98;val hexInstance = 0x00FF
      println("decimal "+decimalInstance+" Hexa deciaml "+hexInstance)
       // Short,Double,Float and byte Definition
      var shortInstance : Short = 400;var byteInstance : Byte = 100
      var doubleInstance : Double = 122.1456787987545;
      println("Short "+shortInstance+" Byte "+byteInstance)
      println(" Double "+doubleInstance)
 
      // Double Definition and Usage
      var doubleExponential : Double = 3e6
      println("Double with Exponential "+doubleExponential)
 
      // Character Assignmnets
      var characterinstance = 'A';var characterUnicode = '\u0044';
      println("character Instance "+characterinstance+" Character Unicode "+characterUnicode)
 
      // Boolean Assignmnets
      var booleanTInstance = true;var booleanFInstance = true;
      println("boolean T Instance "+booleanTInstance+" boolean F Instance "+booleanFInstance)
 
      // Multiple Assignment of the objects
      val (object1: Int, object2: String) = Pair(120, "Owlchemy Labs")
      println("object1 "+object1+" object2 "+object2)
 
      //Types of String assignmnets
      var artificialIntelligence = "AIMatter"
      val artificialIntelligenceInd : String = "Halli Labs"
      val javaInstance : java.lang.String = "drawElements"
      println("Artificial Intelligence "+artificialIntelligence+" Artificial Intelligence India "+artificialIntelligenceInd)
      println("javaInstance " +javaInstance)
 
      // Functions with String
      var productivitySuite = "AppBridge"
      println(productivitySuite.length())
      println("Artificial Intelligence India".concat("Halli Labs"))
      println("Artificial Intelligence India".foreach(print))
      println("Artificial Intelligence India".take(10))
      println("Artificial Intelligence India".toLowerCase())
      println("Kaggle" == "Kaggle") // Test string equalit
      var multiLineStrings = """February 12,2001   
                Deja——UsenetUSA——Google Groups """;
 
                // String substitution or Interpolation (3 types : s, f, raw)  
                val companyName = "Fabric"
                val (money: Double, year: Int) = Pair(9.8,2012)
      //The literal ‘s’ allows the usage of variable directly in processing a string.                                                                                                      
      println(s"Crash Analytics, $companyName")
      //The literal ‘f’ interpolator allows to create a formatted String
      println(f"Google has spent around $money billion dollars on R&D in $year")
      //The ‘raw’ interpolator is similar to ‘s’ interpolator except that it performs no escaping of literals within a string.
      println(raw"foo\nbar")
 
      // More String functions
      println("Limes Audio".substring(0,3))
      for (charFromString <- "Cronologics") yield charFromString.toUpper
      // Use for Each to iterate string Objects
      "Eyefluence".foreach(println)
      "FameBit".getBytes.foreach(println)
      println("Urban Engines".charAt(0) )
      println("Apigee".capitalize)
      println("Apigee".distinct)
      println("Apigee".distinct)
 
      val arrayInstance = Array("API.AI "," Natural language processing "," for Google Assistant");
      arrayInstance.mkString;arrayInstance.mkString(",");arrayInstance.mkString(" ");
      arrayInstance.mkString("(", ",", ")")
      println(arrayInstance)
 
      class ScalaUtils (val inputString1 : String , val inputString2 : String ){
 
        val input1 : String = inputString1;
        val input2 : String = inputString2;
 
        // If the function does not return anything we mention as "Unit"
        // Its equivalent to void in Java
        def executeStringFunctions() : Unit = {
          println(input1 * 3) // prints the string 3 times
          println(input1.count(_ == 'a')) //Counts the number of elements
          println(input1.diff("wave")) // Computes the differnce between the string and sequnce        
          println(input1.distinct) // Build a new sequnce without any duplicates
          println(input1.drop(4)) // selects all the elements except first 4 characters
          println(input1.dropRight(4)) // selects all the elements except last 4 characters
          println(input1.dropWhile(_ != ' ')) //Drops longest prefix of elements
          println(input1.filter(_ != 'w') ) //selects elements which satisfy condition
          println(input1.filterNot(_ != 'w') ) //selects elements which does not satisfy condition
          println(input1.apply(2)) // return an element at the index n
          println(input1.foreach(println(_))) // Applies a function to all elements in a String
          println(input1.foreach(println))  // Applies a function to all elements in a String
          println(input1.getBytes.foreach(println)) // Applies a function to all elements in a String
          println(input1.head) // Selects the first element of the sequence
          println(input1.headOption) //Optionally select the first element
          println(input1.combinations(2)) // iterats over combinations
          println(input1.isEmpty) // test whether the sequence is empty
          println(input1.lastIndexOf("r"))  //find index of last occurence of some value
          println(input1.map(_.toUpper)) // Change to upper case
          println(input1.min) // finds the smallest value in the sequence
          println(input1.mkString(",")) // Displays all elements of this string in a String
          println(input1.mkString("->", ",", "<-")) // params Start , end , Separator string
          println(input1.nonEmpty) // tests whether the sequence is non empty
          println(input1.par) // returns the parallel implementation of the collection
          println(input1.partition(_ > 'e')) // Partition the collection into two using the input object
          println(input1.contains("raw")) // test whether the string contains the sequence
          println(input1.replace('o', 'x')) // Character replace
          println(input1.replace("o", "x")) // String replace
          println(input1.replaceAll("o", "x")) // replace all instances
          println(input1.replaceFirst("o", "x")) // replace the first instance
          println(input1.size) // returns the size of the string
          println(input1.slice(0,4)) // retrive an interval of elements from 0 to 4
          println(input1.sortWith(_ < _)) // Sort the string according to the function defined as parametr
          println(input1.sortWith(_ > _)) // Sort the string according to the function defined as parametr
          println(input1.sorted) // Sorts the string according to the ordering
          println(input1.split(" ")) // Sprlit the string using the separator
          println(input1.splitAt(2)) // Split the string in to two after a given position
          println(input1.substring(2,7)) // retrives the par of the string
          println(input1.tail) // Selects the string except te first
          println(input1.take(3)) //selects the first 3 elements from the string
          println(input1.takeRight(3)) // selects the last 3 elements from the string
          println(input1.takeWhile(_ != 'r')) // takes the longest  prefix of element following a predicate
          println(input1.toArray) // copies the elements of the string to an array
          println(input1.toBuffer) // Creates a new mutable buffer from the string
          println(input1.toList ) // Input string in tyo a new list
          println(input1.toSet) // Input string in tyo a new set
          println(input1.toStream) // Input string in tyo a new stream
          println(input1.toVector) // Input string in tyo a new vector
          println(input1.trim) // Returns a copy of the string, with leading and trailing whitespace omitted
          println(input1.view) // creates a non strict view of the sequence
          println(input1.zip(0 to 10))
          println(input1.zipWithIndex)
        }
 
        def demostrateFunctionWithReturn(intInput1 : Int , intInput2 : Int) : Int = {
          return intInput1 + intInput2
        }
 
        def demostarateArthimaticOperators() : Unit = {
          // Arthimatic operators
          println(11.2 + 12.3) // Adding Floating Point Numbers
          println(32- 11) // Subtract Action
          println('b' - 'a') // Charcater Subtraction
          println(12L * 13L) // Long Multiplication
          println(111 / 124) // Division operation
          println(112 % 41) // Modulo operation
          println(111.0f / 41.0f) // Float Division
          println(121.0 % 14.0) // Float Modulo Division
          println(11 + -31) // Negative Number Usage
        }
 
        def demostrateRelationalOperators(){
          // relational and Logical operators demo
          println(121 > 21) // Checking greater than
          println(112 < 21 ) // Checking lesserthan
          println(4.0 <= 5.0) // Check less than or equal to
          println(3.5f >= 4.32f) // Check greater than or equal to
          println('z' >= 'Z') // Charcater comparision
          val thisIsBoring = !true // Boolean action with Not operation
          println(thisIsBoring) 
          println(!thisIsBoring)
          val toBe = true // Boolean with logical opeartors
          println(toBe || !toBe) // Question
          println(toBe && !toBe) // Hypothetical
          println(12 > 22)     
        }
 
        def demostrateBitWiseOperators() : Unit = {
          // BitWise Operators
          println(5 & 6) // Bitwise and Operator
          println(5 | 6) // Bitwise inclusive OR Operator
          println(5 ^ 6) // Bitwise XOR Operator (Exclusive XOR)
          println(~1) // Bitwise NOT (unary)
          println(-2 >> 41) // Right Shift
          println(-2 >>> 41)
          println(5 << 6) // Left Shift 
        }
 
        def demostrateEquialityOperators() : Unit = {
          // Equality Operators
          println(1 == 2) // Check equality operations
          println(1 != 2) // Check not equals operation
          println(List(1, 2, 3) == List(1, 2, 3)) // List Comparions With Equal to
          println(List(1, 2, 3) == List(4, 5, 6)) // List Comparision - Different Example
          println(1 == 1.0) // Different data Type comparision
          println(List(1, 2, 3) == null) // Check list for null
          println(null == List(1, 2, 3)) // Check for null in alternative way
          println(("he"+"llo") == "hello") //
        }
 
        // Method defined with defailt values for the parameters
        def multiply(indexA : Int  = 16, indexB : Int = 22) : Int = {
          return indexA * indexB
        }
 
        def appendString(arguements : String*) : String = {
          var appendString = " "
          for(index <- arguements){
            appendString = " " + index
          }
          return appendString
        }
 
        def greeting(f:(String) => Unit, name: String) {
            f(name)
        }
 
        def printResults(f:(Int) => Boolean, x: Int) {
          println(f(x))
        }
 
      } // End of the class
 
      //defining Instance and Calling the method
      val utilInstance = new ScalaUtils("RelativeWave","Launchpad Toys");
      utilInstance.executeStringFunctions();
 
      // demotrate Operators
      utilInstance.demostarateArthimaticOperators()
      utilInstance.demostrateRelationalOperators()
      utilInstance.demostrateBitWiseOperators()
      utilInstance.demostrateEquialityOperators()
 
      // Function call variants :
      // demostarte functiosn with return types
      utilInstance.demostrateFunctionWithReturn(22,10);
 
      utilInstance.multiply(10,20) // Function called By value
      utilInstance.multiply(indexA = 5,indexB = 20)  // Function called by named paramters
      utilInstance.multiply()  // Function will use the default parameters
 
      // Use variable arguements in the menthod as parameters
      utilInstance.appendString("May 10, 2017","Owlchemy Labs","Virtual reality studio","Google VR")
 
      // Higher Order functions ; Use one function as input to another
 
 
      // Control Structures
      // if , else if and else Statement
      val time = 2003
      if(time == 2001) {
        println("Deja")
      } else if (time == 2003) {
        println("Kaltix")
      } else {
        println("Picasa")
      }
 
      // Use if else in single statement
      println(if (!args.isEmpty) args(0) else "untitled.txt")
 
      // While Loop
      var index = 6
      while (index != 0) {
        println("The value of index is :: "+index)
        index = index - 1
      }
 
      // Do while loop
      index = 6
      do {
        println("The value of index is :: "+index)
        index = index - 1
      } while (index != 0)
 
      // Using the keyword "to" to set the max limit in for loop
      for (index <- 1 to 10) {
        println("The value of index is :: "+index)
      }
 
      // Using the keyword untill to set the max limit in for loop
      for (index <- 1 until 10) {
        println("The value of index is :: "+index)
      }
 
      // Multiple Variable Iteration using the for Loop
      for (i <- 1 to 10; j <- 10 to 20) {
        println("The value of i is :: "+i)
        println("The value of j is :: "+j)
      }
 
      // Iterating a Colletable using the for loop
      var listNumber = List(10,20,30,40,50,60)
      for(index <- listNumber){
        println("The value of the index is ::" +index)
      }    
 
      // For loop with filters
      for(index <- listNumber if(index) < 50 ; if(index != 10)) {
        println("The value of the index is :: "+index)
      }
 
      // use yield with for loop to retuirn value
      var filtervalue = for{ index <- listNumber if index != 10; if index < 50 } yield index
      for( index <- filtervalue){
         println( " The value of the index is : " + index)
      }
 
      // Closure Example
      def sayGoodMorning(name: String) { println(s"Good Morning ", "$name") }
      def sayGoodNoon(name: String) { println(s"Good Noon ", "$name") }
      utilInstance.greeting(sayGoodMorning, " Pulse.io")
      utilInstance.greeting(sayGoodNoon, " Pulse.io")
 
      // Define claosures using array buffer
      val googleAcquisition = ArrayBuffer("Nest Labs","Impermium","Boston Dynamics Robotics")
      val addToAcquisition = (newAcquisition: String) => {
        googleAcquisition += newAcquisition
        println(googleAcquisition.mkString(", "))
      }
 
      def printAcquisition(f: String => Unit, newAcquition: String) {
        println(f(newAcquition))
      }
 
      printAcquisition(addToAcquisition,"Holomni Robotic wheels")
      printAcquisition(addToAcquisition,"Meka Robotics")
      printAcquisition(addToAcquisition,"Redwood Robotics")
 
      // Array usage : ways to denine an array
      var stringArrayInstanceM1 = new Array[String](3)
      var stringArrayInstanceM2 :Array[String] = new Array[String](3)
      var stringArrayInstance = Array("Phatbits","allPAY","bruNET","dMarc","Measure","Upstartle")
      var multiDimArrays = ofDim[Int](3,3)
 
      // concatinating Arrays
      println(concat(Array("Upstartle","YouTube","JotSpot"),Array("Trendalyzer","Crusix")))
 
      // Iterating the array using for loop
      for(index <- 0 to (stringArrayInstance.length - 1)) {
        println("Index is at :: "+index)
      }
 
      // Insert elements in Multidimentaional array , You can print the elements of the array is the same way.
      for(indexI <- 0 to 2;indexJ <- 0 to 2){
        multiDimArrays(indexI)(indexJ) = indexI + indexJ;
      }
 
      // we can create arrays using the range first parameter = start element , second element = last element
      // third parameter = step
      var arrayfromRange = range(10, 100, 10)
      println(arrayfromRange);
 
      // Collections : Set
      val googleAcquisitionSet : Set[String] = Set("Nest Labs","Impermium","Boston Dynamics Robotics")
      val googleAcquisitionConcatSet : Set[String] = Set("FlexyCore","SCHAFT, Inc","Industrial Perception")
 
      // define an empty set
      var emptySetInstance:Set[String] = Set.empty 
 
      println("googleAcquisitionSet.head :: "+googleAcquisitionSet.head)
      println("googleAcquisitionSet.tail :: "+googleAcquisitionSet.tail)
      println("googleAcquisitionSet.isEmpty :: "+googleAcquisitionSet.isEmpty)
      println("googleAcquisitionSet.size :: "+googleAcquisitionSet.size)
      println("googleAcquisitionSet.contains :: "+googleAcquisitionSet.contains("Nest Labs"))
      println("Intersection of two sets "+googleAcquisitionSet.intersect(googleAcquisitionConcatSet))
      println("Union of two sets "+googleAcquisitionSet.union(googleAcquisitionConcatSet))
 
      var mergeSetInstance =  googleAcquisitionSet ++ googleAcquisitionConcatSet
      println("mergeSetInstance.size :: "+mergeSetInstance.size)
 
      // adding selements in the set
      mergeSetInstance += "Stackdriver"
      println("mergeSetInstance.size :: "+mergeSetInstance.size)
 
      // Create a Sorted set and Display the set of elements
      var sortedSetInstance: SortedSet[Int] = SortedSet(15,38,41,62,19,6,4,17,12) 
      sortedSetInstance.foreach((element:Int)=> println(element)) 
      
      // Create a hashset and Display the set of elements
      var hashSetInstance : SortedSet[Int] = SortedSet(15,38,41,62,19,6,4,17,12) 
      hashSetInstance.foreach((element:Int)=> println(element))
 
      // Collection : Sequence
      // Seq is a trait which represents indexed sequences that are guaranteed immutable.
      // accessed by index and maintains its insertion order.
      var sequenceInstance : Seq[Int]  = Seq(15,38,41,62,19,6,4,17,12)
      sequenceInstance.foreach((element:Int) => println(element))
      println("Check contains "+sequenceInstance.contains(41))
      var intArrayCopy : Array[Int] = Array()
      println(" --> copyToArray "+sequenceInstance.copyToArray(intArrayCopy))
      println("Check endsWith "+sequenceInstance.endsWith(Seq(17,12)))
      println("get the Head element "+sequenceInstance.head)
      println("index of  "+sequenceInstance.indexOf(6))
      println("Check for Empty  "+sequenceInstance.isEmpty)
      println("Check the last index of Element "+sequenceInstance.lastIndexOf(17))
      println("reverse Sequence "+sequenceInstance.reverse)
 
      //Collections : Vector
      // Vector is a general-purpose, immutable data structure.
      // It provides random access of elements. It is good for large collection of elements.
      val googleAcquisitionVector : Vector[String] = Vector("Nest Labs","Impermium","Boston Dynamics Robotics")
      val googleAcquisitionConcatVector : Vector[String] = Vector("FlexyCore","SCHAFT, Inc","Industrial Perception")
      //iterating a Vector component
      googleAcquisitionVector.foreach((element:String)=> println(element))
      
      // Add an Element to an vector
      var addedVector  = googleAcquisitionVector :+ "FlexyCore"
      addedVector.foreach((element:String)=> println(element))
 
      //Merge the vector component
      var mergedVector =  googleAcquisitionVector ++ googleAcquisitionConcatVector
      mergedVector.foreach((element:String)=> println(element))
 
      // Sort the merged vector Componenet
      var sortedvectorInstance =  mergedVector.sorted
      sortedvectorInstance.foreach((element:String)=> println(element))
     
      // Collections : List
      // List is used to store ordered elements. It extends LinearSeq trait.
      //It is a class for immutable linked lists. This class is good for last-in-first-out (LIFO),
      //stack-like access patterns.It maintains order of elements and can contain duplicates elements also.
      val googleAcquisitionList : List[String] = List("Nest Labs","Impermium","Boston Dynamics Robotics")
     
      // Iterate the elements in the list
      googleAcquisitionList.foreach((element:String)=> println(element))
      
      // Sort and reverse functions of the list
      var sortedinstance = googleAcquisitionList.sorted
      var reversedInstance = googleAcquisitionList.reverse
 
      // Merge two list Objects and
      var mergeListvalues = sortedinstance ++ reversedInstance
      mergeListvalues.foreach((element:String)=> println(element))
 
      // Collections : Queue
      // Queue as in first-in-first-out (FIFO) manner,implemented as a pair of lists.
      // One is used to insert the elements and second to contain deleted elements.
      // Elements are added to the first list and removed from the second list.
      val acquitionYearQueue : Queue[Int] = Queue(2014, 2014, 2013)
      println("get the first element in the queue: "+ acquitionYearQueue.front) 
      println("Add an element in the queue "+acquitionYearQueue.enqueue(2010))
      println("Dele an element from the queue "+ acquitionYearQueue.dequeue) 
 
      //Collections : Stream
      //Stream is a lazy list,lazy computation(Evaluates whenever its required) which increases performance
      val streamInstance = 2014 #:: 2014 #:: 2013 #:: Stream.empty
      println(streamInstance) // retrives only few values
      println((1 to 3).toStream) // Store any value as stream
      println(streamInstance.head) // print the first element of the stream
      println(streamInstance.take(10)) // retrive the number o0f values from stream
      println(streamInstance.map{_*2})
 
      //Collection : Map
      //Define an Empty Map
      //Map is used to store elements in  pairs of key and values
      // HashMap is used to store element. It use hash code to store elements and return a map.
     // two ways to create a Map in scala
      var emptyMapInstance:Map[String,String] = Map.empty[String,String]
      var mapInstance = Map(("2001","Deja"),("2003","Kaltix")) 
      var hashMapInstance = HashMap("2004"->"Picasa","2005"->"Dodgeball","2006"->"Measure") 
      println(mapInstance)
 
      /* Collection : Tuples
         A tuple is a collection of elements in ordered form and store any type of data,
         use it to return multiple values from a function*/
      val tupleInstance = ("Nest Labs","Impermium","Boston Dynamics Robotics")
      println(tupleInstance._2) // fetch the second value from the tuple
      //Use product iterator to iterate ver the tuple object
      tupleInstance.productIterator.foreach(println)
 
      // File Processing
      // read the input from the console
      print("Please eneter the your name : " )
      val input = scala.io.StdIn.readLine()
      println("Hey " + input + "!!! ,  Good Morning")
 
      // Print contends from a File
      var filePathInstance = "C:/Users/571695/Desktop/One-Snippet-Pro/Scala/Read-Me.txt";
      for (line <- Source.fromFile(filePathInstance).getLines) {
        println(line)
      }
 
      // We can change the contends of the file to various collections
      val linesToList = Source.fromFile(filePathInstance).getLines.toList
      val linesToArray = Source.fromFile(filePathInstance).getLines.toArray
      val linesToString = Source.fromFile(filePathInstance).getLines.mkString
      val lineIOInstance = io.Source.fromFile(filePathInstance).mkString
 
      // Accessing file contends through buffered Reader
      val bufferedSourceInstance = Source.fromFile(filePathInstance)
      for (line <- bufferedSourceInstance.getLines) {
        println(line)
      }
      bufferedSourceInstance.close
 
      for (line <- io.Source.fromFile(filePathInstance).getLines) {
        println(line)
      }
 
      /* Pattern Matching
       A pattern match includes a sequence of alternatives, each starting with the keyword case.
       Each alternative includes a pattern and one or more expressions, which will be evaluated
       if the pattern matches. An arrow symbol => separates the pattern from the expressions.
      abstract class ShareContent*/
      case class WhatsApp(message: String, senderName: String, titleContent: String) extends ShareContent
      case class Facebook(wallContent: String, senderName: String) extends ShareContent
      case class Twitter(wallContent: String, senderTwitterHandle: String) extends ShareContent
 
      def shareArtifcats(shareContent: ShareContent): String = {
        shareContent match {
          case WhatsApp(message, senderName, titleContent) =>
            s"The content $message with title: $titleContent has been shared by the user $senderName"
          case Facebook(wallContent, senderName) =>
            s"Your Facebook wall has been posted by the message: $wallContent"
          case Twitter(wallContent, senderTwitterHandle) =>
            s"Some one has tweet you with the message : $wallContent"
         }
      }
 
      val shareWhatsApp = WhatsApp("Amazing Tutorials", "rvigneshwaran","One-Snippet-Pro")
      val shareFacebookApp = Facebook("One-Snippet-Pro", "rvigneshwaran")
      println(shareArtifcats(shareWhatsApp))
      println(shareArtifcats(shareFacebookApp))
 
      // Regular Expresssions
      val regexInstance: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r
      val inputAcquitions: String =
        """Neven Vision: Picasa;
          |YouTube: YouTube;
          |background-position: top center;
          |JotSpot: Google Sites;
          |Endoxon Mapping : Google Maps;
          |Adscape: Adsense;
          |Trendalyzer: Google Analytics;
          |Tonic Systems: Google Docs""".stripMargin
      for (matchedItems <- regexInstance.findAllMatchIn(inputAcquitions)) {
        println(s"Acquired Company: ${matchedItems.group(1)} Finally released as : ${matchedItems.group(2)}")
      }
 
      // try catch demo
      try {
        for (line <- Source.fromFile(filePathInstance).getLines) {
          println(line)
        }
      } catch {
       case fileNotFoundInst : FileNotFoundException => { fileNotFoundInst.printStackTrace(); fileNotFoundInst.toString()}
       case ioExceptionInst : IOException => { ioExceptionInst.printStackTrace(); ioExceptionInst.toString() }
      } finally {
        println("Condition Executed")
      }
 
      /*An extractor object is an object with an unapply method. Whereas the apply method is
        like a constructor which takes arguments and creates an object, the unapply takes
        an object and tries to give back the arguments. This is most often used in
        pattern matching and partial functions.*/
      val extractorInstance = HelloWorld("123456789101")
      extractorInstance match {
        case HelloWorld(registerNumber) => println(registerNumber)
        case _ => println("Could not extract a register number")           
      }
  }
 
  // The injection method (optional)
  def apply(registerNumber: String) = s"$registerNumber"
 
  // The extraction method (mandatory)
  def unapply(registerNumber: String): Option[(String)] = {
    if(registerNumber.nonEmpty && registerNumber.length() == 12) {
      var collegeExamCode = registerNumber.substring(0,3)
      var YearCode = registerNumber.substring(4,5)
      var courseCode = registerNumber.substring(6,8)
      var studentNumber = registerNumber.substring(9,12)
      Some("collegeExamCode :: "+collegeExamCode+" YearCode :: "+" courseCode :: "+courseCode+" studentNumber :: "+studentNumber)
     }else None
  }
}