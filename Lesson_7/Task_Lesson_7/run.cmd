@echo off

if not exist "build" (
    mkdir build
)

if exist "source" (
    javac -d build source\*.java
) else (
    javac -d build run.cmd\*.java
)

java -cp ./build ProgrammingTest