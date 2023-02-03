import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import javax.swing.DefaultBoundedRangeModel;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class App {
    public static void main(String[] args) throws Exception {
        int mode = 0;
        if (args.length > 0) {
            if (args[0].equals("-m"))
                mode = 1;
            else if (args[0].equals("-s"))
                mode = 2;
        }
        ArrayList<Food> Foods = new ArrayList<Food>();
        Foods.add(new Food("Hotdog", 5000, 2));
        Foods.add(new Food("Hamburger", 15000, 3));
        Foods.add(new Food("Fried Chicken", 12000, 5));
        Foods.add(new Food("French Fries", 10000, 4));
        Foods.add(new Food("Drink", 3000, 1));
        if (mode != 0) {
            long startTime = System.currentTimeMillis();
            try {
                for (int i = 0; i < 100; i++) {
                    startOrder(mode, Foods.get(0), Foods.get(3), Foods.get(4));
                    startOrder(mode, Foods.get(1), Foods.get(3), Foods.get(4));
                    startOrder(mode, Foods.get(2), Foods.get(3), Foods.get(4));
                }
            } catch (Exception e) {
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
            return;
        }
        mode = 1;
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.print("\033[H\033[2J");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃         Cheong-sun Restaurant!        ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                       ┃");
            System.out.println("┃  Welcome tp Cheong-sun Restaurant!    ┃");
            System.out.println("┃                                       ┃");
            System.out.println("┃  Options:                             ┃");
            System.out.println("┃     1. Purchase Packages              ┃");
            System.out.println("┃     2. Purchase Item                  ┃");
            System.out.println("┃     3. Change working mode            ┃");
            System.out.println("┃     4. Exit program                   ┃");
            System.out.println("┃                                       ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            int pil = Integer.parseInt(scan.nextLine());
            int subpil;
            switch (pil) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃         Cheong-sun Restaurant!              ┃");
                    System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                    System.out.println("┃                                             ┃");
                    System.out.println("┃  Options:                                   ┃");
                    System.out.println("┃     1. Hotdog, Frech fries. drink           ┃");
                    System.out.println("┃     2. Hamburger, Frech fries. drink        ┃");
                    System.out.println("┃     3. Fried Chickern, Frech fries, drink   ┃");
                    System.out.println("┃                                             ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    subpil = Integer.parseInt(scan.nextLine());
                    if (subpil == 1 - 1)
                        startOrder(mode, Foods.get(0), Foods.get(3), Foods.get(4));
                    if (subpil == 2 - 1)
                        startOrder(mode, Foods.get(1), Foods.get(3), Foods.get(4));
                    if (subpil == 3 - 1)
                        startOrder(mode, Foods.get(2), Foods.get(3), Foods.get(4));
                    Thread.sleep(2000);
                    break;

                case 2:
                    System.out.print("\033[H\033[2J");
                    int maxLength = 0;
                    for (Food i : Foods) {
                        maxLength = Math.max(maxLength, i.getName().length());
                    }
                    maxLength += 25;
                    boxEmpty("┏", "━", maxLength, "┓");
                    boxString("┃", (maxLength - 13) / 2 + 1, "Purchase Item", (maxLength - 13) / 2, "┃");
                    boxEmpty("┣", "━", maxLength, "┨");
                    boxEmpty("┃", " ", maxLength, "┃");
                    boxString("┃", 2, "Options: ", maxLength - 11, "┃");
                    for (int i = 0; i < Foods.size(); i++) {
                        boxString("┃", 4, (i + 1) + ". " + Foods.get(i).getName(),
                                maxLength - Foods.get(i).getName().length() - 7,
                                "┃");
                    }
                    boxEmpty("┃", " ", maxLength, "┃");
                    boxEmpty("┗", "━", maxLength, "┛");
                    subpil = Integer.parseInt(scan.nextLine());
                    if (subpil > 0 && subpil <= Foods.size() + 1) {
                        System.out.print("\033[H\033[2J");
                        int foodToBuy = subpil - 1;

                        int price = Foods.get(foodToBuy).getPrice();
                        boxEmpty("┏", "━", maxLength, "┓");
                        boxString("┃", (maxLength - 17) / 2 + 1, "Purchase finished", (maxLength - 17) / 2, "┃");
                        boxEmpty("┣", "━", maxLength, "┨");
                        boxEmpty("┃", " ", maxLength, "┃");
                        boxString("┃", 4, "Buy: " + Foods.get(foodToBuy).getName(),
                                maxLength - Foods.get(foodToBuy).getName().length() - 9,
                                "┃");
                        boxString("┃", 4, "price: " + price,
                                maxLength - String.valueOf(price).length() - 11,
                                "┃");
                        boxEmpty("┃", " ", maxLength, "┃");
                        boxEmpty("┗", "━", maxLength, "┛");
                        startOrder(mode, Foods.get(foodToBuy));
                        Thread.sleep(2000);
                    }
                    break;

                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃          Change working mode          ┃");
                    System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                    System.out.println("┃                                       ┃");
                    System.out.println("┃  Options:                             ┃");
                    if (mode == 1) {
                        System.out.println("┃     1. Multi Thread (Active)          ┃");
                        System.out.println("┃     2. Single Thread                  ┃");
                    } else {
                        System.out.println("┃     1. Multi Thread                   ┃");
                        System.out.println("┃     2. Single Thread (Active)         ┃");
                    }
                    System.out.println("┃                                       ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    subpil = Integer.parseInt(scan.nextLine());
                    mode = subpil;
                    break;

                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.println("┃          Thanks for coming!!!         ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    break;

            }
        }
    }

    public static void startOrder(int mode, Food... foods) {
        if (mode == 1) {
            for (Food food : foods) {
                RobotMulti robot = new RobotMulti(food.getName(), food);
                Thread thread = new Thread(robot);
                thread.start();
            }
        } else if (mode == 2) {
            for (Food food : foods) {
                Robot robot = new Robot(food.getName(), food);
                robot.run();
            }
        }
    }

    private static String xString(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }

    private static void boxString(String start, int ps, String str, int pe, String end) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        sb.append(xString(" ", ps));
        sb.append(str);
        sb.append(xString(" ", pe));
        sb.append(end);
        System.out.println(sb);
        // return sb.toString();
    }

    private static void boxEmpty(String start, String fill, int times, String end) {
        StringBuilder result = new StringBuilder();
        result.append(start);
        for (int i = 0; i < times; i++)
            result.append(fill);
        result.append(end);
        System.out.println(result.toString());
        // return result.toString();
    }
}