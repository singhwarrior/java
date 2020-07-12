# Multi-threading in Java
### Threads
Threads are part of an OS process. They improve the performance of process by utilizing the resources in better way. 

##### Threads in JAVA
JAVA is one of the first few languages who introduced the Threads in language. Introducing threads brought the better utilization of resources but it also brought some problems of concurrency for programmers. The concurrency problems have to be taken care while working with multi-threaded applications/programs.

##### Threads in other frameworks & Non-Blocking Algorithm
New frameworks like Play/AKKA or Vert.x came as asynchronus and share-nothing approach as a different concurrency model from JAVA/J2EE. LMAX Disruptor has been introduced as Non-Blocking Algorithm, and added as toolkit. 

##### Functional Programming Parallelism
In JAVA7 new fork and join framework  has been introduced as functional parallelism. Also Collection Streams have been used in JAVA8. 

### Benifit of Threads
Benifit of threads are as follows
##### Better Resource Utilization & Performance
It can be understood by an example. There can be two files(file-A and file-B) which we have to be read and some processing needs to be done on them. In case of single thread we can read one file and then process. 

| TASK | TIME |
| ------ | ------ |
| Read file-A | 4 seconds |
| Process on file-A data | 2 seconds |
| Read file-B | 5 seconds |
| Process on file-B data | 3 seconds |

In above scenario, Total Time=14seconds. Problem was that when thread was reading file-B, the CPU is idle because no processing is happening. 
If the same will be implemented with two threads can better use the resources as follows:

| TASK | TIME |
| ------ | ------ |
| Thread-1 read file-A | 4 seconds |
| Thread-2 read file-B(But here Thread-1 can do processing of 2 seconds) | 5 seconds |
| Process on file-B data | 3 seconds |

In above scenario, Total Time=12seconds.

##### Better Responsiveness
Using Threads can result in better responsiveness. For example, in case of network programming, if a there is a single thread for a TCP server it will keep on listening the port and process as well. So if any other request comes to the server from client, it will wait because server was busy in processing somthing.

```sh
while(server is active){
    listen to a port
    process request
}
```
If the incoming request is handed over to another thread it will be ready for listening from anothe client request.
```sh
while(server is active){
    listen to a port
    launch another thread to process request
}
```
This makes the server more responsive to handle more client requests.
### Cost of using Threads
Threads should be used if they are required, if not then they should be not. There are following things which can impact the performance of the programs if proper evaluation and thought has not been given before implementing a program:
##### Context Switching & Memory Consumption
CPU switches from one thread to another thread which is called Context Switching. There is a cost assocated with it, because CPU keeps track of some internal variables and program pointers of current thread and it will load internal variables and program pointers of another thread.  
The thread maintain their stack which means extra memory utilization. So there is CPU time and memory associated with threads.