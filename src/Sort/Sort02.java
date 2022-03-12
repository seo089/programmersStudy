package Sort;

import java.util.Arrays;

/**문제 설명
 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
 이중 가장 큰 수는 6210입니다.

 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

 제한 사항
 numbers의 길이는 1 이상 100,000 이하입니다.
 numbers의 원소는 0 이상 1,000 이하입니다.
 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.*/

public class Sort02 {

    public static String solution(int[] numbers) {
        String answer = "";

        //numbers 배열 String 타입으로 바꿔서 arr 배열에 저장
        String[] arr = new String[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        //내림차순 정렬
        //s2+s1(106)이 s1+s2(610)보다 더 크다면 자리 바꿔서 정렬
        Arrays.sort(arr, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        //0이 중복인 numbers 배열일 때 0 리턴
        if(arr[0].equals("0")) return "0";

        for(String s : arr){
            answer += s;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(solution(numbers));
    }
}
