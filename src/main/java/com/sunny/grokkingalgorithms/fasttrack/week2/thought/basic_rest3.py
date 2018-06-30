import urllib2
import urllib
import json
import datetime

now = datetime.datetime.today()
headers = {'userId' : 'r1QWH8Qzm'}
url = 'https://http-hunt.thoughtworks-labs.net/challenge/input'
req = urllib2.Request(url, None, headers)
response = urllib2.urlopen(req)
json_data = json.load(response)
#print json_data

dict = {}
totalvalue = 0
for obj in json_data:
    endDate = obj['endDate']
    startDate = obj['startDate']
    #category = obj['category']
    if (datetime.datetime.strptime(startDate,'%Y-%m-%d') <= now) and ( endDate == None or datetime.datetime.strptime(endDate,'%Y-%m-%d') >= now):
        totalvalue += obj['price']        

#print count        
        
dict['totalValue'] = totalvalue
        
headers = {'userId' : 'r1QWH8Qzm',
"content-type": "application/json" }
url = 'https://http-hunt.thoughtworks-labs.net/challenge/output'
##data = urllib.urlencode(jsonRequest)
##print jsonRequest
req = urllib2.Request(url,data=json.dumps(dict),headers=headers)
resp=urllib2.urlopen(req)        