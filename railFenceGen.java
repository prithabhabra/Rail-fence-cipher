
import java.util.ArrayList;
import java.util.Scanner;

public class railFenceGen {

    public static void main(String args[]) {
        String input;
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter input string:");
        input = cs.nextLine();
        System.out.println("Enter number of levels:");
        int n = cs.nextInt();
        System.out.println("Input string:" + input);

        //Encryption
        ArrayList<Character> ip = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int i = j; i < input.length(); i = i + n) {
                ip.add(input.charAt(i));
            }
        }
        String encmsg = new String();
        for(Character c : ip) {
            encmsg += c;
        }

        System.out.println("Encrypted message:" + encmsg);

        //Decryption
        String decmsg = "";
        int no = encmsg.length() % n;
        int s = encmsg.length() / n;
        char[][] a = new char[40][40];
        int k = 0;
        for (int i = 0; i < no; i++) {
            a[k] = encmsg.substring(i * (s + 1), (i + 1) * (s + 1)).toCharArray();
            k++;
        }
        for (int i = (s + 1) * no; i < encmsg.length(); i = i + s) {
            a[k] = encmsg.substring(i, (i + s)).toCharArray();
            k++;
        }

        int cnt = 0;
        for (int i = 0; i < s + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt == encmsg.length()) {
                    break;
                }
                decmsg += a[j][i];
                cnt++;
            }
        }

        System.out.println("Decrepted message:" + decmsg);
    }

}
