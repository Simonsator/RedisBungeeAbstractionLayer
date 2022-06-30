package de.simonsator.abstractredisbungee.legacy;

import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import io.github.invvk.redisvelocity.jedis.JedisPool;

import java.io.IOException;

public class InvvkFakeJedisPool extends FakeJedisPool {
	private final JedisPool SOURCE;

	public InvvkFakeJedisPool(JedisPool pPool) {
		SOURCE = pPool;
	}

	@Override
	public FakeJedis getResource() {
		return new InvvkFakeJedis(SOURCE.getResource());
	}

	@Override
	public void close() throws IOException {
		SOURCE.close();
	}
}
