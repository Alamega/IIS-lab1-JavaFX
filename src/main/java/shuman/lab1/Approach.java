package shuman.lab1;

public class Approach {
    String name;
    int[] signs;

    public Approach(String name, int sign1, int sign2, int sign3, int sign4, int sign5) {
        this.name = name;
        this.signs = new int[] { sign1, sign2, sign3, sign4, sign5 };
    }

    public static Approach[] approaches = {
            new Approach("Структурный",  1, 0, 1,  0, 0),
            new Approach("Логический",   1, 1,  0, 0, 0),
            new Approach("Имитационный", 1, 1,  0, 1,  0),
            new Approach("Эволюционный", 1, 0, 0, 0, 1),
    };

    public static int getDistance(int[] input, Approach stand) {
        int distance = 0;
        for (int i = 0; i < input.length; i++) {
            distance += Math.abs(input[i] - stand.signs[i]);
        }
        return distance;
    }

    public static double getSimilarity(int[] input, Approach stand, int func) {
        double a = 0;
        double b = 0;
        double g = 0;
        double h = 0;
        for (int i = 0; i < input.length; i++) {
            a += stand.signs[i] * input[i];
            b += (1 - stand.signs[i]) * (1 - input[i]);
            g += input[i] * (1 - stand.signs[i]) ;
            h += (1 - input[i]) * stand.signs[i];
        }
        double result = 0;
        switch (func) {
            case 1 -> result = a / (a + b + g + h);
            case 2 -> result = a / (a + g + h);
            case 3 -> result = a / (2 * a + g + h);
            case 4 -> result = a / (a + 2 * (g + h));
            case 5 -> result = (a + b) / (a + b + g + h);
            case 6 -> result = a / (g + h);
            case 7 -> result = (a * b - g * h) / (a * b + g * h);
            default -> {}
        }
        return result;
    }

    @Override
    public String toString() {
        return name + ": " + signs[0] + " " + signs[1] + " " + signs[2] + " " + signs[3] + " " + signs[4];
    }
}
