package Graph;

/**
 * @author Jianshu
 * @time 20200726
 */
public class Main {
    public static void main(String[] args){
        int[] vexData=new int[]{0,1,2,3,4,5};
        /*
         *        5
         *
         * 1      2     3
         *
         *     4     0
         *
         */
        int[] arcData=new int[]{5,1,4,5,2,1,5,3,5,1,4,7,2,3,2,2,4,2,2,0,7,4,0,3};
        AMGraph amGraph=new AMGraph(6,8);
        amGraph.createUDN(vexData,arcData);

        amGraph.DFS();
        amGraph.BFS();
        amGraph.shortestPathDIJ(0,5);
        System.out.println("\n最小生成树为[Kruskal算法]");
        amGraph.miniSpanTreeKruskal();
    }
}
