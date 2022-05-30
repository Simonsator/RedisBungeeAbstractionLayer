package de.simonsator.abstractredisbungee;

import net.md_5.bungee.api.config.ServerInfo;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public abstract class FakeRedisBungeeAPI extends FakeRedisUniversalAPI {
	private static FakeRedisBungeeAPI instance;

	public FakeRedisBungeeAPI() {
		instance = this;
	}

	public static FakeRedisBungeeAPI getApi() {
		return instance;
	}

	public abstract ServerInfo getServerFor(@NonNull UUID player);
}
