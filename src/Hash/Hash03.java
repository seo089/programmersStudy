package Hash;

import java.util.HashMap;
/**문제 설명
 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

 종류	이름
 얼굴	동그란 안경, 검정 선글라스
 상의	파란색 티셔츠
 하의	청바지
 겉옷	긴 코트
 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

 제한사항
 clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 같은 이름을 가진 의상은 존재하지 않습니다.
 clothes의 모든 원소는 문자열로 이루어져 있습니다.
 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 스파이는 하루에 최소 한 개의 의상은 입습니다.*/

public class Hash03 {
    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String,Integer> map = new HashMap<>();

        //map에 <의상종류, 의상종류의 개수> 를 담는다
        for (int i = 0; i<clothes.length ; i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }

        for (String s: map.keySet()) {
            //해당 의상만 입을 경우 (+1)을 포함해서 곱해준다
            answer *= (map.get(s)+1);
        }
        //모든 의상을 선택하지 않았을 경우의 수 -1 해서 리턴
        return answer-1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
