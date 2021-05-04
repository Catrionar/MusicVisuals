package C19332586;

import processing.core.*;

public class Circle {
    CatrionasVisual cv;

    public Circle(CatrionasVisual cv)
    {
        this.cv = cv;
    }

    public void render(float x, float y)
    {
        cv.strokeWeight(2);
        float c = PApplet.map(cv.getSmoothedAmplitude(), 0, 1, 0, 255);
        cv.stroke(c, 255, 255);
        cv.noFill();
        
        float size = cv.random(cv.getSmoothedAmplitude()*10);
        float s = 100 + (100 * (cv.getSmoothedAmplitude()* size) * 10);

        for(int i = 0; i < 200; i++)
        {
            cv.circle(x, y, s);
        }
        
    }
    
}
