import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrmEstadistica extends JFrame {

    JTextField txtDato;
    JList lstMuestra;
    JTextField txtEstadistica;
    JComboBox cmbEstadistica;

    public FrmEstadistica() {

        setSize(400, 300);
        setTitle("Estadística");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblDato = new JLabel("Dato");
        lblDato.setBounds(10, 10, 100, 25);
        getContentPane().add(lblDato);

        txtDato = new JTextField();
        txtDato.setBounds(80, 10, 100, 25);
        getContentPane().add(txtDato);

        JLabel lblDatos = new JLabel("Muestra");
        lblDatos.setBounds(210, 10, 100, 25);
        getContentPane().add(lblDatos);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(80, 40, 100, 25);
        getContentPane().add(btnAgregar);

        JButton btnQuitar = new JButton("Quitar");
        btnQuitar.setBounds(80, 70, 100, 25);
        getContentPane().add(btnQuitar);

        lstMuestra = new JList();
        JScrollPane spMuestra = new JScrollPane(lstMuestra);
        spMuestra.setBounds(210, 40, 100, 150);
        getContentPane().add(spMuestra);

        JButton btnEstadistica = new JButton("Calcular");
        btnEstadistica.setBounds(10, 200, 100, 25);
        getContentPane().add(btnEstadistica);

        cmbEstadistica = new JComboBox();
        String[] opciones = new String[] { "Sumatoria", "Promedio", "Desviación", "Máximo", "Minimo", "Moda" };
        DefaultComboBoxModel mdlEstadistica = new DefaultComboBoxModel(opciones);
        cmbEstadistica.setModel(mdlEstadistica);
        cmbEstadistica.setBounds(110, 200, 100, 25);
        getContentPane().add(cmbEstadistica);

        txtEstadistica = new JTextField();
        txtEstadistica.setBounds(210, 200, 100, 25);
        getContentPane().add(txtEstadistica);

        // eventos de la GUI
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                agregarDato();
            }
        });

        btnQuitar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                quitarDato();
            }
        });

        btnEstadistica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                calcularEstadistica();
            }
        });
    }

    // declarar el arreglo que almacenará los datos de la muestra
    private double[] muestra = new double[1000];
    private int totalDatos = -1;

    private void agregarDato() {
        try {
            double dato = Double.parseDouble(txtDato.getText());
            totalDatos++;
            muestra[totalDatos] = dato;
            txtDato.setText("");
            mostrarMuestra();
        } catch (Exception ex) {
            txtDato.setText("");
            JOptionPane.showMessageDialog(null, "Debe especificar un valor numérico");
        }
    }

    private void mostrarMuestra() {
        String[] strMuestra = new String[totalDatos + 1];
        for (int i = 0; i <= totalDatos; i++) {
            strMuestra[i] = String.valueOf(muestra[i]);
        }
        lstMuestra.setListData(strMuestra);
    }

    private void quitarDato() {
        // obtener la posicion escogida
        int posicion = lstMuestra.getSelectedIndex();
        if (posicion >= 0) {
            // retirar la posicion del vector
            for (int i = posicion; i < totalDatos; i++) {
                muestra[i] = muestra[i + 1];
            }
            totalDatos--;
            mostrarMuestra();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una posición");
        }
    }

    private double sumatoria() {
        double suma = 0;
        for (int i = 0; i <= totalDatos; i++) {
            suma += muestra[i];
        }
        return suma;
    }

    private double promedio() {
        double promedioCalculado = 0;
        if (totalDatos >= 0) {
            promedioCalculado = sumatoria() / (totalDatos + 1);
        }

        return promedioCalculado;
    }

    private double desviacionEstandar() {
        double suma = 0;
        double promedioCalculado = promedio();
        for (int i = 0; i <= totalDatos; i++) {
            suma += Math.abs(muestra[i] - promedioCalculado);
        }

        return totalDatos > 0 ? suma / totalDatos : 0;
    }

    private double maximo() {
        double mayor = muestra[0];
        for (int i = 1; i <= totalDatos; i++) {
            if (muestra[i] > mayor) {
                mayor = muestra[i];

            }

        }

        return mayor;

    }

    private double minimo() {
        double menor = muestra[0];
        for (int i = 1; i <= totalDatos; i++) {
            if (muestra[i]<menor){
                menor=muestra[i];

            }
            
        }
        
        return menor;
    }

    private void calcularEstadistica() {
        switch (cmbEstadistica.getSelectedIndex()) {
            case 0:
                txtEstadistica.setText(String.valueOf(sumatoria()));
                break;
            case 1:
                txtEstadistica.setText(String.valueOf(promedio()));
                break;

            case 2:
                txtEstadistica.setText(String.valueOf(desviacionEstandar()));
                break;

            case 3:
                txtEstadistica.setText(String.valueOf(maximo()));
                break;

            case 4:
                txtEstadistica.setText(String.valueOf(minimo()));
                break;

        }
    }

}
