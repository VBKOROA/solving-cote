import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public String[] solution(String[] record) {
		Map<String, String> users = new HashMap<>();
		List<String[]> commandList = new ArrayList<>();

		for (String log : record) {
			String[] commands = log.split(" ");
			switch (commands[0]) {
				case "Enter":
				case "Change":
					users.put(commands[1], commands[2]);
					break;
				default:
					break;
			}
			commandList.add(commands);
		}

		List<String> answer = new ArrayList<>();

		for (String[] commands : commandList) {
			switch (commands[0]) {
				case "Enter":
					answer.add(users.get(commands[1]) + "님이 들어왔습니다.");
					break;
				case "Leave":
					answer.add(users.get(commands[1]) + "님이 나갔습니다.");
					break;
				default:
					break;
			}
		}

		return answer.toArray(String[]::new);
	}
}
