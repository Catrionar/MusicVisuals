package C19332586;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Snowflake {
    PVector a;
    PVector b;

    CatrionasVisual cv;

    Snowflake(CatrionasVisual cv, PVector a, PVector b)
    {
        this.cv = cv;
        this.a = a;
        this.b = b;
    }

    Snowflake[] generate()
    {
        Snowflake[] child = new Snowflake[4];

        PVector v = PVector.sub(b, a);
        v.div(3);

        PVector b1 = PVector.add(a, v);
        child[0] = new Snowflake(cv, a, b1);

        PVector a1 = PVector.sub(b, v);
        child[3] = new Snowflake(cv, a1, b);

        v.rotate(-PConstants.PI/3);
        PVector c = PVector.add(b1, v);
        child[1] = new Snowflake(cv, b1, c);
        child[2] = new Snowflake(cv, c, a1);

        return child;
    }

    void render()
    {
        cv.colorMode(PConstants.HSB);
        for(int i = 0 ; i < cv.getAudioBuffer().size(); i ++)
        {
            float c = PApplet.map(cv.getSmoothedAmplitude()*3, 0, 1, 0, 255);
            cv.stroke(c, 255, 255, 100);

            cv.line(a.x, a.y, b.x, b.y);
        }
    }
}
