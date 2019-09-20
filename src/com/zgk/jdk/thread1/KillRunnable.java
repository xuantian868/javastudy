package com.zgk.jdk.thread1;

//实现Runnable接口
public class KillRunnable implements Runnable{

	private ThreadHero zhengyi;
	private ThreadHero heian;

	public KillRunnable(ThreadHero zhengyi, ThreadHero heian) {
		this.zhengyi = zhengyi;
		this.heian = heian;
	}
	
	@Override
	public void run() {
		while (!heian.isDead()) {
			zhengyi.attackHero(heian);
		}
	}

}
