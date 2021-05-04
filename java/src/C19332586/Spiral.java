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
        cv.strokeWeight(4);

        float r = 1f;
        int numPoints = 3;
        float thetaInc = 3.14f/ (float) numPoints;
         
        for(int i = 0 ; i < cv.getAudioBuffer().size(); i ++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getAudioBuffer().size(), 0, 255), 255, 255);

            float theta = i * (thetaInc + cv.getSmoothedAmplitude() * 5);
            float x = cv.width / 2f + PApplet.sin(theta) * r;
            float y = cv.height / 2f - PApplet.cos(theta) * r;
            r += 0.6f + cv.getSmoothedAmplitude();
            
            cv.line(x, y, x, y + cv.getSmoothedAmplitude());
        }
    }
}
