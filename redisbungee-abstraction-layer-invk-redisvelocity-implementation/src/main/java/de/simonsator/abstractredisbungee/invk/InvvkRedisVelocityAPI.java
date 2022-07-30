package de.simonsator.abstractredisbungee.invk;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.ServerInfo;
import de.simonsator.abstractredisbungee.FakeRedisVelocityAPI;
import de.simonsator.abstractredisbungee.events.PubSubMessageManager;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import io.github.invvk.redisvelocity.RedisVelocityAPI;
import io.github.invvk.redisvelocity.events.PubSubMessageEvent;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class InvvkRedisVelocityAPI extends FakeRedisVelocityAPI {
	private final RedisVelocityAPI API;

	public InvvkRedisVelocityAPI(ProxyServer pProxyServer, Object pMainPluginObject) {
		super();
		API = RedisVelocityAPI.getRedisVelocityApi();
		pProxyServer.getEventManager().register(pMainPluginObject, this);
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

	@Subscribe
	public void onPubSubMessage(PubSubMessageEvent pEvent) {
		PubSubMessageManager.getInstance().invokePubSubMessageEvent(pEvent.getChannel(), pEvent.getMessage());
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
