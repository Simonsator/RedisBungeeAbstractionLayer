package de.simonsator.abstractredisbungee.legacy;

import de.simonsator.abstractredisbungee.fakejedis.FakeJedisTransaction;
import io.github.invvk.redisvelocity.jedis.Transaction;

public class InvkFakeJedisTransaction extends FakeJedisTransaction {
	private final Transaction SOURCE;

	public InvkFakeJedisTransaction(Transaction pTransaction) {
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
