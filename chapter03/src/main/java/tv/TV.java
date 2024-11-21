package tv;

public class TV {

	private int channel;
	private int volume;
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public void status() {
		System.out.print("TV [channel=" + channel + ", volume=" + volume + ", power=");
		
		if (power) {
			System.out.println("on]");
		} else {
			System.out.println("off]");
		}
	}

	public void isPower() {
		if (power == false) {
			System.out.println("TV가 꺼져있습니다.");
		}
	}

	public void power(boolean on) {
		if (on) {
			if (power) {
				System.out.println("TV가 이미 켜져있습니다.");
				return;
			}
			
			power = true;
		} else {
			if (power == false) {
				System.out.println("TV가 이미 꺼져있습니다.");
				return;
			}
			
			power = false;
		}
	}

	public void channel(int channel) {
		if (!power) {
			isPower();
		}
		
		if (channel > 255 || channel < 1) {
			System.out.println("유효하지 않은 채널입니다.");
			return;
		}
		
		this.channel = channel;
	}

	public void channel(boolean up) {
		if (!power) {
			isPower();
		}
		
		if (up) {
			if (channel >= 255) {
				channel = 1;
			} else {
				channel++;
			}
		} else {
			if (channel <= 1) {
				channel = 255;
			} else {
				channel--;
			}
		}
	}
	
	public void volume(int volume) {
		if (!power) {
			isPower();
		}
		
		if (volume > 100 || volume < 0) {
			System.out.println("유효하지 않은 볼륨입니다.");
			return;
		}
		
		this.volume = volume;
	}
	
	public void volume(boolean up) {
		if (!power) {
			isPower();
		}
		
		if (up) {
			if (volume >= 100) {
				volume = 1;
			} else {
				volume++;
			}
		} else {
			if (volume <= 0) {
				volume = 100;
			} else {
				volume--;
			}
		}
	}
}
