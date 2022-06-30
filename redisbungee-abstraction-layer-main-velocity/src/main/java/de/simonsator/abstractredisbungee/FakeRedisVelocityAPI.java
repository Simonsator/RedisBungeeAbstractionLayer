package de.simonsator.abstractredisbungee;

import com.velocitypowered.api.proxy.server.ServerInfo;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public abstract class FakeRedisVelocityAPI extends FakeRedisUniversalAPI {
	private static FakeRedisVelocityAPI instance;

	public FakeRedisVelocityAPI() {
		instance = this;
	}

	public static FakeRedisVelocityAPI getApi() {
		return instance;
	}

	public abstract ServerInfo getServerFor(@NonNull UUID player);
}
