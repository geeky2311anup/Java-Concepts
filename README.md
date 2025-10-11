# Simple Java App

This is a simple Java project structure for learning.

## Folder Structure:

```
simple-java-app/
├── src/           (Source code goes here)
│   └── Calculator.java
├── bin/           (Compiled .class files go here)
└── README.md      (This file)
```

## How to compile and run:

### From the project root directory:

```bash
# Compile Java files
javac -d bin src/*.java

# Run the program
java -cp bin Calculator
```

### From src directory:

```bash
# Compile
javac -d ../bin *.java

# Then go to bin and run
cd ../bin
java Calculator
```

## What each folder is for:

- **src/**: Put your .java source files here
- **bin/**: Compiled .class files will be created here automatically
