
import java.util.Scanner;

public class MainProcess {
    public static void main(String[] args) {
        run();

    }

    public static void run() {
        System.out.println("Lütfen birinci inputu giriniz:");
        try (Scanner sc = new Scanner(System.in)) {
            StateManagement _stateManagement = new StateManagement();
            String input1 = sc.nextLine();
            _stateManagement.readFile();
            _stateManagement.Start(input1);

            StateProcess _stateManagement1 = new StateProcess();
            _stateManagement1.stackDigits = _stateManagement.stackDigits;
            _stateManagement1.getStarterState = _stateManagement.getStarterState();
            _stateManagement1.transitionProcess(_stateManagement1.getStarterState(), StateManagement.map);
            _stateManagement1.kkk();
            _stateManagement1.removeTheList();

            System.out.println("Lütfen ikinci inputu giriniz:");
            String input2 = sc.nextLine();
            StateManagement _stateManagement2 = new StateManagement();
            _stateManagement2.Start(input2);

            StateProcess _stateManagement3 = new StateProcess();
            _stateManagement3.stackDigits = _stateManagement2.stackDigits;
            _stateManagement3.getStarterState = _stateManagement2.getStarterState();

            _stateManagement3.transitionProcess(_stateManagement3.getStarterState(), StateManagement.map);
            _stateManagement3.kkk();
        }
    }
}

