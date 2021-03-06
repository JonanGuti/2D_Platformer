package main.java.jonanguti.platformer.GameStates;



import main.java.jonanguti.platformer.Map.Background;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuState extends GameState {

    private Background bg;

    private int currentChoice = 0;
    private String[] options ={"Start","Help", "Quit"};

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(GSManager gsm){
        this.gsm = gsm;

        try{
            bg = new Background("/Backgrounds/menubg.gif", 1);
            bg.setVector(-0.1, 0);

            titleColor = new Color(120, 36, 44);
            titleFont = new Font("Algerian", Font.PLAIN, 30);




            font = new Font("Arial", Font.BOLD, 14);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void init(){}
    public void update(){
        bg.update();
    }
    public void draw(Graphics2D g){
        //Title
        bg.draw(g);

        //Title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Lost Empire", 70, 70);

        //Menu
        g.setFont(font);

        for (int i = 0; i < options.length; i++){

            if (i == currentChoice){
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 16));

            }
            else{
                g.setColor(Color.RED);
                g.setFont(font);
            }

            g.drawString(options [i], 145, 140 + i * 20);
        }
    }

    private void select(){
        if (currentChoice == 0){
            gsm.setState(gsm.LEVEL1STATE);


        }
        if (currentChoice == 1){
            //TODO Help

        }
        if (currentChoice == 2){
            System.exit(0);

        }


    }

    public void keyPressed(int k){
        if (k == KeyEvent.VK_ENTER){
            select();
        }

        if (k == KeyEvent.VK_W){
            currentChoice--;

            if (currentChoice == -1){
                currentChoice = options.length - 1;
            }

        }

        if (k == KeyEvent.VK_S){
            currentChoice++;

            if (currentChoice == options.length){
                currentChoice = 0;
            }
        }

    }
    public void keyReleased(int k){}



}
