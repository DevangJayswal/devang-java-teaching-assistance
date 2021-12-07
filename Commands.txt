## install third party dependencies
mvn install:install-file -Dfile=src\main\webapp\WEB-INF\lib\ojdbc7-12.1.0.2.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar

mvn install:install-file -Dfile=workspace\STS\BitBucket\CrestMaster\src\main\webapp\WEB-INF\lib\ojdbc7-12.1.0.2.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0.2 -Dpackaging=jar