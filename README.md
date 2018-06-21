# spring-boot-jboss-skeleton

The goal of the Skeleton is to deploy an Spring-Boot-Application 2+ (WAR format) on JBoss' environment.

### FEATURES

1. ✅ Integration to JBoss EAP 7.0.0.GA (WildFly Core 2.1.2.Final-redhat-1)
	1. ✅ DataSources
	1. ✅ System Properties
1. ❌ Legacy EJB	
1. ✅ Multiple SQL files
1. ✅ Simulate Oracle DB on H2(memory)
    1. ✅ Support to SEQUENCE
    1. ✅ Support to SCHEME	
1. ❌ DEV and PROD environment
    1. ❌ DEV
		1. ✅ application-dev.properties
		1. ✅ Hibernate ddl-create from classes
		1. ✅ data-h2.sql and script-h2.sql(schema)
		1. ✅ swagger
		1. ❌ Maven's profile DEV
	1. ❌ PROD
		1. ✅ application-prod.properties
		1. ⚠ Oracle Driver
		1. ✅ JBoss' configurations		
		1. ❌ Maven's profile PROD
1. ✅ JUnit 5
	1. ✅ SpringExtension + Eclipse Runner
	1. ✅ SpringExtension + Maven Runner
	1. ✅ MockitoExtension
	1. ✅ AssertJ
1. ⚠ CORS
1. ✅ Banner.txt

### TJ CUSTOM FEATURES

1. ❌ Abstract
	1. ❌ Model
	1. ❌ Repository
	1. ❌ Controller
	1. ❌ Business
		1. ❌ Validators
		1. ❌ Actuators
	1. ❌ Service
1. ❌ Exception
1. ❌ Response
	1. ❌ Pagination
	