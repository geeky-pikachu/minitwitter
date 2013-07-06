## Geek Academy Mini Project Web Application

	- Spring MVC
	- Redis
	- RabbitMQ
	- maven

## How to create project

	- mvn archetype:create -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=com.minitwitter -DartifactId=minitwitter
	- cd minitwitter
	- mvn eclipse:eclipse
	- modify pom
	- mvn clean compile
	- mvn exec:java -Dexec.mainClass=com.minitwitter.MainClass
	- mvn tomcat:run (mvn -Dmaven.tomcat.port=9090 tomcat:run)
	- mvn package (mvn compile war:war)
