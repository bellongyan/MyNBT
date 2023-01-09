package com.example.mynbt.tools;

public class Female12 {

    private int height_value;   // 身高
    private double weight_value;   // 体重
    private int vital_capacity_value;   // 肺活量
    private double fifty_race_value;  // 50 米跑
    private double sit_and_reach_value;   // 坐位体前屈
    private int jump_value;   // 立定跳远
    private int pull_up_value;   // 引体向上
    private int one_thousand_value;   // 1000 米跑
    private double BMI_score;   // BMI 成绩
    private double vital_capacity_score;   // 肺活量成绩
    private double fifty_race_score;   // 50 米跑成绩
    private double sit_and_reach_score;   // 坐位体前屈成绩
    private double jump_score;   // 立定跳远成绩
    private double pull_up_score;   // 引体向上成绩
    private double one_thousand_score;   // 1000 米跑成绩
    private double physique_score;   // 体测成绩

    public Female12(int height_value, double weight_value, int vital_capacity_value, double fifty_race_value, double sit_and_reach_value, int jump_value, int pull_up_value, int one_thousand_value) {
        this.height_value = height_value;
        this.weight_value = weight_value;
        this.vital_capacity_value = vital_capacity_value;
        this.fifty_race_value = fifty_race_value;
        this.sit_and_reach_value = sit_and_reach_value;
        this.jump_value = jump_value;
        this.pull_up_value = pull_up_value;
        this.one_thousand_value = one_thousand_value;
    }

    public int getHeight_value() {
        return height_value;
    }

    public void setHeight_value(int height_value) {
        this.height_value = height_value;
    }

    public double getWeight_value() {
        return weight_value;
    }

    public void setWeight_value(double weight_value) {
        this.weight_value = weight_value;
    }

    public int getVital_capacity_value() {
        return vital_capacity_value;
    }

    public void setVital_capacity_value(int vital_capacity_value) {
        this.vital_capacity_value = vital_capacity_value;
    }

    public double getFifty_race_value() {
        return fifty_race_value;
    }

    public void setFifty_race_value(double fifty_race_value) {
        this.fifty_race_value = fifty_race_value;
    }

    public double getSit_and_reach_value() {
        return sit_and_reach_value;
    }

    public void setSit_and_reach_value(double sit_and_reach_value) {
        this.sit_and_reach_value = sit_and_reach_value;
    }

    public int getJump_value() {
        return jump_value;
    }

    public void setJump_value(int jump_value) {
        this.jump_value = jump_value;
    }

    public int getPull_up_value() {
        return pull_up_value;
    }

    public void setPull_up_value(int pull_up_value) {
        this.pull_up_value = pull_up_value;
    }

    public int getOne_thousand_value() {
        return one_thousand_value;
    }

    public void setOne_thousand_value(int one_thousand_value) {
        this.one_thousand_value = one_thousand_value;
    }

    public double getBMI_score() {
        return BMI_score;
    }

    public void setBMI_score(double BMI_score) {
        this.BMI_score = BMI_score;
    }

    public double getVital_capacity_score() {
        return vital_capacity_score;
    }

    public void setVital_capacity_score(double vital_capacity_score) {
        this.vital_capacity_score = vital_capacity_score;
    }

    public double getFifty_race_score() {
        return fifty_race_score;
    }

    public void setFifty_race_score(double fifty_race_score) {
        this.fifty_race_score = fifty_race_score;
    }

    public double getSit_and_reach_score() {
        return sit_and_reach_score;
    }

    public void setSit_and_reach_score(double sit_and_reach_score) {
        this.sit_and_reach_score = sit_and_reach_score;
    }

    public double getJump_score() {
        return jump_score;
    }

    public void setJump_score(double jump_score) {
        this.jump_score = jump_score;
    }

    public double getPull_up_score() {
        return pull_up_score;
    }

    public void setPull_up_score(double pull_up_score) {
        this.pull_up_score = pull_up_score;
    }

    public double getOne_thousand_score() {
        return one_thousand_score;
    }

    public void setOne_thousand_score(double one_thousand_score) {
        this.one_thousand_score = one_thousand_score;
    }

    public double getPhysique_score() {
        return physique_score;
    }

    public void setPhysique_score(double physique_score) {
        this.physique_score = physique_score;
    }

