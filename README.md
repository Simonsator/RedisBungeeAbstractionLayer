# RedisBungee Abstraction Layer

An abstraction layer for RedisBungee making it easy to implement support for different RedisBungee/RedisVelocity
implementations

## Maven For Bungeecord

```xml
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
			<version>2.0.3-RELEASE</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
```

## Maven For Velocity

```xml
	<repositories>
		<repository>
			<id>simonsators Repo</id>
			<url>https://simonsator.de/repo</url>
		</repository>
	</repositories>
	<dependencies>
		<dependency>
			<groupId>de.simonsator</groupId>
			<artifactId>redisbungee-abstraction-layer-init-velocity</artifactId>
			<version>2.0.3-RELEASE</version>
			<scope>provided</scope>
		</dependency>
	</dependencies>
```

## How to use

When starting your plugin call ```FakeRedisBungeeInit.init()``` on Bungeecord and ```FakeRedisVelocityInit.init()``` on
Velocityto load the correct abstraction layer for your RedisBungee version. After that you may use
```FakeRedisBungeeAPI.getApi()``` for all RedisBungee calls.

## Supported RedisBungee Versions

* Original RedisBungee (the module which contains the code for the original RedisBungee is called
  ```redisbungee-abstraction-layer-legacy-redisbungee-implementation```)
* Limework RedisBungee for Bungeecord (the module which contains the code for the original RedisBungee is called
  ```redisbungee-abstraction-layer-limework-implementation``` for Limework up to version 0.7.2 and
  ```redisbungee-abstraction-layer-limework-modern-implementation``` for Limework 0.8.0 and higher)
* Invk RedisVelocity (the module which contains the code for the Invk RedisVelocity is called
  ```redisbungee-abstraction-layer-invk-redisvelocity-implementation```)
* Limework RedisBungee for Velocity (the module which contains the code for the Limework for Velocity is called
  ```redisbungee-abstraction-layer-limework-redisvelocity-implementation```)