#! /bin/bash
export CLASSPATH=*:.
javac -cp  selenium-server-standalone-2.48.2.jar:.  test.java 
java -cp selenium-server-standalone-2.48.2.jar:. test