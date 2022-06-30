package de.simonsator.abstractredisbungee;

import de.simonsator.abstractredisbungee.legacy.InvvkRedisBungeeAPI;

public class FakeRedisBungeeInit {
	public static boolean init() {
		if (InvvkRedisBungeeAPI.isCompatible()) {
			new InvvkRedisBungeeAPI();
			return true;
		}
		return false;
	}
}
