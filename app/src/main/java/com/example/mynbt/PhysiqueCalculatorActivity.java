package com.example.mynbt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mynbt.R;
import com.example.mynbt.tools.Female12;
import com.example.mynbt.tools.Female34;
import com.example.mynbt.tools.Male12;
import com.example.mynbt.tools.Male34;


public class PhysiqueCalculatorActivity extends AppCompatActivity {

    int sign = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physique_calculator);


        final Button male_12 = findViewById(R.id.male_12);
        final Button male_34 = findViewById(R.id.male_34);
        final Button female_12 = findViewById(R.id.female_12);
        final Button female_34 = findViewById(R.id.female_34);
        final Button calc = findViewById(R.id.calc);
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final EditText vital_capacity = findViewById(R.id.vital_capacity);
        final EditText fifty_meter_race = findViewById(R.id.fifty_meter_race);
        final EditText sit_and_reach = findViewById(R.id.sit_and_reach);
        final EditText jump = findViewById(R.id.jump);
        final EditText pull_up = findViewById(R.id.pull_up);
        final EditText one_thousand = findViewById(R.id.one_thousand);
        final TextView pull_up_text = findViewById(R.id.pull_up_text);
        final TextView one_thousand_text = findViewById(R.id.one_thousand_text);

        male_12.setOnClickListener(v -> {
            pull_up_text.setText("引体向上");
            one_thousand_text.setText("1000 米跑");
            sign = 0;
        });

        male_34.setOnClickListener(v -> {
            pull_up_text.setText("引体向上");
            one_thousand_text.setText("1000 米跑");
            sign = 1;
        });

        female_12.setOnClickListener(v -> {
            pull_up_text.setText("仰卧起坐");
            one_thousand_text.setText("800 米跑");
            sign = 2;
        });

        female_34.setOnClickListener(v -> {
            pull_up_text.setText("仰卧起坐");
            one_thousand_text.setText("800 米跑");
            sign = 3;
        });

        calc.setOnClickListener(v -> {
            int height_value = Integer.parseInt(height.getText().toString());                   // 身高
            double weight_value = Double.parseDouble(weight.getText().toString());                  // 体重
            int vital_capacity_value = Integer.parseInt(vital_capacity.getText().toString());   // 肺活量
            double fifty_race_value = Double.parseDouble(fifty_meter_race.getText().toString());    // 50 米跑
            double sit_and_reach_value = Double.parseDouble(sit_and_reach.getText().toString());    // 坐位体前屈
            int jump_value = Integer.parseInt(jump.getText().toString());                       // 立定跳远
            int pull_up_value = Integer.parseInt(pull_up.getText().toString());                 // 引体向上
            int one_thousand_value = Integer.parseInt(one_thousand.getText().toString());       // 1000 米跑
            double physique_score = 0.0;                                                            // 体测成绩
            Male12 male12 = new Male12(height_value, weight_value, vital_capacity_value, fifty_race_value, sit_and_reach_value, jump_value, pull_up_value, one_thousand_value);
            Male34 male34 = new Male34(height_value, weight_value, vital_capacity_value, fifty_race_value, sit_and_reach_value, jump_value, pull_up_value, one_thousand_value);
            Female12 female12 = new Female12(height_value, weight_value, vital_capacity_value, fifty_race_value, sit_and_reach_value, jump_value, pull_up_value, one_thousand_value);
            Female34 female34 = new Female34(height_value, weight_value, vital_capacity_value, fifty_race_value, sit_and_reach_value, jump_value, pull_up_value, one_thousand_value);

            if (sign == 0) {
                male12.calcBMI();
                male12.calcVitalCapacityScore();
                male12.calcFiftyRaceScore();
                male12.calcSitReachScore();
                male12.calcJumpScore();
                male12.calcPullUpScore();
                male12.calcOneThousandScore();
                physique_score = 0.15 * male12.getVital_capacity_score() + 0.20 * male12.getFifty_race_score() + 0.10 * male12.getSit_and_reach_score() + 0.10 * male12.getJump_score() + 0.10 * male12.getPull_up_score() + 0.20 * male12.getOne_thousand_score() + 0.15 * male12.getBMI_score();
            } else if (sign == 1) {
                male34.calcBMI();
                male34.calcVitalCapacityScore();
                male34.calcFiftyRaceScore();
                male34.calcSitReachScore();
                male34.calcJumpScore();
                male34.calcPullUpScore();
                male34.calcOneThousandScore();
                physique_score = 0.15 * male34.getVital_capacity_score() + 0.20 * male34.getFifty_race_score() + 0.10 * male34.getSit_and_reach_score() + 0.10 * male34.getJump_score() + 0.10 * male34.getPull_up_score() + 0.20 * male34.getOne_thousand_score() + 0.15 * male34.getBMI_score();
            } else if (sign == 2) {
                female12.calcBMI();
                female12.calcVitalCapacityScore();
                female12.calcFiftyRaceScore();
                female12.calcSitReachScore();
                female12.calcJumpScore();
                female12.calcPullUpScore();
                female12.calcOneThousandScore();
                physique_score = 0.15 * female12.getVital_capacity_score() + 0.20 * female12.getFifty_race_score() + 0.10 * female12.getSit_and_reach_score() + 0.10 * female12.getJump_score() + 0.10 * female12.getPull_up_score() + 0.20 * female12.getOne_thousand_score() + 0.15 * female12.getBMI_score();
            } else if (sign == 3) {
                female34.calcBMI();
                female34.calcVitalCapacityScore();
                female34.calcFiftyRaceScore();
                female34.calcSitReachScore();
                female34.calcJumpScore();
                female34.calcPullUpScore();
                female34.calcOneThousandScore();
                physique_score = 0.15 * female34.getVital_capacity_score() + 0.20 * female34.getFifty_race_score() + 0.10 * female34.getSit_and_reach_score() + 0.10 * female34.getJump_score() + 0.10 * female34.getPull_up_score() + 0.20 * female34.getOne_thousand_score() + 0.15 * female34.getBMI_score();
            }

            // 创建一个 AlertDialog.Builder 对象
            AlertDialog.Builder builder = new AlertDialog.Builder(PhysiqueCalculatorActivity.this);
            // 设置弹窗标题
            builder.setTitle("体测计算器");
            // 设置弹窗内容
            builder.setMessage("你的体测成绩为 " + physique_score);
            // 设置确认按钮的文本和点击事件
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // 关闭弹窗
                    dialog.dismiss();
                }
            });
            // 创建并显示弹窗
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
}