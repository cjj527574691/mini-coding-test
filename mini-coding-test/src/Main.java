import java.util.*;

public class Main {

    private static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                System.out.println("输入字符中" + str + "不为数字或者为负数");
                return false;
            }
        }
        return true;
    }

    private static void rowToList(String systemin, List<String> numList) {
        if (systemin != null && systemin.length() > 0){
            List<String> list = Arrays.asList(systemin.split(" "));
            list.forEach(a -> {
                if (isNumeric(a)) {
                    if (Integer.valueOf(a) > -1 && Integer.valueOf(a) < 99) {
                        numList.add(a);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {

        List<String> resultList =new ArrayList<>();
        List<String> btnList = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

        Scanner sc  = new Scanner(System.in);
        System.out.println("请输入若干数字，取值从0~99，用空格隔开，以＃结尾：");
        String systemin = "start";
        List<String> numList = new ArrayList<>();
        while ('#' != systemin.charAt(systemin.length() - 1)) {
            rowToList(systemin, numList);
            System.out.println("现在数组中整数为：" + String.join(",", numList));
            systemin = sc.nextLine().trim();
        }
        rowToList(systemin, numList);
        System.out.println("现在数组中整数为：" + String.join(",", numList));

        if (numList.size() == 0){
            System.out.println("数组中无有效整数输入，不进行转换");
        } else {
            String numString = String.join("", numList);
            numString = numString.replace("0", "");
            numString = numString.replace("1", "");
            resultList.add("");
            for ( int i = 0 ; i < numString.length() ; i++) {
                List<String> result = new ArrayList<>();
                String dict = btnList.get(numString.charAt(i) - '0');
                for ( int j = 0 ; j < resultList.size() ; j++) {
                    for ( int k = 0 ; k < dict.length() ; k++) {
                        result.add(resultList.get(j) + dict.charAt(k));
                    }
                }
                resultList = result;
            }
            System.out.println("所有组合结果为：" + String.join(",", resultList));
        }
    }

}
