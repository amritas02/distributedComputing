                          Distributed Computing

Group Members: Tenzin Minleg
               Amrita Sadarangani
               Sonam Phuntsog

Our project intents to solve relatively large computational problems by taking advantage of
spare processing power of many sparsely used computes. By doing so we want the effectively
emulate a high-end computer.

At the server system the user perceives the collection of autonomous processors as a unit
and becomes equipped to solving a large computational problem. When the server side receives
a computational problem, firstly it breaks the problem into subparts and sends the smaller
problems to several clients. All the client sides computes their subproblems and sends the
result to the central server, upon receiving all the answers to subproblems the server combines
the solutions to form the final solution which will be presented to the main user.

Applications of this can be numerous as many scientific and engineering fields uses
linear algebra extensively and most operations on matrixes and vectors can be divided smaller tasks,
each of which can solved by one or more computers.

At the end of this semester we plan to demonstrate three computer configuration, one running the server
and two running client program. And  perform matrix operations using Distributed Computing.

=====================================================================================

Lets "Main machine" be the emulated high-end computer where we give big problems
and "Volunteer machine" be smaller computers where computations take place

Steps to run the project


In Main machine
1) java -classpath lib/jblas-1.2.4.jar:classes UnitHub localhost 9992

in volunteer machine
1) rmiregistry 9092 &
2) java -classpath lib/jblas-1.2.4.jar:classes StartServer 9092 localhost 9992

todo
1) complete distributedAdd method in UnitHub
2) add more distributed operations
