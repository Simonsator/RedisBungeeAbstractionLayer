package de.simonsator.abstractredisbungee;

import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import net.md_5.bungee.api.config.ServerInfo;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public abstract class FakeRedisBungeeAPI {
	private static FakeRedisBungeeAPI instance;

	public static FakeRedisBungeeAPI getApi() {
		return instance;
	}

	public abstract FakeJedisPool getPool();

	public abstract boolean isPlayerOnline(@NonNull UUID player);

	public abstract ServerInfo getServerFor(@NonNull UUID player);

	public abstract void registerPubSubChannels(String... channels);

	public abstract void sendChannelMessage(@NonNull String channel, @NonNull String message);
}
