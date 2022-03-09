package Hash;

import java.util.Arrays;
import java.util.HashSet;

/**전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

 구조대 : 119
 박준영 : 97 674 223
 지영석 : 11 9552 4421
 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

 제한 사항
 phone_book의 길이는 1 이상 1,000,000 이하입니다.
 각 전화번호의 길이는 1 이상 20 이하입니다.
 같은 전화번호가 중복해서 들어있지 않습니다.
 */

public class Hash02 {

    public static boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        //phone_book 배열의 string을 모두 set에 담는다
        Arrays.stream(phone_book).forEach(s -> set.add(s));

        for(String str : set){
            //set에 담긴 str을 1개부터++ 쪼개서 set에 존재하는지 확인
            for(int i = 1; i < str.length(); i++){
                if(set.contains(str.substring(0, i))){
                    //i번째까지 자른 문자열이랑 같은 str이 있으면 false 리턴
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}
