## create maven project
* create stand-alone quickstart project
`mvn archetype:generate -DgroupId=com.example -DartifactId=java-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

* create webapp project
`mvn archetype:generate -DgroupId=com.bharath -DartifactId=java-web-project -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false`


## install third party dependencies
`mvn install:install-file -Dfile=src\main\webapp\WEB-INF\lib\ojdbc7-12.1.0.2.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar`

`mvn install:install-file -Dfile=workspace\STS\BitBucket\CrestMaster\src\main\webapp\WEB-INF\lib\ojdbc7-12.1.0.2.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar`