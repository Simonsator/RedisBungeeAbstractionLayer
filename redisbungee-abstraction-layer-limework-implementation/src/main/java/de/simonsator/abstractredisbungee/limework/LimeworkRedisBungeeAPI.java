package de.simonsator.abstractredisbungee.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class LimeworkRedisBungeeAPI extends CommonLimeworkRedisBungeeAPI {

	public LimeworkRedisBungeeAPI(Plugin pPluginInstance) {
		super(pPluginInstance);
	}

	@Override
	public ServerInfo getServerFor(@NonNull UUID player) {
		String info = API.getServerFor(player);
		if (info != null)
			return ProxyServer.getInstance().getServerInfo(info);
		return null;
	}

	@SuppressWarnings("deprecation")
	public static boolean isCompatible() {
		try {
			Object redisbungee = ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee");
			if (redisbungee != null && !(redisbungee instanceof com.imaginarycode.minecraft.redisbungee.RedisBungee)) {
				return RedisBungeeAPI.class.getMethod("getServerFor", UUID.class).
						getReturnType().getName().equals("java.lang.String");
			}
		} catch (Exception ignored) {

		}
		return false;
	}
}
