package Graph;

/**
 * @author Jianshu
 * @time 20200726
 * 图的深度优先遍历，广度优先遍历和迪杰斯特拉最短路径算法
 */
import java.util.*;

public class AMGraph {

    final int unReach=65535;
    int vexNum;//点的数量
    int arcNum;//边的数量

    int[] vex;//点的集合
    int[][] arc;

    boolean[] isVisited;//用于判断当前点是否被访问过

    List<GraphEdge> graphEdgeList;

    public AMGraph(int vexNum, int arcNum) {
        this.vexNum = vexNum;
        this.arcNum = arcNum;
    }

    /**
     *
     * @param vexData 点的数据集
     * @param arcData 边的关系和权重数据集
     */
    public void createUDN(int[] vexData,int[] arcData){

        graphEdgeList=new ArrayList<>();//初始化最小生成树需要数组

        vex=vexData;//点初始化
        arc=new int[vexNum][vexNum];
        for(int i=0;i<vexNum;i++){
            for(int j=0;j<vexNum;j++){
                arc[i][j]=unReach;
            }
        }

        int ptr=0;
        int arcA,arcB,w;
        for(int i=0;i<arcNum;i++){
            arcA=arcData[ptr];arcB=arcData[ptr+1];w=arcData[ptr+2];
            //初始化所需要的数组
            GraphEdge graphEdge=new GraphEdge(arcA,arcB,w);
            graphEdgeList.add(graphEdge);
            arc[arcA][arcB]=w;
            arc[arcB][arcA]=arc[arcA][arcB];//无向图

            ptr=ptr+3;
        }
    }

    public void DFS(){

        System.out.println("图的深度优先遍历是：");
        isVisited=new boolean[vexNum];
        for(int i=0;i<vexNum;i++){
            isVisited[i]=false;
        }

        for(int v=0;v<vexNum;v++){
            if(!isVisited[v]){
                DFS_AM(v);
            }
        }

    }

    public void DFS_AM(int v){

        System.out.println(vex[v]);
        isVisited[v]=true;
        for(int w=0;w<vexNum;w++){
            if(arc[v][w]!=unReach&&!isVisited[w]){
                DFS_AM(w);
            }
        }
    }

    public void BFS(){

        isVisited=new boolean[vexNum];
        for(int i=0;i<vexNum;i++){
            isVisited[i]=false;
        }

        System.out.println("图的广度优先遍历是：");

        ArrayDeque<Integer> deque=new ArrayDeque<>();

        for(int i=0;i<vexNum;i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                System.out.println(vex[i]);
                deque.add(i);
            }

            while(!deque.isEmpty()){
                int v=deque.remove();
                for(int w=0;w<vexNum;w++){
                    if(!isVisited[w]&&arc[v][w]!=unReach){
                        isVisited[w]=true;
                        System.out.println(vex[w]);
                        deque.add(w);
                    }
                }
            }
        }
    }

    /**
     *
     * @param start 起点，从0开始
     * @param end 终点，从0开始
     */
    public void shortestPathDIJ(int start, int end){

        boolean[] isVisited=new boolean[vexNum];//用来标记是否访问过
        int[] d=new int[vexNum];//保存最短路径长度，当前所找到的从起始点到其它每个顶点vi的长度
        int[] path=new int[vexNum];//路径信息

        for(int v=0;v<vexNum;v++){
            isVisited[v]=false;
            d[v]=arc[start][v];//记录从开始节点的连接权重
            if(d[v]<unReach)
                path[v]=start;
            else
                path[v]=-1;
        }

        isVisited[start]=true;//第一项为标记为访问过其余均未访问过
        d[start]=0;

        int v=0;
        int min;
        for(int i=0;i<vexNum;i++){
            /*
             * 选出当前V-S中与S有关联边且权值最小的顶点 书上描述为当前离V0最近的点
             */
            min=unReach;
            for(int w=0;w<vexNum;w++){
                if(!isVisited[w]&&d[w]<min){
                    v=w;
                    min=d[w];
                }
            }
            isVisited[v]=true;//将这个点标记为访问过

            /*
             * v为当前刚选入集合S中的点，以点V为中间点考察d0v+dvw是否小于D[w]如果小于则更新
             */
            for(int w=0;w<vexNum;w++){
                if(!isVisited[w]&&(d[v]+arc[v][w]<d[w])){
                    d[w]=d[v]+arc[v][w];
                    path[w]=v;
                }
            }
        }
        System.out.println("点"+start+"到"+end+"的最短距离是："+d[end]);
        printPath(path,end);
    }

    /**
     * 打印迪杰斯特拉最短路径
     * @param path
     * @param end
     */
    public void printPath(int[] path,int end){
        ArrayList<Integer> p=new ArrayList<>();
        int temp=path[end];
        while(temp!=-1){
            p.add(0,vex[temp]);
            temp=path[temp];
        }
        System.out.print("最短路径是：");
        for(Integer i:p){
            System.out.print(" --> "+i);
        }
    }

    /**
     * 最小生成树
     * 实现原理就是[并查集]
     */
    public void miniSpanTreeKruskal(){

        //初始化并查集数组，每个节点的根节点初始化为自己
        int[] vexSet=new int[vexNum];
        for(int i=0;i<vexNum;i++){
            vexSet[i]=i;
        }

        Collections.sort(graphEdgeList);
        int v1,v2;
        for(int i=0;i<arcNum;i++){
            v1=graphEdgeList.get(i).head;
            v2=graphEdgeList.get(i).tail;
            v1=vexSet[v1];
            v2=vexSet[v2];
            //如果v1和v2的根节点不同，说明没有构成环，因为如果v1 v2根节点相同，v1-->v2又是一条边，一定为环
            if(v1!=v2){
                System.out.println(graphEdgeList.get(i).head+"---"+
                        graphEdgeList.get(i).lowCost+"--->"+graphEdgeList.get(i).tail);
                for(int j=0;j<vexNum;j++){
                    if(vexSet[j]==v2){
                        vexSet[j]=v1;//将v2的根节点修改为v1的根节点
                    }
                }
            }
        }
    }
}
