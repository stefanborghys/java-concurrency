java-concurrency
================

Java concurrency tryout  
  
# Concurrency  
  
The ability for software to do multiple things at the same moment is called concurrency.  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/index.html)  
  
# Threads  
  
- **process**: is a self-contained execution environment.  A process generally has a complete, private set of basic run-time resources;  in particular, each process has its own memory space.  
- **thread**: sometimes called lightweight process.  Both processes and threads provide an execution environment,  but creating a new thread requires fewer resources than creating a new process.  
Threads exist within a process — every process has at least one.  Threads share the process's resources, including memory and open files.  This makes for efficient, but potentially problematic, communication.  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/procthread.html)  
  
- **Runnable** interface: only demands to implement the run() method  
- **Thread** class: predefines a number of Thread management methods. But requires to extend Thread  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html)  
  
**Pausing a Thread**:  
  
<code>Thread.sleep(milliseconds); // Sleeps for ... milliseconds</code>  
The pause is not always exact the amount of millisenconds.  
This depends upon the limits of the OS or can differ when the thread is interrupted.  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html)  
  
**Interrupting a Thread**:  
  
<code>Thread.interrupt();</code>  
An interrupt notifies a thread to stop it's current execution.  
The action is undertaken by the Thread depends upon the implementation.  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html)  
  
**Joining two Threads**:  
  
<code>t.join();</code>  
When one thread joins another it will wait until this joined thread has finshed.  
  
source: [http://docs.oracle.com/javase/tutorial/essential/concurrency/join.html](http://docs.oracle.com/javase/tutorial/essential/concurrency/join.html)  
  
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
