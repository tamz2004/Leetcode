LeetCode Logo
Daily Question
7

avatar
Premium
Debugging...
Debugging...







Run
Description
Description
Accepted
Editorial
Editorial
Solutions
Solutions
Submissions
Submissions
Code
Code
Code Sample


Testcase
Testcase
Test Result
Accepted
Runtime: 0 ms
Case 1
Case 2
Case 3
Input
root =
[2,3,5,8,13,21,34]
Output
[2,5,3,8,13,21,34]
Expected
[2,5,3,8,13,21,34]
Contribute a testcase
All Submissions

Accepted
Ahamed Tamzil
Ahamed Tamzil
submitted at Dec 20, 2024 22:57

Editorial

Solution
Runtime
10
ms
Beats
34.32%
Analyze Complexity
Memory
50.74
MB
Beats
13.10%
Analyze Complexity
Code
Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        for (int i = 0; !q.isEmpty(); ++i) {
            List<TreeNode> t = new ArrayList<>();
            for (int k = q.size(); k > 0; --k) {
                var node = q.poll();
                if (i % 2 == 1) {
                    t.add(node);
                }
                if (node.left != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            for (int l = 0, r = t.size() - 1; l < r; ++l, --r) {
                var x = t.get(l).val;
                t.get(l).val = t.get(r).val;
                t.get(r).val = x;
            }
        }
        return root;
    }
}
View more
More challenges
226. Invert Binary Tree
Write your notes here
Select related tags
0/5
Runtime: 0ms


java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ReverseTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 0);
        return root;
    }
    
    private void dfs(TreeNode left, TreeNode right, int depth) {
        if (left == null && right == null) return;

        if (depth % 2 == 0) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left, right.right, depth + 1);
        dfs(left.right, right.left, depth + 1);
    }
}

Tag
