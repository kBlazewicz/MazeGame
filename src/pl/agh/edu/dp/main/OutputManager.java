package pl.agh.edu.dp.main;

public abstract class OutputManager {
    private static String consoleMessage1 = "";
    private static String consoleMessage2 = "";

    public static String getConsoleMessage1() {
        return consoleMessage1;
    }

    public static String getConsoleMessage2() {
        return consoleMessage2;
    }

    public static void setConsoleMessage(String consoleMessage) {
        System.out.println(consoleMessage);
        OutputManager.consoleMessage2 = OutputManager.consoleMessage1;
        OutputManager.consoleMessage1 = consoleMessage;
    }

}
