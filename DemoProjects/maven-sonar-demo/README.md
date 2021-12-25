## install sonar
* download zip
* extract zip
* go to `sonarqube-9.2.1.49989\bin\windows-x86-64` directory
* run `StartSonar.bat`
* go to `localhost:9000`
* initially the default username and password is `admin`
* 
## setup sonar
* copy and paste `src/main/resources/settings.xml` under your `.m2` directory of maven
* this will have sonar `pluginGroups` and we will also activate sonar plugin by default
* whenever maven is run it will automatically enable this sonar plugin  which is specified in `profiles`
* this is the configuration that you need to run sonar
* in addition to this, inside that `profiles` you can pass in properties you want to point the maven to 
the sonar running on a different server. you can pass that url inside properties
* when we run `mvn clean verify sonar:sonar` `sonar` plugin and `sonar` goal will be executed.
* it will try to push the reports to sonar, but it will fail saying `Not authorized.`
* because we don't have credentials setup 
* go to`localhost:9000` -> go to `My Account` from top right menu.  -> click on `Security` tab
* and now we need to generate a token. enter token name that you want and generate.
* go to terminal and `mvn clean verify sonar:sonar -Dsonar.login=<token_you_generated>`
* we can use this security token, and then we can run the sonar goal 
* then reports will be automatically available for sonar to analyze, and they will appear on `localhost:9000` dashboard

## run
`mvn clean verify sonar:sonar -Dsonar.login=<token_you_generated>`