## clean target directory
`mvn clean`

## install with specific profile
`mvn install -P <profile_name>` e.g. `mvn install -P prod`

check the `target/classes` directory. you will see `application.properties` file of the profile you have mentioned while `mvn install -P <profile_name>`