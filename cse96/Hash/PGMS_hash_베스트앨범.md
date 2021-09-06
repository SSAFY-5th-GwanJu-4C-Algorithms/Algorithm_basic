![image](https://user-images.githubusercontent.com/78025547/132246663-e74ef922-e022-4dd6-9a76-3f33a32188ce.png)

ㅠㅠ
```
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //장르별 누적 재생 수
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		//각 곡별 재생된 횟수 - 인덱스 저장을 위한 해시맵의 해시맵
		HashMap<String,HashMap<Integer,Integer>> playRecord = new HashMap<String,HashMap<Integer,Integer>>();
		int len = genres.length;
		for(int i = 0; i < len; i++) {
			if(hashMap.containsKey(genres[i])) {
				hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);
			}
			else {
				hashMap.put(genres[i], plays[i]);
			}
			//각 장르별 플레이 기록
			if(playRecord.containsKey(genres[i])) {
				//재생 횟수를 key값으로 인덱스를 value로 넣음
				playRecord.get(genres[i]).put(plays[i],i);
			}
			else {
				playRecord.put(genres[i], new HashMap<Integer,Integer>());
				playRecord.get(genres[i]).put(plays[i],i);
			}
		}
		//장르 개수 keySet을 array로..
		String[] genreList = hashMap.keySet().toArray(new String[hashMap.size()]);	
		Arrays.sort(genreList, (o1 , o2) ->{
			return hashMap.get(o2) - hashMap.get(o1);
		});

		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(String genre : genreList) {
			Integer[] selectList = playRecord.get(genre).keySet().toArray(new Integer[playRecord.get(genre).size()]);
            if(selectList.length >= 2){
                for(int i = 0; i < 2; i++) {
                    ans.add(playRecord.get(genre).get(selectList[i]));
                }
            }
            else if (selectList.length == 1){
                ans.add(playRecord.get(genre).get(selectList[0]));
            }
            else continue;
		}
		
		len  = ans.size();
		int[] answer = new int[ans.size()];
		for(int i = 0; i < len; i++) {
			answer[i] = ans.get(i);
		}
		
        return answer;
    }
}

```
막히는 부분 hashMap 정리다시 보면서 생각대로 풀어봤는데
효율이 너무 안나오네요
