import urllib2
import urllib
import json

headers = {'userId' : 'r1QWH8Qzm'}
url = 'https://http-hunt.thoughtworks-labs.net/challenge/input'
req = urllib2.Request(url, None, headers)
response = urllib2.urlopen(req)
json_data = json.load(response)
length =  len(json_data)
jsonRequest = {"count":str(length)}

headers = {'userId' : 'r1QWH8Qzm',
"content-type": "application/json" }
url = 'https://http-hunt.thoughtworks-labs.net/challenge/output'
##data = urllib.urlencode(jsonRequest)
req = urllib2.Request(url,data=json.dumps(jsonRequest),headers=headers)
resp=urllib2.urlopen(req)
