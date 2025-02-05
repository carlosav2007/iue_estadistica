import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// Jframe es un formulario sog
public class frm_estadistica extends JFrame {

    public frm_estadistica() {

        setSize(600, 300);
        setTitle("estadistica");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);


        JLabel Idldato= new JLabel("dato");
        Idldato.setBounds(10,10,100,25);
        getContentPane().add(Idldato);

        JTextField txtDato= new JTextField("");
        txtDato.setBounds(110,10,100,25);
        getContentPane().add(txtDato);

        JLabel Idldatos= new JLabel("muestra");
        Idldatos.setBounds(250,10,100,25);
        getContentPane().add(Idldatos);

        JTextField txtdesviacion = new JTextField("");
        txtdesviacion.setBounds(250,200,100,25);
        getContentPane().add(txtdesviacion);

        JButton btnAgregar=new JButton("agregar");
        btnAgregar.setBounds(110,50, 100, 25);
        getContentPane().add(btnAgregar);

        JButton btnquitar=new JButton("quitar");
        btnquitar.setBounds(120,85, 80, 25);
        getContentPane().add(btnquitar);
 
        JButton btndesviacion=new JButton("desviacion");
        btndesviacion.setBounds(110,200, 100, 25);
        getContentPane().add(btndesviacion);




    }

}
