import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DbJokes {
    private Random random;
    private ArrayList<String> jokes;

    public DbJokes() {
        random = new Random();
        jokes = new ArrayList<>();

        Collections.addAll(jokes,
                "Из обсуждения телефонных мошенников.\n" +
                        "\n" +
                        "Наталья: Недавно звонил товарищ следователь. По поводу мошеннический действий с моим счетом. Знаете, как я обрадовалась? 20 минут рассказывала, как мой сосед машины меняет раз в 6 месяцев. Наверное, подпольный банкир. А дама из дома напротив водит мужчин. Она точно проститутка и налогов не платит. Товарищ следователь заикался. Пытался вставить слово. Потом сам бросил трубку.",

                "Сегодня проснулся посреди ночи, от Надькиных шорохов, доносящихся с кухни. Спрашиваю:\n" +
                        "- Что, опять sleepless night?\n" +
                        "- Ничего у меня не слиплось, я только кусочек попробовала.",
                "yyy: Друг - фотограф пишет\n" +
                        "yyy: Ему одна невеста фотки принесла обратно с претензиями. Говорит, что за такие деньги мог бы её похудее нафоткать. )",

                "Несмотря на падение цен на нефть, падения цен на бензин удалось избежать.",

                "lav: Сегодня ходил, их менеджер мне говорит: «А вы институт из-за чего бросили? Из-за лени?»\n" +
                        "lav: а начальник его перебивает: «Ну, господь с тобой, разве по человеку нельзя сказать, что он никакой не ленивый, вон как хорошо все настроил, явно ситуация тяжелая была»\n" +
                        "lav: Я вот думаю, может им все-таки стоило сказать, что я в институт и не поступал даже?");
    }

    public String getRandomJoke() {
        int selectedIndex = random.nextInt(jokes.size());
        return jokes.get(selectedIndex);
    }
}
