from typing import List

class Song:
    def __init__(self, id: int, genre: str, play: int):
        self.id = id
        self.play = play
        self.genre = genre

def solution(genres: List[str], plays: List[int]):
    plays_by_genre: dict[str, int] = {}
    
    songs = []
    
    for idx, info in enumerate(zip(genres, plays)):
        genre = info[0]
        play = info[1]
        
        songs.append(Song(idx, genre, play))
        
        if genre in plays_by_genre:
            plays_by_genre[genre] += play
        else:
            plays_by_genre[genre] = play
            
    filtered_songs = sum(
        [sorted(
            [song for song in songs if song.genre == genre], 
            key=lambda song: song.play, 
            reverse=True)[:2] 
         for genre in plays_by_genre.keys()], 
        [])
            
    genre_rank_by_plays = {
        info[0]: rank 
        for rank, info in enumerate(sorted(
            plays_by_genre.items(), 
            key = lambda entry: entry[1], 
            reverse=True))}
    
    return [song.id for song in sorted(
        filtered_songs, 
        key=lambda song: (genre_rank_by_plays[song.genre], -song.play, song.id))]