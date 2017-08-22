package no.aev.norway9001.Game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * Special button class to cut down on code duplication.
 */
public class SpaceButton extends Button
{

    private FontsProvider fonts = new FontsProvider();

    public SpaceButton()
    {
        setupButton();
    }

    public SpaceButton(String text)
    {
        super(text);
        setupButton();
    }

    private void setupButton()
    {
        setFont(fonts.getSpaceFontMedium());
        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        setTextFill(Color.WHITE);

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.RED);

        setOnMouseEntered(event -> setEffect(shadow));
        setOnMouseExited(event -> setEffect(null));
    }
}
