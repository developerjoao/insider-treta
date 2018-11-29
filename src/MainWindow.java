import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MainWindow {
    private JFrame frame;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;

    // panel1
    private JLabel userCsvLabel;
    private JLabel userCsv;
    private JButton userCsvButton;

    // panel2
    private JLabel initialDateLabel;
    private JLabel finalDateLabel;
    private JTextField initialDate;
    private JTextField finalDate;

    // panel3
    private JLabel deviceCsvLabel;
    private JLabel deviceCsv;
    private JButton deviceCsvButton;

    // panel4
    private JLabel httpCsvLabel;
    private JLabel httpCsv;
    private JButton httpCsvButton;

    // panel5
    private JLabel logonCsvLabel;
    private JLabel logonCsv;
    private JButton logonCsvButton;

    private JButton processCsvButton;

    public MainWindow() {
        mountComponents();
    }

    private void mountComponents() {
        frame = new JFrame("Insider Threat");
        frame.setLayout(new GridLayout(6, 6));

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));

        userCsvLabel = new JLabel("Registro de usuários: ");
        userCsv = new JLabel("");
        userCsvButton = new JButton("Selecionar arquivo");

        panel1.add(userCsvLabel);
        panel1.add(userCsv);
        panel1.add(userCsvButton);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));

        initialDateLabel = new JLabel("Data Inicial: ");
        initialDate = new JTextField();
        finalDateLabel = new JLabel("Data Final: ");
        finalDate = new JTextField();

        panel2.add(initialDateLabel);
        panel2.add(initialDate);
        panel2.add(finalDateLabel);
        panel2.add(finalDate);

        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 1));

        deviceCsvLabel = new JLabel("Registro de dispositivos: ");
        deviceCsv = new JLabel("");
        deviceCsvButton = new JButton("Selecionar arquivo");

        panel3.add(deviceCsvLabel);
        panel3.add(deviceCsv);
        panel3.add(deviceCsvButton);

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(1, 1));

        httpCsvLabel = new JLabel("Registro de http: ");
        httpCsv = new JLabel("");
        httpCsvButton = new JButton("Selecionar arquivo");

        panel4.add(httpCsvLabel);
        panel4.add(httpCsv);
        panel4.add(httpCsvButton);

        panel5 = new JPanel();
        panel5.setLayout(new GridLayout(1, 1));

        logonCsvLabel = new JLabel("Registro de logon: ");
        logonCsv = new JLabel("");
        logonCsvButton = new JButton("Selecionar arquivo");

        panel5.add(logonCsvLabel);
        panel5.add(logonCsv);
        panel5.add(logonCsvButton);

        panel6 = new JPanel();
        panel6.setLayout(new GridLayout(1, 1));

        processCsvButton = new JButton("Processar arquivos");

        panel6.add(processCsvButton);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        userCsvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int retorno = fileChooser.showOpenDialog(frame);

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    userCsv.setText(file.toString());
                } else {
                    System.out.println("Cancelled");
                }
            }
        });

        deviceCsvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int retorno = fileChooser.showOpenDialog(frame);

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    deviceCsv.setText(file.toString());
                } else {
                    System.out.println("Cancelled");
                }
            }
        });

        httpCsvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int retorno = fileChooser.showOpenDialog(frame);

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    httpCsv.setText(file.toString());
                } else {
                    System.out.println("Cancelled");
                }
            }
        });

        logonCsvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int retorno = fileChooser.showOpenDialog(frame);

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    logonCsv.setText(file.toString());
                } else {
                    System.out.println("Cancelled");
                }
            }
        });

        processCsvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Initial Date: " + initialDate.getText());
                // System.out.println("Final Date: " + finalDate.getText());

                // try {
                // TimeWindow timeWindow = new TimeWindow(initialDate.getText(),
                // finalDate.getText());
                // timeWindow.getTimeWindow();
                // } catch (Exception exception) {
                // System.out.println("Data inválida");
                // return;
                // }
                // System.out.println("Ronaldo: " +
                // timeWindow.isValidDate(initialDate.getText(), "MM/dd/yyyy"));

            	try {
					BufferedReader reader = new BufferedReader(new FileReader(userCsv.getText()));
					String header = reader.readLine();
					
					String line = reader.readLine();
					String[] data = line.split(",");
					
					User user = new User(data[0], data[1], data[2], data[3], data[4]);
					
					user.show();
					
					reader.close();
            	} catch (Exception e1) {
					e1.printStackTrace();
				}
            }
        });
    }
}