package de.simonsator.abstractredisbungee.fakejedis;

import java.util.List;
import java.util.Set;

public abstract class FakeJedis implements AutoCloseable {
	public abstract void close();

	public abstract String hget(String key, String field);

	public abstract Long hset(String key, String field, String value);

	public abstract void hdel(String key, String... fields);

	public abstract Set<String> keys(String pattern);

	public abstract String get(String key);

	public abstract String set(String key, String value);

	public abstract String setex(String key, int seconds, String value);

	public abstract FakeJedisTransaction multi();

	public abstract List<String> lrange(String key, long start, long stop);

	public abstract Long lrem(String key, long count, String value);

	public abstract Long lpush(String key, String... strings);

	public abstract Long llen(String key);

	public abstract Boolean sismember(String key, String member);

	public abstract Long sadd(String key, String... members);

	public abstract Long srem(String key, String... members);
}
