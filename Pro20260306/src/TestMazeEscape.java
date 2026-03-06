import java.util.*;

public class TestMazeEscape {

    public static void main(String[] args) {
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        int result = solution(maps);
        System.out.println(result);
    }

    public static int solution(String[] maps) {
        int h = maps.length;
        int w = maps[0].length();
        int[] start = new int[2], lever = new int[2], end = new int[2];

        // 1. S(시작), L(레버), E(도착) 좌표 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') start = new int[]{i, j};
                else if (c == 'L') lever = new int[]{i, j};
                else if (c == 'E') end = new int[]{i, j};
            }
        }

        // 2. BFS로 S -> L 까지의 거리와 L -> E 까지의 거리 합산
        int d1 = bfs(maps, start, lever); // 시작에서 레버까지
        int d2 = bfs(maps, lever, end);   // 레버에서 도착까지

        // 둘 중 하나라도 도달할 수 없으면 -1 반환
        if (d1 == -1 || d2 == -1) return -1;
        return d1 + d2;
    }

    public static int bfs(String[] maps, int[] start, int[] target) {
        int h = maps.length, w = maps[0].length();
        int[][] dist = new int[h][w]; 
        for (int i = 0; i < h; i++) Arrays.fill(dist[i], -1); // 방문 여부와 거리 저장

        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        dist[start[0]][start[1]] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            // 타겟(L 또는 E)에 도착하면 거리 반환
            if (curr[0] == target[0] && curr[1] == target[1]) return dist[curr[0]][curr[1]];

            // 3. 4방향 탐색 (일반 for문 사용)
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                // 범위 체크 및 장애물(X) 확인
                if (nr >= 0 && nr < h && nc >= 0 && nc < w && maps[nr].charAt(nc) != 'X' && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }
}