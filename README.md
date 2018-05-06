# idocs-demo
A simple demo maven application made with Java8


## Download Instruction

Run `git clone https://github.com/NikGioulos/idocs-demo` to download the project to your computer.



## Application Entry Point
1) main method is located in the DemoMain class
3) Java8 is prerequisite since Lambda expressions are used in application

##Extra Questions
1) each UTF-8 char needs maximum 4bytes. 
So, each line requires on average 4*8 = 32 bytes.
So, in case all the String lines are unique, maximum is 200x1024x1024/32

2) i would use new String() and i would force GC to clear unneeded objects from heap

3) i would use some adjustments to improve performance 
For example, we could use Guava utilities for collections (instead of plain java)

4) i would use a profiler to get detailed information about the behavior and performance 
of each part of your code to find the bottleneck
