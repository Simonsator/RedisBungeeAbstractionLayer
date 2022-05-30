package de.simonsator.abstractredisbungee;

public abstract class FakeRedisBungeeAPI extends FakeRedisUniversalAPI {
	private static FakeRedisBungeeAPI instance;

	public FakeRedisBungeeAPI() {
		instance = this;
	}

	public static FakeRedisBungeeAPI getApi() {
		return instance;
	}
}
