package no.aev.norway9001.Game;

/**
 * Class responsible for writing debugging info to the system output.
 */
public final class Debugger
{

    public static final Debugger INSTANCE = new Debugger();
    private boolean debug;

    /**
     * Create a new debugger. Defaults to off.
     */
    private Debugger()
    {
        debug = false;
    }

    /**
     * Create a new debugger. Defaults to off.
     *
     * @param debug Whether debug mode should be on.
     */
    private Debugger(boolean debug)
    {
        this.debug = debug;
    }

    /*
    public static Debugger getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Debugger();
        }
        return INSTANCE;
    }
    */

    /**
     * Writes out debug info to system output.
     *
     * @param msg The message to output.
     */
    public void writeDebugInfo(String msg)
    {
        if (debug)
            System.out.println(msg);
    }

    public boolean isDebug()
    {
        return debug;
    }

    public void setDebug(boolean debug)
    {
        this.debug = debug;
    }
}
