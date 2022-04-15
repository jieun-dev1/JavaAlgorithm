package Programmers;

class TargetNum {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, 0, 0, target);
		return answer;
	}

	// 재귀함수로 풀기
	public int dfs(int[] numbers, int sum, int depth, int target) {
		if (numbers.length == depth) {
			if (sum == target)
				return 1;
			else
				return 0;
		}

		return dfs(numbers, sum + numbers[depth], depth + 1, target)
				+ dfs(numbers, sum - numbers[depth], depth + 1, target);

	}
}