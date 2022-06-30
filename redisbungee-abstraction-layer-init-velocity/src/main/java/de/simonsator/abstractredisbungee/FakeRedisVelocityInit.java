package de.simonsator.abstractredisbungee;

import de.simonsator.abstractredisbungee.legacy.InvvkRedisVelocityAPI;

public class FakeRedisVelocityInit {
	public static boolean init() {
		if (InvvkRedisVelocityAPI.isCompatible()) {
			new InvvkRedisVelocityAPI();
			return true;
		}
		return false;
	}
}
