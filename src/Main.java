public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(xString("x", 5));
        System.out.println(boxString("|", 4, "Hello", 5, "|"));
        System.out.println(boxEmpty("|", " ", 14, "|"));
    }

    private static String boxString(String start, int ps, String str, int pe, String end) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        sb.append(xString(" ", ps));
        sb.append(str);
        sb.append(xString(" ", pe));
        sb.append(end);
        return sb.toString();
    }

    private static String boxEmpty(String start, String fill, int times, String end) {
        StringBuilder result = new StringBuilder();
        result.append(start);
        for (int i = 0; i < times; i++)
            result.append(fill);
        result.append(end);
        return result.toString();
    }

    private static String xString(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}
