import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StateManagement {
    static ArrayList<String> file = new ArrayList<>();
    public static Map<String, List<String>> map = new HashMap<String, List<String>>();
    private String starterState;
    private String[] getAllState;
    private String[] getAlphabet;
    public Stack<String> stackDigits = new Stack<>();

    public void Start(String input) {
        

        setDigitsStack(input);
        fieldTheMap();

    }

    public void fieldTheMap() {

        for (int i = 4; i <= file.size() - 2; i++) {
            List<String> listTemp = new ArrayList<>();

            String[] temp = file.get(i).split("\t");

            for (int index = 1; index <= getAlphabet().length; index++) {
                listTemp.add(temp[index]);

            }
            map.put(temp[0], listTemp);

        }
    }

    private void setDigitsStack(String input) {

        long inputLong = Long.parseLong(input);
        for (int index = 0; index < input.length(); index++) {
            stackDigits.add(String.valueOf(inputLong % 10));
            inputLong /= 10;

        }

    }

    String[] getAlphabet() {
        String temp = file.get(1).substring(file.get(1).indexOf("{") + 1, file.get(1).indexOf("}"));
        String[] elements = temp.split(",");
        getAlphabet = elements.clone();

        return getAlphabet;
    }

    String[] getAllState() {
        String temp = file.get(0).substring(file.get(0).indexOf("{") + 1, file.get(0).indexOf("}"));
        String[] elements = temp.split(",");
        getAllState = elements.clone();
        return getAllState;
    }

    String getStarterState() {
        String temp = file.get(file.size() - 1);
        starterState = temp.substring(5, 7);
        return starterState;
    }

    void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("FST.txt"));
            String line;
            while ((line = reader.readLine()) != null) {

                file.add(line);
            }
            reader.close();
            System.out.println("FST.txt dosyası okundu.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
