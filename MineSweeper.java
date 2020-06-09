import java.util.Random;
import java.util.Scanner;

public class MineSweeper 
{

    public static Random rd = new Random();
    public static void outputMatrix(int map[][], int[][] open) 
    {
        System.out.print("+");
        for (int i = 0; i < map[0].length; i++) 
            System.out.print("---+");
        System.out.println();
        for (int i = 0; i < map.length; i++) 
        {
            for (int j = 0; j < map[i].length; j++)
                if (open[i][j]==1) 
                    if (map[i][j]!=0)System.out.print("| "+map[i][j]+" ");
                    else System.out.print("|   ");
                else if (open[i][j]==0) System.out.print("| + ");
                else if (open[i][j]==2) System.out.print("| F ");
            System.out.println("|");
            System.out.print("+");
                for (int j = 0; j < map[0].length; j++) 
                System.out.print("---+");
            System.out.println();
        }       
    }
    public static void outputMatrix(int a[][]) 
    {
        System.out.print("+");
        for (int i = 0; i < a[0].length; i++) 
            System.out.print("---+");
        System.out.println();
        for (int i = 0; i < a.length; i++) 
        {
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j]!=9 && a[i][j] != 0) System.out.print("| "+a[i][j]+" ");
                else if (a[i][j]==0) System.out.print("|   ");
                else if (a[i][j]==9) System.out.print("| X ");
            System.out.println("|");
            System.out.print("+");
                for (int j = 0; j < a[0].length; j++) 
                System.out.print("---+");
            System.out.println();
        }       
    }
    public static void taoSoMin(int[][] map, int i, int j) 
    {
        int d = 0;
        if (i>=1 && j>=1 && i <= map.length-2 && j <= map[i].length-2)    
        {
            if (map[i-1][j-1] == 9) d++;
            if (map[i-1][j] == 9) d++;
            if (map[i-1][j+1] == 9) d++;
            if (map[i][j-1] == 9) d++;
            if (map[i][j+1] == 9) d++;
            if (map[i+1][j-1] == 9) d++;
            if (map[i+1][j] == 9) d++;
            if (map[i+1][j+1] == 9) d++;
        }
        else if (i==0 && j>=1 && j <= map[i].length-2)
        {
            if (map[i][j-1] == 9) d++;
            if (map[i][j+1] == 9) d++;
            if (map[i+1][j-1] == 9) d++;
            if (map[i+1][j] == 9) d++;
            if (map[i+1][j+1] == 9) d++;
        }
        else if (i==map.length-1 && j>=1 && j <= map[i].length-2)
        {
            if (map[i-1][j-1] == 9) d++;
            if (map[i-1][j] == 9) d++;
            if (map[i-1][j+1] == 9) d++;
            if (map[i][j-1] == 9) d++;
            if (map[i][j+1] == 9) d++;
        }
        else if (i>=1 && j==0 && i <= map.length-2)
        {
            if (map[i-1][j] == 9) d++;
            if (map[i-1][j+1] == 9) d++;
            if (map[i][j+1] == 9) d++;
            if (map[i+1][j] == 9) d++;
            if (map[i+1][j+1] == 9) d++;
        }
        else if (i>=1 && i <= map.length-2 && j == map[i].length-1)
        {
            if (map[i-1][j-1] == 9) d++;
            if (map[i-1][j] == 9) d++;
            if (map[i][j-1] == 9) d++;
            if (map[i+1][j-1] == 9) d++;
            if (map[i+1][j] == 9) d++;
        }
        else if (i==0 && j==0)
        {
            if (map[i][j+1] == 9) d++;
            if (map[i+1][j] == 9) d++;
            if (map[i+1][j+1] == 9) d++;
        }
        else if (i==map.length-1 && j==map[i].length-1)
        {
            if (map[i-1][j-1] == 9) d++;
            if (map[i-1][j] == 9) d++;
            if (map[i][j-1] == 9) d++;
        }
        else if (i==0 && j==map[i].length-1)
        {
            if (map[i][j-1] == 9) d++;
            if (map[i+1][j] == 9) d++;
            if (map[i+1][j-1] == 9) d++;
        }
        else if (i==map.length-1 && j==0)
        {
            if (map[i][j+1] == 9) d++;
            if (map[i-1][j] == 9) d++;
            if (map[i-1][j+1] == 9) d++;
        }
        map[i][j] = d;
    }

    public static Scanner sc = new Scanner(System.in); 
    public static int soMin(int[][] map) 
    {
        int somin =0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j]==9) somin++;
            }
        }    
        return somin;
    }
    public static void main(String[] args) 
    {
        System.out.println("Nhap <=1 la OutOfBoundException");
        System.out.print("hang (>1): ");
        int m=sc.nextInt();
        System.out.print("cot (>1): ");
        int n=sc.nextInt();
        int[][] open = new int[m][n];           // tạo mảng mở
        for (int e = 0; e < open.length; e++) 
            for (int op = 0; op < open[e].length; op++) 
                open[e][op]=0;
        
        int[][] map = new int[m][n];                    // tạo map
        for (int i = 0; i < map.length; i++) 
            for (int j = 0; j < map[i].length; j++) 
                map[i][j] = rd.nextInt(7)+3;
            
        for (int i = 0; i < map.length; i++)            // tạo map chỉnh
            for (int j = 0; j < map[i].length; j++) 
                if (map[i][j]!=9) taoSoMin(map, i, j);
            
        int soO = m*n - soMin(map);
        int index = 0;     
        outputMatrix(map, open);                 
        while (index <  soO)
        {
            System.out.println("F: flag || O: open || GG!");
            System.out.println("Error roi, nen auto la mo :D khong flag voi GG đuoc :v");
            String temp = "O";      //temp=sc.nextLine();
            switch (temp.charAt(0)) 
            {
                case 'F':
                    System.out.print("hang: ");
                    int h = sc.nextInt();
                    System.out.print("cot: ");
                    int c = sc.nextInt();
                    open[h][c]=2;       //flag
                    outputMatrix(map, open);
                    break;
                case 'O':
                    System.out.print("hang: ");
                    int z = sc.nextInt();
                    System.out.print("cot: ");
                    int x = sc.nextInt();
                    if (map[z][x]!=9) 
                    {
                        if (open[z][x]==0)
                        {
                            open[z][x]=1;
                            index++;
                        }
                        outputMatrix(map, open);
                        break;
                    }
                    else {
                        System.out.println("Loserrrrrrrrrrrrrrrrr!!!");
                        outputMatrix(map);
                        return;
                    }
                case 'G':
                    System.out.println("Loserrrrrrrrrrrrrrrrr!!!");
                    outputMatrix(map);
                    break;
            }
        }
        System.out.println("Winner Winner Chicken Dinner!!!!!!!!!");
        outputMatrix(map);
    }
}