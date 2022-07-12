package de.simonsator.abstractredisbungee.events;

import java.util.LinkedList;
import java.util.List;

public class PubSubMessageManager {
	private static PubSubMessageManager instance;
	private final List<PubSubMessageListener> LISTENERS = new LinkedList<>();

	public static PubSubMessageManager getInstance() {
		return instance;
	}

	public PubSubMessageManager() {
		instance = this;
	}

	public void registerPubSubMessageEvent(PubSubMessageListener pReceiver) {
		LISTENERS.add(pReceiver);
	}

	public void unregisterPubSubMessageEvent(PubSubMessageListener pReceiver) {
		LISTENERS.remove(pReceiver);
	}

	public void invokePubSubMessageEvent(String pChannel, String message) {
		for (PubSubMessageListener listener : LISTENERS)
			listener.onMessageReceived(pChannel, message);
	}
}
