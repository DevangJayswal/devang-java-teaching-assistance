## Interface rule until version 7

* every variable present inside interface is public static final
* every method present inside is by default public and abstract

## from version 8

* we can write concrete method inside interface
* these methods are called default method
* we can write any number of default method inside interface

## why default method

* the purpose of default method is to save implementation classes. it is not to provide any meaningful implementation.
  it is just a dummy implementation. if we want to use we can use, otherwise we can ignore in implementation class. even
  we add concrete method in the form of default method inside an interface, it is never equal to abstract class.

* inside interface every variable is public static final, we can never declare instance variable inside interface, but
  we can do so in abstract class

* we can not declare constructor, but we can do so in abstract class


