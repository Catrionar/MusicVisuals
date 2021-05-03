package C19332586;

import processing.core.*;

public class Sun {
    CatrionasVisual cv;
    float cy, cw;
    float lerpedAverage = 0;
    float sum, average = 0;


    public Sun(CatrionasVisual cv)
    {
        this.cv = cv;
        cy = this.cv.height/2;
        cw = this.cv.width/2;
    }
    
    public void render()
    {
        cv.colorMode(PConstants.HSB); 

        for (int i = 0; i < cv.getAudioBuffer().size(); i ++)
        {
            sum += PApplet.abs(cv.getAudioBuffer().get(i));
        }

        average = sum / cv.getAudioBuffer().size();
        lerpedAverage = PApplet.lerp(lerpedAverage, average, 0.1f);
        
        float r = 1f;
        int numPoints = 360;
        float thetaInc = PConstants.TWO_PI / (float) numPoints;

        for (int i = 0; i < 360; i++)
        {
          float c = PApplet.map(cv.getSmoothedAmplitude(), 0, 1, 0, 255);
          cv.stroke(c, 255, 255, 100);
          cv.strokeWeight(3);

          float thetay =  i * (thetaInc + lerpedAverage * 100) ;
          float thetax = i * (thetaInc + lerpedAverage * 100);
          float x = cw + PApplet.sin(thetax) * r;
          float y = cy - PApplet.cos(thetay) * r;
          r += 0.5f + lerpedAverage;
          
          cv.line(cw, cy, x, y);

          cv.fill(c, 255, 255);
          cv.circle(cw, cy, 120);
          cv.fill(0);
          cv.ellipse(cw - 20, cy - 20, 20, 25);
          cv.ellipse(cw + 20, cy - 20, 20, 25);
        }
    }

  }