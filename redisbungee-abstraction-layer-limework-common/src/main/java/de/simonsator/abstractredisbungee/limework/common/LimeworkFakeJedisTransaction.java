package de.simonsator.abstractredisbungee.limework.common;

import com.imaginarycode.minecraft.redisbungee.internal.jedis.Transaction;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisTransaction;

public class LimeworkFakeJedisTransaction extends FakeJedisTransaction {
	private final Transaction SOURCE;

	public LimeworkFakeJedisTransaction(Transaction pTransaction) {
		SOURCE = pTransaction;
	}

	@Override
	public void setex(String key, int seconds, String value) {
		SOURCE.setex(key, seconds, value);
	}

	@Override
	public void del(String key) {
		SOURCE.del(key);
	}

	@Override
	public void set(String key, String value) {
		SOURCE.set(key, value);
	}

	@Override
	public void exec() {
		SOURCE.exec();
	}
}
