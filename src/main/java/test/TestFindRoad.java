package test;


import utils.RandomNumUtil;
import biz.FindRoadCount;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by joeyy on 2017/7/6.
 */
public class TestFindRoad {

    public static void main(String[] args) {

        //testCreateArray();

        testIfTheResultIsSame();

    }


    private static void testCreateArray(){

        int[] a = RandomNumUtil.randomArrayForUniqueNum(1,20,10);

        int[] b = RandomNumUtil.getRandomArray(1,20,10);

        System.out.println("-----------random array for unique number start---------");

        for(int i : a ){

            System.out.print(i+" ");


        }
        System.out.println("");
        System.out.println("-----------random array for unique number end---------");

        System.out.println("-----------random array for not unique number start---------");

        for(int i : b ){

            System.out.print(i+" ");

        }
        System.out.println("");
        System.out.println("-----------random array for not unique number end---------");



    }

    private static void testIfTheResultIsSame(){



        //pull 10 nums from random unique number list

        int[] a = RandomNumUtil.randomArrayForUniqueNum(1,20,10);

        //int[] a = RandomNumUtil.getRandomArray(1,20,10);

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        Stack<Integer> numStack = new Stack<Integer>();


        //put all nums to a stack
        for (int i = 0; i < a.length; i++) {
            numStack.add(a[i]);
        }

        //pull 2 nums from stack to map
        while(!numStack.isEmpty()){
            map.put(numStack.pop(),numStack.pop());
        }



        FindRoadCount instance = new FindRoadCount();

        Integer count = 1;
        for(Map.Entry e:map.entrySet()){
            System.out.println("-------------------------------This is "+count +"th test, the m ="+(Integer)e.getKey() +", the n="+(Integer)e.getValue() +";---------------------");
            BigDecimal i = instance.getTotalRoad((Integer)e.getKey(),(Integer)e.getValue());
            BigDecimal j = instance.goToCount((Integer)e.getKey(),(Integer)e.getValue());
            count++;
            boolean isTheSame = (null!=i && null!=j && i.compareTo(j)==0)?true:false;

            System.out.println("The getTotalRoad result is "+ i +";");
            System.out.println("The goToCount result is "+ j +";");
            System.out.println("Is the result the same? :"+isTheSame +";");

            System.out.println("-----------------------------------------end---------------------------------------;");

        }

        map=null;
        numStack=null;
        instance=null;








    }
}
