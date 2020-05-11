package data;

public class ShopriteTime {
	private String hour;
	private String min;
	private String meridian;
	
	public ShopriteTime(String hour, String min, String meridian) {
		this.hour = hour;
		this.min = min;
		this.meridian = meridian;
	}
	
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMeridian() {
		return meridian;
	}

	public void setMeridian(String meridian) {
		this.meridian = meridian;
	}

	@Override
	public String toString() {
		return "ShopriteTime [hour=" + hour + ", min=" + min + ", meridian=" + meridian + "]";
	}
}
