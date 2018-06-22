package <Here goes your package>;
import java.util.Scanner;
public class <here your class> {
    public String[][] generateUni(String[][] uni, int size) {
        String[][] generated=new String[size][size];
        int row,col,cAlive,nRow,nCol;
        for(row=1;row<size-1;row++)
            for(col=1;col<size-1;col++) {
                cAlive=0;
                for(nRow=-1;nRow<=1;nRow++)
                    for(nCol=-1;nCol<=1;nCol++)
                        if(!(nRow==0&&nCol==0))
                            if (uni[row + nRow][col + nCol] == "*") cAlive++;
                if(uni[row][col]==" ") {
                    if(cAlive==3)
                        generated[row][col] = "*";
                    else
                        generated[row][col] = " ";
                }
                else {
                    if(cAlive==2 || cAlive==3)
                        generated[row][col] = "*";
                    else
                        generated[row][col] = " ";
                }
            }
        return generated;
    }
    public String[][] universe1(int size){
        String[][] uni = new String[size][size];
        for (int fila = 0; fila < size; fila++)
            for (int col = 0; col < size; col++) {
                if(fila==0||fila==size-1)
                    uni[fila][col] = "-";
                else if(col==0||col==size-1)
                    uni[fila][col] = "|";
                else
                    uni[fila][col] = " ";
                if(fila>0&&fila<size-1) {
                    if (fila == col)
                        uni[fila][col] = "*";
                    if (fila + col == size - 1)
                        uni[fila][col] = "*";
                }
            }

        return uni;
    }
public void printUni(String[][] uni, int size){
    for (int fila = 0; fila < size; fila++) {
        for (int col = 0; col < size; col++) {
            if (fila == 0 || fila == size - 1)
                uni[fila][col] = "-";
            else if (col == 0 || col == size - 1)
                uni[fila][col] = "|";
            System.out.print(uni[fila][col]);
        }
        System.out.print("\n");
    }
}
    public static void main(String[] args) {
        GameOfLife ob = new GameOfLife();
        Scanner reader = new Scanner(System.in);
        String dec;
        int count=1;
        System.out.println("Size of the universe");
        int size = reader.nextInt();
        String[][] universe1 = ob.universe1(size);
        String[][] nuevo;
        System.out.println("universe "+count++);
        ob.printUni(universe1,size);
        nuevo = ob.generateUni(universe1,size);
        System.out.println("universe "+count++);
        ob.printUni(nuevo,size);
        do {
            System.out.println("Print again? (Y/N)");
            dec = reader.next().toUpperCase();
            if(dec.equals("N")) break;
            System.out.println("universe "+count++);
            nuevo = ob.generateUni(nuevo,size);
            ob.printUni(nuevo,size);
            System.out.println("universe "+count++);
            nuevo = ob.generateUni(nuevo,size);
            ob.printUni(nuevo,size);
        }while(!dec.equals("n".toUpperCase()));
    }
}