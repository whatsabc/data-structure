package Graph;

/**
 * @author Jianshu
 * @time 20200726
 */
public class Main {
    public static void main(String[] args){
        int[] vexData=new int[]{0,1,2,3,4,5};
        int[] arcData=new int[]{0,1,4,0,2,1,0,3,5,1,4,7,2,3,2,2,4,2,2,5,7,4,5,3};
        AMGraph amGraph=new AMGraph(6,8);
        amGraph.createUDN(vexData,arcData);

        amGraph.DFS();
        amGraph.BFS();
        amGraph.ShortestPath_DIJ(0,5);
    }
}
