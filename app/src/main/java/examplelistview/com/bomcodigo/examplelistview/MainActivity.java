package examplelistview.com.bomcodigo.examplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listagem;
    private ImageButton imageButton;
    private EditText searchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<SuperHero> superHeroList = new SuperHeroHelper().getSuperHeroList();
        SuperHeroAdapter adapter = new SuperHeroAdapter(this,superHeroList);


        searchQuery = (EditText) findViewById(R.id.search_query);

        listagem = (ListView) findViewById(R.id.list_super_hero);
        listagem.setAdapter(adapter);

        imageButton = (ImageButton) findViewById(R.id.search_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtrar(searchQuery.getText().toString());
            }
        });
    }

    public void filtrar(String query){
        ((SuperHeroAdapter) listagem.getAdapter()).setFilter(query);
    }


}
