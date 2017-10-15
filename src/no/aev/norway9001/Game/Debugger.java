package no.aev.norway9001.Game;

/**
 * Class responsible for writing debugging info to the system output.
 */
public class Debugger
{

    private boolean debug = true;

    public Debugger()
    {

    }

    /**
     * Writes out debug info to system output.
     *
     * @param msg
     */
    public void writeDebugInfo(String msg)
    {
        if (debug)
            System.out.println(msg);
    }
}
