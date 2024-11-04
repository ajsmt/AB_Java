@echo off

if not exist "build" (
    mkdir build
)

javac -d ./build ./source/*.java ./source/AB/TOY/*.java ./source/AB/GUI/*.java

java -cp ./build Main