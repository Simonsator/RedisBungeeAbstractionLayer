package de.simonsator.abstractredisbungee.events;

public interface PubSubMessageListener {
	void onMessageReceived(String pChannel, String message);
}
