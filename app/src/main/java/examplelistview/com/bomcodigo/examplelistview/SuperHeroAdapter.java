package examplelistview.com.bomcodigo.examplelistview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bomcodigo.com.
 */
public class SuperHeroAdapter extends BaseAdapter{
    private List<SuperHero> superHeroList;
    private List<SuperHero> finalSuperHeroList;
    private LayoutInflater inflater;
    private Context context;

    public SuperHeroAdapter(Context context, List<SuperHero> superHeroList) {
        this.superHeroList = superHeroList;
        this.finalSuperHeroList = superHeroList;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return superHeroList.size();
    }

    @Override
    public SuperHero getItem(int i) {
        return superHeroList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        if (view == null){
            view = inflater.inflate(R.layout.list_item,null);
            holder.superName = (TextView) view.findViewById(R.id.super_name);
            holder.realName  = (TextView) view.findViewById(R.id.real_name);
            holder.publisher = (TextView) view.findViewById(R.id.publisher);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        SuperHero superHero = superHeroList.get(i);
        holder.superName.setText(superHero.getSuperName());
        holder.realName.setText(superHero.getRealName());
        holder.publisher.setText(superHero.getPublisher());
        return view;
    }

    public void setFilter(String query){
        List<SuperHero> filteredList = new ArrayList<>();
        if (!TextUtils.isEmpty(query)) {
            for (SuperHero s : finalSuperHeroList) {
                boolean match = s.getSuperName().toLowerCase().startsWith(query.toString().toLowerCase());
                match = match || s.getRealName().toLowerCase().startsWith(query.toString().toLowerCase());
                match = match || s.getPublisher().toLowerCase().startsWith(query.toString().toLowerCase());
                if (match) {
                    filteredList.add(s);
                }
            }
            superHeroList = filteredList;
            notifyDataSetChanged();
        }else{
            superHeroList = finalSuperHeroList;
            notifyDataSetChanged();
        }
    }

    private class Holder{
        public TextView superName;
        public TextView realName;
        public TextView publisher;

    }
}
