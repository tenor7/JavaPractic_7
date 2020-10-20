import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void game() {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stk1 = new Stack<Integer>();
        Stack<Integer> stk2 = new Stack<Integer>();
        Stack<Integer> tmp = new Stack<Integer>();
        boolean result = false;
        int a,b;

        for (int i = 0;i < 5;i++){
            tmp.push(in.nextInt());
        }
        while (!tmp.empty()){
            stk1.push(tmp.pop());
        }
        for (int i = 0; i < 5; i++){
            tmp.push(in.nextInt());
        }
        while(!tmp.empty()){
            stk2.push(tmp.pop());
        }
        for(int i = 0; i< 106; i++) {
            if (((stk1.peek()>stk2.peek()) && !(stk1.peek()==9 && stk2.peek()==0))||(stk1.peek()==0 && stk2.peek()==9)){
                a = stk1.pop();
                b = stk2.pop();
                while (!stk1.empty()){
                    tmp.push(stk1.pop());
                }
                stk1.push(b);
                stk1.push(a);
                while (!tmp.empty()){
                    stk1.push(tmp.pop());
                }
            } else if(((stk2.peek()>stk1.peek()) && !(stk1.peek()==0 && stk2.peek()==9))||(stk2.peek()==0 && stk1.peek()==9)){
                a = stk2.pop();
                b = stk1.pop();
                while (!stk2.empty()){
                    tmp.push(stk2.pop());
                }
                stk2.push(b);
                stk2.push(a);
                while (!tmp.empty()){
                    stk2.push(tmp.pop());
                }
            }

            if (stk1.empty()) {
                System.out.println("Second " + (i+1));
                result = true;
                break;
            } else if (stk2.empty()) {
                System.out.println("First " + (i+1));
                result = true;
                break;
            }
        }
        if (!result) System.out.println("Botva!");
    }

    public static void main(String[] args) {
         Main.game();
    }
}