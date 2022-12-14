package com.example.javaviewpagerjeyanthi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();
    ViewPager2 viewPager2;
    String[] quotes = new String[]{
            "The purpose of our lives is to be happy. <br><br> — Dalai Lama <br><br> " ,
            "Life is what happens when you’re busy making other plans.<br><br>— John Lennon <br><br> ",
            "“Get busy living or get busy dying.” <br><br>— Stephen King <br><br> ",
            "“You only live once, but if you do it right, once is enough.”<br><br> — Mae West, <br><br> ",
            "“Many of life’s failures are people who did not realize how close they were to success when they gave up.”<br><br>– Thomas A. Edison <br><br> ",
            "“If you want to live a happy life, tie it to a goal, not to people or things.”<br><br>– Albert Einstein<br><br> ",
            "“Never let the fear of striking out keep you from playing the game.”<br><br>– Babe Ruth <br><br> ",
            "“Money and success don’t change people; they merely amplify what is already there.”<br><br> — Will Smith <br><br> ",
            "“Your time is limited, so don’t waste it living someone else’s life. Don’t be trapped by dogma – which is living with the results of other people’s thinking.” <br><br>– Steve Jobs <br><br> ",
            "“Not how long, but how well you have lived is the main thing.”<br><br> — Seneca <br><br> ",
            " “If life were predictable it would cease to be life, and be without flavor.”<br><br> – Eleanor Roosevelt <br><br> ",
            "“The whole secret of a successful life is to find out what is one’s destiny to do, and then do it.”<br><br>– Henry Ford <br><br> ",
            "“In order to write about life first you must live it.”<br><br>– Ernest Hemingway<br><br> ",
            " “The big lesson in life,  is never be scared of anyone or anything.”<br><br>– Frank Sinatra<br><br>",
            "“Curiosity about life in all of its aspects, I think, is still the secret of great creative people.”<br><br> – Leo Burnett<br><br> ",
            "“Life is not a problem to be solved, but a reality to be experienced.”<br><br>– Soren Kierkegaard<br><br> ",
            "“The unexamined life is not worth living.” <br><br>— Socrates<br><br> ",
            "“Turn your wounds into wisdom.”<br><br> — Oprah Winfrey <br><br>  ",
            "“The way I see it, if you want the rainbow, you gotta put up with the rain.” <br><br>—Dolly Parton <br><br> ",
            "“Do all the good you can, for all the people you can, in all the ways you can, as long as you can.”<br><br> — Hillary Clinton (inspired by John Wesley quote)<br><br> ",
            "“Don’t settle for what life gives you; make life better and build something.”<br><br> — Ashton Kutcher<br><br> ",
            "“Everything negative – pressure, challenges – is all an opportunity for me to rise.” <br><br>— Kobe Bryant<br><br> ",
            "“I like criticism. It makes you strong.” <br><br>— LeBron James<br><br> ",
            "“You never really learn much from hearing yourself speak.” <br><br>― George Clooney<br><br> ",
            "“Life imposes things on you that you can’t control, but you still have the choice of how you’re going to live through this.” <br><br>— Celine Dion<br><br> ",
            "“Life is never easy. There is work to be done and obligations to be met – obligations to truth, to justice, and to liberty.” <br><br>— John F. Kennedy (JFK Quotes)<br><br> ",
            "“Live for each second without hesitation.” <br><br>— Elton John<br><br> ",
            "“Life is like riding a bicycle. To keep your balance, you must keep moving.”<br><br> — Albert Einstein<br><br> ",
            "“Life is really simple, but men insist on making it complicated.”<br><br> — Confucius<br><br> ",
            "“Life is a succession of lessons which must be lived to be understood.”<br><br> — Helen Keller<br><br> ",
            " “My mama always said, life is like a box of chocolates. You never know what you’re gonna get.” <br><br>— Forrest Gump<br><br> ",
            "“Watch your thoughts; they become words. Watch your words; they become actions. Watch your actions; they become habits. Watch your habits; they become character. Watch your character; it becomes your destiny.”<br><br>— Lao-Tze<br><br> ",
            "“When we do the best we can, we never know what miracle is wrought in our life or the life of another.” <br><br>— Helen Keller <br><br> ",
            "“The healthiest response to life is joy.” <br><br>— Deepak Chopra<br><br> ",
            "“Life is like a coin. You can spend it any way you wish, but you only spend it once.”<br><br> — Lillian Dickson<br><br> ",
            "“The best portion of a good man’s life is his little nameless, unencumbered acts of kindness and of love.”<br><br> — Wordsworth<br><br> ",
            "“In three words I can sum up everything I’ve learned about life: It goes on.” <br><br>― Robert Frost<br><br> ",
            "“Life is ten percent what happens to you and ninety percent how you respond to it.” <br><br>— Charles Swindoll<br><br> ",
            "“Maybe that’s what life is… a wink of the eye and winking stars.” <br><br>— Jack Kerouac<br><br>",
            "“Life is a flower of which love is the honey.” <br><br>— Victor Hugo<br><br> ",
            "“Keep smiling, because life is a beautiful thing and there’s so much to smile about.”<br><br> — Marilyn Monroe<br><br> ",
            "“Health is the greatest gift, contentment the greatest wealth, faithfulness the best relationship.” <br><br>— Buddha<br><br> ",
            "“You have brains in your head. You have feet in your shoes. You can steer yourself any direction you choose.”<br><br> — Dr. Seuss<br><br> ",
            "“Good friends, good books, and a sleepy conscience: this is the ideal life.”<br><br> — Mark Twain<br><br>",
            "“Live in the sunshine, swim the sea, drink the wild air.” <br><br>— Ralph Waldo Emerson<br><br>",
            "“The greatest pleasure of life is love.” <br><br>— Euripides<br><br> ",
            "“Life is what we make it, always has been, always will be.”<br><br> — Grandma Moses<br><br> ",
            "“Too many of us are not living our dreams because we are living our fears.” <br><br>– Les Brown<br><br> ",
            "“I believe every human has a finite number of heartbeats. I don’t intend to waste any of mine.”<br><br> —Neil Armstrong <br><br>",
            "“Live as if you were to die tomorrow. Learn as if you were to live forever.” <br><br>—Mahatma Gandhi<br><br> ",
            "“Don’t cry because it’s over, smile because it happened.”<br><br> —Dr. Seuss <br><br> ",
            " “The best way to predict your future is to create it.” <br><br>— Abraham Lincoln<br><br> ",
            "“Sometimes you can’t see yourself clearly until you see yourself through the eyes of others.” <br><br>—Ellen DeGeneres<br><br> ",
            "“Be nice to people on the way up, because you may meet them on the way down.” <br><br>– Jimmy Durante<br><br> ",
            "“Your image isn’t your character. Character is what you are as a person.” <br><br>— Derek Jeter<br><br> ",
            "“If you’re changing the world, you’re working on important things. You’re excited to get up in the morning.” <br><br>– Larry Page<br><br> ",
            "“Lose an hour in the morning, and you will spend all day looking for it.” <br><br>– Richard Whately<br><br> ",
            "“Life is what we make it, always has been, always will be.”<br><br> — Grandma Moses<br><br> "
                };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "------------------>on create");

        viewPager2 = findViewById(R.id.viewpager);

        TestAdapter testAdapter = new TestAdapter(this);

        viewPager2.setAdapter(testAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.d(TAG, "----------->onCreateOptionsMenu");
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Log.d(TAG, "----------->onOptionsItemSelected");

        switch (item.getItemId())
        {
            case R.id.share_quotes:
                Log.d(TAG, "----------->share quotes");
                shareQuotesMethod();
                return true;
            case R.id.go_to:
                Log.d(TAG, "------->Go to page");
                displayChoosenPage();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayChoosenPage() {

        Log.d(TAG, "------->displayChoosenPage");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Go to the selected page");

        View view = LayoutInflater.from(this).inflate(R.layout.alter_dialog, null);

        EditText edPageNumber = view.findViewById(R.id.editTextNumber);
        edPageNumber.setHint("Enter Page NO(1 - " + quotes.length + ")");

        builder.setView(view);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

               viewPager2.setCurrentItem(Integer.parseInt(edPageNumber.getText().toString())-1);

            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();

             }


    private void shareQuotesMethod() {
        Log.d(TAG, "----------->share quotes Method called");

        int index = viewPager2.getCurrentItem();
        Log.d(TAG, "------->index:" + index);
        String tempQuotes = quotes[index];
        Log.d(TAG, "-------------->quotes : " +quotes[index]);

        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        myIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(tempQuotes).toString());
        startActivity(Intent.createChooser(myIntent, "share via"));

    }
}