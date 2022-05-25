package de.simonsator.abstractredisbungee.fakejedis;

public abstract class FakeJedisTransaction {
	public abstract void setex(String key, int seconds, String value);

	public abstract void del(String key);

	public abstract void set(String key, String value);

	public abstract void exec();
}
