gatling-maven-plugin-demo
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

To test it out, simply execute the following command:

    $mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation   -DUser=1 -DRampUser="5"   -DbaseUrl="rl"  
    
    mvn gatling:test -Dgatling.simulationClass=session2.DemoStore   -DUser=1 -DRampUser="5"   -DbaseUrl="rl"
    
    mvn gatling:test -Dgatling.simulationClass=blazedemo4.BlazeDemo6
    /Users/kzanjad/Documents/Training/SapientTraining/gatling-maven-plugin-demo-main/src/test/scala/blazedemo4/BlazeDemo6.scala
or simply:

    $mvn gatling:test
    
    
    Jenkins job:  https://www.baeldung.com/ops/jenkins-run-gatling-tests
    Manage Plugin Global Tool Configure: JDK and MAVEN
    
    Shell job
    
    java -version
    echo $M2_HOME
    export MAVEN_HOME="/Users/kzanjad/Documents/Software/apache-maven-3.1.1"
    
    export PATH=$PATH:$MAVEN_HOME/bin
    echo $MAVEN_HOME
    mvn -version
    # mvn clean install
    mvn gatling:test -Dgatling.simulationClass=session2.DemoStore
    
    
