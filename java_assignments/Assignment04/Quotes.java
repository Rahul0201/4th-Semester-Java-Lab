package java_assignments.Assignment04;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

class DayQuote{
    int day;
    int month;
    String string;

    void CreateDayQuote(int d, int m, String s){
        day = d;
        month = m;
        string = s;
        //return this;
    }
    void show(){System.out.println(string);}

}
public class Quotes {
    static ArrayList<String> QuoteListOne = new ArrayList<String>();
    static ArrayList<DayQuote> SpecialQuotes = new ArrayList<DayQuote>();

    static void generateNormalQuotes(){
        QuoteListOne.add("Microsoft isn\'t evil, they just make really crappy operating systems. -- Linus Torvalds" );
        QuoteListOne.add("An unjust law is no law at all. -- St. Augustine of Hippo");
        QuoteListOne.add("All sufferings come from false pride. -- Unknown" );
        QuoteListOne.add("Before anything else, preparation is the key to success. -- Alexander Graham Bell" );
        QuoteListOne.add("The mind is the reality. You are what you think. -- Alfred Bester");
        QuoteListOne.add("The only true wisdom is knowing that you know nothing. -- Socrates");
        QuoteListOne.add("Silent gratitude isn\'t much use to anyone. -- G. B. Stern");
        QuoteListOne.add("Nothing will work unless you do. -- Maya Angelou" );
        QuoteListOne.add("Many argue; not many converse. -- Alcott, Louisa May");
        QuoteListOne.add("An alert and learned man will take advice from any event. -- Ali bin Abu-Talib");
        QuoteListOne.add("The brighter stars emerge out of the blackest darkness. -- Shri Radhe Maa");
        QuoteListOne.add("The secret of your future is hidden in your daily routine. -- Mike Murdock"); 
        QuoteListOne.add("The secret of your future is hidden in your daily routine. -- Mike Murdock");
        QuoteListOne.add("If your ship doesnt come in, swim out to meet it! -- Jonathan Winters");
        QuoteListOne.add("As long as youre going to be thinking anyway, think big. -- Donald Trump");
        QuoteListOne.add("A goal is a dream with a deadline. -- Napoleon Hill");
        QuoteListOne.add("People buy into the leader before they buy into the vision. -- John C. Maxwell");
        QuoteListOne.add("It takes two to lie. One to lie and one to listen. -- Homer Simpson");
        QuoteListOne.add("Heroism ... is endurance for one moment more. -- George F. Kennan");
        QuoteListOne.add("A person who makes few mistakes makes little progress. -- Bryant McGill");
        QuoteListOne.add("The first rule of my speaking is: listen! -- Larry King");
        QuoteListOne.add("It is not the mountain we conquer, but ourselves. -- Edmund Hillary");
        QuoteListOne.add("If everything comes your way, you are in the wrong lane. -- Unknown");
        QuoteListOne.add("When the stomach is full, it is easy to talk of fasting. -- St. Jerome");
        QuoteListOne.add("Better a witty fool than a foolish wit. -- William Shakespeare");
        QuoteListOne.add("A man is about as big as the things that make him angry. -- Winston Churchill");
        QuoteListOne.add("The aims of life are the best defense against death. -- Primo Levi" );
        QuoteListOne.add("Let your hopes, not your hurts, shape your future. -- Robert H. Schuller");
        QuoteListOne.add("The secret of success is constancy to purpose. -- Benjamin Disraeli");
        QuoteListOne.add("He that waits upon fortune, is never sure of a dinner. -- Franklin, Benjamin");
        QuoteListOne.add("The cruelest lies are often told in silence. -- Adlai Stevenson");
        QuoteListOne.add("That's what makes Linux so good: you put in something, and that effort multiplies. It's a positive feedback cycle. - Linus Torvalds");
        QuoteListOne.add("Genius does what it must, talent does what it can. -- Robert Bulwer Lytton");
        QuoteListOne.add("Men may move mountains, but ideas move men. -- Lois McMaster Bujold");
        QuoteListOne.add("Any plan is bad which is not susceptible of change. -- Bartholomew of San Concordio");
        QuoteListOne.add("Silence is sometimes the severest criticism. -- Charles Buxton");
        QuoteListOne.add("Even a broken clock gets it right occasionally. -- Jim Butcher");
        QuoteListOne.add("One can only forget about time by making use of it. -- Charles Baudelaire");
        QuoteListOne.add("Art attests to what is inhuman in man. -- Alain Badiou");
        QuoteListOne.add("There is no terror in a bang, only in the anticipation of it -- Alfred Hitchcock");
    }
    private static void addtoSPquotes(int day, int month, String quote){
        DayQuote q = new DayQuote();
        q.CreateDayQuote(day, month, quote);
        SpecialQuotes.add(q);
    }
    static void generateSpecialQuotes(){ 
        addtoSPquotes(1,1,"Happy New Year"); 
        addtoSPquotes(14,2,"Happy Valentines Day");
        addtoSPquotes(8,3,"Happy Internationals Women\'s Day");
        addtoSPquotes(22,4,"Happy Earth Day");
        addtoSPquotes(1,5,"Remember International labour\'s Day");
        addtoSPquotes(12,6,"Today is Anti Child Labour Day");
        addtoSPquotes(1,7,"Happy Doctors\' Day");
        addtoSPquotes(15,8,"Happy Independance Day");
        addtoSPquotes(15,9,"Happy Engineers\' Day");
        addtoSPquotes(16,10,"Vow to end world hunger in World Food Day");
        addtoSPquotes(14,11,"Happy children\'s Day");
        addtoSPquotes(25,12,"Merry Christmas");
    }
    static void generate(){
        generateNormalQuotes();
        generateSpecialQuotes();
    }
    static void ShowQuote(){
        Calendar cal = Calendar.getInstance();
        Random r = new Random(cal.get(Calendar.SECOND)*cal.get(Calendar.MINUTE));
        
        for(DayQuote Q : SpecialQuotes){
            if( Q.day == cal.get(Calendar.DATE) && Q.month == cal.get(Calendar.MONTH)+1 ){
                if( Math.abs(r.nextInt()) % 2 == 0){
                    Q.show();
                    return;
                }
            }
        }
        System.out.println(QuoteListOne.get( Math.abs(r.nextInt()) % QuoteListOne.size() ));
        return;

    }


}
