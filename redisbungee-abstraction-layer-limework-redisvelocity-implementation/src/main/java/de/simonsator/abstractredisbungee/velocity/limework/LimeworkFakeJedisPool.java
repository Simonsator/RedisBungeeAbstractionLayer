package de.simonsator.abstractredisbungee.velocity.limework;

import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;
import com.imaginarycode.minecraft.redisbungee.internal.jedis.JedisPool;

import java.io.IOException;

public class LimeworkFakeJedisPool extends FakeJedisPool {
	private final JedisPool SOURCE;

	public LimeworkFakeJedisPool(JedisPool pPool) {
		SOURCE = pPool;
	}

	@Override
	public FakeJedis getResource() {
		return new LimeworkFakeJedis(SOURCE.getResource());
	}

	@Override
	public void close() throws IOException {
		SOURCE.close();
	}
}
