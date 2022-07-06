package de.simonsator.abstractredisbungee;

import de.simonsator.abstractredisbungee.legacy.LegacyRedisBungeeAPI;
import de.simonsator.abstractredisbungee.limework.LimeworkRedisBungeeAPI;
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
		return false;
	}
}
