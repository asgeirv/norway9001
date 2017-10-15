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

    /**
     * Writes out debug info to system output.
     * This will only happen if debug mode is on.
     *
     * @param originatingClass The class which sent the debug message.
     * @param msg The message to output.
     */
    public void printDebugInfo(Class originatingClass, String msg)
    {
        if (debug)
            System.out.println(originatingClass.getSimpleName() + ": " + msg);
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
