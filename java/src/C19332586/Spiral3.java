package C19332586;

import processing.core.*;

public class Spiral3 {

    CatrionasVisual cv;
    float cy, cw;

    public Spiral3(CatrionasVisual cv)
    {
        this.cv = cv;
        cy = this.cv.height/2;
        cw = this.cv.width/2;
    }

    public void render()
    {
        cv.colorMode(PConstants.HSB); 
        cv.strokeWeight(2);
        float r = 1f;
        float ly;
        float thetaInc = PConstants.TWO_PI / (float) cv.getAudioBuffer().size();
        
        for(int i = 0 ; i < cv.getAudioBuffer().size() ; i ++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getAudioBuffer().size(), 0, 255), 255, 255);
            float theta = i * (thetaInc + cv.getSmoothedAmplitude() * 5);
            float x = cw + PApplet.sin(theta) * r;
            float y = cy - PApplet.cos(theta) * r;
            
            ly = cv.getAudioBuffer().get(i);
            r += 0.6f + cv.getSmoothedAmplitude();
            cv.line(cw, cy, x, ly + y);
        }
    }
}
