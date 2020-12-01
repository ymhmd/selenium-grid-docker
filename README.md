# selenium-grid-docker


#### Steps to execute the tests
1. `docker-compose -f docker-compose.yml up -d`
2. `docker ps`
3. `mvn clean test -Dsurefire.suiteXmlFiles=TestNGRunner.xml`