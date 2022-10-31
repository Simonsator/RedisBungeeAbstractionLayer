package de.simonsator.abstractredisbungee.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import com.imaginarycode.minecraft.redisbungee.events.PubSubMessageEvent;
import de.simonsator.abstractredisbungee.FakeRedisBungeeAPI;
import de.simonsator.abstractredisbungee.events.PubSubMessageManager;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import de.simonsator.abstractredisbungee.limework.common.LimeworkFakeJedisPool;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public abstract class CommonLimeworkRedisBungeeAPI extends FakeRedisBungeeAPI implements Listener {
	protected final RedisBungeeAPI API;

	public CommonLimeworkRedisBungeeAPI(Plugin pPluginInstance) {
		super();
		API = RedisBungeeAPI.getRedisBungeeApi();
		ProxyServer.getInstance().getPluginManager().registerListener(pPluginInstance, this);
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
	public void registerPubSubChannels(String... channels) {
		API.registerPubSubChannels(channels);
	}

	@Override
	public void sendChannelMessage(@NonNull String channel, @NonNull String message) {
		API.sendChannelMessage(channel, message);
	}

	@EventHandler
	public void onPubSubMessage(PubSubMessageEvent pEvent) {
		PubSubMessageManager.getInstance().invokePubSubMessageEvent(pEvent.getChannel(), pEvent.getMessage());
	}
}
