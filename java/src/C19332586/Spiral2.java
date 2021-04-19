package C19332586;

import processing.core.*;

public class Spiral2 {

    CatrionasVisual cv;
    float cy, cw;

    float smoothline = 0;

    public Spiral2(CatrionasVisual cv)
    {
        this.cv = cv;
        cy = this.cv.height/2 ;
        cw = this.cv.width/2;
    }

    public void render()
    {
        cv.colorMode(PApplet.HSB); 
        cv.strokeWeight(3);
        float r = 1f;
        float ly;
        float thetaInc = cv.TWO_PI / (float) 100;
        for(int i = 0 ; i < cv.getAudioBuffer().size() ; i ++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getAudioBuffer().size(), 0, 255), 255, 255);

            float theta = i * (thetaInc + cv.getSmoothedAmplitude() * 5);
            float x = cw + cv.sin(theta) * r;
            float y = cy - cv.cos(theta) * r;
            ly = cv.getAudioBuffer().get(i);
            r += 0.5f + cv.getSmoothedAmplitude();
            

            cv.line(cw, cy, x, ly + y);
        }
    }
}
