

package edu.usm.cos420.ConsultingRegister.view;

/*
 * @author codysnow
 *
 */
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
 
public class GUIStack implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    private LinkedHashMap<String, JPanel> cardDeck;
    
    public GUIStack(LinkedHashMap<String, JPanel> deck) {
    	this.cardDeck = deck;
    	createAndShowGUI();
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Clinic Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
         
        
        // ADD BUTTONS BELOW along with their ActionListeners
        
        // NEW PATIENT
        JButton btnNewPatient = new JButton("New Patient");
        btnNewPatient.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "New Patient");
        	}
        });
		
        
        // PATIENT SEARCH
        JButton btnPatientSearch = new JButton("Patient Search");
        btnPatientSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, "Patient Search");
        	}
        });
        
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        
        
        //Create main view card
        JPanel card1 = new JPanel();
        cards.add(card1, card1.getName());
        

        GroupLayout gl_card1 = new GroupLayout(card1);
        gl_card1.setHorizontalGroup(
        	gl_card1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_card1.createSequentialGroup()
        			.addGap(96)
        			.addComponent(btnNewPatient)
        			.addGap(104)
        			.addComponent(btnPatientSearch)
        			.addContainerGap(150, Short.MAX_VALUE))
        );
        gl_card1.setVerticalGroup(
        	gl_card1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_card1.createSequentialGroup()
        			.addGap(5)
        			.addGroup(gl_card1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnNewPatient)
        				.addComponent(btnPatientSearch))
        			.addContainerGap(437, Short.MAX_VALUE))
        );
        card1.setLayout(gl_card1);
        
        // add the passed-in deck of cards to the stack
        for (Map.Entry<String, JPanel> card : cardDeck.entrySet()) {
        	cards.add(card.getValue(), card.getKey());
        }
        
        // add all cards to the JFrame
        frame.getContentPane().add(cards, BorderLayout.CENTER);
        
        //TODO: Determine the best way to size the initial/subsequent frames
        //frame.pack();
        frame.setBounds(100, 100, 550, 500);
        
        //Display the window.
        frame.setVisible(true);
    }
     
    // TODO: Review this method - is it needed? 
    // Should we be implementing Action Listener instead?
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
     
}