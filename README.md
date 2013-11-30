# Undertow Practice

## Usage

~~~
git clone https://github.com/emag/undertow-practice
cd undertow-practice
mvn clean compile exec:java -Dexec.mainClass=org.emamotor.undertow.practice.HelloWorldServer
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building undertow-practice 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ undertow-practice ---
[INFO] Deleting /home/tanabe/workspace/undertow-practice/target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ undertow-practice ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/tanabe/workspace/undertow-practice/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ undertow-practice ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /home/tanabe/workspace/undertow-practice/target/classes
[INFO] 
[INFO] >>> exec-maven-plugin:1.2.1:java (default-cli) @ undertow-practice >>>
[INFO] 
[INFO] <<< exec-maven-plugin:1.2.1:java (default-cli) @ undertow-practice <<<
[INFO] 
[INFO] --- exec-maven-plugin:1.2.1:java (default-cli) @ undertow-practice ---
11 30, 2013 7:18:17 午後 org.xnio.Xnio <clinit>
INFO: XNIO version 3.2.0.Beta2
11 30, 2013 7:18:17 午後 org.xnio.nio.NioXnio <clinit>
INFO: XNIO NIO Implementation Version 3.2.0.Beta2
HelloWorldServer is running!
~~~

~~~
curl localhost:8080
Hello World%
~~~
