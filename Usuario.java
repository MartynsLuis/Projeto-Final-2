public class Usuario {
    private String nome;
    private String funcao;
    private String senha;

    public Usuario(String name, String function, String password){
        nome = name;
        funcao = function;
        senha = password;
    }

    public String getNome(){
        return nome;
    }

    public String getFuncao(){
        return funcao;
    }

    public String getSenha(){
        return senha;
    }
}
