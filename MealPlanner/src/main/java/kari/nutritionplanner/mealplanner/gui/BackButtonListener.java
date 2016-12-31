/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kari.nutritionplanner.mealplanner.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kari
 */
public class BackButtonListener implements ActionListener {
    private final CardLayout cards;
    private final Container container;

    public BackButtonListener(CardLayout cards, Container container) {
        this.cards = cards;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        cards.show(container, "start");
    }
    
    
}
