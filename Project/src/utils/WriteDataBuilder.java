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
		if (result != "") {
			result += "#";
		}
		result += integer;
		return this;
	}

	public WriteDataBuilder add(double decimal) {
		if (result != "") {
			result += "#";
		}
		result += decimal;
		return this;
	}

	public String getResult() {
		result += "\n";
		return result;
	}

}
