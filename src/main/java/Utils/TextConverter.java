package Utils;

public class TextConverter {

    public static double getDoubleValuePriceFromTextWith$(String text){
        return Double.parseDouble(
                text.replace("$"," ").trim()
        );
    }
}
