package Hash;

import java.util.HashMap;

/** 완주하지 못한 선수
 문제 설명
 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 제한사항
 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 completion의 길이는 participant의 길이보다 1 작습니다.
 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 참가자 중에는 동명이인이 있을 수 있습니다.
 */

public class Hash01 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> map = new HashMap<String, Integer>();

        // 먼저 <참가선수명, 선수숫자> 를 해시에 담는다
        for (int i = 0 ; i < participant.length ; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }

        // <참가선수명, 선수숫자에서 완주한 선수의 숫자를 뺀 숫자> 로 바꿔준다
        for (int i = 0 ; i < completion.length ; i++){
            if(map.containsKey(completion[i])){
                map.put(completion[i], map.get(completion[i] )-1);
            }
        }

        // 남은 1명을 리턴값에 담는다
        for (String s : map.keySet()){
            if(map.get(s) == 1){
                answer = s;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));
    }
}
