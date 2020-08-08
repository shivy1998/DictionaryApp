package lockdown.org.dictionaryapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity
{
    Button btnSpeak;
    TextView tvWord, tvMeaning;
    TextToSpeech tts;
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_details);
        btnSpeak = findViewById(R.id.btnSpeak);
        tvWord = findViewById(R.id.tvWord);
        tvMeaning = findViewById(R.id.tvMeaning);
        Intent i = getIntent();
        Bundle ob = i.getExtras();
        String word = ob.getString("word");
        final String meaning = ob.getString("meaning");
        tvWord.setText("Word : "+word);
        tvMeaning.setText("Meaning : "+meaning);
        tts = new TextToSpeech(DetailsActivity.this, new TextToSpeech.OnInitListener()
        {
            public void onInit(int status)
            {
                tts.setLanguage(Locale.UK);
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String data = tvMeaning.getText().toString();
                tts.speak(data,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}