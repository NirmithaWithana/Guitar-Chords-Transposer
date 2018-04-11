/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitarchordtransposer;

import javax.swing.JTable;

/**
 *
 * @author Nirmitha
 */
public class Transpose {

    public static String downChrod(String getchar) {

        switch (getchar) {

            case "A":
                return "Ab";

            case "Ab":
                return "G";

            case "G#":
                return "G";

            case "G":
                return "F#";

            case "F#":
                return "F";

            case "Gb":
                return "F";

            case "F":
                return "E";

            case "E":
                return "Eb";

            case "Eb":
                return "D";

            case "D#":
                return "D";

            case "D":
                return "C#";

            case "C#":
                return "C";

            case "Db":
                return "C";

            case "C":
                return "B";

            case "B":
                return "Bb";

            case "Bb":
                return "A";

            case "A#":
                return "A";

            default:
                break;
        }
        return "";

    }

    public static String upChrod(String getchar) {

        switch (getchar) {

            case "A":
                return "Bb";

            case "Bb":
                return "B";

            case "A#":
                return "B";

            case "B":
                return "C";

            case "C":
                return "C#";

            case "C#":
                return "D";

            case "Db":
                return "D";

            case "D":
                return "Eb";

            case "Eb":
                return "E";

            case "D#":
                return "E";

            case "E":
                return "F";

            case "F":
                return "F#";

            case "F#":
                return "G";

            case "Gb":
                return "G";

            case "G":
                return "Ab";

            case "Ab":
                return "A";

            case "G#":
                return "A";

            default:
                break;
        }
        return "";
    }

    static void ChangeTableChordUp(JTable Table) {

        int rows = Table.getRowCount();  // count number of rows in JTable

        for (int column = 0; column < 4; column++) {

            for (int row = 0; row < rows; row++) {

                Object cellvalue = Table.getModel().getValueAt(row, column);

                //if cell value is empty convert it to "-"
                if (cellvalue == null || cellvalue.toString().isEmpty()) {
                    Table.setValueAt("-", row, column);
                }

                String original = Table.getModel().getValueAt(row, column).toString();

                if (original.contains("/")) {
                    // split to two keys
                    String[] allkeys = original.split("/");

                    String key1 = allkeys[0].replaceAll("[-1234579msijugad]", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    String key1arranged = upChrod(key1);  // transposed key

                    String key2 = allkeys[1].replaceAll("[-1234579msijugad]", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    String key2arranged = upChrod(key2);  // transposed key

                    String newkey1 = allkeys[0].replaceAll(key1, key1arranged);
                    String newkey2 = allkeys[1].replaceAll(key2, key2arranged);

                    Table.setValueAt(newkey1 + "/" + newkey2, row, column);

                } else {
                    String getchar = original.replaceAll("[-1234579msijugad]", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    String replaced = original.replaceAll(getchar, Transpose.upChrod(getchar));
                    Table.setValueAt(replaced, row, column);

                }
            }

        }

    }

    static void ChangeTableChordDown(JTable Table)  {

        int rows = Table.getRowCount();  // count number of rows in JTable

        for (int column = 0; column < 4; column++) {

            for (int row = 0; row < rows; row++) {

                Object cellvalue = Table.getModel().getValueAt(row, column);

                //if cell value is empty convert it to "-"
                if (cellvalue == null || cellvalue.toString().isEmpty()) {
                    Table.setValueAt("-", row, column);
                }

                String original = Table.getModel().getValueAt(row, column).toString();

                if (original.contains("/")) {
                    // split to two keys
                    String[] allkeys = original.split("/");

                    String key1 = allkeys[0].replaceAll("[-1234579msijugad]", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    String key1arranged = downChrod(key1);  // transposed key

                    String key2 = allkeys[1].replaceAll("[-1234579msijugad]", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    String key2arranged = downChrod(key2);  // transposed key

                    String newkey1 = allkeys[0].replaceAll(key1, key1arranged);
                    String newkey2 = allkeys[1].replaceAll(key2, key2arranged);

                    Table.setValueAt(newkey1 + "/" + newkey2, row, column);

                } else {
                    String getchar = original.replaceAll("[-1234579msijugad]", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    String replaced = original.replaceAll(getchar, Transpose.downChrod(getchar));
                    Table.setValueAt(replaced, row, column);
                }
            }

        }

    }

}
