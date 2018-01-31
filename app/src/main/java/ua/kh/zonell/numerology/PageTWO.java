package ua.kh.zonell.numerology;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PageTWO extends AppCompatActivity {

        @BindView(R.id.etLine1)
        EditText etLine1;
        @BindView(R.id.etLine2)
        EditText etLine2;
        @BindView(R.id.etLine3)
        EditText etLine3;
        @BindView(R.id.etLine4)
        EditText etLine4;
        @BindView(R.id.btnCalculate)
        Button btnCalculate;
        @BindView(R.id.btnClear)
        Button btnClear;
        @BindView(R.id.tvRes)
        TextView tvRes;

        private List<Integer> list1;
        private List<Integer> list2;
        private List<Integer> list3;
        private List<Integer> list4;

        private List<Integer> list5;
        private List<Integer> list6;

        private List<Integer> list8;
        private List<Integer> list9;

        private List<Integer> list10;
        private List<Integer> list11;

        private List<Integer> joinList1;
        private List<Integer> joinList2;

        private List<Integer> finalList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_page_two);
            ButterKnife.bind(this);

//            etLine1.setText("18756790");
//            etLine2.setText("33581212");
//            etLine3.setText("88335749");
//            etLine4.setText("12853314");

            initUI();
        }

        private void initUI() {
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            list3 = new ArrayList<>();
            list4 = new ArrayList<>();

            list5 = new ArrayList<>();
            list6 = new ArrayList<>();
            list8 = new ArrayList<>();
            list9 = new ArrayList<>();

            list10 = new ArrayList<>();
            list11 = new ArrayList<>();

            joinList1 = new ArrayList<>();
            joinList2 = new ArrayList<>();

            finalList = new ArrayList<>();
        }

        private void readData(List<Integer> list, EditText editText, int num) {
            String line = editText.getText().toString();
            if (line.length() == 8) {
                for (int i = 0; i < line.length(); ) {
                    try {
                        list.add(Integer.parseInt(line.substring(i, ++i)));
                    } catch (Exception e) {
                        e.toString();
                    }
                }
            } else {
                Toast.makeText(getApplicationContext(), "Заполните линию № " + num, Toast.LENGTH_LONG).show();
            }
        }

        private List<Integer> mathList(List<Integer> list1, List<Integer> list2) {
            Integer sumList;
            Integer result = 0;
            List<Integer> listRes = new ArrayList<>();
            for (int i = 0; i < list1.size(); i++) {
                    sumList = list1.get(i) + list2.get(i);
                for (char character : Integer.toString(Math.abs(sumList)).toCharArray()) {
                        result += Integer.valueOf(Character.toString(character));
                }
                listRes.add(Math.abs(result));
                result = 0;
            }
            return listRes;
        }

        private List<Integer> joinList(List<Integer> list1, List<Integer> list2) {
            List<Integer> listRes = new ArrayList<>(16);
            for (int i = 0; i < list1.size(); i++) {
                listRes.add(list1.get(i));
                listRes.add(list2.get(i));
            }
            return listRes;
        }

        private int getFinalNum(int num) {
            Integer result = 0;
            for (char character : Integer.toString(num).toCharArray()) {
                result += Integer.valueOf(Character.toString(character));
            }
            if (result >= 10) {
                return getFinalNum(result);
            } else {
                return result;
            }
        }

        private List<Integer> getFinalList(List<Integer> list1, List<Integer> list2) {
            List<Integer> fList = new ArrayList<>();

            list1 = getInterimList(list1);
            list2 = getInterimList(list2);

            fList.add(getS(list1.get(0), list1.get(1), list1.get(2), list1.get(3)));
            fList.add(getS(list1.get(4), list1.get(5), list1.get(6), list1.get(7)));
            fList.add(getS(list1.get(8), list1.get(9), list1.get(10), list1.get(11)));
            fList.add(getS(list1.get(12), list1.get(13), list1.get(14), list1.get(15)));

            fList.add(getS(list2.get(0), list2.get(1), list2.get(2), list2.get(3)));
            fList.add(getS(list2.get(4), list2.get(5), list2.get(6), list2.get(7)));
            fList.add(getS(list2.get(8), list2.get(9), list2.get(10), list2.get(11)));
            fList.add(getS(list2.get(12), list2.get(13), list2.get(14), list2.get(15)));

            return fList;
        }

        private int getS(int i1, int i2, int i3, int i4) {
            int s1, s2, s3, s4, s5, s6 = 0;

            s1 = getFinalNum(i1 + i2);
            s2 = getFinalNum(i2 + i3);
            s3 = getFinalNum(i3 + i4);
            s4 = getFinalNum(s1 + s2);
            s5 = getFinalNum(s2 + s3);
            s6 = getFinalNum(s4 + s5);

            return s6;
        }

        private List<Integer> getInterimList(List<Integer> list) {
            List<Integer> interList = new ArrayList<>();

            interList.add(list.get(0));
            interList.add(list.get(14));
            interList.add(list.get(3));
            interList.add(list.get(13));
            interList.add(list.get(7));
            interList.add(list.get(9));
            interList.add(list.get(4));
            interList.add(list.get(10));
            interList.add(list.get(12));
            interList.add(list.get(2));
            interList.add(list.get(15));
            interList.add(list.get(1));
            interList.add(list.get(11));
            interList.add(list.get(5));
            interList.add(list.get(8));
            interList.add(list.get(6));

            return interList;
        }

        @OnClick(R.id.btnCalculate)
        public void clickedCalculate() {
            list1.clear();
            list2.clear();
            list3.clear();
            list4.clear();

            list5.clear();
            list6.clear();

            list8.clear();
            list9.clear();

            list10.clear();
            list11.clear();

            joinList1.clear();
            joinList2.clear();

            finalList.clear();

            readData(list1, etLine1, 1);
            readData(list2, etLine2, 2);
            readData(list3, etLine3, 3);
            readData(list4, etLine4, 4);

            if (list1.size() == 8 && list2.size() == 8 && list3.size() == 8 && list4.size() == 8){
                list5 = mathList(list1, list4);
                list6 = mathList(list2, list3);

                joinList1 = joinList(list5, list6);
                joinList2 = joinList(list6, list5);

                finalList = getFinalList(joinList1, joinList2);

                setTextRes(finalList);
            }
        }

        private void setTextRes(List<Integer> list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 4){
                    sb.append("   ");
                }
                sb.append(list.get(i).toString());
            }

            tvRes.setText(sb.toString());
        }

        @OnClick(R.id.btnClear)
        public void clickedClear() {
            etLine1.setText("");
            etLine2.setText("");
            etLine3.setText("");
            etLine4.setText("");

            tvRes.setText("");
        }
}
