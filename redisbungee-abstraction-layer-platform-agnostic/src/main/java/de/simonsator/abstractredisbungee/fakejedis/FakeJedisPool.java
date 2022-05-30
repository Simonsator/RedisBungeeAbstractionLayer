package de.simonsator.abstractredisbungee.fakejedis;

import java.io.Closeable;

public abstract class FakeJedisPool implements Closeable {
	public abstract FakeJedis getResource();
}
