import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int[] solution(String[] genres, int[] plays) {
		Map<String, List<Song>> songsByGenre = new HashMap<>();
		Map<String, Integer> totalPlaysByGenre = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			songsByGenre.computeIfAbsent(genres[i], (key) -> new ArrayList<>()).add(new Song(i, plays[i]));
			totalPlaysByGenre.merge(genres[i], plays[i], Integer::sum);
		}

		List<Integer> answer = new ArrayList<>();

		totalPlaysByGenre.entrySet()
			.stream()
			.sorted(Comparator.comparingInt((Map.Entry<String, Integer> entry) -> entry.getValue()).reversed())
			.forEach((entry) -> {
				songsByGenre.get(entry.getKey()).stream().sorted(Comparator.comparingInt((Song song) -> song.plays)
						.reversed()
						.thenComparingInt((Song song) -> song.idx))
					.limit(2)
					.forEach(song -> {
						answer.add(song.idx);
					});
			});

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	class Song {
		public int idx;
		public int plays;

		public Song(int idx, int plays) {
			this.idx = idx;
			this.plays = plays;
		}
	}
}
