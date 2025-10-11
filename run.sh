#!/bin/bash
# Simple script to compile and run Java files

# Check if filename is provided
if [ $# -eq 0 ]; then
    echo "Usage: ./run.sh <JavaFileName>"
    echo "Example: ./run.sh dataAbstraction"
    exit 1
fi

CLASS_NAME=$1

# Find the java file
JAVA_FILE=$(find src -name "${CLASS_NAME}.java" | head -1)

if [ -z "$JAVA_FILE" ]; then
    echo "Error: ${CLASS_NAME}.java not found in src directory"
    exit 1
fi

echo "Compiling $JAVA_FILE..."
javac -d bin "$JAVA_FILE"

if [ $? -eq 0 ]; then
    echo "Running $CLASS_NAME..."
    java -cp bin $CLASS_NAME
else
    echo "Compilation failed!"
fi
