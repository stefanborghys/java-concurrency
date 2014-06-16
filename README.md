java-concurrency
================

Java concurrency tryout  
  
# Concurrency  
  
The ability for software to do multiple things at the same moment is called concurrency.  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)  
  
# Synchronization  
  
Threads communicate primarily by sharing access to fields and the objects reference fields refer to.  
This form of communication is extremely efficient, but makes two kinds of errors possible:  
- thread interference errors  
- memory consistency errors  

The tool needed to prevent these errors is synchronization.  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html)  
  
## Thread Interference  

Interference happens when two operations, running in different threads, but acting on the same data, interleave.  
This means that the two operations consist of multiple steps, and the sequences of steps overlap.
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html)  
  
## 
