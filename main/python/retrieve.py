import time
import requests
from Adafruit_IO import RequestError,Client, Feed
user='g00g1y5p4'
key = "aio_lHMb18qHaS0fSlIvz7XBQwu39DgS"

aio = Client(user,key)

def function_request():
	try:
		valu = aio.receive("iot").value
		if valu=="g00g1yg00g1y":
			return "accident occured"
		time.sleep(5)
		function_request()
	except:
		time.sleep(5)
		function_request()
	'''
	return "1"'''
