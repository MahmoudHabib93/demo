@echo off
setlocal

echo Setting up environment...
set "JAVA_HOME=C:\Program Files\Java\jdk-23"
set "MAVEN_HOME=%~dp0tools\apache-maven-3.9.6"
set "PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%"

echo Checking Configuration...
echo JAVA_HOME: %JAVA_HOME%
echo MAVEN_HOME: %MAVEN_HOME%

call java -version
call mvn -version

if %errorlevel% neq 0 (
    echo Error: Configuration failed.
    pause
    exit /b
)

echo.
echo Executing Tests...
call mvn test

echo.
echo Test Execution Finished.
echo You can view the report at target/extent-reports/extent-report.html
pause
