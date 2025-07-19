// Remove Sub-Folders from the Filesystem - https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/?envType=daily-question&envId=2025-07-19

// Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.

// If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".

// The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.

// For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.

// Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
// Output: ["/a","/c/d","/c/f"]
// Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class July19__RemoveSubFoldersFromTheFilesystem {
    public static List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        res.add(folder[0]);
        for (int i = 1; i < n; i++) {
            String last = res.get(res.size() - 1);
            last += '/';
            if (!folder[i].startsWith(last)) {
                res.add(folder[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] folder = { "/a", "/a/b", "/c/d", "/c/d/e", "/c/f" };
        System.out.println(removeSubfolders(folder));
        // ["/a","/c/d","/c/f"]
    }
}
