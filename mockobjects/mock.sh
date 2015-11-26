#! /bin/bash
export CLASSPATH=*:.
javac TestTempServlet.java TemperatureServlet.java
java org.junit.runner.JUnitCore TestTempServlet