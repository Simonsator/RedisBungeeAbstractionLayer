package de.simonsator.abstractredisbungee.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Plugin;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.UUID;

public class ModernLimeworkRedisBungeeAPI extends CommonLimeworkRedisBungeeAPI {
	public ModernLimeworkRedisBungeeAPI(Plugin pPluginInstance) {
		super(pPluginInstance);
	}

	@SuppressWarnings("deprecation")
	public static boolean isCompatible() {
		try {
			Object redisbungee = ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee");
			if (redisbungee instanceof com.imaginarycode.minecraft.redisbungee.RedisBungee) {
				Class.forName("com.imaginarycode.minecraft.redisbungee.AbstractRedisBungeeAPI");
				return RedisBungeeAPI.class.getMethod("getServerFor", UUID.class).
						getReturnType().getName().equals("net.md_5.bungee.api.config.ServerInfo");
			}
		} catch (Exception ignored) {
			ignored.printStackTrace();
		}
		return false;
	}

	@Override
	public ServerInfo getServerFor(@NonNull UUID player) {
		return API.getServerFor(player);
	}
}
