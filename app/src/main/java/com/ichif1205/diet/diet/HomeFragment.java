package com.ichif1205.diet.diet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        final LineChart chart = (LineChart) root.findViewById(R.id.chart);
        chart.setData(createDemoData());
        return root;
    }

    private LineData createDemoData() {
        ArrayList<Entry> valsComp1 = new ArrayList<Entry>();
        ArrayList<Entry> valsComp2 = new ArrayList<Entry>();

        Entry c1e1 = new Entry(100.000f, 0); // 0 == quarter 1
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(50.000f, 1); // 1 == quarter 2 ...
        valsComp1.add(c1e2);
        valsComp1.add(new Entry(200.000f, 2));
        // and so on ...

        Entry c2e1 = new Entry(120.000f, 0); // 0 == quarter 1
        valsComp2.add(c2e1);
        Entry c2e2 = new Entry(110.000f, 1); // 1 == quarter 2 ...
        valsComp2.add(c2e2);

        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");
        setComp1.setColor(getResources().getColor(R.color.circle));
        setComp1.setCircleColor(getResources().getColor(R.color.circle));
        setComp1.setCircleSize(10f);
        setComp1.setLineWidth(10f);
        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q");

        LineData data = new LineData(xVals, dataSets);

        return data;
    }

}
