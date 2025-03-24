package ro.t5tostudy.scoaladevalori.perepedenainte_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<TestPackage> implements View.OnClickListener {

    public ArrayList<TestPackage> adaptorList;
    Context mContext;

    private static class AdapterView {
        TextView titleTxt;
        TextView descriptionTxt;
        TextView publisherTxt;
    }

    public ListAdapter(ArrayList<TestPackage> data, Context context){
        super(context, R.layout.list_adapter_single_item, data);
        this.adaptorList = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        TestPackage testPackage = (TestPackage) object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        TestPackage testPackage = getItem(position);
        AdapterView adaptorView;

        final View result;

        if(convertView==null){
            adaptorView = new AdapterView();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_adapter_single_item, parent, false);
            adaptorView.titleTxt = (TextView) convertView.findViewById(R.id.title_list_adapter_single_item);
            adaptorView.descriptionTxt = (TextView) convertView.findViewById(R.id.description_list_adapter_single_item);
            adaptorView.publisherTxt = (TextView) convertView.findViewById(R.id.publisher_list_adapter_single_item);

            result = convertView;

            convertView.setTag(adaptorView);
        }
        else {
            adaptorView = (AdapterView) convertView.getTag();

            result = convertView;
        }

        lastPosition = position;

        adaptorView.titleTxt.setText(testPackage.getTitle());
        adaptorView.descriptionTxt.setText(testPackage.getDescription());
        adaptorView.publisherTxt.setText(testPackage.getPublisher());

        return convertView;
    }
}
