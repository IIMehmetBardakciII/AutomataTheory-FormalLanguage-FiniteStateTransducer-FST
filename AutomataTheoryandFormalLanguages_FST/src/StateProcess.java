import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StateProcess extends StateManagement {
    static ArrayList<String> States = new ArrayList<String>();
    static ArrayList<String> Outputs = new ArrayList<String>();
    Stack<String> stackDigits = new Stack<>();
    String getStarterState;

    public String transitionProcess(String starterkey, Map<String, List<String>> map) {

        String nextState = "";
        if (stackDigits.size() <= 0) {
            return null;
        } else {

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry.getKey().equals(starterkey)) {
                    String input = stackDigits.pop();
                    

                    for (int index = 0; index < getAlphabet().length; index++) {
                        if (!input.isEmpty()) {
                            if (index == Integer.parseInt(input)) {
                                String[] temp = entry.getValue().get(Integer.parseInt(input)).split(",");
                                nextState = temp[0].substring(1, 3);
                                States.add(temp[0].substring(1, 3));
                                Outputs.add(temp[1].substring(1, 2));
                                return transitionProcess(nextState, map);

                            }
                        }
                    }

                }
            }

        }
        return nextState;
    }

    public void removeTheList() {
        States.clear();
        Outputs.clear();
    }

    public void kkk() {
        String states = "";
        states += getStarterState() + ",";
        for (String listItem : States) {
            states += listItem + ",";

        }
        System.out.println("Durumların sırası:" + states.substring(0, states.length() - 1));
        System.out.println("Çıktı:" + Outputs);
    }

}

