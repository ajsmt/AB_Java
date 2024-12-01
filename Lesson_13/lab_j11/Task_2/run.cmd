@echo off

if not exist "build" (
    mkdir build
)

javac -d build -cp source source\Main.java

if %errorlevel% neq 0 (
    echo Failed.
    exit /b %errorlevel%
)

java -cp ./build Main