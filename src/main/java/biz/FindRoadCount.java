package biz;

import java.math.BigDecimal;

/**
 * Created by joeyy on 2017/5/25.
 */

public class FindRoadCount {



    /**
     * @param m 方格横坐标最大值
     * @param n 方格纵坐标最大值
     * @return 总共的路径数
     */
    public BigDecimal getTotalRoad(Integer m, Integer n){

        BigDecimal m1 = new BigDecimal(m);
        BigDecimal n1 = new BigDecimal(n);

        BigDecimal totalSteps = m1.add(n1).subtract(new BigDecimal(2));

        BigDecimal pickedSteps1 = m1.subtract(new BigDecimal(1));

        BigDecimal pickedSteps2 = n1.subtract(new BigDecimal(1));

        BigDecimal totalRoad = getCombineCount(totalSteps,pickedSteps1);

        BigDecimal totalRoad1 = getCombineCount(totalSteps,pickedSteps2);


        if(totalRoad.compareTo(totalRoad1)==0){
            return totalRoad;

        }else{
            System.out.println("---------------------getCombineCount method is not correct!!!------------------");
        }

        return BigDecimal.ZERO;

    }


    /**
     *
     * @param m 方格横坐标最大值
     * @param n 方格纵坐标最大值
     * @return 总共路径数
     */
    public BigDecimal goToCountForBigDecimal(BigDecimal m, BigDecimal n) {

        //若终点即起点，则无路可走
        if (m.compareTo(new BigDecimal(1))==0 && n.compareTo(new BigDecimal(1)) == 0) {
            return BigDecimal.ZERO;
        }
        //若走到上边界或右边界,有且只有一种走法
        if (m.compareTo(new BigDecimal(1))==0 || n.compareTo(new BigDecimal(1)) == 0) {
            return new BigDecimal(1);
        }
        return goToCountForBigDecimal(m, n.subtract(new BigDecimal(1))) .add(goToCountForBigDecimal(m.subtract(new BigDecimal(1)), n));
    }


    /**
     *
     * @param m 方格横坐标最大值
     * @param n 方格纵坐标最大值
     * @return 总共路径数
     */
    public BigDecimal goToCount(Integer m, Integer n) {

        BigDecimal m1 = new BigDecimal(m);
        BigDecimal n1 = new BigDecimal(n);

        return goToCountForBigDecimal(m1,n1);


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

    public static BigDecimal factorial(BigDecimal n){
        BigDecimal bd1 = new BigDecimal(1);//1
        if(n.equals(new BigDecimal(1))||n.compareTo(BigDecimal.ZERO)==0){
            return bd1;
        }
        else
            return n.multiply(factorial(n.subtract(bd1)));//n*f(n-1)
    }

    /**
     * 求组合数
     * @param totalCount 待选数目
     * @param pickCount 需选数目
     * @return 组合数
     */
    private static BigDecimal getCombineCount(BigDecimal totalCount , BigDecimal pickCount){

        BigDecimal totalRoad;


        System.out.println("totalCount :"+totalCount +" pickCount :"+pickCount + " from getCombineCount" );

        /*if(totalCount>12){
            System.out.println("totalCount is "+totalCount +" >12 , so this case is not reliable" );

        }
        if(pickCount >12){
            System.out.println("pickCount is "+pickCount +" >12 , so this case is not reliable" );

        }*/

        totalRoad= (totalCount.compareTo(pickCount)!=-1 ) ? factorial(totalCount).divide( factorial(totalCount.subtract(pickCount)) ).divide( factorial(pickCount)) : BigDecimal.ZERO;

        System.out.println("totalRoad:" + totalRoad + " from getCombineCount");



        return totalRoad;



    }




}
