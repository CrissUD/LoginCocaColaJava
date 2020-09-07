package app.client.login;

import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import app.services.graphicServices.GraficosAvanzadosService;
import app.services.graphicServices.ObjGraficosService;
import app.services.graphicServices.RecursosService;

public class LoginTemplate extends JFrame{

    private static final long serialVersionUID = -366696646190333733L;

    private LoginComponent loginComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JPanel pFondo, pDatos, pSuperior,pBarra;
    private JButton bCerrar, bIngresar;
    private JLabel lFondo, lLogoLogin, lLogo;
    private JLabel lNombreUsuario, lTipoUsuario, lClaveUsuario;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
    private JComboBox<String> cmbTipoUsuario;
    
    private ImageIcon iFondo, iLogo, iCerrar, iDimAux;
    private Border bordeRedondeadoFondo, bordeRedondeado, bordeInferior, bordeCircular;
    
    public LoginTemplate(LoginComponent loginComponent){
        
        this.loginComponent = loginComponent;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJLabels();
        this.crearForm();
        this.crearJButtons();
        
        setSize(900,600);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void crearObjetosDecoradores(){
        iFondo = new ImageIcon("resources/images/fondo.jpg");
        iLogo = new ImageIcon("resources/images/logo.png");
        iCerrar = new ImageIcon("resources/images/cerrar1.png");

        iDimAux = new ImageIcon(
            iFondo.getImage().getScaledInstance(900, 600, Image.SCALE_AREA_AVERAGING)
        ); 
        bordeRedondeadoFondo = sGraficosAvanzados.DibujarBordeRedondeado(null, 40, false, false, iDimAux.getImage());
        bordeRedondeado = sGraficosAvanzados.DibujarBordeRedondeado(null, 40, false, false, null);
        bordeInferior = BorderFactory.createMatteBorder(0, 0, 2, 0, sRecursos.getColorRojo());
        bordeCircular = sGraficosAvanzados.DibujarBordeCircular(sRecursos.getColorRojo(), true, false, iDimAux.getImage());
    }

    public void crearJPanels(){
        pDatos = sObjGraficos.construirJPanel(500, 50, 350, 500, sRecursos.getColorBlanco(), bordeRedondeadoFondo);
        this.add(pDatos);
        
        pSuperior = sObjGraficos.construirJPanel(65, 30, 200, 120, sRecursos.getColorBlanco(), null);
        pDatos.add(pSuperior);
        
        pBarra = sObjGraficos.construirJPanel(1, 155, 348, 20, sRecursos.getColorAmarillo(), null);
        pDatos.add(pBarra);

        pFondo = sObjGraficos.construirJPanel(0, 0, 900, 600, null, null);
        this.add(pFondo);
    }

    public void crearJLabels(){
        // lLogo = sObjGraficos.construirJLabel(null, 20, 20, 70, 70, null, null, null, null, null, bordeCircular, "c");
        // pFondo.add(lLogo);
        iDimAux = new ImageIcon(
            iFondo.getImage().getScaledInstance(pFondo.getWidth(), pFondo.getHeight(), Image.SCALE_AREA_AVERAGING)
        ); 
        lFondo = sObjGraficos.construirJLabel("", 0, 0, 900, 600, null, iDimAux, null, null, null, null, "c");
        pFondo.add(lFondo);
        
        iDimAux = new ImageIcon(iLogo.getImage().getScaledInstance(120, 120, Image.SCALE_AREA_AVERAGING));
        lLogoLogin = sObjGraficos.construirJLabel(
            "", 0, 0, 220, 120, sRecursos.getCMano(), iDimAux, null, null, null, null, "c"
        );
        pSuperior.add(lLogoLogin);

        
        
        lNombreUsuario = sObjGraficos.construirJLabel(
            "Nombre de Usuario", 120, 185, 110, 30, null, null,
            sRecursos.getFontTitulos(), null, sRecursos.getColorNegro(), null, "c"
        );
        pDatos.add(lNombreUsuario); 

        lClaveUsuario = sObjGraficos.construirJLabel(
            "Clave de Usuario", 125, 265, 100, 30, null, null,
            sRecursos.getFontTitulos(), null, sRecursos.getColorNegro(), null, "c"
        );
        pDatos.add(lClaveUsuario); 

        lTipoUsuario = sObjGraficos.construirJLabel(
            "Tipo de Usuario", 130, 340, 90, 30, null, null,
            sRecursos.getFontTitulos(), null, sRecursos.getColorNegro(), null, "c"
        );
        pDatos.add(lTipoUsuario); 
    }

    public void crearForm(){
        tNombreUsuario= sObjGraficos.construirJTextField(
            "Nombre Usuario", 85, 210, 180, 30, null, sRecursos.getColorBlanco(),
            sRecursos.getColorGris(), sRecursos.getColorRojo(), bordeInferior, "c"
        );
        tNombreUsuario.addFocusListener(loginComponent);
        pDatos.add(tNombreUsuario); 
        
        tClaveUsuario= sObjGraficos.construirJPasswordField(
            "Clave Usuario", 85, 290, 180, 30, null, sRecursos.getColorBlanco(),
            sRecursos.getColorGris(), sRecursos.getColorRojo(), bordeInferior, "c"
        );
        tClaveUsuario.addFocusListener(loginComponent);
        pDatos.add(tClaveUsuario); 
        
        cmbTipoUsuario= sObjGraficos.construirJComboBox(
            "Administrador_Operador", 110, 370, 130, 30, null, sRecursos.getColorBlanco() , sRecursos.getColorRojo(), "c"
        );
        pDatos.add(cmbTipoUsuario);
    }

    public void crearJButtons(){
        bIngresar= sObjGraficos.construirJButton(
            "Ingresar", 50, 430, 250, 40, sRecursos.getCMano(), null, null, sRecursos.getColorRojo(), 
            sRecursos.getColorBlanco(), bordeRedondeado, "c", true);
        bIngresar.addActionListener(loginComponent);
        pDatos.add(bIngresar);
        
        bCerrar= sObjGraficos.construirJButton(
            null, 310, 10, 32, 32, sRecursos.getCMano(), iCerrar, null, null, null, null, "c", false
        );
        bCerrar.addActionListener(loginComponent);
        pDatos.add(bCerrar);
    }

    public JButton getBCerrar(){
        return this.bCerrar;
    }
}