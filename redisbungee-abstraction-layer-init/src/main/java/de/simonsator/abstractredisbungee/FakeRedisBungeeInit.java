package de.simonsator.abstractredisbungee;

import de.simonsator.abstractredisbungee.legacy.LegacyRedisBungeeAPI;
import de.simonsator.abstractredisbungee.limework.LimeworkRedisBungeeAPI;

public class FakeRedisBungeeInit {
	public static boolean init() {
		if (LegacyRedisBungeeAPI.isCompatible()) {
			new LegacyRedisBungeeAPI();
			return true;
		}
		if (LimeworkRedisBungeeAPI.isCompatible()) {
			new LimeworkRedisBungeeAPI();
			return true;
		}
		return false;
	}
}
