package Inflearn.Others;

import java.io.*;
import java.util.StringTokenizer;

//1. 주어지는 값의 예시: 7 2 1 4 5 1 3 3
//2. N은 첫번 째 값. 주어지는 원소의 갯수다.
//height 가 long type인 이유. 양수는 약 10억이기 때문에 더 큰 값인 long을 주었다. max 는 height x 길이니까 더 큰 long을 줌.

//참고: https://steady-coding.tistory.com/129
public class Histogram {
    static int[] arr, tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferReader 로 라인을 읽고, 그 라인에서 특정 문자열을 읽어들이려면 StringTokenizer 사용해야 한다.
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine()); //라인이 존재하는 동안은, 즉 (N==0)이 등장하기 전까지는, 값을 읽는다.
            int N = Integer.parseInt(st.nextToken()); //N은 한 줄의 첫 숫자다. nextToken으로 공백단위로 읽을 수 있다. Integer.parseInt로 String 타입 숫자를 Int 타입 숫자로 읽자.
            if(N == 0) {
                break; //주어지는 숫자가 0이면 반복문을 탈출한다. 입력의 마지막 줄에는 0이 하나 주어지므로.
            }

            arr = new int[N+1]; // 인덱스는 1부터 시작한다.
            for (int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); // 한줄에서 arr 배열을 완성하고 나면, while(true)니까 N=0이 나올 때까지 계속 ARR 배열이 만들어짐.
            }

            tree = new int[N*4]; //트리는 충분히 크게 만든다.
            init(1,1,N);
            sb.append(getMax(1,N,N)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //트리 구조 만들어주기
    public static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = start;
        } else {
            int mid = (start + end) /2;
            init(node *2, start, mid);
            init(node*2+1, mid+1, end);

            if(arr[tree[node*2]]<= arr[tree[node*2+1]]){
                tree[node] = tree[node*2]; //자식노드 좌/우 중 더 작은 값을 부모 노드에 넣어주기.
            } else {
                tree[node] = tree[node*2+1];
            }
        }
    }


    //특정 구간 내의 최소 높이 인덱스를 구하기.
    //left-right : 주어진 범위
    //left-right : 탐색 범위위 ex. start - end 가 1-4인데, 3-7을 구한다면, 1-2는 -1이 되고, 3-4의 rmin 값만 구해지는 것.
    public static int query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) { // 1-2 (end) 같은 경우. 아예 범위가 포함되지 않을 때.
            return -1; // 합을 구할 때는 0을 넣었었다. index 범위 밗일 때는 최소값이라는 게 없으니까 -1이 됨. return을 하면 메서드를 빠져나간다.
        }
        if (left <= start && end <= right){ //구하는 범위 내에 완전히 포함될 때.
            return tree[node]; //tree[node]는 최솟값을 포함한다. node 가 1일 때 tree 배열의 1인덱스를 리턴하는 것. 5번 노드인 3-4 구간에서는 10번 노드가 가리키는 3이 저장되어 있음.
        }

        //1-4 같은 경우는 쪼개야 함. lmin = -1 이니 rmin 이 되겠지. -1이 아닌 경우, tree[node] 가 저장되어 있음.
        int mid = (start + end) / 2;
        int lmin = query (start, mid, node*2,  left, right);
        int rmin = query (mid+1, end, node*2+1, left, right);

        if(lmin == -1) {
            return rmin; //lmin 이나 rmin 이 구하는 범위 값에 없다면(-1이라면), 다른 한쪽을 최소 값으로 간주한다.
        } else if (rmin == -1) {
            return lmin; //
        } else {
            if(arr[lmin] <= arr[rmin]) {
                return lmin;
            } else {
                return rmin;
            }
//            return Math.min(lmin, rmin); //실제 index가 가리키는 값으로 비교해야 함. (
        }
    }

    //최댓값 구하기: 높이 X (END - START+1)
    //MAX 는 Main 함수에서 아래와 같이 불림.
    //sb.append(getMax(1,N,N)+"\n");
    public static long getMax(int start, int end, int N) {
        int m = query(1,N,1,start,end); //처음에는 1,N부터 시작함. m은 최소 높이를 가진 index 다..
        long area = (end-start+1) * (long)arr[m];

        //왼쪽 막대 존재 여부 확인
        if(start <= m-1) {
            long tmp = getMax(start, m-1, N);
            area = Math.max(area, tmp);
        }

        //오른쪽 막대 존재 여부 확인
        if(m+1 <= end) {
            long tmp = getMax(m+1, end, N);
            area = Math.max(area, tmp);
        }
        return area;
    }
}
