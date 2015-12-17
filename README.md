# Monopoly Kata

[![Build Status](https://travis-ci.org/michaelruocco/monopoly-kata.svg?branch=master)](https://travis-ci.org/michaelruocco/monopoly-kata)
[![Coverage Status](https://coveralls.io/repos/michaelruocco/monopoly-kata/badge.svg?branch=master&service=github)](https://coveralls.io/github/michaelruocco/monopoly-kata?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/5672ebd2107997003e0006be/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5672ebd2107997003e0006be)

This project is my attempt at the monopoly kata exercise that is outlined here: 

http://schuchert.wikispaces.com/Katas.MonopolyTheGame(r)

I have chosen to use cucumber as my BDD tool to translate the stated acceptance criteria into an executable
specification to help verify the correctness of the system. The implementation has been developed using TDD and I have
tried to keep the code as clean and simple as possible. Feedback and comments are very welcome!

## Running the Tests

You can run the unit and cucumber tests for this project by running the following command:

```
gradlew assemble check cucumber
```