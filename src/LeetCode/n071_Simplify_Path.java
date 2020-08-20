package LeetCode;

import java.util.Stack;

/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. 
The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

 

Example 1:
Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:
Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

Example 3:
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Example 4:
Input: "/a/./b/../../c/"
Output: "/c"

Example 5:
Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */
public class n071_Simplify_Path {
	public String simplifyPath(String path) {
		String res = new String();
		Stack<String> stack = new Stack<String>();
		String[] paths = path.split("/");
		
		for(String p : paths) {
			if(p.equals("..")) {
				if(!stack.isEmpty()) {		//every time when pop(), need to check isEmpty first
					stack.pop();
				}
			} else if(!p.equals(".") && !p.equals("")) {
				stack.push(p);
			}
		}
		
		while(!stack.isEmpty()) {
			res = "/" + stack.pop() + res;
		}
		
		if(res.length() == 0) {
			return "/";
		}
		
		return res;
	}
	
	//Must read for String.split() https://zhuanlan.zhihu.com/p/45151144
	public static void main(String[] args) {
		n071_Simplify_Path obj = new n071_Simplify_Path();
		System.out.println(obj.simplifyPath("/home/"));
		System.out.println(obj.simplifyPath("/../"));
		System.out.println(obj.simplifyPath("/home//foo/"));
		System.out.println(obj.simplifyPath("/a/./b/../../c/"));
		System.out.println(obj.simplifyPath("/a/../../b/../c//.//"));
		System.out.println(obj.simplifyPath("/a//b////c/d//././/.."));
	}
}
