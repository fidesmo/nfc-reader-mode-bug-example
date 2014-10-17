package bug.android.fidesmo.com.nfcreadermodebugexample;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    TextView TextView1;
    Button Button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       TextView1 = (TextView) findViewById(R.id.textView1);
       Button1 = (Button) findViewById(R.id.button1);

    }

    @Override
    public void onPause() {
        super.onPause();
        NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);
        adapter.disableReaderMode(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //1. Get the default adapter
        NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);

        if (!adapter.isEnabled()) {
            Toast.makeText(getApplicationContext(), "Please enable NFC to test this.", Toast.LENGTH_LONG).show();
        }

        Bundle options = new Bundle();
        options.putInt(NfcAdapter.EXTRA_READER_PRESENCE_CHECK_DELAY, 5000);
        //2. Enable reader mode
        adapter.enableReaderMode(this,
                new NfcAdapter.ReaderCallback() {
                    @Override
                    public void onTagDiscovered(final Tag tag) {
                        //Update the view since input was recieved.
                        recievedInput();
                    }
                },
                NfcAdapter.FLAG_READER_NFC_A | NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK,
                options);
    }

    private void recievedInput() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView1.setText(getText(R.string.nfc_reaction));
                Button1.setEnabled(true);
                //Make the user able to leave for next activity
            }
        });
    }

    public void startNewAcitivty(View view) {
        //3. Disable reader mode
        NfcAdapter adapter = NfcAdapter.getDefaultAdapter(this);
        adapter.disableReaderMode(this);

        //4. Send user to next activity
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }
}
