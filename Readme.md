# SysexVerbal

Inspired in [VerbalExpressions](https://github.com/VerbalExpressions), SysexVerbal is a simple library that allows extract booleans, integers, ASCII strings...

## Examples

### Getting a bit like boolean

```java
int bytePosition = 5;
int bitPosition = 1;
boolean isThis =  SysexVerbal.For(sysexMidiMessage).asBoolean(bytePosition, bitPosition);
```

### Getting a ASCII text message

```java
int byteStart = 5;
int byteEnd = 15
String text = SysexVerbal.For(sysexMidiMessage).interval(byteStart, byteEnd).asAsciiString();

int aByte = 3;
String character = SysexVerbal.For(sysexMidiMessage).aByte(3).asAsciiString();
```

### Getting a integer number

```java
// In this example, the bit representing the 64° (2^7) is in another byte!

int byte64Position = 4;
int byte32Position = 7;

int result = SysexVerbal.For(message).concatOf(byte64Position).bit(bit64Position)
									 .concatOf(byte32Position).bits(1, 7)
									 .asInteger();
```
