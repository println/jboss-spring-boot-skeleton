# spring-boot-jboss-skeleton

The the goal of the Skeleton is deploy a Spring-Boot-Application 2+ on JBoss environment by a WAR package.

### Implemented FEATURES

1. ✅ Integration to JBoss EAP 7.0.1 GA 
1. ✅ Multiple SQL files
1. ✅ Simulate Oracle DB on H2(memory)
    1. ✅ Support to SEQUENCE
    1. ✅ Support to SCHEME
	1. ✅ Hibernate ddl-create from classes
1. ❌ DEV and PROD environment
    1. ❌ DEV
		1. ✅ application-dev.properties
		1. ✅ data-h2.sql and script-h2.sql(schema)
		1. ✅ swagger
		1. ❌ Maven's profile DEV
	1. ❌ PROD
		1. ❌ application-prod.properties
		1. ❌ Maven's profile PROD
1. ✅ JUnit 5
	1. ✅ SpringExtension + Eclipse Runner
	1. ✅ SpringExtension + Maven Runner
	1. ✅ Mockito + Test
	1. ✅ AssertJ