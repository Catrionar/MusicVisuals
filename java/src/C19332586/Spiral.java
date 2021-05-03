package C19332586;

import processing.core.*;

public class Spiral {
    CatrionasVisual cv;
    
    public Spiral(CatrionasVisual cv)
    {
        this.cv = cv;
    }

    public void render()
    {
        cv.colorMode(PConstants.HSB);
        float r = 1f;
        int numPoints = 3;
        cv.strokeWeight(4);
        float thetaInc = 3.14f/ (float) numPoints;
        float lastX;
        float lastY;
         
        for(int i = 0 ; i < cv.getAudioBuffer().size(); i ++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getAudioBuffer().size(), 0, 255), 255, 255);
            float theta = i * (thetaInc + cv.getSmoothedAmplitude() * 5);
            float x = cv.width / 2 + PApplet.sin(theta) * r;
            float y = cv.height / 2 - PApplet.cos(theta) * r;
            r += 0.6f + cv.getSmoothedAmplitude();
            lastX = x;
            lastY = y;
            cv.line(lastX, lastY, x, y + cv.getSmoothedAmplitude());
        }
    }
}
