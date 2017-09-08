import os as osInstance
import time as timeInstance
 
#get the current working directory in python
currentDirInstance = osInstance.getcwd()
 
#user can change this to comman line args to pass it from command line
sourceDir = [currentDirInstance]
targetDir = currentDirInstance
 
#set the target directory to save the date wise back up , if the back up has to be done for two days
target = targetDir + osInstance.sep + timeInstance.strftime('%Y%m%d%H%M%S') + '.zip'
 
if not osInstance.path.exists(targetDir):
  osInstance.mkdir(targetDir)
 
zipCommand = 'zip -r {0} {1}'.format(target,' '.join(sourceDir))
 
#Substuite for ternary operator in Python (using if else as ternary operator in python)
print('backed Up to Target Location :: ', target if osInstance.system(zipCommand) == 0 else 'Backup FAILED')
 
#or
 
# Index of the tuple can be used to evaluate this expression 
# Using tuple with index as subsitute to ternary operator
print (('Backup FAILED', 'backed Up to Target Location :: ')[osInstance.system(zipCommand) == 0])