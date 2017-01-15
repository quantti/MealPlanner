/*
 * Copyright (C) 2017 kari
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package kari.nutritionplanner.mealplanner.gui.controllers;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import kari.nutritionplanner.mealplanner.gui.CalcMealView;
import kari.nutritionplanner.mealplanner.servicelayer.MealCalcHelper;

/**
 * ActionListener joka on vastuussa lisäkkeen lisäämisestä ateriaan. Hakee
 * buttongroupista valitun raaka-aineen ja lisää sen MealCalcHelperiin talteen
 * ja tekee sekä näyttää seuraavan kortin.
 *
 * @author kari
 */
public class SelectSideIngListener extends GetMealListener {

    private final MealCalcHelper helper;
    private final ButtonGroup bg;
    private final Container container;
    private final String nextCard;

    /**
     * Konstruktori saa parametrina koko käyttöliittymää pyörittävän
     * CardLayoutin, containerin joka sisältää kaikki "kortit" sekä seuraavan
     * kortin "osoitteen" Stringinä. Lisäksi parametrina ButtonGroup josta
     * käyttäjä on valinnut haluamansa lisäkkeen.
     *
     * @param view CalcMealView CalcMealView, jossa sijaitsevat kaikki aterian
     * laskemiseen liittyvät komponentit
     * @param cardL CardLayout joka pyörittää koko käyttöliittymää
     * @param bg ButtonGroup josta käyttäjä on valinnut haluamansa lisäkkeen
     * @param container Container Sisältää kaikki kortit
     * @param nextCard String Seuraavan kortin osoite
     */
    public SelectSideIngListener(CalcMealView view, CardLayout cardL, ButtonGroup bg, Container container, String nextCard) {
        super(view, cardL);
        this.helper = view.getHelper();
        this.bg = bg;
        this.nextCard = nextCard;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonModel b = bg.getSelection();
        String name = b.getActionCommand();
        helper.setSideIngredient(name);
        JPanel card = view.createCaloriesCard(container);
        container.add(card, nextCard);
        cardL.show(container, nextCard);
    }

}
