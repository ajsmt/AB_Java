@echo off

if not exist "build" (
    mkdir build
)

javac -d ./build ./source/*.java ./source/AB/Gui/*.java ./source/AB/Data/*.java

java -cp ./build Main