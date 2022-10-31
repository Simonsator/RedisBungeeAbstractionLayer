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

	@Override
	public ServerInfo getServerFor(@NonNull UUID player) {
		return API.getServerFor(player);
	}

	@SuppressWarnings("deprecation")
	public static boolean isCompatible() {
		try {
			Object redisbungee = ProxyServer.getInstance().getPluginManager().getPlugin("RedisBungee");
			if (redisbungee != null && !(redisbungee instanceof com.imaginarycode.minecraft.redisbungee.RedisBungee)) {
				if (redisbungee.getClass().getName().equals("com.imaginarycode.minecraft.redisbungee.RedisBungee"))
					return RedisBungeeAPI.class.getMethod("getServerFor", UUID.class).
							getReturnType().getName().equals("net.md_5.bungee.api.config.ServerInfo");
			}
		} catch (Exception ignored) {

		}
		return false;
	}
}
