import java.util.*;

public class Main {
    public static String createDummyWord(String word) {
        String dummyWord = "";
        for(int i = 0; i < word.length(); i++) {
            dummyWord = dummyWord + "_";
        }
        return dummyWord;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] wordlist = {"test", "word", "list", "table"};

        String defaultTable =
                "┏━━━┓\n" +
                "┃   \n" +
                "┃   \n" +
                "┃   \n" +
                "┃   \n" +
                "┻";
        System.out.println(defaultTable);

        Random random = new Random();

        String gameWord = wordlist[random.nextInt(wordlist.length)];

        String dummy = createDummyWord(gameWord);

        int falseAttempts = 0;

        while(falseAttempts < 7) {
            System.out.println(dummy);
            String prediction = input.next();
            if(gameWord.equals(prediction)) {
                System.out.println("Game ends. Word: " + gameWord);
                break;
            }
            if(gameWord.contains(prediction)) {
                //int indexChar = gameWord.indexOf(prediction);
                //dummy = dummy.substring(0, indexChar) + prediction + dummy.substring(indexChar+1);
                String[] word = gameWord.split("");
                for (var i = 0; i < word.length; i++) {
                    if(word[i].equals(prediction)) {
                        dummy = dummy.substring(0, i) + prediction + dummy.substring(i+1);
                    }
                }
            } else {
                falseAttempts++;
                System.out.println("False");
                switch (falseAttempts) {
                    case 1:
                        System.out.println("┏━━━┓\n" + "┃   |\n" + "┃   \n" + "┃  \n" + "┃  \n" + "┻");
                        break;
                    case 2:
                        System.out.println("┏━━━┓\n" + "┃   |\n" + "┃   O\n" + "┃  \n" + "┃  \n" + "┻");
                        break;
                    case 3:
                        System.out.println("┏━━━┓\n" + "┃   |\n" + "┃   O\n" + "┃  /\n" + "┃  \n" + "┻");
                        break;
                    case 4:
                        System.out.println("┏━━━┓\n" + "┃   |\n" + "┃   O\n" + "┃  /|\n" + "┃  \n" + "┻");
                        break;
                    case 5:
                        System.out.println("┏━━━┓\n" + "┃   |\n" + "┃   O\n" + "┃  /|\\\n" + "┃  \n" + "┻");
                        break;
                    case 6:
                        System.out.println("┏━━━┓\n" + "┃   |\n" + "┃   O\n" + "┃  /|\\\n" + "┃  /\n" + "┻");
                        break;
                    case 7:
                        System.out.println("┏━━━┓\n" + "┃   |\n" + "┃   O\n" + "┃  /|\\\n" + "┃  / \\\n" + "┻");
                        System.out.println("Game ends. You failed. Word: " + gameWord);
                        break;
                }
            }
        }
    }
}