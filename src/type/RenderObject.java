package type;

import client.Main;
import window.Scene;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rae
 * @version 1.0.0
 */

public class RenderObject {
    // static vars
    public static final ArrayList<RenderObject> ALL = new ArrayList<>();

    // instance vars
    private int radius;
    private int posX;
    private int posY;

    // constructors
    private RenderObject() {
        ALL.add(this);
        this.posX = 0;
        this.posY = 0;
        this.radius = 0;
    }
    public static RenderObject create(int radius) {
        RenderObject out = new RenderObject();
        out.radius = radius;
        return out;
    }
    public static RenderObject create(int radius, int posX, int posY) {
        RenderObject out = new RenderObject();
        out.radius = radius;
        out.posX = posX;
        out.posY = posY;
        return out;
    }
    // end of constructors
    public static void render() {
        JPanel panel = Main.SCENE.getDrawPanel();
        Graphics g = panel.getGraphics();
        ALL.forEach(renderObject -> {
            g.drawOval(renderObject.posX, renderObject.posY, renderObject.radius, renderObject.radius);
        });
    }


}
