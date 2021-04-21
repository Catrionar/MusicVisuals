package C19332586;

import processing.core.*;

public class Circle {
    CatrionasVisual cv;
    float cy, cw;


    public Circle(CatrionasVisual cv)
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
        float au;
        float thetaInc = cv.TWO_PI / (float) 1;
        for(int i = 0 ; i < cv.getAudioBuffer().size() ; i ++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getAudioBuffer().size(), 0, 255), 255, 255);

            //float theta = i * (thetaInc + cv.getSmoothedAmplitude() * 5);
            float x = cv.sin(thetaInc + cv.getAudioBuffer().get(i) ) * r;
            float y = cy - cv.cos(thetaInc + cv.getAudioBuffer().get(i) ) * r;
            au = y * cv.getAudioBuffer().get(i);
            r += 0.5f + cv.getSmoothedAmplitude();
            //cv.line(cw, cy, 50 + (au * 500), 50 + (au * 500));
            //cv.line(cw, cy, i, cy + au);
            
            //cv.line(i, cy, i, cy + cy * cv.getAudioBuffer().get(i));
            cv.line(cw, cy, x,  au );
        }
    }
}
