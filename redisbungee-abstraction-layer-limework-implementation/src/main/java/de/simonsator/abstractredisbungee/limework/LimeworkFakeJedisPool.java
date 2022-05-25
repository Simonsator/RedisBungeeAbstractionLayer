package de.simonsator.abstractredisbungee.limework;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import com.imaginarycode.minecraft.redisbungee.internal.jedis.JedisPool;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;

import java.io.IOException;

public class LimeworkFakeJedisPool extends FakeJedisPool {
	private final RedisBungeeAPI SOURCE;

	public LimeworkFakeJedisPool(RedisBungeeAPI pPool) {
		SOURCE = pPool;
	}

	@Override
	public FakeJedis getResource() {
		return new LimeworkFakeJedis(SOURCE.requestJedis());
	}

	@Override
	public void close() {
	}
}
