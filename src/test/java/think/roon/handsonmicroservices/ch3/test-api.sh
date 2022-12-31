#!/bin/sh
# assertCurl: command not found 에러 뜸..
assertCurl 200 "curl http://$HOST:${PORT}/ch3/test?productId=123 -s"
assertEqual 1 $(echo $RESPONSE | jq .productId)
assertEqual 1 $(echo $RESPONSE | jq .reviews | length)