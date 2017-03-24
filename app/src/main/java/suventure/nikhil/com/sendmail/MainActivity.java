package suventure.nikhil.com.sendmail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button buttonSend;
    String senderMail="sender mail",recipientsMail="recipient_mail",password="sender_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSend=(Button)findViewById(R.id.button_send);
        //password=getString(R.string.password);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });



    }


    private void send() {


    Thread thread = new Thread() {
        @Override
        public void run() {

            MailSender sender = new MailSender(senderMail, password);
            try {
                sender.sendMail("Email Subject", "Email Body", senderMail, recipientsMail, "");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };
    thread.start();
}

}
