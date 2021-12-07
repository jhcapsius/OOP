/**
 *Implementation of a class that reads a PGM file and stores the associated values in the class attributes. Furthermore, the image can be rotated by 90° and saved in a new file.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Bild {
    private String format;
    private double width;
    private double heigth;
    private double brightness;
    private boolean read;
    private int[][] daten;
    private int[][] rotatedImage;

    /**
     * Reads the data of a pgm file and assigns them to attributes
     * @param dateiName path of the data 
     */

    public void leseBild(String dateiName){
        try{
            Path path = Paths.get(dateiName);
            //Saves the values for format, width, height and brightness by iterating over the first 3 lines.
            for(int i = 0; i < 3; i++){
                switch(i){
                    case 0:
                        this.format = Files.readAllLines(path).get(i);
                        break;
                    case 1:
                        String[] buffer = Files.readAllLines(path).get(i).split(" ");
                        this.width = Double.parseDouble(buffer[0]);
                        this.heigth = Double.parseDouble(buffer[1]);
                        break;
                    case 2:
                        this.brightness = Double.parseDouble(Files.readAllLines(path).get(i));
                }
            }

            //saves the values of the image in a 2-d array 
            this.daten = new int[(int) this.heigth][(int) this.width];
            for(int i =  0; i < this.daten.length; i++){
                String[] buffer = Files.readAllLines(path).get(i+3).replaceAll("[^a-zA-Z0-9]+", " ").split(" ");
                for(int k = 0; k < this.daten[0].length; k++){
                    this.daten[i][k] = Integer.parseInt(buffer[k]);
                }
            }
            this.read = true;
        }

        //throws exception when the data is not found
        catch(IOException e){
            System.out.println("Data not found");
            this.read = false;
        }
    }

    /**
     * prints the values of the pgm file when a pgm file has been read in.
     */    
    public void print(){
        if(this.read){
            System.out.print("Format: " + this.format + "\nWidth: " + this.width +"\nHeight: " + this.heigth + "\nBrightness: " + this.brightness + "\n");
            for(int i = 0; i < this.daten.length;  i++){
                for(int k = 0; k < this.daten[0].length; k++){
                    if(this.daten[i][k] <= 9){
                        System.out.print(" " + daten[i][k] + " ");
                    }else{
                        System.out.print(daten[i][k] + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            
        }else{
            System.out.println("please read data first\n");
        }
    }

    /**
     * rotates the image 90°
     */
    public void rotiereBild(){
        int h = 0;
        int j = this.daten[0].length-1;
        this.rotatedImage = new int[this.daten[0].length][this.daten.length];
        for(int i = 0; i < this.rotatedImage.length; i++){
            for(int k = 0; k < this.rotatedImage[0].length; k++){
                this.rotatedImage[i][k] = this.daten[h][j];
                h++;
            }
            j--;
            h = 0;
        }
    }

    /**
     * creates a new pgm file with the values of the rotated image
     * @param dateiName name of the new file
     */

    public void schreibeBild(String dateiName){
        Path path = Paths.get(".", dateiName);
        try{
            //adds the format, hwidth, heigth and brightness to the string builder
            StringBuilder builder = new StringBuilder();
            builder.append(this.format+"\n");
            builder.append(this.rotatedImage[0].length + " " + this.rotatedImage.length + "\n");
            builder.append((int)this.brightness + "\n");
            
            //adds the data of the image to the string builder
            for(int i = 0; i < this.rotatedImage.length; i++){
                for(int k = 0; k < this.rotatedImage[0].length; k++){
                    if(k == 0 ){
                        builder.append(this.rotatedImage[i][k]);
                    }else if(this.rotatedImage[i][k] <= 9){
                        builder.append("  " + this.rotatedImage[i][k]);
                    }else{
                        builder.append(" " + this.rotatedImage[i][k]);
                    }
                }
                builder.append("\n");
            }

            //creates a new file at the given location
            Files.writeString(path, builder.toString());
        
        //throws exception if the file could not be created
        }catch(IOException e){
            System.out.println("File could not be created");
        }
    }
}
