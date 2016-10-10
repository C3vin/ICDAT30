package INQ;

import java.util.Stack;

public class AET {
	public class Node {
		char val;
		Node left;
		Node right;
		Node(char x) { val = x; }
	}
	// A utility function to check if 'c'
	// is an operator

	public boolean isOperator(char c) {
		if (c == '+' || c == '-'
				|| c == '*' || c == '/'
				|| c == '^') {
			return true;
		}
		return false;
	}

	// Utility function to do inorder traversal
	public void inorder(Node t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.val + " ");
			inorder(t.right);
		}
	}

	// Returns root of constructed tree for given
	// postfix expression
	public Node constructTree(char postfix[]) {
		Stack<Node> st = new Stack();
		Node t, t1, t2;

		// Traverse through every character of
		// input expression
		for (int i = 0; i < postfix.length; i++) {

			// If operand, simply push into stack
			if (!isOperator(postfix[i])) {
				t = new Node(postfix[i]);
				st.push(t);
			} else // operator
			{
				t = new Node(postfix[i]);

				// Pop two top nodes
				// Store top
				t1 = st.pop();      // Remove top
				t2 = st.pop();

				//  make them children
				t.right = t1;
				t.left = t2;

				// System.out.println(t1 + "" + t2);
				// Add this subexpression to stack
				st.push(t);
			}
		}

		//  only element will be root of expression
		// tree
		t = st.peek();
		st.pop();

		return t;
	}	
	public static void main(String args[]) {

		AET et = new AET();
		String postfix = "ab+ef*g*-";
		char[] charArray = postfix.toCharArray();
		Node root = et.constructTree(charArray);
		System.out.println("infix expression is");
		et.inorder(root);
		
	}
}
