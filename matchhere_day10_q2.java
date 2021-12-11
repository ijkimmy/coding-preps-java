import java.io.*;
public class matchhere_day10_q2 {
    public static void main(String[] args){
        // BJ 11729
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());

            StringBuilder output = new StringBuilder();
            int cnt = move(n, 1, 3, 2, output);
            System.out.println(cnt);
            System.out.print(output);
        } catch(IOException e){
            System.out.print(e);
        }
    }

    public static int move(int n, int from, int to, int mid, StringBuilder sb){
        if(n==1){
            sb.append(from + " " + to + "\n");
            return 1;
        }

        int cnt = 0;
        cnt += move(n-1, from, mid, to, sb);

        ++cnt;
        sb.append(from + " " + to + "\n");

        cnt += move(n-1, mid, to, from, sb);
        return cnt;
    }
}
