
public class Question{

	private Object partOne;
	private Object partTwo;
	
	private Object optionOne;
	private Object optionTwo;
	private Object optionThree;
	private Object optionFour;
	
	private Object correctOption;
	
	public Question() {
		
	}

	public Question(Object partOne, Object partTwo, Object optionOne, Object optionTwo, Object optionThree,
			Object optionFour) {
		
		this.partOne = partOne;
		this.partTwo = partTwo;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
	}

	public Object getPartOne() {
		return partOne;
	}

	public void setPartOne(Object partOne) {
		this.partOne = partOne;
	}

	public Object getPartTwo() {
		return partTwo;
	}

	public void setPartTwo(Object partTwo) {
		this.partTwo = partTwo;
	}

	public Object getOptionOne() {
		return optionOne;
	}

	public void setOptionOne(Object optionOne) {
		this.optionOne = optionOne;
	}

	public Object getOptionTwo() {
		return optionTwo;
	}

	public void setOptionTwo(Object optionTwo) {
		this.optionTwo = optionTwo;
	}

	public Object getOptionThree() {
		return optionThree;
	}

	public void setOptionThree(Object optionThree) {
		this.optionThree = optionThree;
	}

	public Object getOptionFour() {
		return optionFour;
	}

	public void setOptionFour(Object optionFour) {
		this.optionFour = optionFour;
	}

	public Object getCorrectOption() {
		if(partOne instanceof Integer) {
			Integer tp1 = (Integer) partOne;
			if(partTwo instanceof Integer) {
				Integer tp2 = (Integer) partTwo;
				return tp1 + tp2;
			}
			else if(partTwo instanceof Double) {
				Double tp2 = (Double) partTwo;
				return tp1 + tp2;	
			}
			else if(partTwo instanceof String) {
				String tp2 = (String) partTwo;
				return tp1 + tp2;
			}
		}
		else if(partOne instanceof Double || partOne instanceof Float) {
			Double tp1 = (Double) partOne;
			if(partTwo instanceof Integer) {
				Integer tp2 = (Integer) partTwo;
				return tp1 + tp2;
			}
			else if(partTwo instanceof Double) {
				Double tp2 = (Double) partTwo;
				return tp1 + tp2;	
			}
			else if(partTwo instanceof String) {
				String tp2 = (String) partTwo;
				return tp1 + tp2;
			}
		}
		else if(partOne instanceof String) {
			String tp1 = (String) partOne;
			if(partTwo instanceof Integer) {
				Integer tp2 = (Integer) partTwo;
				return tp1 + tp2;
			}
			else if(partTwo instanceof Double) {
				Double tp2 = (Double) partTwo;
				return tp1 + tp2;	
			}
			else if(partTwo instanceof String) {
				String tp2 = (String) partTwo;
				return tp1 + tp2;
			}
		}
		return null;
	}

	public void setCorrectOption(Object correctOption) {
		this.correctOption = correctOption;
	}
	
	
}
