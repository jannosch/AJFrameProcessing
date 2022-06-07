package aj.frame.components;

import aj.vector.BindableVector;
import processing.core.PGraphics;
import processing.event.MouseEvent;

public class Button extends Component implements Clickable {

    public Button(BindableVector position, BindableVector size) {
        super(position, size);
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    protected void drawComponent(PGraphics g) {
        g.fill(255, 77, 91);
        g.rect(0, 0, size.getX(), size.getY());
    }
}
