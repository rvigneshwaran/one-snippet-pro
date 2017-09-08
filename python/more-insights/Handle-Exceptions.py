  #snippet in order to demostrate python exception,some standard libraries and logging
  
  import sys as systemInstance
  import os as osInstance
  import platform as platformInstance
  import logging as loggingInstance
  import traceback as tracebackInstance
  
  #logging informations : logging configurations and log locations
  logFileLocation = osInstance.getcwd() + "python-debug.log"
  loggingInstance.basicConfig(level=loggingInstance.DEBUG,format='%(asctime)s : %(levelname)s : %(message)s'
    ,filename=logFileLocation,filemode='w')
  
  #sys.version_info is a  tuple which contains all the informations like major,mocro,serial and release level
  loggingInstance.info(" Printing System level Informations ")
  print("sys.version_info.major ",systemInstance.version_info.major)
  print("sys.version_info.minor ",systemInstance.version_info.minor)
  print("sys.version_info.micro ",systemInstance.version_info.micro)
  print("sys.version_info.serial ",systemInstance.version_info.serial)
  print("sys.version_info.releaselevel ",systemInstance.version_info.releaselevel)
  
  #Home Drive details
  loggingInstance.info(" Printing drive details ")
  operatingSystem = print(platformInstance.platform()) #returns the operating system platform with the version and build number
  homeDriveLocation = osInstance.getenv('HOMEDRIVE')
  homePathLocation = osInstance.getenv('HOMEPATH')
  homeLocation = osInstance.getenv('HOME')
  print("Home location :: ",homeLocation,"Home Drive Location :: ",homeDriveLocation," Home Path Location :: ",homePathLocation)
  loggingInstance.warn("Ending the Show ")
  
  #Usage of Asset and exceptions (assert statement is used to assert that something is true)
  listInstance = ["ganga","sathyavati"]
  
  try:
    assert len(listInstance) >= 0
    assert len(listInstance) == 0
  except AssertionError:
      #Piece of Code which can exactly drill down which line number and statement exception occured
      _, _, tbInstance = systemInstance.exc_info()
      tracebackInstance.print_tb(tbInstance)
      tableInfo = tracebackInstance.extract_tb(tbInstance)
      filename, line, func, text = tableInfo[-1]
      loggingInstance.error('An error occurred on line {} in statement {}'.format(line, text))
      exit(1)
      
  #storing of varibales is also very easy
  listData = ["Gandhāri","Shakuni","Dhritarashtra"]
  inst1,inst2,inst3 = listData
  print("inst1 ",inst1,"inst2 ",inst2,"inst3 ",inst3)
  
  #python supports extended unpacking of the contends
  a, *b, c = [1, 2, 3, 4, 5]
  print("a ",a,"b ",b,"c ",c) # a=1,b=[3,4,5],c=5
  
  #revrsing a String is Quite easy
  inputString = "Bhishmar"
  print(inputString[::-1])