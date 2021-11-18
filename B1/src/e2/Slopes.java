package e2;

public class Slopes {
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * @param slopeMap A square matrix representing the slope with spaces
     * represented as "." and trees represented as "#".
     * @param right Movement to the right
     * @param down Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because :
     * - It is not square .
     * - It has characters other than "." and "#"
     * - right >= number of columns or right < 1
     * - down >= number of rows of the matrix or down < 1
     */

    //Comprueba si una matriz es correcta
    public static void checkMatrix(  char [][] slopeMap, int right, int down ){
        for (char[] chars : slopeMap) {
            for (char aChar : chars) {
                if (slopeMap.length != chars.length)
                    throw new IllegalArgumentException("ERROR: It is not a square");

                if (aChar != '#' && aChar != '.')
                    throw new IllegalArgumentException("ERROR: It is not # or .");

                if (right >= slopeMap.length || right < 1) {
                    throw new IllegalArgumentException("ERROR: incorrect size (right)");
                }
                if (down >= chars.length || down < 1) {
                    throw new IllegalArgumentException("ERROR: incorrect size (down)");
                }
            }
        }
    }


    public static int downTheSlope ( char [][] slopeMap, int right, int down) {
        int tree=0;
        int i = 0;
        int j = 0;
        int auxRight = right;
        int auxDown = down;

        checkMatrix(slopeMap,right,down);
        //comprobacion arboles
        do {
            do {
                if (slopeMap[i][j] == '#') tree++; //comprueba si es arbol
                j++;
                if (j == slopeMap.length ) j = 0;
                //  System.out.println("posicion " + i + j);
                right--;
            } while (right > 0);
            right = auxRight;

            do {
                if (slopeMap[i][j] == '#') tree++; //compruebo si es arbol
                i++;
                //  System.out.println("posicion " + i + j);
                if (i == slopeMap.length) { // si i = al numero de columnas salir
                    return tree;
                }
                down--;
            } while (down > 0);
            down = auxDown;

        }while(true);
    }


    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     *
     * Params , return value and thrown expections as in downTheSlope ...
     */

    public static int jumpTheSlope ( char[][] slopeMap, int right, int down ){
        int tree=0;
        int i = 0;
        int j = 0;
        int auxRight = right;
        int auxDown = down;
        checkMatrix(slopeMap,right,down);
        //comprobacion arboles
        do {
            if (slopeMap[i][j] == '#') tree++; //comprueba si es arbol
            do {
                j++;
                if (j == slopeMap.length ) j = 0;
                //  System.out.println("posicion " + i + j);
                right--;
            } while (right > 0);
            right = auxRight;

            do {
                i++;
                //  System.out.println("posicion " + i + j);
                if (i == slopeMap.length) { // si i = al numero de columnas salir
                    return tree;
                }
                down--;
            } while (down > 0);
            down = auxDown;
        }while(true);
    }

}
