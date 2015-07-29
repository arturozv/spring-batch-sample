package com.zenval.util;
import java.time.Duration;
import java.time.Instant;

public class TimeDuration {
	public final static long getMillisSince(Instant start) {
		return Duration.between(start, Instant.now()).toMillis();
	}
}
