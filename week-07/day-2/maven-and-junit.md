<!-- this is a markdown file -->
<!-- markdown files are often used for GitHub repo readmes and other areas you need quick formatting -->
# Maven and JUnit

The above line is a top-level heading.

This is some regular text.

## This is a second-level heading.

### This is a third-level heading.
- This is a list.
- This is the second item in the list.
- This is the third item.
    - This is an embedded list.
    - Second item, etc.

1. An ordered list.
2. Second item.
3. Third item.

# Maven and JUnit, Redux

## Maven
- Maven is two things:
    - A build tool
    - A package manager
- A build tool takes the project through a series of steps each time you run/install/deploy it
    - testing
    - verification
    - building, etc.
- A package manager sets up the relationship between the project and its dependencies
    - dependencies are other projects/packages/software, etc. that our project needs to run
    - you include dependencies in the configuration of your Maven project
    - you can then use the packages, classes, and libraries of the other project(s) just like any other class

### Build Tool
- There is a default Maven lifecycle that exists when working with a Maven project
    - validate -- is the project structured correctly; do we have everything we need?
    - compile -- just like a regular Java compile -- compiles the source code into .class files
    - test -- (JUnit for us) runs unit tests to see if all our methods are working correctly
    - package -- assemble the project into a single, runnable JAR or WAR file (Java ARchive, Web ARchive)
    - verify -- does it work? runs a series of checks
    - install -- places the verified JAR in the local repository for use in other local projects
    - deploy -- places the verified JAR in the remote repository or final deployed location

### Package Manager
- each piece of software on which our project depends will be included as a dependency
- the pom.xml file outlines all the dependencies
- when the project builds, all the dependent software is included
- if a dependency has additional dependencies, those are included as well
- you can add/remove dependencies as you see fit
- you can also update the version of the dependency by simply changing the version number in your pom.xml
- IMPORTANT -- to make sure dependencies are installed correctly, do a Maven update!
