import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

public class Sala {
    private JFrame tela; // é janela/tela
    private HashMap<String, String> mensagem; // A primeira String é para o nome de usuario e a segunda é pra mensagem
    private Usuario usuarioAtua; // usuario
    private JTextArea textArea; // essa é a area de texto, onde aprace as mensagens
    private JLabel nomeDisciplina; // essa é a Label onde fica o nome da disciplina

    public Sala(Usuario usuario){
        this.usuarioAtua = usuario;
        mensagem = new HashMap<String, String>(); // não adicionei uma função para pegar as mensagen já existentes
        criarJanela();
    }

    private void criarJanela(){
        tela = new JFrame("Sala De Aula");
        Container informacoesTela = tela.getContentPane();
        informacoesTela.setLayout(new BoxLayout(informacoesTela, BoxLayout.Y_AXIS));
        createMenuBar(); // cria amenubar


        // essa é o titulo/matéria
        nomeDisciplina = new JLabel("Default");
        nomeDisciplina.setAlignmentX(Component.CENTER_ALIGNMENT);
        informacoesTela.add(nomeDisciplina);

        // Area onde fica as mensagens
        textArea = new JTextArea(10,25);
        textArea.setEditable(false);
        JScrollPane scrollTextarea = new JScrollPane(textArea);

        informacoesTela.add(scrollTextarea);

        // essa parte é a parte da caixa de texto e o botão enviar
        Container mesageSend = new Container();
        JTextField textField = new JTextField(23);
        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener((ActionEvent e) -> {escreverTela(textField.getText());
                                                         textField.setText("");});
        mesageSend.setLayout(new FlowLayout());
        mesageSend.add(textField);
        mesageSend.add(sendButton);

        informacoesTela.add(mesageSend);
        
        // aqui ele escreve todas as mensagens já presentes na hashmap
        for(String nome : mensagem.keySet()){
            String mesage = mensagem.get(nome);
            escreverTela(mesage,nome);
        }

        tela.setSize(300,350);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createMenuBar(){
        
        JMenuBar menubar = new JMenuBar(); // barra de menus
        tela.setJMenuBar(menubar);

        JMenu quitMenu = new JMenu("Sair"); // menubar de sair
        quitMenu.addActionListener((ActionEvent e) -> {}); // ainda precisa da função
        menubar.add(quitMenu);

        if (usuarioAtua.getFuncao().equals("Professor")){
            JMenu configMenu = new JMenu("Configurações"); // menurbar de configuração
            menubar.add(configMenu);

            JMenuItem openItem = new JMenuItem("Mudar Nome Da Disciplina");
            openItem.addActionListener((ActionEvent e) -> { trocarDisciplina(); });
            configMenu.add(openItem);

            JMenuItem quitItem = new JMenuItem("Trocar Senha");
            //quitItem.addActionListener((ActionEvent e) -> { trocarSenha();});
            configMenu.add(quitItem);

            // se quiser pode adicionar uma outra menuItem
            /*JMenuItem aboutItem = new JMenuItem("About");
            aboutItem.addActionListener((ActionEvent e) -> { System.out.println("Menu item: About"); });
            configMenu.add(aboutItem);*/
        }
    }

    // torna a janela visivel, pode ser colocado no fim do criajanela se assim quiser
    public void tornarVisivel(){
        tela.setVisible(true);
    }

    // traca o nome da disciplina
    private void trocarDisciplina(){
        String disciplina = JOptionPane.showInputDialog("Insira o nome da disciplina");
        nomeDisciplina.setText(disciplina);
    }

    // aqui tem que por o metodo para adicionar a mensagem a hashmap e logo apos escrevela na tela
    private void adicionarMensagem(){

    }

    // serve pra escrever na tela quano é o usuario atual
    private void escreverTela(String mensagemEnviada){
        textArea.append(usuarioAtua.getNome() + "(Você) -> " + mensagemEnviada + "\r\n");
    }

    // serve pra escrever na tela quando não é o usuario atual
    private void escreverTela(String mensagemEnviada, String remetente){
        textArea.append(remetente + " -> " + mensagemEnviada);
    }
    
}