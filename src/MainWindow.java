import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.lang.Math;

public class MainWindow {
	private ArrayList<Tree> usuarios;
	private ArrayList<Tree> suspeitos;
	
	private String dataTotal;
	LocalDate inicio;
	LocalDate fim;
	
    private JFrame frame;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    
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

    // panel6
    private JButton processCsvButton;
    
    // panel7
    private JLabel userIdInputLabel;
    private JTextField userIdInput;
    private JButton showUserTree;
    
    // panel8
    private JButton detectButton;
    
    
    /***
     * MÈtodo que cria a interface e inicializa tanto
     * o array de usu·rios, quando o array de suspeitos
     * que v„o ser utilizados durante a utilizaÁ„o do sistema.
     * */
    public MainWindow() {
    	this.usuarios = new ArrayList<Tree>();
    	this.suspeitos = new ArrayList<Tree>();
        createInterface();
    }
    
    /***
     * MÈtodo para ler o CSV de Usu·rios.
     * */
    private void readUserCsv() {
    	try {
			BufferedReader reader = new BufferedReader(new FileReader(userCsv.getText()));
			String header = reader.readLine();
			
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				} else {
					String [] data = line.split(",");
					User user = new User(data[0], data[1], data[2], data[3], data[4]);
					
					Tree usuario = new Tree(user);
					this.usuarios.add(usuario);
				}
			}					
			reader.close();
    	} catch (Exception e1) {
			e1.printStackTrace();
		}
    }

    /***
     * MÈtodo para ler e adicionar data ‡ ·rvore de Usuario,
     * tambÈm assimila data inicial e final para checagem e validaÁ„o
     * para an·lise do sistema.
     * */
    private void readDate() {
    	try {
    		String dataInicial = initialDate.getText();
    		String dataFinal = finalDate.getText();
    		
    		dataTotal = dataInicial + " " + dataFinal;
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    		this.inicio = LocalDate.parse(dataInicial, formatter);
    		this.fim = LocalDate.parse(dataFinal, formatter);
    		
    		for(Tree usuario:this.usuarios) {
    			usuario.addDate(dataTotal);
    		}
    		
    		// Adicionar nos de data aqui
    	} catch (Exception el) {
    		el.printStackTrace();
    	}
    }
    
    /***
     * MÈtodo para ler o CSV de Pendrive.
     * */
    private void readDeviceCsv() {
    	try {
			BufferedReader reader = new BufferedReader(new FileReader(deviceCsv.getText()));
			String header = reader.readLine();
			
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				} else {
					String [] data = line.split(",");
					
					String [] date = data[1].split(" ");
					String day = date[0]; // Vari√°vel com o dia
					String hour = date[1].split(":")[0]; // Vari√°vel com o hor√°rio
					
					String userId = data[2]; // Vari√°vel com o Id do usu√°rio
					String userIdCorrected = userId.split("/")[1];
					
					String pc = data[3]; // Vari√°vel com o Id do PC
					
					String activity = data[4]; // Vari√°vel com a atividade
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					LocalDate currentDate = LocalDate.parse(day, formatter);
					
					if( (currentDate.isEqual(this.inicio)||currentDate.isAfter(this.inicio)) &&
							(currentDate.isEqual(this.fim)||currentDate.isBefore(this.fim))) {
						for(Tree usuario:this.usuarios) {
							if(usuario.getRoot().getValue().getId().equals(userIdCorrected)) {

								Node<String> currentPc = usuario.findPC(dataTotal, pc, Integer.parseInt(hour));
								usuario.addPendrive(currentPc, activity, Integer.parseInt(hour));
							}
						}
					}
				}
			}					
			reader.close();
    	} catch (Exception el) {
    		el.printStackTrace();
    	}
    }

    /***
     * MÈtodo para ler o CSV de Http.
     * */
    private void readHttpCsv() {
    	try {
			BufferedReader reader = new BufferedReader(new FileReader(httpCsv.getText()));
			String header = reader.readLine();
			
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				} else {
					String [] data = line.split(",");
					
					String [] date = data[1].split(" ");
					String day = date[0]; // Vari√°vel com o dia
					String hour = date[1].split(":")[0]; // Vari√°vel com o hor√°rio
					
					String userId = data[2]; // Vari√°vel com o Id do usu√°rio
					String userIdCorrected = userId.split("/")[1];
					
					String pc = data[3]; // Vari√°vel com o Id do PC
					
					String activity = data[4]; // Vari√°vel com a atividade					
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					LocalDate currentDate = LocalDate.parse(day, formatter);
					
					if( (currentDate.isEqual(this.inicio)||currentDate.isAfter(this.inicio)) &&
							(currentDate.isEqual(this.fim)||currentDate.isBefore(this.fim))) {
						for(Tree usuario:this.usuarios) {
							if(usuario.getRoot().getValue().getId().equals(userIdCorrected)) {

								Node<String> currentPc = usuario.findPC(dataTotal, pc, Integer.parseInt(hour));
								usuario.addHTTP(currentPc, activity, Integer.parseInt(hour));
							}
						}
					}
					// Crie o no aqui
				}
			}					
			reader.close();
    	} catch (Exception e1) {
    		e1.printStackTrace();
		}
    }

    /***
     * MÈtodo para ler o CSV de Logon.
     * */
    private void readLogonCsv() {
    	try {
			BufferedReader reader = new BufferedReader(new FileReader(logonCsv.getText()));
			String header = reader.readLine();
			
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				} else {
					String [] data = line.split(",");
					
					String [] date = data[1].split(" ");
					String day = date[0]; // Vari√°vel com o dia
					String hour = date[1].split(":")[0]; // Vari√°vel com o hor√°rio
					
					String userId = data[2]; // Vari√°vel com o Id do usu√°rio
					String userIdCorrected = userId.split("/")[1];
					
					String pc = data[3]; // Vari√°vel com o Id do PC
					
					String activity = data[4]; // Vari√°vel com a atividade					
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					LocalDate currentDate = LocalDate.parse(day, formatter);
					
					if( (currentDate.isEqual(this.inicio)||currentDate.isAfter(this.inicio)) &&
							(currentDate.isEqual(this.fim)||currentDate.isBefore(this.fim))) {
						for(Tree usuario:this.usuarios) {
							if(usuario.getRoot().getValue().getId().equals(userIdCorrected)) {

								Node<String> currentPc = usuario.findPC(dataTotal, pc, Integer.parseInt(hour));
								usuario.addLogon(currentPc, activity, Integer.parseInt(hour));
							}
						}
					}
					// Crie o no aqui 
				}
			}					
			reader.close();
    	} catch (Exception el) {
    		el.printStackTrace();
    	}
    }
    
    /***
     * MÈtodo que checa se os campos de arquivos est„o vazios.
     * */
    private boolean validate() {
    	boolean flag = true;
    	
    	if(userCsv.getText().isEmpty() || deviceCsv.getText().isEmpty() 
    			|| httpCsv.getText().isEmpty() || logonCsv.getText().isEmpty() 
    			|| initialDate.getText().isEmpty() || finalDate.getText().isEmpty()) {
    		flag = false;
    	}
    	
    	return flag;
    }
    
    /***
     * MÈtodo que via processar as aÁıes do sistema.
     * */
    private void processAction() {
    	readUserCsv();
    	readDate();
    	readDeviceCsv();
    	readHttpCsv();
    	readLogonCsv();
    }
    
    /***
     * MÈtodo que gera a interface do sistema.
     * */
    private void createInterface() {
        frame = new JFrame("Insider Threat");
        frame.setLayout(new GridLayout(8, 8));

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));

        userCsvLabel = new JLabel("Registro de usu√°rios: ");
        userCsv = new JLabel("");
        userCsvButton = new JButton("Selecionar arquivo");

        panel1.add(userCsvLabel);
        panel1.add(userCsv);
        panel1.add(userCsvButton);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 1));

        initialDateLabel = new JLabel("Data Inicial (MM/dd/yyyy): ");
        initialDate = new JTextField();
        finalDateLabel = new JLabel("Data Final (MM/dd/yyyy): ");
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
        
        panel7 = new JPanel();
        panel7.setLayout(new GridLayout(1, 1));
        
        userIdInputLabel = new JLabel("Digite o id do usu√°rio: ");
        userIdInput = new JTextField();
        showUserTree = new JButton("Mostrar perfil");
        
        panel7.add(userIdInputLabel);
        panel7.add(userIdInput);
        panel7.add(showUserTree);
        
        panel8 = new JPanel();
        panel8.setLayout(new GridLayout(1, 1));
        
        detectButton = new JButton("Detectar Anomalias");
        
        panel8.add(detectButton);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);
        frame.add(panel7);
        frame.add(panel8);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        
        /***
         * Bot„o que vai selecionar o arquivo CSV referente aos usu·rios.
         * */
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

        /***
         * Bot„o que vai selecionar o arquivo CSV referente ao Pendrive.
         * */
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

        /***
         * Bot„o que vai selecionar o arquivo CSV referente ao Http.
         * */
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

        /***
         * Bot„o que vai selecionar o arquivo CSV referente ao Logon.
         * */
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
        
        /***
         * Bot„o que vai validar se todos os campos foram preenchidos corretamente.
         * */
        processCsvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(validate()) {
            		processAction();
            	} else {
            		JOptionPane.showMessageDialog(null, "Preencha corretamente os campos");
            	}
            }
        });
        
        /***
         * Bot„o para mostrar um usu·rio especÌfico processado. È necess·rio
         * passar o Id do usu·rio para poder mostrar seus dados.
         * */
        showUserTree.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		String userId = userIdInput.getText();
        		boolean not_found = true;
        		for(Tree usuario:usuarios) {
					if(usuario.getRoot().getValue().getId().equals(userId)) {
						not_found = false;
						usuario.showTree();
						usuario.getRoot().showHistogram();
					}
        		}
        		
        		//Criar arquivo de usuÔøΩrio com as informaÔøΩÔøΩes.
        		
        		if(not_found) {
        			System.out.println("Usuario nao encontrado!");
        		}
        	}
        });
    
        /***
         * Bot„o para detectar usu·rios suspeitos no sistema.
         * */
        detectButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int[] avgHistogram = new int[24];
        		
        		for(Tree usuario:usuarios) {
        			for(int i=0;i<24;i++) {
        				avgHistogram[i] += usuario.getRoot().getHistogram(i);
        			}
        		}
        		
        		for(int i = 0;i<24;i++) {
        			avgHistogram[i] = (int) Math.ceil(avgHistogram[i]/usuarios.size());
        		}
        		
        		for(Tree usuario:usuarios) {
        			if(usuario.getRoot().enclideanDistance(avgHistogram)) {
        				suspeitos.add(usuario);
        			}
        		}
        		
        		for(Tree suspeito:suspeitos) {
        			System.out.println("Usuario suspeito: "+suspeito.getRoot().getValue().getId());
        		}
        		
        	}
        });
    }
}