package bug.android.fidesmo.com.nfcreadermodebugexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import bug.android.fidesmo.com.nfcreadermodebugexample.R;

public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //5. React to the same NFC input again for some reason.
    }
}
