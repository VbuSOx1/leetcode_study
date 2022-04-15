package hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weib
 * @date 2022-04-15 15:44
 * 207. 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 * 拓扑排序 dfs
 */
public class No_207_course_schedule {
    List<List<Integer>> g = new ArrayList<>();
    int[] visit;
    boolean isValid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e: prerequisites) {
            g.get(e[1]).add(e[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }
        return isValid;
    }


    public void dfs(int i) {
        if (visit[i] == 2){
            return;
        }
        visit[i] = 1;
        for (int next : g.get(i)) {
            if (visit[next] == 0) {
                dfs(next);
                if (! isValid) {
                    return;
                }
            }else if (visit[next] == 1){
                isValid = false;
                return;
            }
        }
        visit[i] = 2;
    }
}
