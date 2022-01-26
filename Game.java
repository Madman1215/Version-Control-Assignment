
public class Game {

	private String name;
	private int score;
	private int time;
	
	public Game() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s%-10d%3dsec", name, score, time);
	}
	
}
