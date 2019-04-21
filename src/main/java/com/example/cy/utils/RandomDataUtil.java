package com.example.cy.utils;



import org.apache.commons.lang.math.RandomUtils;




import java.util.*;

/**
 * 生成随机集合工具类
 *
 */
public class RandomDataUtil {
    public final static int TWO=2;
    /**
     * 生成随机集合（不重复）
     * <p>
     *     使用Set的值唯一的特性。
     *     最佳适用场合：集合中数目多，取相对较少对象时。在取对象相对较多时（超过集合的一半时）采用逆向方法，
     *                在取得对象个数是集合总数的1/2左右时是效率最慢的。
     * </p>
     * @param list
     * @param generateNum 生成集合中元素的个数
     * @param <T>
     * @return
     */
    public <T> List<T> generateRandomDataNoRepeat(List<T> list,Integer generateNum){
        List<T> tList = new ArrayList<T>();
        if(list.size()>0&&list!=null) {
            for (Integer num : generateRandomNoRepeat(list.size(), generateNum)) {
                tList.add(list.get(num));
            }
        }
        return tList;
    }

    /**
     * 生成随机集合，随机置换位置、随机截取位置法。
     * <p>
     *     随机置换法：将集合的每个位置值与随机位置的值调换，并随机截取位置.
     *     最佳适合场合：集合的数量相对较少，获取较多的随机个数集合。
     * </p>
     * @param list
     * @param generateNum
     * @param <T>
     * @return
     */
    public <T> List<T> generateRandomPermutation(List<T> list,Integer generateNum){
        if(list.size()>0&&list!=null) {
            checkParams(list.size(),generateNum);
            List<T> randomAllList = randomPermutation(list, generateNum);
            int initPosition=interceptPosition(list.size(),generateNum);
            return randomAllList.subList(initPosition,initPosition+generateNum);
        }
        return Collections.emptyList();
    }

    /**
     * 随机置换算法
     * @param list
     * @param generateNum
     * @param <T>
     * @return
     */
    private <T> List<T> randomPermutation(List<T> list,Integer generateNum){
        for (int i = 0; i < list.size(); i++) {
            Integer random=RandomUtils.nextInt(list.size());
            T t = list.get(random);
            list.set(random,list.get(i));
            list.set(i,t);
        }
        return list;
    }

    /**
     * 随机生成截取位置
     * @param totalCount
     * @param generateNum
     * @return
     */
    private Integer interceptPosition(Integer totalCount,Integer generateNum){
        int num=RandomUtils.nextInt(totalCount);
        if(num+generateNum>totalCount){
            num=num-generateNum;
        }
        return  num;
    }
    /**
     * 生成不重复的随机数
     * @param totalCount
     * @param generateNum
     * @param
     * @return
     */
    public Set<Integer> generateRandomNoRepeat(Integer totalCount,Integer generateNum){
        if(isLessThanHalfTotalCount(totalCount,generateNum)){
            return getRandomNoRepeat(totalCount,generateNum);
        }
        return getReverseRandomNoRepeat(totalCount,generateNum);
    }

    /**
     * 验证参数是否合法
     * @param totalCount
     * @param generateNum
     */
    private void checkParams(Integer totalCount,Integer generateNum){
        if(totalCount<generateNum){
            throw new IllegalArgumentException("generateNum is out of totalCount");
        }
    }

    /**
     * 判断使用哪种生成机制
     * @param totalCount
     * @param generateNum
     * @return
     */
    private Boolean isLessThanHalfTotalCount(Integer totalCount,Integer generateNum){
        if(generateNum<totalCount/TWO){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 生成set，不重复
     * @param totalCount
     * @param generateNum
     * @return
     */
    private Set<Integer> getRandomNoRepeat(Integer totalCount,Integer generateNum){
        Set<Integer> set = new HashSet<Integer>();
        while (true) {
            set.add(RandomUtils.nextInt(totalCount));
            if(set.size() == generateNum){
                return set;
            }
        }
    }

    /**
     * 逆向生成set，不重复
     * @param totalCount
     * @param generateNum
     * @return
     */
    private Set<Integer> getReverseRandomNoRepeat(Integer totalCount,Integer generateNum){
        Set<Integer> set = new HashSet<Integer>();
        while (true) {
            set.add(RandomUtils.nextInt(totalCount));
            if(set.size() == totalCount-generateNum){
                Set<Integer> setALL=getSetALL(totalCount);
                setALL.removeAll(set);
                return setALL;
            }
        }
    }

    /**
     * 生成Set
     * @param totalCount
     * @return
     */
    private Set<Integer> getSetALL(Integer totalCount){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<totalCount;i++){
            set.add(i);
        }
        return set;
    }

}