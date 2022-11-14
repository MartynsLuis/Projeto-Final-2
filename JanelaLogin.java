import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

public class JanelaLogin {
    private JFrame janela;
    private HashMap<String,Usuario> usuarios;
    
    public JanelaLogin(){
        criarFrame();
        usuarios = new HashMap<String,Usuario>();
    }

    private void criarFrame(){
        janela = new JFrame("Login");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container telalogin = janela.getContentPane();
        Container subLogin = new Container();
        Container subSenha = new Container();

        // Login
        telalogin.setLayout(new BoxLayout(telalogin, BoxLayout.Y_AXIS));

        // caixa de login
        subLogin.setLayout(new FlowLayout());
        JLabel Texto = new JLabel("Login");
        subLogin.add(Texto);

        JTextField loginTexto = new JPasswordField(25);
        subLogin.add(loginTexto);

        // caixa da senha
        subSenha.setLayout(new FlowLayout());
        JLabel senhaTexto = new JLabel("Senha");
        subSenha.add(senhaTexto);

        JPasswordField caixaTextoSenha = new JPasswordField(25);
        subSenha.add(caixaTextoSenha);

        // adicionando tudo
        telalogin.add(subLogin);
        telalogin.add(subSenha);

        // Botão de entrar
        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.setAlignmentX(Component.RIGHT_ALIGNMENT);
        botaoEntrar.addActionListener((ActionEvent e) -> { confirmaLogin(loginTexto.getText(), String.valueOf(caixaTextoSenha.getPassword())); });
        telalogin.add(botaoEntrar);

        janela.pack();
    }

    /*private void criarCaixaDeTexto(Container contentPane, String nomeDaCaixa){
        JLabel Texto = new JLabel(nomeDaCaixa);
        contentPane.add(Texto);

        JPasswordField caixaTexto = new JPasswordField(25);
        contentPane.add(caixaTexto);
    }*/

        // Confirma se o login e a senha são existentes/corretas
        private void confirmaLogin(String login, String senha){
            Usuario usuario = usuarios.get(login); // User user = new User(username, host, port password); Server-Client socket host:port
            // verifica se o login é inválido     private HashMap<String,Usuario> usuarios;
            if (usuario == null){
                JOptionPane.showMessageDialog(janela, "Login inválido", "Login Inválido", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // verifica se a senha é a correta
            if (usuario.getSenha().equals(senha)){ // tem que adicionaro coisa aqui
                //janela.dispose();
                //Sala chatSala = new Sala(usuario);
                //janelaEscola.deixarVisivel();
                return;
            }
            JOptionPane.showMessageDialog(janela, "Senha inválido", "Senha Inválido", JOptionPane.INFORMATION_MESSAGE);
        }
    
        public void mostrarTela(){
            janela.setVisible(true);
        }
}
