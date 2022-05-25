package de.simonsator.abstractredisbungee.legacy;

import com.imaginarycode.minecraft.redisbungee.internal.jedis.JedisPool;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;

import java.io.IOException;

public class LegacyFakeJedisPool extends FakeJedisPool {
	private final JedisPool SOURCE;

	public LegacyFakeJedisPool(JedisPool pPool) {
		SOURCE = pPool;
	}

	@Override
	public FakeJedis getResource() {
		return new LegacyFakeJedis(SOURCE.getResource());
	}

	@Override
	public void close() throws IOException {
		SOURCE.close();
	}
}
