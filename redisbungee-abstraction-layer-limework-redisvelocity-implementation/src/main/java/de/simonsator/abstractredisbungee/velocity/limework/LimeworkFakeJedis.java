package de.simonsator.abstractredisbungee.velocity.limework;

import de.simonsator.abstractredisbungee.fakejedis.FakeJedis;
import de.simonsator.abstractredisbungee.fakejedis.FakeJedisTransaction;
import com.imaginarycode.minecraft.redisbungee.internal.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class LimeworkFakeJedis extends FakeJedis {
	private final Jedis SOURCE;

	public LimeworkFakeJedis(Jedis pJedis) {
		SOURCE = pJedis;
	}

	@Override
	public void close() {
		SOURCE.close();
	}

	@Override
	public String hget(String key, String field) {
		return SOURCE.hget(key, field);
	}

	@Override
	public Long hset(String key, String field, String value) {
		return SOURCE.hset(key, field, value);
	}

	@Override
	public void hdel(String key, String... fields) {
		SOURCE.hdel(key, fields);
	}

	@Override
	public Set<String> keys(String pattern) {
		return SOURCE.keys(pattern);
	}

	@Override
	public String get(String key) {
		return SOURCE.get(key);
	}

	@Override
	public String set(String key, String value) {
		return SOURCE.set(key, value);
	}

	@Override
	public String setex(String key, int seconds, String value) {
		return SOURCE.setex(key, seconds, value);
	}

	@Override
	public FakeJedisTransaction multi() {
		return new LimeworkFakeJedisTransaction(SOURCE.multi());
	}

	@Override
	public List<String> lrange(String key, long start, long stop) {
		return SOURCE.lrange(key, start, stop);
	}

	@Override
	public Long lrem(String key, long count, String value) {
		return SOURCE.lrem(key, count, value);
	}

	@Override
	public Long lpush(String key, String... strings) {
		return SOURCE.lpush(key, strings);
	}

	@Override
	public Long llen(String key) {
		return SOURCE.llen(key);
	}

	@Override
	public Boolean sismember(String key, String member) {
		return SOURCE.sismember(key, member);
	}

	@Override
	public Long sadd(String key, String... members) {
		return SOURCE.sadd(key, members);
	}

	@Override
	public Long srem(String key, String... members) {
		return SOURCE.srem(key, members);
	}
}
