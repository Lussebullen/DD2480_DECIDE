# DD2480_DECIDE
DECIDE Assignment in the KTH course DD2480.

# Documentation of Work
17/01/2024 Mathias
- Set up Repo with branch protection and Project with assignment requirements added

## Requirements
Java (version?)
JDK version
Maven version

## Build instructions Windows

Install chocolatey https://docs.chocolatey.org/en-us/choco/setup

Install Maven via chocolatey, ```choco install maven```

### To run in command line:

navigate to ```DD2480_DECIDE\decide```

Execute ```mvn compile```

To run tests, execute ```mvn test```

### To run in visual studio code:

Install recommended java plugins, including Maven

Open DD2480_DECIDE as work folder

In the bottom left, at the maven tab, open the "Lifecycle" tab

Hover any option of your choice, such as "test", and click the play button to run the corresponding option

If vscode says the maven executable is missing, and requests it, insert the following ```C:\ProgramData\chocolatey\lib\maven\apache-maven-3.9.6\bin\mvn``` if you used the default install location of Maven from chocolatey

## Commit convention
All commits should be performed on the appropriate issue branch
Prefixes: feat/, fix/, doc/, refactor/
 