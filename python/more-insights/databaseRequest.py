from flask import Flask,request
from flask.ext.mysqldb import MySQL
import json as jsonInstance
import pandas as pandaInstance
import requests as requestInstance

app = Flask(__name__)

# My SQL Server Configurations
app.config['MYSQL_HOST'] = '127.0.0.1'
app.config['MYSQL_USER'] = 'vignesh'
app.config['MYSQL_PASSWORD'] = 'vignesh'
app.config['MYSQL_DB'] = 'visualization'
mysqlInstance = MySQL(app)

@app.route('/getRecordsAsJSON')
def getRecordsAsJSON():
  # Get the input Parameter from the request Object 
  inputSource = request.args.get('inputSource')
  jsonData = {}
  if inputSource == "database":
    # Create Connection and cursor instance
    cursorInstance = mysqlInstance.connection.cursor()
    # Prepared statement execution
    cursorInstance.execute('''SELECT * FROM IRIS''')
    # Extract the row headers / Metadata of the query 
    rowMetadata=[x[0] for x in cursorInstance.description]
    # Fetch all the records 
    resultset = cursorInstance.fetchall()
    json_data=[]
    for result in resultset:
      json_data.append(dict(zip(rowMetadata,result)))
    jsonData = jsonInstance.dumps(json_data)
  elif inputSource == "restservice":
    # Access a Get URL to get the response
    responseInstance = requestInstance.get("http://services.groupkt.com/country/get/all")
    print(jsonInstance.loads(responseInstance.content)['RestResponse']['result'])
    # Convert the data in to data frames
    jsonData = jsonInstance.dumps(jsonInstance.loads(responseInstance.content)['RestResponse']['result'])
  #print("The Type of the output data is :: ",jsonData)
  # Convert output data to Data frame
  print(pandaInstance.read_json(jsonData))
  return jsonData

if __name__ == '__main__':
   app.run(debug=True)