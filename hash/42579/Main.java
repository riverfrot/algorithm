import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    class Song implements Comparable<Song> {
        int id;
        int play;
        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }

        @Override
        public  int compareTo(Song anotherSong) {
            if(this.play == anotherSong.play){
                return this.id - anotherSong.id;
            }
            return anotherSong.play - this.play;
        }
    }

    public static void main(String args[]) throws IOException {
//        입출력 예
//        genres	plays	return
//["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
//        입출력 예 설명
//        classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
//
//                고유 번호 3: 800회 재생
//        고유 번호 0: 500회 재생
//        고유 번호 2: 150회 재생
//        pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
//
//                고유 번호 4: 2,500회 재생
//        고유 번호 1: 600회 재생
//        따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
//
//        장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        HashMap<String, Integer> sumMap = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> pqMap = new HashMap<>();
        for(int i=0; i < genres.length ; i++){
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
            pqMap.putIfAbsent(genres[i], new PriorityQueue<>());
            // add 순간 자동으로 compareTo에 의해자동 정렬
            pqMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<String> sortegenres = new ArrayList<>(sumMap.keySet());
        sortegenres.sort((a,b) -> sumMap.get(b) - sumMap.get(a));


        List<Integer> result = new ArrayList<>();
        for(String genre : sortegenres) {
            PriorityQueue<Song> pq = pqMap.get(genre);
            int count = 0;
            while (!pq.isEmpty() && count < 2) {
                result.add(pq.poll().id);
                count++;
            }
        }
        result.stream().mapToInt(i->i).toArray();


    }
}
