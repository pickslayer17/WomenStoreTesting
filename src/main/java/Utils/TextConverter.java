package Utils;

public class TextConverter {

    public static double parsePriceToDoubleFromTextWith$(String text) {
        return Double.parseDouble(
                text.replace("$", " ").trim()
        );
    }
}
