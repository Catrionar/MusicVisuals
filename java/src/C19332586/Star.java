package C19332586;

import processing.core.*;

public class Star {

    CatrionasVisual cv;
    float cy, cw, splitx, splity = 0;

    public Star(CatrionasVisual cv)
    {
        this.cv = cv;
        cy = this.cv.height / 2;
        cw = this.cv.width / 2; 
        splitx = this.cv.width / 5;
        splity = this.cv.height / 5;
    }

    public void render()
    {
        float au;
        cv.colorMode(PConstants.HSB);
        cv.strokeWeight(2);
        
        for(int i = 0 ; i < (cv.getAudioBuffer().size() * 0.5f) ; i ++)
        {
            cv.stroke(PApplet.map(i, 0, cv.getAudioBuffer().size(), 0, 255), 255, 255);

            au = cv.getAudioBuffer().get(i);
            float ln = i * 0.68f;

            cv.line((splitx) + i , (splity * 2), (splitx) + i , (splity * 2) + cy * au );
            cv.line((splitx * 3) + i , (splity * 2), (splitx * 3) + i , (splity * 2) + cy * au );
            cv.line((splitx * 1.85f ) + ln, (splity * 2) - ln , (splitx *1.85f ) + ln, (splity * 2) - ln + cy * au);
            cv.line((splitx * 2.44f) + ln, (splity  ) + ln , (splitx * 2.44f ) + ln, (splity ) + ln + cy * au);
            cv.line((splitx) + i , (splity * 2) + ln, (splitx) + i , (splity * 2) + ln + cy * au );
            cv.line((splitx * 3) + i , (splity * 3) - ln, (splitx * 3) + i , (splity * 3) -ln + cy * au );
            cv.line((splitx * 1.27f ) + ln, (splity * 4f) - ln , (splitx *1.27f ) + ln, (splity * 4f) - ln + cy * au);
            cv.line((splitx * 1.27f ) + (ln * 2f), (splity * 4f) + (ln * -0.8f) , (splitx *1.27f ) + (ln * 2f), (splity * 4f) + (ln * -0.8f) + cy * au);
            cv.line((splitx * 2.4f ) + (ln * 1.8f), (splity * 3.2f) - (ln * -0.8f) , (splitx *2.4f ) + (ln * 1.8f), (splity * 3.2f) - (ln * -0.8f) + cy * au);
            cv.line((splitx * 3f ) + (ln * 0.75f), (splity * 3f) + ln , (splitx *3f ) + (ln * 0.75f), (splity * 3f) + ln + cy * au);
        }
    }
}
