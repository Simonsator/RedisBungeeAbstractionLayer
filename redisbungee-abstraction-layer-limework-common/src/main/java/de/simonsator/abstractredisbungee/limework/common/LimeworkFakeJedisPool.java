package de.simonsator.abstractredisbungee.limework.common;

import com.imaginarycode.minecraft.redisbungee.RedisBungeeAPI;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisPool;

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
