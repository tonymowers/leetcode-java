![build and test](https://github.com/github/docs/actions/workflows/build.yml/badge.svg)

# LeetCode Java TDD

I use this repository to practice applying TDD (test driven development) to 
solving LeetCode algorithm problems.  

There are certain problems, that after having solved them the first time, I'll 
occasionally revisit to use in a code kata or teaching example. The practice
helps me to retain a certain level of proficiency with various languages,
development environments and techniques.

## Background Information 

### Code Kata

A [code kata](https://en.wikipedia.org/wiki/Kata_(programming)) is an exercise
in programming which helps programmers hone their skills through practice and
repetition. The idea is to take a problem you've already solved, repeat the 
process of solving, and to reflect upon your technique each time. The concept
is used heavily in the martial arts.

### LeetCode 

[LeetCode](https://www.leetcode.com) is a website containing 1000s of algorithm coding practice problems.  

The problems on the LeetCode website are representative of the types of algorithm problems that are used in technical 
interviews by companies like Google and Yelp.  

### Test Driven Development

Test Driven Development is a coding discipline where tests are written before the production code. 

Robert Martin describes TDD, in his [article](https://blog.cleancoder.com/uncle-bob/2014/12/17/TheCyclesOfTDD.html) on
the topic, as consisting of two coding cycles:
- micro-cycle
- nano-cycle

#### Micro-cycle (minute by minute): Red Green Refactor

1. Create a unit tests that fails
1. Write production code that makes that test pass.
1. Clean up the mess you just made.

#### Nano-cycle (second by second)

1. You must write a failing test before you write any production code.

1. You must not write more of a test than is sufficient to fail, or fail to compile.

1. You must not write more production code than is sufficient to make the currently failing test pass.

### Code Smells and Refactoring

The discipline of cleaning up code without changing its behavior is called refactoring. Some of the more common coding 
problems, that are cleaned up during refactoring sessions, are called code smells.

The website [Refactoring Guru](https://refactoring.guru/refactoring/smells) describes some of the more common code 
smells, and the refactorings often used to address them.


## Advanced TDD: Transformation Priority Premise

The Trnasformation Priority Premise is an advanced concept in TDD for how to evolved code as new test cases are added.

Whereas refactoring is the practice of cleaning up code without changing the code's behavior, code transformation is the
practice of incrementally changing a piece of code's behavior by small changes to the code.  As each new test
is added the code is transformed in the most minimal way possible in order to make the test pass.

The Transformation Priority Premise is Uncle Bob's suggestion of the basic types of transformation that are applied during
the TDD coding cycle and the priority in which to apply those transformations.

- [Wikipedia Transformation Priority Premise](https://en.wikipedia.org/wiki/Transformation_Priority_Premise)
- [Uncle Bob's Transformation Priority Premise Post](https://blog.cleancoder.com/uncle-bob/2013/05/27/TheTransformationPriorityPremise.html)







