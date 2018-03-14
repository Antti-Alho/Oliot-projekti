/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;

import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Eelis
 */
class JButtonStateController implements DocumentListener {
    private JButton button;
    

    JButtonStateController(JButton b) {
        this.button = b;
    }

    public void changedUpdate(DocumentEvent e) {
        disableIfEmpty(e);
    }

    public void insertUpdate(DocumentEvent e){
        disableIfEmpty(e);
    }

    public void removeUpdate(DocumentEvent e){
        disableIfEmpty(e);
    }
    //tekstikentässä pitää olla kahden numeron pituinen luku eli 10 kelpaa 0-9 ei
    public void disableIfEmpty(DocumentEvent e) {
        button.setEnabled(e.getDocument().getLength() > 1 );
    }
}

