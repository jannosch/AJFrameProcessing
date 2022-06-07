package aj;

import aj.frame.AJFrame;
import aj.frame.components.*;
import aj.vector.BindableVector;
import aj.vector.Vector;
import processing.core.PGraphics;
import processing.core.PVector;

public class Main {

    public static void main(String[] args) {
	    AJFrame frame = new AJFrame();


        HorizontalBar bar = (HorizontalBar) new HorizontalBar(new BindableVector(0, 0), new BindableVector(0, 200).bind(frame.getSize(), new PVector(1, 0.2f))).addTo(frame);

        Component component = new Component(new BindableVector(100, 100), new BindableVector(0, 200).bind(frame.getSize(), new Vector(0.5f, 0.1f))) {
            @Override
            protected void drawComponent(PGraphics g) {
                g.fill(27, 185, 187);
                g.rect(0, 0, size.getX(), size.getY());
            }
        }.addTo(bar);

        Button button = (Button) new Button(new BindableVector(200, 200), new BindableVector(100, 33)).addTo(bar);

        button.getPosition().getBindings().forEach(b -> System.out.println(b.getX()));
    }
}
