import urllib2
import urllib
import json
import datetime

now = datetime.datetime.today()
headers = {'userId' : 'blank'}
url = 'https://http-hunt.dummy-labs.net/challenge/input'
req = urllib2.Request(url, None, headers)
response = urllib2.urlopen(req)
json_data = json.load(response)
#print json_data

dict = {}
for obj in json_data:
    endDate = obj['endDate']
    startDate = obj['startDate']
    category = obj['category']
    if (datetime.datetime.strptime(startDate,'%Y-%m-%d') <= now) and ( endDate == None or datetime.datetime.strptime(endDate,'%Y-%m-%d') >= now):
        print str(obj) 
        if category in dict:
           dict[category] = dict[category] + 1
        else:
           dict[category] = 1        

#print count        
        
print dict
        
headers = {'userId' : 'blank',
"content-type": "application/json" }
url = 'https://http-hunt.dummy-labs.net/challenge/output'
##data = urllib.urlencode(jsonRequest)
##print jsonRequest
req = urllib2.Request(url,data=json.dumps(dict),headers=headers)
resp=urllib2.urlopen(req)        