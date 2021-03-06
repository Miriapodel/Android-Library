package com.miriapodel.backtoworkapp;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.widget.WithHint;

import com.bumptech.glide.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private SharedPreferences sharedPreferences;

    private static final String ALL_BOOKS_KEY="all_books";
    private static final String CURRENTLY_READING_KEY="currently_reading";
    private static final String ALREADY_READ_KEY="already_read";
    private static final String WISHLIST="wishlist";
    private static final String FAVORITES="favorites";

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wishlistBooks;
    private static ArrayList<Book> favoritesBooks;

    public Utils(Context context)
    {
        sharedPreferences = context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(getAllBooks() == null)
        {
            addInitialData();
        }

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(getCurrentlyReadingBooks() == null)
        {
            editor.putString(CURRENTLY_READING_KEY, gson.toJson(new ArrayList<Book>()));

            editor.commit();

        }

        if(getAlreadyReadBooks() == null)
        {
            editor.putString(ALREADY_READ_KEY ,gson.toJson(new ArrayList<Book>()));

            editor.commit();
        }

        if(getWishlistBooks() == null)
        {
            editor.putString(WISHLIST, gson.toJson(new ArrayList<Book>()));

            editor.commit();
        }

        if(favoritesBooks == null)
        {
            editor.putString(FAVORITES, gson.toJson(new ArrayList<Book>()));

            editor.commit();
        }
    }

    private void addInitialData()
    {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(1, 460,"https://www.edituracartex.ro/wp-content/uploads/2019/06/Enigma-Otiliei-George-Calinescu.jpeg", "Enigma Otiliei", "George Calinescu", "Romanul, alcatuit din 20 de capitole, este construit pe mai multe planuri narative", "Felix Sima, un t??n??r de 18 ani, vine ??n Bucure??ti la unchiul s??u Costache Giurgiuveanu pentru a urma Facultatea de medicin??. Ajuns la adresa indicat??, Otilia, fata vitreg?? a b??tr??nului, ??l invit?? ??n cas??, unde ??i cunoa??te pe membrii familiei: m??tu??a Aglae, unchiul Simion ??i copiii acestora Titi, Aurica, Olimpia, ginerele St??nic?? Ra??iu precum ??i prietenul de familie Leonida Pascalopol. A doua zi, Otilia ??i arat?? locuin??a, el remarc?? felul juc??u?? al fetei ??i este surprins c??nd g??se??te o scrisoare adresat?? acesteia, pe numele Otilia M??rculescu. Fata este r??vnit?? de Leonida Pascalopol ??i invidiat?? de to??i membrii familiei Tulea. Felix, curios de enigma numelui M??rculescu, descoper?? soarta Otiliei care nu este cu mult diferit?? de a sa. Fata a r??mas orfan?? de mic?? ??i este crescut?? de tat??l s??u vitreg, mo?? Costache. Pascalopol a cunoscut-o pe mama Otiliei ??i de atunci i-a ajutat foarte mult, Otilia purt??ndu-i o stim?? deosebit??. Rugat de Aglae, Felix ??l mediteaz?? pe Titi care a r??mas corigent, ??i ??n aceste ??mprejur??ri sora sa Aurica se ata??eaz?? de t??n??r. El, ??ns??, se simte tot mai atras de Otilia pe care o admir?? ??i cu care petrece din ce ??n ce mai mult timp. Vede ??ns?? ??n Pascalopol un rival. La ??nceputul lunii august, Olimpia, cel mai mare copil al Aglaei, ????i face apari??ia acas?? ??mpreun?? cu St??nic??, concubinul ei, cu care are un copil. Simion nu-??i recunoa??te fiica ??i refuz?? s??-i dea o cas?? de locuit ??i zestrea sa. St??nic??, prin minciuni ??i scrisori adresate domnului Pascalopol cum c?? se ??mpu??c??, reu??e??te s?? str??ng?? ceva bani de la to??i ??i s??-l ??nduplece pe Simion cu motivarea c?? mai are c??teva luni de tr??it, s??-i dea zestrea Olimpiei. La invita??ia lui Pascalopol, Felix ??i Otilia se duc la mo??ia acestuia, unde tinerii profit?? de timpul petrecut ??mpreun??, iar dup?? dou?? s??pt??m??ni revin acas??. ??ntre timp, fiul Olimpiei ??i al lui St??nic??, Aurel Ra??iu, moare, iar tat??l, ??nduio??at, ??i public?? ??n ziar decesul, amintind toate rudele, ??n speran??a de a ob??ine c??t mai mult sprijin financiar. St??nic?? este interesat de averea lui mo?? Costache ??i ??n acest scop ??l aduce pe un oarecare doctor Vasiliade pentru a-i pune diagnosticul c?? este bolnav. Singurul care descoper?? planul este Pascalopol, care ??l avertizeaz?? pe b??tr??n.\n" +
                "\n" +
                "??ntre Felix ??i Otilia se cl??de??te o rela??ie profund?? de prietenie ??i ata??ament. Felix ??i m??rturise??te iubirea, iar Otilia pare ??i ea ??nduio??at??, ??ns?? prive??te totul ??n mod copil??resc. Grija sa pentru Felix pare mai mult a unei surori. Ru??inat, Felix ????i pune pe h??rtie toate sentimentele sale, trimi????ndu-i Otiliei scrisoarea, ??ns?? ea nu-i d?? nici un r??spuns. ??ntr-un moment de gelozie, Felix o roag?? pe Otilia s?? nu se mai ??nt??lneasc?? cu Pascalopol, ??ns?? tot el, invitat de acesta la el acas??, ????i d?? seama de gre??eala f??cut?? fa???? de Otilia. ??n cas?? discu??iile despre adop??ia Otiliei de c??tre mo?? Costache declan??eaz?? un nou val cu scandaluri din partea Aglaei. ??n cele din urm??, fata ??i cere lui mo?? Costache s?? nu ??ntocmeasc?? formalit????ile de adop??ie ??i pleac?? cu Pascalopol la Paris, spre surprinderea lui Felix, care r??m??ne dezam??git. El se refugiaz?? ??n bra??ele unei curtezane, Georgeta. Felix are ocazia s??-l cunoasc?? pe Weissmann, un coleg de facultate care-i treze??te pasiuni neb??nuite pentru poezie. Discu??iile avute cu acesta ??i dezv??luie situa??ia material?? dificil?? a studentului, dar ??i spiritul practic al acestuia, care face injec??ii ??i consult?? diferite persoane pentru a-??i ??ntre??ine fra??ii ??i surorile. Cina la restaurantul domnului Iorgu ??n cinstea anivers??rii fiicei sale minore ??i reunesc la aceea??i mas?? pe Georgeta cu generalul, pe St??nic??, Olimpia, Aglae, Titi, Felix ??i mo?? Costache. Aglae pare foarte interesat?? de viitorul fiicei celor dou?? gazde, ??n speran??a c?? o va c??s??tori cu Titi, ??n timp ce Felix se simte din ce ??n ce mai jignit de purt??rile Georgetei. La ??nceput, dup?? o u??oar?? criz??, familia Tulea ignor?? purt??rile lui Simion, care ??ncepuse s?? aiureze, ??ns?? v??z??nd c?? situa??ia devine insuportabil??, Aglae ajutat?? de St??nic?? ??i de Weissmann ??l duc la un sanatoriu. Titi se afl?? ??n centrul aten??iei pentru Aglae care urm??re??te s??-l ??nsoare c??t mai bine spre dezam??girea Auricii ??i a Olimpiei. O nepoat?? a sa de 16 ani pe nume Lili ????i manifest?? dorin??a de a se c??s??tori, iar St??nic?? ??l recomand?? tat??lui acesteia pe Felix Sima, ??n special pentru c?? dorea a aduce ??n r??ndurile familiei sale ??i oameni cul??i. Felix viseaz?? c?? Otilia c??nt?? la pian, ??ns?? spre surprinderea sa totul pare a fi realitate. Rev??z??ndu-se, cei doi povestesc ??ndelung, ??n timp ce Felix se simte tot mai atras de Otilia ??i de schimbarea acesteia. Mo?? Costache are planurile sale cu cei doi tineri, ??ncep??nd s?? adune materiale de construc??ii pentru o cas?? unde cei doi, Felix ??i Otilia aveau s?? stea dup?? moartea sa. St??nic?? ??i face cuno??tin???? lui Felix cu Lili, spre sup??rarea lui Titi, care este atras de fat?? ??i nu ??n??elege de ce toate sunt atrase de b??iatul doctorului Sima. Din cauza unei u??oare insola??ii ??i a efortului, mo?? Costache are un atac, ??n urma c??ruia toat?? familia Tulea ????i petrece dou?? zile ??n casa b??tr??nului ignor??nd boala acestuia. Pascalopol aduce un doctor avizat, profesor la universitate, care recomand?? mult?? lini??te ??i odihn?? bolnavului.\n" +
                "\n" +
                "Mo?? Costache se ??ns??n??to??e??te ??i ??i alung?? din cas?? pe to??i cei din familia Tulea fiind de acord cu propunerea lui Pascalopol de a deschide un cont ??n banc?? pe numele Otiliei cu suma de 300.000 lei, ??ns?? nu-i d?? banii, ??ncrez??ndu-se ??n s??n??tatea sa. Mo??ierul deschide contul ??i depune ??n el 100.000 lei pe numele Otiliei. Dup?? infarct, mo?? Costache devine din ce ??n ce mai speriat de moarte, la aceasta contribuind ??i St??nic?? care ??i povestea tot felul de nenorociri. Consult?? diferi??i doctori, urmeaz?? chiar un tratament cheltuind bani pe medicamente ??i invit?? preo??ii s??-i sfin??easc?? casa. Vinde apoi anumite imobile ??i aduce ??n cas?? o menajer?? pe nume Paulina, dar care nu st?? mult pentru c?? b??tr??nul ??i descoper?? interesul fa???? de averea sa. Aurica se spovede??te preotului ??uic??, m??rturisindu-i dorin??a de a se c??s??tori cu un evreu ??i anume cu Weissemann, iar St??nic?? o ??ndeamn?? pe Otilia s??-l conving?? pe Felix s?? se c??s??toreasc?? cu Lili. Mo?? Costache ??i d??ruie??te lui Pascalopol 100.000 lei pentru Otilia. St??nic??, dup?? ??ndelungi c??ut??ri afl?? locul unde sunt ascun??i banii ??i-l jefuie??te. Mo?? Costache este surprins de atac ??i, ??n urma efortului, moare. St??nic?? divor??eaz?? de Olimpia ??i se c??s??tore??te cu Georgeta, iar apoi intr?? ??n politic??. Otilia se c??s??tore??te cu Pascalopol ??i pleac?? ??mpreun?? la Paris. Felix, cu ocazia r??zboiului, devine doctor, apoi profesor universitar ??i se c??s??tore??te bine, intr??nd ??n cercuri ??nalte. Se ??nt??lne??te ??nt??mpl??tor cu Pascalopol ??n tren ??i afl?? c?? acesta a divor??at de Otilia, fiind acum c??s??torit?? cu un om bogat din Buenos Aires. Fotografia ar??tat?? nu mai aduce nimic din ceea ce era odinioar?? Otilia. Amintirile acelei idile se n??ruiesc ??n cuvintele lui mo?? Costache: ???Aici nu st?? nimeni???."));
        books.add(new Book(2, 525,"https://s1.cel.ro/images/mari/ion---liviu-rebreanu-agora.jpg", "Ion", "Liviu Rebreanu", "Liviu Rebreanu creeaz?? ??n opera sa Ion o galerie bogat?? de personaje, dominant?? fiind imaginea lui Ion", "Romanul ??ncepe cu descrierea drumului care duce c??tre satul Pripas, la care se ajunge prin ?????oseaua ce vine de la C??rlibaba, ??ntov??r????ind Some??ul??? p??n?? la Cluj, din care se desprinde ???un drum alb mai sus de Armadia??? ??i dup?? ce las?? Jidovi??a ??n urm??, ???drumul urc?? ??nt??i anevoie p??n?? ce-??i face loc printre dealurile str??mtorate (...), apoi cote??te brusc pe sub R??pile Dracului, ca s?? dea buzna ??n Pripasul pitit ??ntr-o scr??ntitur?? de coline???. La intrarea ??n sat, ???te ??nt??mpin?? (...) o cruce str??mb?? pe care e r??stignit un Hristos cu fa??a sp??lat?? de ploi ??i cu o cununi???? de flori ve??tede ag????at?? de picioare???. Imaginea este reluat?? simbolic nu numai ??n finalul romanului, ci ??i ??n desf????urarea ac??iunii, ??n scena licita??iei la care se vindeau mobilele ??nv??????torului, suger??nd destinul tragic al lui Ion ??i al Anei, precum ??i via??a tensionat?? ??i necazurile celorlalte personaje: Titu, Zaharia Herdelea, Ioan Belciug, Vasile Baciu, George Bulbuc etc.\n" +
                "\n" +
                "Ac??iunea romanului ??ncepe ??ntr-o zi de duminic??, ??n care to??i locuitorii satului Pripas se afl?? aduna??i la hora tradi??ional??, ??n curtea Todosiei, v??duva lui Maxim Oprea. Nu lipsesc nici frunta??ii satului, familia ??nv??????torului Herdelea, preotul Belciug, fostul ??nv??????tor - tolstoianul Simion Butunoiu -, ??i ???bocotanii??? care cinstesc cu prezen??a lor s??rb??toarea. Hora este o pagin?? etnografic?? memorabil?? prin jocul tradi??ional, vigoarea fl??c??ilor ??i candoarea fetelor, prin l??uta ??iganilor care compun imaginea unui ritm impetuos: ???De tropotele juc??torilor se hurduc?? p??m??ntul. Zecile de perechi bat some??ana cu at??ta pasiune, c?? potcoavele fl??c??ilor scap??r?? sc??ntei, poalele fetelor se bolbocesc, iar colbul de pe jos se ??nv??ltore??te, se a??az?? ??n straturi groase pe fe??ele br??zdate de sudoare, luminate de oboseal?? ??i de mul??umire???.\n" +
                "\n" +
                "Lui Ion ??i place Florica, dar Ana are p??m??nt, a??a c?? el ??i face curte acesteia, spre disperarea lui Vasile Baciu, tat??l Anei, care se ceart?? cu Ion ??i-l face de r??sul satului, spun??ndu-i ???s??r??ntoc???. Alexandru Glaneta??u, tat??l lui Ion, a risipit zestrea Zenobiei, care avusese avere c??nd se m??ritase cu el. Vasile Baciu, om vrednic al satului, se ??nsurase tot pentru avere cu mama Anei, dar fiind harnic sporise averea ??i se g??ndea s??-i asigure fetei zestre atunci c??nd se va m??rita.\n" +
                "\n" +
                "Ion, fl??c??u harnic ??i m??ndru, dar s??rac o necinste??te pe Ana ??i ??l oblig?? astfel pe Vasile Baciu s?? i-o dea de nevast?? ??mpreun?? cu o parte din p??m??nturi. Ob??in??nd avere, Ion dob??nde??te situa??ie social??, demnitate uman?? ??i satisfacerea propriului orgoliu.\n" +
                "\n" +
                "??n cel??lalt plan, familia ??nv??????torului Herdelea are necazurile sale. Herdelea ????i zidise casa pe lotul ce apar??inea bisericii, cu ??nvoirea preotului Belciug. Rela??iile ??nv??????torului cu preotul se degradeaz?? cu timpul, de aceea Herdelea se teme c?? ar putea pierde toat?? agoniseala ??i i-ar r??m??ne familia pe drumuri. Preotul Belciug, r??mas v??duv ??nc?? din primul an, are o personalitate puternic??, este cel mai respectat ??i temut om din sat, av??nd o autoritate total?? asupra ??ntregii colectivit????i.\n" +
                "\n" +
                "??n sat, domin?? mentalitatea c?? oamenii sunt respecta??i dac?? au oarecare agoniseal??, fapt ce face ca rela??iile sociale s?? fie tensionate ??ntre ???s??r??ntoci??? ??i ???bocotani???, ??ntre chibzuin??a rosturilor ??i nechibzuin??a patimilor, ceea ce face s?? se dea ??n permanen???? o lupt?? aprig?? pentru existen????.\n" +
                "\n" +
                "Destinele personajelor sunt determinate de aceast?? mentalitate, de faptul c?? familiile nu se ??ntemeiaz?? pe sentimente, ci pe interese economice: ?????n societatea ????r??neasc??, femeia reprezint?? dou?? bra??e de lucru, o zestre ??i o produc??toare de copii. Odat?? criza erotic?? trecut??, ea ??nceteaz?? de a mai ??nsemna ceva pentru feminitate. Soarta Anei e mai rea, dar deosebit?? cu mult de a oric??rei femei, nu??? (G. C??linescu). B??tut?? de tat?? ??i de so??, Ana, r??mas?? f??r?? sprijin moral, dezorientat?? ??i respins?? de to??i, se sp??nzur??. Florica, p??r??sit?? de Ion, se c??s??tore??te cu George ??i se bucur?? de norocul pe care ??l are, de??i ??l iubea tot pe Ion."));

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(ALL_BOOKS_KEY, gson.toJson(books));
        editor.commit();

    }

    public ArrayList<Book> getAllBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);

        return books;

    }

    public ArrayList<Book> getCurrentlyReadingBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_KEY, null), type);

        return books;

    }

    public ArrayList<Book> getAlreadyReadBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_KEY, null), type);

        return books;

    }

    public ArrayList<Book> getWishlistBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(WISHLIST, null), type);

        return books;
    }

    public ArrayList<Book> getFavoritesBooks() {

        ArrayList<Book> books;

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        books = gson.fromJson(sharedPreferences.getString(FAVORITES, null), type);

        return books;

    }

    public static Utils getInstance(Context context)
    {

        if(instance != null)
        {
            return instance;
        }
        else
        {
            instance = new Utils(context);

            return instance;
        }

    }

    public Book getBookById(int id)
    {
        ArrayList<Book> books = getAllBooks();

        for(Book b : books)
            if(id == b.getId())
                return b;

            return null;
    }

    public boolean addToCurrentlyReading(Book book)
    {
       ArrayList<Book> books = getCurrentlyReadingBooks();

       Gson gson = new Gson();
       SharedPreferences.Editor editor = sharedPreferences.edit();

       if(books != null)
       {
           if(books.add(book))
           {
               editor.remove(CURRENTLY_READING_KEY);

               editor.putString(CURRENTLY_READING_KEY, gson.toJson(books));
               editor.commit();

               return true;
           }
       }

       return false;
    }

    public boolean addToAlreadyReadBooks(Book book)
    {
        ArrayList<Book> books = getAlreadyReadBooks();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(books != null)
        {
            if(books.add(book))
            {
                editor.remove(ALREADY_READ_KEY);

                editor.putString(ALREADY_READ_KEY, gson.toJson(books));
                editor.commit();

                return true;
            }
        }

        return false;
    }

    public boolean addToWishlistBooks(Book book)
    {
        ArrayList<Book> books = getWishlistBooks();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(books != null)
        {
            if(books.add(book))
            {
                editor.remove(WISHLIST);

                editor.putString(WISHLIST, gson.toJson(books));
                editor.commit();

                return true;
            }
        }

        return false;
    }

    public boolean addToFavoritesBooks(Book book)
    {
        ArrayList<Book> books = getFavoritesBooks();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(books!=null)
        {
            if(books.add(book))
            {
                editor.remove(FAVORITES);

                editor.putString(FAVORITES, gson.toJson(books));
                editor.commit();

                return true;
            }
        }

        return false;
    }

    public boolean removeFromCurrentlyReading(Book book)
    {
        ArrayList<Book> books = getCurrentlyReadingBooks();

        if(books!=null) {
            for (Book b : books) {
                if(b.getId() == book.getId())
                {
                    if(books.remove(book))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(CURRENTLY_READING_KEY);
                        editor.putString(CURRENTLY_READING_KEY, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromAlreadyRead(Book book)
    {
        ArrayList<Book> books = getAlreadyReadBooks();

        if(books!=null)
        {
            for(Book b : books)
            {
                if(b.getId() == book.getId())
                {
                    if(books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(ALREADY_READ_KEY);
                        editor.putString(ALREADY_READ_KEY, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromWishlist(Book book)
    {
        ArrayList<Book> books = getWishlistBooks();

        if(books != null)
        {
            for(Book b : books)
            {
                if(b.getId() == book.getId())
                {
                    if(books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(WISHLIST);
                        editor.putString(WISHLIST, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean removeFromFavorites(Book book)
    {
        ArrayList<Book> books = getFavoritesBooks();

        if(books != null)
        {
            for(Book b : books)
            {
                if(b.getId() == book.getId())
                {
                    if(books.remove(b))
                    {
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.remove(FAVORITES);
                        editor.putString(FAVORITES, gson.toJson(books));
                        editor.commit();

                        return true;
                    }
                }
            }
        }

        return false;
    }

}
