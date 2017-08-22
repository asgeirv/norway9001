package no.aev.norway9001.Game;

import javafx.scene.text.Font;

/**
 * Created by Asgeir on 09.07.2017.
 */
public class FontsProvider
{

    private Font spaceFontSmall;
    private Font spaceFontMedium;
    private Font spaceFontLarge;

    public FontsProvider()
    {
        try
        {
            spaceFontSmall = Font.loadFont(getClass().getResource("/fonts/NEUROPOL.TTF").toExternalForm(), 16);
            spaceFontMedium = Font.loadFont(getClass().getResource("/fonts/NEUROPOL.TTF").toExternalForm(), 24);
            spaceFontLarge = Font.loadFont(getClass().getResource("/fonts/NEUROPOL.TTF").toExternalForm(), 36);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Font getSpaceFontSmall()
    {
        return spaceFontSmall;
    }

    public Font getSpaceFontMedium()
    {
        return spaceFontMedium;
    }

    public Font getSpaceFontLarge()
    {
        return spaceFontLarge;
    }
}
