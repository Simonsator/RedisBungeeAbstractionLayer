# RedisBungee Abstraction Layer

An abstraction layer for RedisBungee making it easy to implement support for different RedisBungee implementations

## Maven

```
	<repositories>
		<repository>
			<id>simonsators Repo</id>
			<url>https://simonsator.de/repo</url>
		</repository>
	</repositories>
	<dependencies>
		<dependency>
			<groupId>de.simonsator</groupId>
			<artifactId>redisbungee-abstraction-layer-init-bungee</artifactId>
			<version>2.0.0-SNAPSHOT</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
```

## How to use

When starting your plugin call ```FakeRedisBungeeInit.init()``` to load the correct abstraction layer for your
RedisBungee version. After that you may use ```FakeRedisBungeeAPI.getApi()``` for all RedisBungee calls.