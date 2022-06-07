package aj.frame;

import aj.frame.components.Clickable;
import aj.frame.components.Component;
import aj.frame.components.Holder;
import aj.vector.BindableVector;
import aj.vector.Vector;
import processing.core.PApplet;
import processing.core.PVector;
import processing.event.MouseEvent;

public class AJFrame extends PApplet {

    Holder holder;
    Component pressedComponent = null;

    public AJFrame() {
        width = 800;
        height = 450;
        PApplet.runSketch(new String[]{""}, this);
    }

    public AJFrame(int width, int height) {
        this.width = width;
        this.height = height;
        PApplet.runSketch(new String[]{""}, this);
    }

    public void settings() {
        size(width, height);

        holder = new Holder(new BindableVector(), new BindableVector(width, height));
    }

    public void setup() {
        windowTitle("AJFrame");
        windowResizable(true);
        noStroke();
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        Component hoveredComponent = holder.getComponentOnPosition(new PVector(event.getX(), event.getY()));

        if (hoveredComponent instanceof Clickable c) {
            cursor(c.getCursor());
        } else {
            cursor(PApplet.ARROW);
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        pressedComponent = holder.getComponentOnPosition(new PVector(event.getX(), event.getY()));

        if (pressedComponent instanceof Clickable c) c.mousePressed(event);
        System.out.println(pressedComponent.getClass());
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        if (pressedComponent instanceof Clickable c) c.mouseDragged(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        Component releasedComponent = holder.getComponentOnPosition(new PVector(event.getX(), event.getY()));

        if (releasedComponent instanceof Clickable c) {
            c.mouseReleased(event);
            if (releasedComponent == pressedComponent) c.mouseClicked(event);
        }
    }

    @Override
    public void windowResized() {
        holder.setWidth(width);
        holder.setHeight(height);
        holder.draw(super.g, true);
    }



    public void draw() {
        holder.draw(super.g, false);
    }

    // NON-PROCESSING METHODS
    public void add(Component component) {
        holder.add(component);
    }

    // GETTERS N SETTERS
    public BindableVector getSize() {
        return holder.getSize();
    }
}
