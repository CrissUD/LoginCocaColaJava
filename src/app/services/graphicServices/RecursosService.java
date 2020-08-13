package app.services.graphicServices;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

/** @author Cristian Felipe Patiño Cáceres Github: CrissUD*/

public class RecursosService {

    // Declaración Objetos Decoradores
    private Color colorBlanco, colorRojo, colorGris, colorNegro, colorAmarillo;
    private Font fontTitulos;
    private Cursor cMano;

    static private RecursosService servicio;

    private RecursosService(){
        colorBlanco = new Color(250,250,250);
        colorGris = new Color(200,200,200);
        colorNegro = new Color(0,0,0);
        colorRojo = new Color(228,30,43);
        colorAmarillo = new Color(255,190,70);
        fontTitulos = new Font("Gabriola", Font.PLAIN, 18);
        cMano = new Cursor(Cursor.HAND_CURSOR);
    }
    
    public Color getColorBlanco(){
        return colorBlanco;
    }

    public Color getColorGris(){
        return colorGris;
    }

    public Color getColorNegro(){
        return colorNegro;
    }

    public Color getColorRojo(){
        return colorRojo;
    }

    public Color getColorAmarillo(){
        return colorAmarillo;
    }
    
    public Font getFontTitulos(){
        return fontTitulos;
    }

    public Cursor getCMano(){
        return cMano;
    }

    public static RecursosService getService(){
        if(servicio == null)
            servicio = new RecursosService();
        return servicio;
    }
}