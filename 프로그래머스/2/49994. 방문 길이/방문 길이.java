import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static final String PATH_STRING_MIDDLE = "+";
	private static final String COOR_STRING_MIDDLE = "/";
	private final StringBuilder sb = new StringBuilder();

	public int solution(String dirs) {
		Set<String> visited = new HashSet<>();
		int xyMax = 10;
		int xyMin = 0;
		int selfX = 5;
		int selfY = 5;
		String[] dirArray = dirs.split("");

		for (String dir : dirArray) {
			switch (dir) {
				case "U":
					// 위로
					if (selfY + 1 <= xyMax) {
						String beforeCoor = coorToString(selfX, selfY);
						selfY++;
						String afterCoor = coorToString(selfX, selfY);
						visited.add(coorsToPath(beforeCoor, afterCoor));
						visited.add(coorsToPath(afterCoor, beforeCoor));
					}
					break;
				case "D":
					// 밑으로
					if (selfY - 1 >= xyMin) {
						String beforeCoor = coorToString(selfX, selfY);
						selfY--;
						String afterCoor = coorToString(selfX, selfY);
						visited.add(coorsToPath(beforeCoor, afterCoor));
						visited.add(coorsToPath(afterCoor, beforeCoor));
					}
					break;
				case "R":
					// 오른쪽
					if (selfX + 1 <= xyMax) {
						String beforeCoor = coorToString(selfX, selfY);
						selfX++;
						String afterCoor = coorToString(selfX, selfY);
						visited.add(coorsToPath(beforeCoor, afterCoor));
						visited.add(coorsToPath(afterCoor, beforeCoor));
					}
					break;
				case "L":
					// 왼쪽
					if (selfX - 1 >= xyMin) {
						String beforeCoor = coorToString(selfX, selfY);
						selfX--;
						String afterCoor = coorToString(selfX, selfY);
						visited.add(coorsToPath(beforeCoor, afterCoor));
						visited.add(coorsToPath(afterCoor, beforeCoor));
					}
					break;
			}
		}

		int answer = visited.size() / 2;
		return answer;
	}

	private String coorToString(int x, int y) {
		sb.setLength(0); // sb 클리어
		return sb.append(x)
			.append(COOR_STRING_MIDDLE)
			.append(y)
			.toString();
	}

	private String coorsToPath(String before, String after) {
		sb.setLength(0);
		return sb.append(before)
			.append(PATH_STRING_MIDDLE)
			.append(after)
			.toString();
	}
}
