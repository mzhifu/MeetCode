package app.meetcode.leetcode.code003;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RankScore {

    public static final String RANK_SCORE = "rank_score";

    public void calculateRankAvg(List<JSONObject> needCalcObjs, String scoreType) {

        List<JSONObject> order = needCalcObjs.stream().sorted(Comparator.comparingDouble(c -> JSONObject.parse(JSONObject.toJSONString(c)).getDouble(scoreType)).reversed())
                .toList();

        //1. 先进行rank.eq

        double rankEqPreItem = Double.POSITIVE_INFINITY;
        Map<Double, Integer> rankEqSeem = new HashMap<>();
        for (int rankIndex = 0; rankIndex < order.size(); rankIndex++) {
            JSONObject rankEqItem = order.get(rankIndex);
            double sourceValue = rankEqItem.getDouble(scoreType);
            if (rankEqPreItem != sourceValue) {
                //不相等，则rankEq=当前数组大小-当前数组下标
                rankEqItem.put(scoreType + "RankEq", order.size() - rankIndex);
                rankEqSeem.put(sourceValue, order.size() - rankIndex);
                rankEqPreItem = sourceValue;
                continue;
            }
            //相等
            if (Objects.nonNull(rankEqSeem.get(sourceValue))) {
                rankEqItem.put(scoreType + "RankEq", rankEqSeem.get(sourceValue));
            }
        }


        for (JSONObject jsonObject : order) {
//            System.out.println(scoreType + ":" + jsonObject.getDouble(scoreType) + ", \t rankEq: " +  jsonObject.getIntValue(scoreType + "RankEq"));
        }


        //2. 进行rank.avg
        double rankAvgPreItem = Double.POSITIVE_INFINITY;
        int rankAvgCount = 0;
        for (int avgIndex = 0; avgIndex < order.size(); avgIndex++) {
            JSONObject rankAvgItem = order.get(avgIndex);
            double rankEqValue = rankAvgItem.getDouble(scoreType + "RankEq");

            if (rankEqValue == rankAvgPreItem) {
                rankAvgCount++;
            } else {
                rankAvgPreItem = rankEqValue;
                rankAvgCount = 0;
            }

            double rankAvg = 0.5 * rankAvgCount + rankAvgPreItem;
            rankAvgItem.put(scoreType + "RankAvg", rankAvg);
            System.out.println(scoreType + ":" + rankAvgItem.getDouble(scoreType) + ", \t rankEq: " +  rankAvgItem.getIntValue(scoreType + "RankEq") + ", \t rankAvg: " + rankAvgItem.getDouble(scoreType + "RankAvg"));
        }


    }
}