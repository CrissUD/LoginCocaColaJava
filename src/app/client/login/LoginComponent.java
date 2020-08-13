package app.client.login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import app.services.graphicServices.RecursosService;

import java.awt.event.FocusEvent;

public class LoginComponent implements ActionListener, FocusListener{

    private LoginTemplate loginTemplate;
    private JTextField text;

    private String[] placeholdes = {"Nombre Usuario", "Clave Usuario"};

    public LoginComponent(){
        this.loginTemplate = new LoginTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginTemplate.getBCerrar())
            System.exit(0);
    }

    @Override
    public void focusGained(FocusEvent e) {
        text = ((JTextField) e.getSource());
        text.setForeground(RecursosService.getService().getColorAmarillo());
        if(text.getText().equals(placeholdes[0]) || text.getText().equals(placeholdes[1]))
            text.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        text = ((JTextField) e.getSource());
        if(text.getText().equals("")){
            text.setForeground(RecursosService.getService().getColorGris());
            text.setText(placeholdes[0]);
        }
    }
    
}