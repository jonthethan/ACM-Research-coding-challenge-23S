import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class Main
 {
    public static void main(String[] args) throws Exception 
    {
        String fileName = "StarData.txt";
        FileInputStream inFileStream = new FileInputStream(fileName);
        Scanner fileS = new Scanner(inFileStream);
        Star[] stars = new Star[240];
        int i = 0;
        double avgTemp = 0, avgLum = 0, avgRad = 0, avgAM = 0;
        int redCount = 0, blueWhiteCount = 0, whiteCount = 0, yellowIshWhiteCount = 0, paleYellowOrangeCount = 0,
            blueCount = 0, whitishCount = 0, yellowWhiteCount = 0, orangeCount = 0, whiteYellowCount = 0,
            yellowishCount = 0, orangeRedCount = 0, mCount = 0, bCount = 0, aCount = 0, fCount = 0, oCount = 0,
            kCount = 0, gCount = 0, type0Count = 0, type1Count = 0, type2Count = 0, type3Count = 0, type4Count = 0,
            type5Count = 0;
        while(fileS.hasNext())
        {
            int t = fileS.nextInt();
            avgTemp += t;
            double l = fileS.nextDouble();
            avgLum += l;
            double r = fileS.nextDouble();
            avgRad += r;
            double aM = fileS.nextDouble();
            avgAM += aM;
            int type = fileS.nextInt();
            switch(type)
            {
                case 0:
                    type0Count++;
                    break;
                case 1:
                    type1Count++;
                    break;
                case 2:
                    type2Count++;
                    break;
                case 3:
                    type3Count++;
                    break;
                case 4:
                    type4Count++;
                    break;
                case 5:
                    type4Count++;
                    break;
            }
            String color = fileS.next();
            if(color.equals("Red"))
                redCount++;
            else if(color.equals("Blue-White"))
                blueWhiteCount++;
            else if(color.equals("White"))
                whiteCount++;
            else if(color.equals("Yellowish-White"))
                yellowIshWhiteCount++;
            else if(color.equals("Pale-yellow-orange"))
                paleYellowOrangeCount++;
            else if(color.equals("Whitish"))
                whitishCount++;
            else if(color.equals("Yellow-White"))
                yellowWhiteCount++;
            else if(color.equals("Blue"))
                blueCount++;
            else if(color.equals("Orange"))
                orangeCount++;
            else if(color.equals("Orange-Red"))
                orangeRedCount++;
            else if(color.equals("White-Yellow"))
                whiteYellowCount++;
            else
                yellowishCount++;
            String sc = fileS.next();
            if(sc.equals("M"))
                mCount++;
            else if(sc.equals("B"))
                bCount++;
            else if(sc.equals("A"))
                aCount++;
            else if(sc.equals("F"))
                fCount++;
            else if(sc.equals("O"))
                oCount++;
            else if(sc.equals("G"))
                gCount++;
            stars[i] = new Star(t, l, r, aM, type, color, sc);
        }
        
        avgTemp /= 240;
        avgLum /= 240;
        avgAM /= 240;
        avgRad /= 240;

        System.out.println("Here is some data on your 240 stars:\n ");
        System.out.printf("Average star temperature: %.2f °Kelvin\n", avgTemp);
        System.out.printf("Average star luminosity: %.2f L/Lo\n", avgLum);
        System.out.printf("Average absolute magnitude: %.2f Mv\n", avgAM);
        System.out.printf("Average radius: %.2f R/Ro\n", avgRad);
        mostCommonColor(redCount, blueWhiteCount, whiteCount, yellowIshWhiteCount, paleYellowOrangeCount, whitishCount, yellowWhiteCount, blueCount, orangeCount, orangeRedCount, whiteYellowCount, yellowishCount);
        mostCommonSpClass(mCount, bCount, aCount, fCount, oCount, gCount, kCount);
        fileS.close();
    }

    public static void mostCommonSpClass(int mCount, int bCount, int aCount, int fCount, int oCount, int gCount, int kCount)
    {
        int sp[] = new int[7];
        sp[0] = mCount;
        sp[1] = bCount;
        sp[2] = aCount;
        sp[3] = fCount;
        sp[4] = oCount;
        sp[5] = gCount;
        sp[6] = kCount;
        int max = sp[0];
        int maxIndex = 0;
        for(int i = 1; i < 7; i++)
        {
            if(sp[i] > max)
            {
                max = sp[i];
                maxIndex = i;
            }
        }

        switch(maxIndex)
        {
            case 0:
                System.out.println("Most common Spectral Class: M");
                break;
            case 1:
                System.out.println("Most common Spectral Class: B");
                break;
            case 2:
                System.out.println("Most common Spectral Class: A");
                break;
            case 3:
                System.out.println("Most common Spectral Class: F");
                break;
            case 4:
                System.out.println("Most common Spectral Class: O");
                break;
            case 5:
                System.out.println("Most common Spectral Class: G");
                break;
            default:
                System.out.println("Most common Spectral Class: K");
        }
    }

    public static void mostCommonColor(int redCount, int blueWhiteCount, int whiteCount, int yellowIshWhiteCount, int paleYellowOrangeCount, int whitishCount, int yellowWhiteCount, int blueCount, int orangeCount, int orangeRedCount,
                                       int whiteYellowCount, int yellowishCount)
    {
        int colors[] = new int[12];
        colors[0] = redCount;
        colors[1] = blueWhiteCount;
        colors[2] = whiteCount;
        colors[3] = yellowIshWhiteCount;
        colors[4] = paleYellowOrangeCount;
        colors[5] = whitishCount;
        colors[6] = yellowWhiteCount;
        colors[7] = blueCount;
        colors[8] = orangeCount;
        colors[9] = orangeRedCount;
        colors[10] = whiteYellowCount;
        colors[11] = yellowishCount;
        int max = colors[0];
        int maxIndex = 0;
        for(int i = 1; i < 12; i++)
        {
            if(colors[i] > max)
            {
                max = colors[i];
                maxIndex = i;
            }
        }

        switch(maxIndex)
        {
            case 0:
                System.out.println("Most common star color: Red");
                break;
            case 1:
                System.out.println("Most common star color: Blue-White");
                break;
            case 2:
                System.out.println("Most common star color: White");
                break;
            case 3:
                System.out.println("Most common star color: Yellowish-White");
                break;
            case 4:
                System.out.println("Most common star color: Pale-Yellow-Orange");
                break;
            case 5:
                System.out.println("Most common star color: Whitish");
                break;
            case 6:
                System.out.println("Most common star color: Yellow-White");
                break;
            case 7:
                System.out.println("Most common star color: Blue");
                break;
            case 8:
                System.out.println("Most common star color: Orange");
                break;
            case 9:
                System.out.println("Most common star color: Orange-Red");
                break;
            case 10:
                System.out.println("Most common star color: White-Yellow");
                break;
            default:
                System.out.println("Most common color: Yellowish");
        }
    }
}
