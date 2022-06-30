package de.simonsator.abstractredisbungee.legacy;

import com.velocitypowered.api.proxy.server.ServerInfo;
import de.simonsator.abstractredisbungee.FakeRedisVelocityAPI;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import io.github.invvk.redisvelocity.RedisVelocityAPI;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class InvvkRedisVelocityAPI extends FakeRedisVelocityAPI {
	private final RedisVelocityAPI API;

	public InvvkRedisVelocityAPI() {
		super();
		API = RedisVelocityAPI.getRedisVelocityApi();
	}

	@Override
	public FakeJedisPool getPool() {
		return new InvvkFakeJedisPool(API.getJedisPool());
	}

	@Override
	public boolean isPlayerOnline(@NonNull UUID player) {
		return API.isPlayerOnline(player);
	}

	@Override
	public ServerInfo getServerFor(@NonNull UUID player) {
		return API.getServerFor(player);
	}

	@Override
	public void registerPubSubChannels(String... channels) {
		API.registerPubSubChannels(channels);
	}

	@Override
	public void sendChannelMessage(@NonNull String channel, @NonNull String message) {
		API.sendChannelMessage(channel, message);
	}

	public static boolean isCompatible() {
		try {
			Class.forName("io.github.invvk.redisvelocity.jedis.JedisPool");
			return true;
		} catch (Exception ignored) {
		}
		return false;
	}
}
