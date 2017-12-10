import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DecodeString_394 {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (s.charAt(i) == ']') {
                StringBuilder tmp = new StringBuilder();
                char c_stack = stack.pop();
                while (c_stack != '[') {
                    tmp.append(c_stack);
                    c_stack = stack.pop();
                }

                int times = 0;
                int index = 1;
                while (!stack.empty() && stack.peek() - '0' >= 0 && stack.peek() - '0' <= 9) {
                    times += (stack.pop() - '0') * index;
                    index *= 10;
                }

                for (int j = 0; j < times; j ++) {
                    for (int z = tmp.length() - 1; z >= 0 ; z --) {
                        stack.push(tmp.charAt(z));
                    }
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }

    // TODO: 再用递归做一遍


}
