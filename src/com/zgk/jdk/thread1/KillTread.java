package com.zgk.jdk.thread1;

public class KillTread extends Thread{
	private ThreadHero zhengyi;
	private ThreadHero heian;

	public KillTread(ThreadHero zhengyi, ThreadHero heian) {
		this.zhengyi = zhengyi;
		this.heian = heian;
	}

	@Override
	public void run() {
		super.run();
		while (!heian.isDead()) {
			zhengyi.attackHero(heian);
		}
	}
}
