# Undertow Practice

## Usage

~~~
$ git clone https://github.com/emag/undertow-practice
$ cd undertow-practice
$ mvn clean compile exec:java -Dexec.mainClass=org.emamotor.undertow.practice.HelloWorldServer
[...]
HelloWorldServer is running!
~~~

~~~
$ curl localhost:8080 -v                           
* About to connect() to localhost port 8080 (#0)
*   Trying 127.0.0.1...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET / HTTP/1.1
> User-Agent: curl/7.29.0
> Host: localhost:8080
> Accept: */*
> 
< HTTP/1.1 200 OK
< Connection: keep-alive
< Content-Type: text/plain
< Content-Length: 11
< 
* Connection #0 to host localhost left intact
Hello World%
~~~
