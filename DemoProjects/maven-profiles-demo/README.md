## clean target directory
mvn clean

## install with specific profile
mvn install -p<profile_name>

mvn install -pprod

## check target directory. you will see application.properties file of the profile you have mentioned while `mvn install -p<profile_name>`