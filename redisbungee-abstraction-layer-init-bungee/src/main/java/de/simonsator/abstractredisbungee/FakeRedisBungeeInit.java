package de.simonsator.abstractredisbungee;

import de.simonsator.abstractredisbungee.legacy.LegacyRedisBungeeAPI;
import de.simonsator.abstractredisbungee.limework.LimeworkRedisBungeeAPI;
import de.simonsator.abstractredisbungee.limework.ModernLimeworkRedisBungeeAPI;
import net.md_5.bungee.api.plugin.Plugin;

public class FakeRedisBungeeInit {
	public static boolean init(Plugin pPluginInstance) {
		if (LegacyRedisBungeeAPI.isCompatible()) {
			new LegacyRedisBungeeAPI(pPluginInstance);
			return true;
		}
		if (LimeworkRedisBungeeAPI.isCompatible()) {
			new LimeworkRedisBungeeAPI(pPluginInstance);
			return true;
		}
		if (ModernLimeworkRedisBungeeAPI.isCompatible()) {
			new ModernLimeworkRedisBungeeAPI(pPluginInstance);
			return true;
		}
		return false;
	}
}
