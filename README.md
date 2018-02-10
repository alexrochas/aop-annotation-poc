# AOP Annotations
> Exception abstraction using annotations for Java

The main reason to do this is to use with Rest applications. Where you can have a "pattern" for your exceptions responses.

## Example of usage

The first example throws an IllegalArgumentException that is captured and re-throwed as an ExpectedException. 

```java
@ExpectedExceptionDecorator(value = "Throwing expected exception!", forClass = { IllegalStateException.class, IllegalArgumentException.class })
public DemoEntity couldThrowException() {
  throw new IllegalArgumentException();
}
```

In this example, we still have an IllegalArgumentException but because we did't mapped this exception type in the annotation,
the code will throw an IllegalArgumentExcpetion.

```java
@ExpectedExceptionDecorator(value = "Does't matter.", forClass = { IllegalStateException.class })
public DemoEntity notThrowExpectedException() {
  throw new IllegalArgumentException();
}
```

## Meta

Alex Rocha - [about.me](http://about.me/alex.rochas)
