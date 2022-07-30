package de.simonsator.abstractredisbungee;

import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.abstractredisbungee.invk.InvvkRedisVelocityAPI;

public class FakeRedisVelocityInit {
	public static boolean init(ProxyServer pProxyServer, Object pMainPluginObject) {
		if (InvvkRedisVelocityAPI.isCompatible()) {
			new InvvkRedisVelocityAPI(pProxyServer, pMainPluginObject);
			return true;
		}
		return false;
	}
}
