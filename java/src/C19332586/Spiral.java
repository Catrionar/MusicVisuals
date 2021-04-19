package C19332586;

import processing.core.*;
import java.util.*;

public class Spiral {
    CatrionasVisual cv;
    float lerpedAverage = 0;
    float average = 0;

    //lerpedAverage = PApplet.lerp(lerpedAverage, average, 0.1f);

    public Spiral(CatrionasVisual cv)
    {
        this.cv = cv;
    }

    public void render()
    {
        cv.colorMode(PApplet.HSB);
        float r = 1f;
        int numPoints = 3;
        //float average = 0;
        cv.strokeWeight(2);
        float thetaInc = 3.14f/ (float) numPoints;
        float lastX = cv.width / 2;
        float lastY = cv.height / 2;
         
        for(int i = 0 ; i < cv.getAudioBuffer().size(); i ++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getAudioBuffer().size(), 0, 255), 255, 255);
            float theta = i * (thetaInc + cv.getSmoothedAmplitude() * 5);
            float x = cv.width / 2 + PApplet.sin(theta) * r;
            float y = cv.height / 2 - PApplet.cos(theta) * r;
            r += 0.5f + cv.getSmoothedAmplitude();
            //cv.line(x, y + y * cv.getAudioBuffer().get(i), lastX, lastY );
            cv.line(lastX, lastY, x, y + y * cv.getAudioBuffer().get(i));
            lastX = x;
            lastY = y;
            //cv.line(lastX, lastY, x, y + cv.getAudioBuffer().get(i));
        }
    }
}
