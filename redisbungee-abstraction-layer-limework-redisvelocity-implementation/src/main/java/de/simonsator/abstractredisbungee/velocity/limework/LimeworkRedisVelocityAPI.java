package de.simonsator.abstractredisbungee.velocity.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import com.imaginarycode.minecraft.redisbungee.events.PubSubMessageEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.ServerInfo;
import de.simonsator.abstractredisbungee.FakeRedisVelocityAPI;
import de.simonsator.abstractredisbungee.events.PubSubMessageManager;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import de.simonsator.abstractredisbungee.limework.common.LimeworkFakeJedisPool;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class LimeworkRedisVelocityAPI extends FakeRedisVelocityAPI {
	private final RedisBungeeAPI API;

	public LimeworkRedisVelocityAPI(ProxyServer pProxyServer, Object pMainPluginObject) {
		super();
		API = RedisBungeeAPI.getRedisBungeeApi();
		pProxyServer.getEventManager().register(pMainPluginObject, this);
	}

	public static boolean isCompatible() {
		try {
			Class.forName("com.imaginarycode.minecraft.redisbungee.internal.jedis.JedisPool");
			return true;
		} catch (Exception ignored) {
		}
		return false;
	}

	@Override
	public FakeJedisPool getPool() {
		return new LimeworkFakeJedisPool(API);
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
}
