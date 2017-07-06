package biz;

/**
 * Created by joeyy on 2017/5/25.
 */

public class FindRoadCount {



    /**
     * @param m 方格横坐标最大值
     * @param n 方格纵坐标最大值
     * @return 总共的路径数
     */
    public Integer getTotalRoad(Integer m,Integer n){

        Integer totalSteps = m+n-2;
        Integer pickedSteps1 = m-1;
        Integer pickedSteps2 = n-1;

        Integer totalRoad = getCombineCount(totalSteps,pickedSteps1);

        Integer totalRoad1 = getCombineCount(totalSteps,pickedSteps2);


        if(totalRoad.equals(totalRoad1)){
            return totalRoad;

        }else{
            System.out.println("---------------------getCombineCount method is not correct!!!------------------");
        }

        return 0;

    }


    /**
     *
     * @param m 方格横坐标最大值
     * @param n 方格纵坐标最大值
     * @return 总共路径数
     */
    public Integer goToCount(Integer m, Integer n) {

        //若终点即起点，则无路可走
        if (m==1 & n == 1) {
            return 0;
        }
        //若走到上边界或右边界,有且只有一种走法
        if (m==1 || n==1) {
            return 1;
        }
        return goToCount(m, n - 1) + goToCount(m - 1, n);
    }


    /**
     * 阶乘
     * @param n
     * @return
     */
    private static int getFactorialSum(Integer n){
        if(n==1||n==0){
            return 1;
        }else{
            return getFactorialSum(n-1)*n;
        }
    }

    /**
     * 求组合数
     * @param totalCount 待选数目
     * @param pickCount 需选数目
     * @return 组合数
     */
    private static Integer getCombineCount(Integer totalCount , Integer pickCount){

        Integer totalRoad;


        System.out.println("totalCount :"+totalCount +" pickCount :"+pickCount);
        if(totalCount>12){
            System.out.println("totalCount is "+totalCount +" >12 , so this case is not reliable" );

        }
        if(pickCount >12){
            System.out.println("pickCount is "+pickCount +" >12 , so this case is not reliable" );

        }

        totalRoad= (totalCount >= pickCount) ? getFactorialSum(totalCount) / getFactorialSum(totalCount - pickCount) / getFactorialSum(pickCount) : 0;

        System.out.println("totalRoad:" + totalRoad);



        return totalRoad;



    }




}
