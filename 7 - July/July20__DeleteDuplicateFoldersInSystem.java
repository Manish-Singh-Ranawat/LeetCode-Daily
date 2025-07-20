// Delete Duplicate Folders in System - https://leetcode.com/problems/delete-duplicate-folders-in-system/description/?envType=daily-question&envId=2025-07-20

// Due to a bug, there are many duplicate folders in a file system. You are given a 2D array paths, where paths[i] is an array representing an absolute path to the ith folder in the file system.
// - For example, ["one", "two", "three"] represents the path "/one/two/three".

// Two folders (not necessarily on the same level) are identical if they contain the same non-empty set of identical subfolders and underlying subfolder structure. The folders do not need to be at the root level to be identical. If two or more folders are identical, then mark the folders as well as all their subfolders.

// - For example, folders "/a" and "/b" in the file structure below are identical. They (as well as their subfolders) should all be marked:
// /a
// /a/x
// /a/x/y
// /a/z
// /b
// /b/x
// /b/x/y
// /b/z
// - However, if the file structure also included the path "/b/w", then the folders "/a" and "/b" would not be identical. Note that "/a/x" and "/b/x" would still be considered identical even with the added folder.

// Once all the identical folders and their subfolders have been marked, the file system will delete all of them. The file system only runs the deletion once, so any folders that become identical after the initial deletion are not deleted.

// Return the 2D array ans containing the paths of the remaining folders after deleting all the marked folders. The paths may be returned in any order.

// Input: paths = [["a"],["c"],["d"],["a","b"],["c","b"],["d","a"]]
// Output: [["d"],["d","a"]]
// Explanation: The file structure is as shown.
// Folders "/a" and "/c" (and their subfolders) are marked for deletion because they both contain an empty folder named "b".

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {
    String serial;
    Map<String, Trie> children = new HashMap<>();
}

public class July20__DeleteDuplicateFoldersInSystem {
    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Trie root = new Trie();
        for (List<String> path : paths) {
            Trie cur = root;
            for (String node : path) {
                cur.children.putIfAbsent(node, new Trie());
                cur = cur.children.get(node);
            }
        }
        Map<String, Integer> freq = new HashMap<>();
        construct(root, freq);
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        operate(root, freq, path, ans);
        return ans;
    }

    private static void construct(Trie node, Map<String, Integer> freq) {
        if (node.children.isEmpty())
            return;
        List<String> v = new ArrayList<>();
        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            construct(entry.getValue(), freq);
            v.add(entry.getKey() + "(" + entry.getValue().serial + ")");
        }
        Collections.sort(v);
        StringBuilder sb = new StringBuilder();
        for (String s : v) {
            sb.append(s);
        }
        node.serial = sb.toString();
        freq.put(node.serial, freq.getOrDefault(node.serial, 0) + 1);
    }

    private static void operate(Trie node, Map<String, Integer> freq, List<String> path, List<List<String>> ans) {
        if (freq.getOrDefault(node.serial, 0) > 1)
            return;
        if (!path.isEmpty()) {
            ans.add(new ArrayList<>(path));
        }
        for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
            path.add(entry.getKey());
            operate(entry.getValue(), freq, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(List.of("a"));
        paths.add(List.of("c"));
        paths.add(List.of("d"));
        paths.add(List.of("a", "b"));
        paths.add(List.of("c", "b"));
        paths.add(List.of("d", "a"));
        System.out.println(deleteDuplicateFolder(paths));
        // [["d"],["d","a"]]
    }
}
