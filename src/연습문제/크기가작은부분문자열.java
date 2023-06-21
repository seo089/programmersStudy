package 연습문제;

public class 크기가작은부분문자열 {

    public static void main(String[] args) {
        String t = "500220839878";
        String p = "7";
        int answer = 0;

       for(int i = 0; i <= t.length() - p.length(); i++){
           if(Long.parseLong(t.substring(i,i+p.length())) <= Long.parseLong(p)){
               answer++;
           }
       }
        System.out.println(answer);
    }

}