    //    ==================================
//    计算 BMI 分数
    public void calcBMI() {
        double BMI = getWeight_value() / (getHeight_value() * getHeight_value() / 10000.0);
        double BMI_score = 0.0;
        if (BMI > 28) {                                             // BMI 大于 28 为 60 分
            BMI_score = 60.0;
        } else if ((BMI > 24.0 && BMI <= 27.9) || BMI <= 17.1) {
            BMI_score = 80.0;                                       // BMI 在大于 24.0 小于等于 27.9 或者 BMI 小于等于 17.8 为 80 分
        } else if (BMI >= 17.2 && BMI <= 23.9) {
            BMI_score = 100.0;                                      // BMI 在大于等于 17.9 小于等于 23.9 时，为 100 分
        }
        setBMI_score(BMI_score);
    }

    //    计算肺活量的分数
    public void calcVitalCapacityScore() {
        double vitalCapacityScore = 0.0;
        if (getVital_capacity_value() < 1800) {
            vitalCapacityScore = 0.0;
        } else if (getVital_capacity_value() < 1840) {
            vitalCapacityScore = 10.0;
        } else if (getVital_capacity_value() < 1880) {
            vitalCapacityScore = 20.0;
        } else if (getVital_capacity_value() < 1920) {
            vitalCapacityScore = 30.0;
        } else if (getVital_capacity_value() < 1960) {
            vitalCapacityScore = 40.0;
        } else if (getVital_capacity_value() < 2000) {
            vitalCapacityScore = 50.0;
        } else if (getVital_capacity_value() < 2100) {
            vitalCapacityScore = 60.0;
        } else if (getVital_capacity_value() < 2200) {
            vitalCapacityScore = 62.0;
        } else if (getVital_capacity_value() < 2300) {
            vitalCapacityScore = 64.0;
        } else if (getVital_capacity_value() < 2400) {
            vitalCapacityScore = 66.0;
        } else if (getVital_capacity_value() < 2500) {
            vitalCapacityScore = 68.0;
        } else if (getVital_capacity_value() < 2600) {
            vitalCapacityScore = 70.0;
        } else if (getVital_capacity_value() < 2700) {
            vitalCapacityScore = 72.0;
        } else if (getVital_capacity_value() < 2800) {
            vitalCapacityScore = 74.0;
        } else if (getVital_capacity_value() < 2900) {
            vitalCapacityScore = 76.0;
        } else if (getVital_capacity_value() < 3000) {
            vitalCapacityScore = 78.0;
        } else if (getVital_capacity_value() < 3150) {
            vitalCapacityScore = 80.0;
        } else if (getVital_capacity_value() < 3300) {
            vitalCapacityScore = 85.0;
        } else if (getVital_capacity_value() < 3350) {
            vitalCapacityScore = 90.0;
        } else if (getVital_capacity_value() < 3400) {
            vitalCapacityScore = 95.0;
        } else {
            vitalCapacityScore = 100.0;
        }
        setVital_capacity_score(vitalCapacityScore);
    }

    //    计算 50 米跑的成绩
    public void calcFiftyRaceScore() {
        double fiftyRaceScore;
        if (getFifty_race_value() > 11.3) {
            fiftyRaceScore = 0.0;
        } else if (getFifty_race_value() > 11.1) {
            fiftyRaceScore = 10.0;
        } else if (getFifty_race_value() > 10.9) {
            fiftyRaceScore = 20.0;
        } else if (getFifty_race_value() > 10.7) {
            fiftyRaceScore = 30.0;
        } else if (getFifty_race_value() > 10.5) {
            fiftyRaceScore = 40.0;
        } else if (getFifty_race_value() > 10.3) {
            fiftyRaceScore = 50.0;
        } else if (getFifty_race_value() > 10.1) {
            fiftyRaceScore = 60.0;
        } else if (getFifty_race_value() > 9.9) {
            fiftyRaceScore = 62.0;
        } else if (getFifty_race_value() > 9.7) {
            fiftyRaceScore = 64.0;
        } else if (getFifty_race_value() > 9.5) {
            fiftyRaceScore = 66.0;
        } else if (getFifty_race_value() > 9.3) {
            fiftyRaceScore = 68.0;
        } else if (getFifty_race_value() > 9.1) {
            fiftyRaceScore = 70.0;
        } else if (getFifty_race_value() > 8.9) {
            fiftyRaceScore = 72.0;
        } else if (getFifty_race_value() > 8.7) {
            fiftyRaceScore = 74.0;
        } else if (getFifty_race_value() > 8.5) {
            fiftyRaceScore = 76.0;
        } else if (getFifty_race_value() > 8.3) {
            fiftyRaceScore = 78.0;
        } else if (getFifty_race_value() > 8.0) {
            fiftyRaceScore = 80.0;
        } else if (getFifty_race_value() > 7.7) {
            fiftyRaceScore = 85.0;
        } else if (getFifty_race_value() > 7.6) {
            fiftyRaceScore = 90.0;
        } else if (getFifty_race_value() > 7.5) {
            fiftyRaceScore = 95.0;
        } else {
            fiftyRaceScore = 100.0;
        }
        setFifty_race_score(fiftyRaceScore);
    }

