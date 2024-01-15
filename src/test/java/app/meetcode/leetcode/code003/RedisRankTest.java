package app.meetcode.leetcode.code003;

import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RedisRankTest {

    @Resource
    private RankScore rankScore;

    @Test
    void rank() {
        List<JSONObject> needCalcObjList = new ArrayList<>();
        needCalcObjList.add(JSONObject.parse("{\"id\":10, \"score1\": 10.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":11, \"score1\": 10.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":12, \"score1\": 10.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":13, \"score1\": 11.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":14, \"score1\": 12.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":15, \"score1\": 13.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":16, \"score1\": 14.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":17, \"score1\": 14.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":18, \"score1\": 14.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":19, \"score1\": 15.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":20, \"score1\": 15.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":21, \"score1\": 16.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":22, \"score1\": 17.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":23, \"score1\": 18.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":24, \"score1\": 19.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":25, \"score1\": 20.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":26, \"score1\": 21.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":27, \"score1\": 22.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":28, \"score1\": 23.0, \"score2\": 2.0, \"score3\": 3.0}"));
        needCalcObjList.add(JSONObject.parse("{\"id\":29, \"score1\": 23.0, \"score2\": 2.0, \"score3\": 3.0}"));

        rankScore.calculateRankAvg(needCalcObjList, "score1");
        rankScore.calculateRankAvg(needCalcObjList, "score2");
        rankScore.calculateRankAvg(needCalcObjList, "score3");

    }
}