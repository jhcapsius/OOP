/**
 * Testclass for EnlargeImage
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class EnlargeImageTest {
    public static void main(String[] args) {
        EnlargeImage enlargeImage = new EnlargeImage();
        int[][] test1 = {{1,0,1},{1,0}};
        int[][] test2 = {{1,0},{1,0,1}};
        int[][] test3 = {{1,0},{1,0,0},{1,0,1}};
        int[][] test4 = {{1,0,1},{1,0},{1,0,1}};
        int[][] test5 = {{1,0,1},{1,0,0},{1,0}};
        int[][] test6 = {{1,0,1},{1,0,1},{1,0,1}};
        int[][] test7 = {{0,0,1},{0,1,0},{1,0,0}};

        enlargeImage.print(enlargeImage.zoom(test1, 2));
        enlargeImage.print(enlargeImage.zoom(test2, 2));
        enlargeImage.print(enlargeImage.zoom(test3, 2));
        enlargeImage.print(enlargeImage.zoom(test4, 2));
        enlargeImage.print(enlargeImage.zoom(test5, 2));
        enlargeImage.print(enlargeImage.zoom(test6, 1));
        enlargeImage.print(enlargeImage.zoom(test6, 2));
        enlargeImage.print(enlargeImage.zoom(test6, 3));
        enlargeImage.print(enlargeImage.zoom(test7, 2));
        enlargeImage.print(enlargeImage.zoom(test7, 3));
    }
}
