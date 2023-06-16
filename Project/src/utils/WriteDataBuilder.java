package utils;

public class WriteDataBuilder {
	private String result = "";

	public WriteDataBuilder add(String string) {
		if (result != "") {
			result += "#";
		}
		result += string;
		return this;
	}

	public WriteDataBuilder add(int integer) {
		result += integer;
		return this;
	}

	public String getResult() {
		result += "\n";
		return result;
	}

}
