package de.simonsator.abstractredisbungee.legacy;

import com.imaginarycode.minecraft.redisbungee.RedisBungee;
import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import de.simonsator.abstractredisbungee.FakeRedisBungeeAPI;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class LegacyRedisBungeeAPI extends FakeRedisBungeeAPI {
	private final RedisBungeeAPI API;
	private final RedisBungee REDIS_BUNGEE_PLUGIN;

	public LegacyRedisBungeeAPI() {
		super();
		REDIS_BUNGEE_PLUGIN = (RedisBungee) ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee");
		API = RedisBungee.getApi();
	}

	@Override
	public FakeJedisPool getPool() {
		return new LegacyFakeJedisPool(REDIS_BUNGEE_PLUGIN.getPool());
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
			if (ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee") instanceof RedisBungee)
				return true;
		} catch (Exception ignored) {

		}
		return false;
	}
}
