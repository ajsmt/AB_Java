@echo off

if not exist "build" (
    mkdir build
)

javac -d ./build ./source/*.java ./source/AB/Gui/*.java

java -cp ./build Main