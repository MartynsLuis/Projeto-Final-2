public class MainSala {
    
    public static void main(String args []){
        Usuario sus = new Usuario("rodrigo", "Professor", "123");
        Sala sala1 = new Sala(sus);

        sala1.tornarVisivel();
    }
}
