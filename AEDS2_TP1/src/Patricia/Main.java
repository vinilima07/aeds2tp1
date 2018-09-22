package Patricia;

import java.io.IOException;
import java.io.RandomAccessFile;
/**
 *
 * @author Vinicius Franca
 */
public class Main {
    RandomAccessFile file;
    public static void main(String[] args) throws IOException {
        Busca b = new Busca();
        b.discover("C:\\Users\\Positivo\\Documents\\github\\treePatricia\\AEDS2_TP1\\src\\Patricia\\exemplo1.txt");
    }
}