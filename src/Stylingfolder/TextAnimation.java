package Stylingfolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAnimation extends JLabel {

    private final String text;
    private Timer timer;

    public TextAnimation(String text) {
        this.text = text;
        setFont(new Font("Arial", Font.PLAIN, 20));
        setHorizontalAlignment(SwingConstants.CENTER);

        timer = new Timer(50, new ActionListener() {
            private float alpha = 0.0f;
            private boolean fadeIn = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += fadeIn ? 0.05f : -0.05f;
                if (alpha > 1.0f) {
                    alpha = 1.0f;
                    fadeIn = false;
                } else if (alpha < 0.0f) {
                    alpha = 0.0f;
                    fadeIn = true;
                }
                setForeground(new Color(0, 0, 0, alpha));
            }
        });

        setText(text);
    }

    public void startAnimation() {
        timer.start();
    }

    public void stopAnimation() {
        timer.stop();
    }

}

