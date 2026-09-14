import java.util.Scanner;

public class Library_ISBN_Normalizer_Validator
{
    static String normalizeCode(String raw)
    {
        String code = raw.trim();

        String publisherCode = code.substring(0, 3).toUpperCase();
        String remainingCode = code.substring(3);

        return publisherCode + remainingCode;
    }

    static String validateAndFormat(String code)
    {
        if (code.length() != 13)
        {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++)
        {
            if (!Character.isLetter(code.charAt(i)))
            {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++)
        {
            if (!Character.isDigit(code.charAt(i)))
            {
                return "Invalid: body must contain only digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisher);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String rawCode = scanner.nextLine();

        String normalizedCode = normalizeCode(rawCode);
        String result = validateAndFormat(normalizedCode);

        System.out.println(result);

        scanner.close();
    }
}