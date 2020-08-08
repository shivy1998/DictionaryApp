package lockdown.org.dictionaryapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity
{
    ListView lvWords;
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        lvWords = findViewById(R.id.lvWords);

        final ArrayList al1 = new ArrayList();

        al1.add("consider");
        al1.add("minute");
        al1.add("accord");
        al1.add("evident");
        al1.add("practice");
        al1.add("intend");
        al1.add("concern");
        al1.add("commit");
        al1.add("issue");
        al1.add("approach");

        final ArrayList al2 = new ArrayList();

        al2.add("deem to be");
        al2.add("infinitely or immeasurably small");
        al2.add("concurrence of opinion");
        al2.add("clearly revealed to the mind or the senses or judgment");
        al2.add("a customary way of operation or behavior");
        al2.add("have in mind as a purpose");
        al2.add("something that interests you because it is important");
        al2.add("perform an act, usually with a negative connotation");
        al2.add("some situation or event that is thought about");
        al2.add("move towards");

        ArrayAdapter aa = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,al1);
        lvWords.setAdapter(aa);
        lvWords.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String word = al1.get(position).toString();
                String meaning = al2.get(position).toString();
                Intent i = new Intent(MainActivity.this,DetailsActivity.class);
                i.putExtra("word",word);
                i.putExtra("meaning",meaning);
                startActivity(i);
            }
        });
    }
}