    //    计算坐位体前屈的成绩
    public void calcSitReachScore() {
        double sitReachScore;
        if (getSit_and_reach_value() < 2.0) {
            sitReachScore = 0.0;
        } else if (getSit_and_reach_value() < 2.8) {
            sitReachScore = 10.0;
        } else if (getSit_and_reach_value() < 3.6) {
            sitReachScore = 20.0;
        } else if (getSit_and_reach_value() < 4.4) {
            sitReachScore = 30.0;
        } else if (getSit_and_reach_value() < 5.2) {
            sitReachScore = 40.0;
        } else if (getSit_and_reach_value() < 6.0) {
            sitReachScore = 50.0;
        } else if (getSit_and_reach_value() < 7.3) {
            sitReachScore = 60.0;
        } else if (getSit_and_reach_value() < 8.6) {
            sitReachScore = 62.0;
        } else if (getSit_and_reach_value() < 9.9) {
            sitReachScore = 64.0;
        } else if (getSit_and_reach_value() < 11.2) {
            sitReachScore = 66.0;
        } else if (getSit_and_reach_value() < 12.5) {
            sitReachScore = 68.0;
        } else if (getSit_and_reach_value() < 13.8) {
            sitReachScore = 70.0;
        } else if (getSit_and_reach_value() < 15.1) {
            sitReachScore = 72.0;
        } else if (getSit_and_reach_value() < 16.4) {
            sitReachScore = 74.0;
        } else if (getSit_and_reach_value() < 17.7) {
            sitReachScore = 76.0;
        } else if (getSit_and_reach_value() < 19.0) {
            sitReachScore = 78.0;
        } else if (getSit_and_reach_value() < 20.6) {
            sitReachScore = 80.0;
        } else if (getSit_and_reach_value() < 22.2) {
            sitReachScore = 85.0;
        } else if (getSit_and_reach_value() < 24.0) {
            sitReachScore = 90.0;
        } else if (getSit_and_reach_value() < 25.8) {
            sitReachScore = 95.0;
        } else {
            sitReachScore = 100.0;
        }
        setSit_and_reach_score(sitReachScore);
    }

    //    计算立定跳远的成绩
    public void calcJumpScore() {
        double jumpScore;
        if (getJump_value() < 126) {
            jumpScore = 0.0;
        } else if (getJump_value() < 131) {
            jumpScore = 10.0;
        } else if (getJump_value() < 136) {
            jumpScore = 20.0;
        } else if (getJump_value() < 141) {
            jumpScore = 30.0;
        } else if (getJump_value() < 146) {
            jumpScore = 40.0;
        } else if (getJump_value() < 151) {
            jumpScore = 50.0;
        } else if (getJump_value() < 154) {
            jumpScore = 60.0;
        } else if (getJump_value() < 157) {
            jumpScore = 62.0;
        } else if (getJump_value() < 160) {
            jumpScore = 64.0;
        } else if (getJump_value() < 163) {
            jumpScore = 66.0;
        } else if (getJump_value() < 166) {
            jumpScore = 68.0;
        } else if (getJump_value() < 169) {
            jumpScore = 70.0;
        } else if (getJump_value() < 172) {
            jumpScore = 72.0;
        } else if (getJump_value() < 175) {
            jumpScore = 74.0;
        } else if (getJump_value() < 178) {
            jumpScore = 76.0;
        } else if (getJump_value() < 181) {
            jumpScore = 78.0;
        } else if (getJump_value() < 188) {
            jumpScore = 80.0;
        } else if (getJump_value() < 195) {
            jumpScore = 85.0;
        } else if (getJump_value() < 201) {
            jumpScore = 90.0;
        } else if (getJump_value() < 207) {
            jumpScore = 95.0;
        } else {
            jumpScore = 100.0;
        }
        setJump_score(jumpScore);
    }

