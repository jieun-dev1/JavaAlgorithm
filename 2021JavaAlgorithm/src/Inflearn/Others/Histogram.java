package Inflearn.Others;

import java.io.*;
import java.util.StringTokenizer;

//1. �־����� ���� ����: 7 2 1 4 5 1 3 3
//2. N�� ù�� ° ��. �־����� ������ ������.
//height �� long type�� ����. ����� �� 10���̱� ������ �� ū ���� long�� �־���. max �� height x ���̴ϱ� �� ū long�� ��.

//����: https://steady-coding.tistory.com/129
public class Histogram {
    static int[] arr, tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferReader �� ������ �а�, �� ���ο��� Ư�� ���ڿ��� �о���̷��� StringTokenizer ����ؾ� �Ѵ�.
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine()); //������ �����ϴ� ������, �� (N==0)�� �����ϱ� ��������, ���� �д´�.
            int N = Integer.parseInt(st.nextToken()); //N�� �� ���� ù ���ڴ�. nextToken���� ��������� ���� �� �ִ�. Integer.parseInt�� String Ÿ�� ���ڸ� Int Ÿ�� ���ڷ� ����.
            if(N == 0) {
                break; //�־����� ���ڰ� 0�̸� �ݺ����� Ż���Ѵ�. �Է��� ������ �ٿ��� 0�� �ϳ� �־����Ƿ�.
            }

            arr = new int[N+1]; // �ε����� 1���� �����Ѵ�.
            for (int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); // ���ٿ��� arr �迭�� �ϼ��ϰ� ����, while(true)�ϱ� N=0�� ���� ������ ��� ARR �迭�� �������.
            }

            tree = new int[N*4]; //Ʈ���� ����� ũ�� �����.
            init(1,1,N);
            sb.append(getMax(1,N,N)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //Ʈ�� ���� ������ֱ�
    public static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = start;
        } else {
            int mid = (start + end) /2;
            init(node *2, start, mid);
            init(node*2+1, mid+1, end);

            if(arr[tree[node*2]]<= arr[tree[node*2+1]]){
                tree[node] = tree[node*2]; //�ڽĳ�� ��/�� �� �� ���� ���� �θ� ��忡 �־��ֱ�.
            } else {
                tree[node] = tree[node*2+1];
            }
        }
    }


    //Ư�� ���� ���� �ּ� ���� �ε����� ���ϱ�.
    //left-right : �־��� ����
    //left-right : Ž�� ������ ex. start - end �� 1-4�ε�, 3-7�� ���Ѵٸ�, 1-2�� -1�� �ǰ�, 3-4�� rmin ���� �������� ��.
    public static int query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) { // 1-2 (end) ���� ���. �ƿ� ������ ���Ե��� ���� ��.
            return -1; // ���� ���� ���� 0�� �־�����. index ���� ���� ���� �ּҰ��̶�� �� �����ϱ� -1�� ��. return�� �ϸ� �޼��带 ����������.
        }
        if (left <= start && end <= right){ //���ϴ� ���� ���� ������ ���Ե� ��.
            return tree[node]; //tree[node]�� �ּڰ��� �����Ѵ�. node �� 1�� �� tree �迭�� 1�ε����� �����ϴ� ��. 5�� ����� 3-4 ���������� 10�� ��尡 ����Ű�� 3�� ����Ǿ� ����.
        }

        //1-4 ���� ���� �ɰ��� ��. lmin = -1 �̴� rmin �� �ǰ���. -1�� �ƴ� ���, tree[node] �� ����Ǿ� ����.
        int mid = (start + end) / 2;
        int lmin = query (start, mid, node*2,  left, right);
        int rmin = query (mid+1, end, node*2+1, left, right);

        if(lmin == -1) {
            return rmin; //lmin �̳� rmin �� ���ϴ� ���� ���� ���ٸ�(-1�̶��), �ٸ� ������ �ּ� ������ �����Ѵ�.
        } else if (rmin == -1) {
            return lmin; //
        } else {
            if(arr[lmin] <= arr[rmin]) {
                return lmin;
            } else {
                return rmin;
            }
//            return Math.min(lmin, rmin); //���� index�� ����Ű�� ������ ���ؾ� ��. (
        }
    }

    //�ִ� ���ϱ�: ���� X (END - START+1)
    //MAX �� Main �Լ����� �Ʒ��� ���� �Ҹ�.
    //sb.append(getMax(1,N,N)+"\n");
    public static long getMax(int start, int end, int N) {
        int m = query(1,N,1,start,end); //ó������ 1,N���� ������. m�� �ּ� ���̸� ���� index ��..
        long area = (end-start+1) * (long)arr[m];

        //���� ���� ���� ���� Ȯ��
        if(start <= m-1) {
            long tmp = getMax(start, m-1, N);
            area = Math.max(area, tmp);
        }

        //������ ���� ���� ���� Ȯ��
        if(m+1 <= end) {
            long tmp = getMax(m+1, end, N);
            area = Math.max(area, tmp);
        }
        return area;
    }
}
