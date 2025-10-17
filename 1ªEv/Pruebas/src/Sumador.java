public class Sumador {
    public static void main(String[] args) {
        //Recojo valores que me envia el usuario en tiempo de ejecucion
        int var1 = Integer.parseInt(args[0]);
        int var2 = Integer.parseInt(args[1]);
        int var3 = 0;

        for(int i = var1; i <= var2; i++){
            var3 += i;
        }

        System.out.println(var3);
    }
}
