/**
 * Threads communicate primarily by sharing access to fields and the objects reference fields refer to.</br>
 * This form of communication is extremely efficient, but makes two kinds of errors possible:</br>
 * thread interference and memory consistency errors.</br>
 * The tool needed to prevent these errors is synchronization.</br>
 * </br>
 * However, synchronization can introduce thread contention,</br>
 * which occurs when two or more threads try to access the same resource simultaneously</br>
 * and cause the Java runtime to execute one or more threads more slowly, or even suspend their execution.</br>
 * Starvation and livelock are forms of thread contention.</br>
 * </br>
 * source: <a href="http://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html">http://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html</a>
 */
package be.seriousbusiness.java.concurrency.synchronization;