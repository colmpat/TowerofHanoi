public class TowerOfHanoi
{
    private String[] towers = {"|","|","|"};
    private int n, count = 0;
    public TowerOfHanoi(int nDes) //at creation of tower declares
    {
        n = nDes;
        for(int i = n; i > 0; i--) //occupies first tower ex n = 4: {"4321" , "",""}
            towers[0] += i;
        
            printBoard();
        towersOfHanoi(n, 1, 3, 2);
    }
    public void towersOfHanoi(int N, int from, int to, int spare)
    {
        if(N == 1)
            moveOneVis(from, to);
        else
        {
            towersOfHanoi(N - 1, from, spare, to);
            
            moveOneVis(from, to);
            
            towersOfHanoi(N-1, spare, to, from);
        }
        
    }
    public void moveOne(int from, int to)
    {
        System.out.println(from + "--->" + to);
    }
    public void moveOneVis(int from, int to)
    {
        towers[to - 1] += towers[from - 1].charAt(towers[from - 1 ].length() - 1);
        towers[from - 1 ] = towers[from - 1].substring(0,towers[from - 1].length() - 1);
        count++;
        printBoard();
    }
    public void printBoard()
    {
       String[] temps = new String[3];//creates local array to preserve the values of towers going into the operations
       for(int i = 0; i < 3; i++)
           temps[i] = towers[i];
           
       for(int i = 0; i < 3; i ++)
           while(temps[i].length() < n + 1)
               temps[i] += " ";
       
        System.out.println("Move " + count + ":");
        for(int i = n; i >= 0; i--)
        {
            for(String c : temps)
                System.out.print(c.charAt(i) + " ");
            System.out.println();
        }
    }
    /**
     * 1
     * 2
     * 3
     * 4
     * | | |
     * 
     * 2
     * 3
     * 4   1
     * | | |
     */
    
}
