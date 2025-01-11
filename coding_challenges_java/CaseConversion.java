package coding_challenges_java;

public class CaseConversion {

    public static void main(String[] args) {
        System.out.println(convertCamelCaseToSnakeCase("ConvertCamelCaseToSnakeCase"));
        System.out.println(convertSnakeCaseToCamelCase("convert_camel_case_to_snake_case"));
    }

    static String convertCamelCaseToSnakeCase(String str) {
        String snakeCaseStrTemp = str.replaceAll("([a-z])([A-Z])", "$1_$2");
        return snakeCaseStrTemp.toLowerCase();
    }

    static String convertSnakeCaseToCamelCase(String str) {
        String[] strArr = str.split("_");
        String[] camelCaseArr = new String[strArr.length];
        camelCaseArr[0] = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            camelCaseArr[i] = strArr[i].substring(0, 1).toUpperCase()
                    + strArr[i].substring(1);
        }
        return String.join("", camelCaseArr);
    }
}
