import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InputData {
    final int MATRIX_SIZE = 5;
    String filename;
    float[][] data;

    public InputData(String filename) {
        this.filename = filename;
        data = new float[MATRIX_SIZE][MATRIX_SIZE];
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            for (int i = 0; i < 5; i++) {
                String[] s = br.readLine().split(" ");
                System.out.println(Arrays.toString(s));
                for (int j = 0; j < 5; j++) {
                    data[i][j] = Float.valueOf(s[j]);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String calculateAndGenerate() {
        StringBuilder sb = new StringBuilder("Input File: " + filename + "\n=================================\n");
        float alpha, beta, delta;
        alpha = beta = delta = 0.0f;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            alpha += data[0][i] * data[i][0];
        }
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                beta += data[i][j];
            }
        }
        delta = beta / alpha;
        sb.append("Calculation results:\n=================================\n");
        sb.append(String.format("alpha: %2f\nbeta: %2f\ndelta: %2f\n", alpha, beta, delta));
        sb.append("=================================\nReport generated by DocGenerator");
        return sb.toString();
    }
}