    //    计算引体向上分数
    public void calcPullUpScore() {
        double pullUpScore;
        if (getPull_up_value() < 16) {
            pullUpScore = 0.0;
        } else if (getPull_up_value() < 18) {
            pullUpScore = 10.0;
        } else if (getPull_up_value() < 20) {
            pullUpScore = 20.0;
        } else if (getPull_up_value() < 22) {
            pullUpScore = 30.0;
        } else if (getPull_up_value() < 24) {
            pullUpScore = 40.0;
        } else if (getPull_up_value() < 26) {
            pullUpScore = 50.0;
        } else if (getPull_up_value() < 28) {
            pullUpScore = 60.0;
        } else if (getPull_up_value() < 30) {
            pullUpScore = 62.0;
        } else if (getPull_up_value() < 32) {
            pullUpScore = 64.0;
        } else if (getPull_up_value() < 34) {
            pullUpScore = 66.0;
        } else if (getPull_up_value() < 36) {
            pullUpScore = 68.0;
        } else if (getPull_up_value() < 38) {
            pullUpScore = 70.0;
        } else if (getPull_up_value() < 40) {
            pullUpScore = 72.0;
        } else if (getPull_up_value() < 42) {
            pullUpScore = 74.0;
        } else if (getPull_up_value() < 44) {
            pullUpScore = 76.0;
        } else if (getPull_up_value() < 46) {
            pullUpScore = 78.0;
        } else if (getPull_up_value() < 49) {
            pullUpScore = 80.0;
        } else if (getPull_up_value() < 52) {
            pullUpScore = 85.0;
        } else if (getPull_up_value() < 54) {
            pullUpScore = 90.0;
        } else if (getPull_up_value() < 56) {
            pullUpScore = 95.0;
        } else {
            pullUpScore = 100.0;
        }
        setPull_up_score(pullUpScore);
    }

    //    计算 1000 米的成绩
    public void calcOneThousandScore() {
        double oneThousandScore;
        if (getOne_thousand_value() > 324) {
            oneThousandScore = 0.0;
        } else if (getOne_thousand_value() > 314) {
            oneThousandScore = 10.0;
        } else if (getOne_thousand_value() > 304) {
            oneThousandScore = 20.0;
        } else if (getOne_thousand_value() > 294) {
            oneThousandScore = 30.0;
        } else if (getOne_thousand_value() > 284) {
            oneThousandScore = 40.0;
        } else if (getOne_thousand_value() > 274) {
            oneThousandScore = 50.0;
        } else if (getOne_thousand_value() > 269) {
            oneThousandScore = 60.0;
        } else if (getOne_thousand_value() > 264) {
            oneThousandScore = 62.0;
        } else if (getOne_thousand_value() > 259) {
            oneThousandScore = 64.0;
        } else if (getOne_thousand_value() > 254) {
            oneThousandScore = 66.0;
        } else if (getOne_thousand_value() > 249) {
            oneThousandScore = 68.0;
        } else if (getOne_thousand_value() > 244) {
            oneThousandScore = 70.0;
        } else if (getOne_thousand_value() > 239) {
            oneThousandScore = 72.0;
        } else if (getOne_thousand_value() > 234) {
            oneThousandScore = 74.0;
        } else if (getOne_thousand_value() > 229) {
            oneThousandScore = 76.0;
        } else if (getOne_thousand_value() > 224) {
            oneThousandScore = 78.0;
        } else if (getOne_thousand_value() > 217) {
            oneThousandScore = 80.0;
        } else if (getOne_thousand_value() > 210) {
            oneThousandScore = 85.0;
        } else if (getOne_thousand_value() > 204) {
            oneThousandScore = 90.0;
        } else if (getOne_thousand_value() > 198) {
            oneThousandScore = 95.0;
        } else {
            oneThousandScore = 100.0;
        }
        setOne_thousand_score(oneThousandScore);
    }
}

