package de.simonsator.abstractredisbungee.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungee;
import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import de.simonsator.abstractredisbungee.FakeRedisBungeeAPI;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class LimeworkRedisBungeeAPI extends FakeRedisBungeeAPI {
	private final RedisBungeeAPI API;

	public LimeworkRedisBungeeAPI() {
		super();
		API = RedisBungeeAPI.getRedisBungeeApi();
	}

	@Override
	public FakeJedisPool getPool() {
		return new LimeworkFakeJedisPool(API.getJedisPool());
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
			Plugin redisbungee = ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee");
			if (redisbungee != null && !(redisbungee instanceof RedisBungee))
				return true;
		} catch (Exception ignored) {

		}
		return false;
	}
}
