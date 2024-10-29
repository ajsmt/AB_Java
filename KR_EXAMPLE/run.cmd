@echo off

if not exist "build" (
    mkdir build
)

javac -d ./build ./source/*.java ./source/AB/Sweets/*.java ./source/AB/Gift/*.java ./source/AB/GUI/*.java

java -cp ./build Main