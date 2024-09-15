@ECHO OFF
javac Main.java
ECHO  Program test :
java Main "a(b(cd)e(fg)h)ij"
::output: "a(beh)ij"
ECHO.  
ECHO  Empty input error test :
java Main
ECHO.   
ECHO  Unbalanced brakets input error test :
java Main "Hello (world))"