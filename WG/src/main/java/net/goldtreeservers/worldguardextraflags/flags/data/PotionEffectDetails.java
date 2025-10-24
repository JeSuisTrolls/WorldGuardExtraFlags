package net.goldtreeservers.worldguardextraflags.flags.data;

import java.util.concurrent.TimeUnit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PotionEffectDetails
{
	private final long endTime;
	private final int amplifier;
	private final boolean ambient;
	private final boolean particles;

    public long getTimeLeft()
	{
		return (this.endTime - System.nanoTime());
	}

	public int getTimeLeftInTicks()
	{
		return (int)(this.getTimeLeft() / TimeUnit.MILLISECONDS.toNanos(50L));
	}
}
