package C19332586;

import java.util.ArrayList;

import ie.tudublin.*;
import processing.core.PVector;

public class CatrionasVisual extends Visual
{    
    Spiral sp;
    Spiral2 sp2;
    Spiral3 sp3;
    Sun sn;
    Star star;
    Circle circle;
    
    boolean[] keys = new boolean[1024];
    int which = 0;

    float x = random(0, width);
    float y = random(0, height);

    float lerpedAverage = 0;
    float sum, average = 0;

    ArrayList<Snowflake> snowflakes;
    int num = 0;
    float call = 0f;


    public void settings()
    {
        //size(500, 500);
        
        // Use this to make fullscreen
        fullScreen();

        //fullScreen(P3D);

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("always.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        sp = new Spiral(this);
        sp2 = new Spiral2(this);
        sp3 = new Spiral3(this);
        sn = new Sun(this);
        star = new Star(this);
        circle = new Circle(this);

        
        snowflakes = new ArrayList<Snowflake>();
        PVector a = new PVector(0, 100);
        PVector b = new PVector(600, 100);
        PVector c = new PVector(300, 600);
        Snowflake seg1 = new Snowflake(this, a, b);
        Snowflake seg2 = new Snowflake(this, b, c);
        Snowflake seg3 = new Snowflake(this, c, a);
        snowflakes.add(seg1);
        snowflakes.add(seg2);
        snowflakes.add(seg3);
    }

    public void keyPressed()
    {

        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        else if (keyCode >= '0' && keyCode <= '6') {
            which = keyCode - '0';
            keys[keyCode] = true;
        }

    }

    public void draw()
    {
        fill(255);
        background(0);
        stroke(255);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();  

        

        switch (which)
        {
            case 0: 
            {
                sp.render();
                break;
            }

            case 1:
            {
                sp2.render();
                break;
            }

            case 2:
            {
                sp3.render();
                break;
            }

            case 3:
            {
                sn.render();
                break;
            }

            case 4:
            {
                star.render();
                break;
            }
            case 5:
            {
                for (int i = 0; i <= 2; i++)
                {
                    circle.render(x, y);
                    change();
                }
                
                break;
            }
            case 6:
            {
                translate(width/3.2f, 150);

                for (Snowflake s : snowflakes)
                {
                    s.render();
                }

                for (int i = 0; i < getAudioBuffer().size(); i ++)
                {
                    sum += abs(getAudioBuffer().get(i));
                }

                average = sum / getAudioBuffer().size();
                lerpedAverage = lerp(lerpedAverage, average, 0.1f);

                if(call <= lerpedAverage)
                {
                    repeat();
                    call += 0.25f;
                }

                break;
            }

            default:
            {
                sp.render();
            }
            
        }
    }

    public void change()
    {
        x = random(0, width);
        y = random(0, height);
    }

    public void repeat() {
        ArrayList<Snowflake> next = new ArrayList<Snowflake>();

        for(Snowflake s : snowflakes)
        {
            Snowflake[] child = s.generate();
            addAll(child, next);     
        }
        snowflakes = next;
        num += 1;

        if(num == 5)
        {
            num = 0;
            snowflakes = new ArrayList<Snowflake>();
            PVector a = new PVector(0, 100);
            PVector b = new PVector(600, 100);
            PVector c = new PVector(300, 600);
            Snowflake seg1 = new Snowflake(this, a, b);
            Snowflake seg2 = new Snowflake(this, b, c);
            Snowflake seg3 = new Snowflake(this, c, a);
            snowflakes.add(seg1);
            snowflakes.add(seg2);
            snowflakes.add(seg3);
        }
        
    }

    void addAll(Snowflake[] array, ArrayList<Snowflake> list)
    {
        for(Snowflake s : array)
        {
            if(num != 5)
            {
                list.add(s);
            }
            else
            {
                list.remove(s);
            } 
        }
        
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void keyReleased() {
        keys[keyCode] = false;
    }
}
