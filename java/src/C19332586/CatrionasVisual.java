package C19332586;

import java.util.ArrayList;
import ie.tudublin.*;
//import java.util.*;

public class CatrionasVisual extends Visual
{    
    Spiral sp;
    Spiral2 sp2;
    //SnakeBody sb;
    //ArrayList<Snake> snake = new ArrayList<Snake>();
    boolean[] keys = new boolean[1024];
    int which = 0;
    //AudioBandsVisual abv;

    public void settings()
    {
        //size(500, 500);
        
        // Use this to make fullscreen
        fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("heroplanet.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        sp = new Spiral(this);
        sp2 = new Spiral2(this);
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
                text("Menu: ", 50, 50);
                break;
            }

            case 1:
            {
                sp.render();
                break;
            }

            case 2:
            {
                sp2.render();
                break;
            }
        }
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void mousePressed() {
    }

    public void keyReleased() {
        keys[keyCode] = false;
    }
}
