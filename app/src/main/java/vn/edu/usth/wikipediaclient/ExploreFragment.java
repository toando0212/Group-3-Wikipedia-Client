package vn.edu.usth.wikipediaclient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private RecyclerView recyclerView;
    private ExploreAdapter exploreAdapter;
    private List<Article> articleList;
    private TextView titleExplore;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExploreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExploreFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static ExploreFragment newInstance(String param1, String param2) {
//        ExploreFragment fragment = new ExploreFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

//        titleExplore = view.findViewById(R.id.titleExplore);

        //set a lineả layout manager to Recycler View
        recyclerView = view.findViewById(R.id.recyclerViewExplore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //add mock data
        articleList = new ArrayList<>();
        articleList.add(new Article("Manchester United", "The greatest Football Club of all time", "Manchester United Football Club, commonly referred to as Man United (often stylised as Man Utd), or simply United, is a professional football club based in Old Trafford, Greater Manchester, England. They compete in the Premier League, the top tier of English football. Nicknamed the Red Devils, they were founded as Newton Heath LYR Football Club in 1878, but changed their name to Manchester United in 1902. After a spell playing in Clayton, Manchester, the club moved to their current stadium, Old Trafford, in 1910.\n" +
                "\n" +
                "Domestically, Manchester United have won a record 20 top-flight league titles, 13 FA Cups, 6 League Cups and a record 21 FA Community Shields. Additionally, in international football, they have won the European Cup/UEFA Champions League three times, and the UEFA Europa League, the UEFA Cup Winners' Cup, the UEFA Super Cup, the Intercontinental Cup and the FIFA Club World Cup once each.[6][7] Appointed as manager in 1945, Matt Busby built a team with an average age of just 22 nicknamed the Busby Babes that won successive league titles in the 1950s and became the first English club to compete in the European Cup. Eight players were killed in the Munich air disaster, but Busby rebuilt the team around star players George Best, Denis Law and Bobby Charlton – known as the United Trinity. They won two more league titles before becoming the first English club to win the European Cup in 1968. After Busby's retirement, Manchester United were unable to produce sustained success until the arrival of Alex Ferguson, who became the club's longest-serving and most successful manager, winning 38 trophies including 13 league titles, five FA Cups and two Champions League titles between 1986 and 2013.[8] In the 1998–99 season, under Ferguson, the club became the first in the history of English football to achieve the continental treble of the Premier League, FA Cup and UEFA Champions League.[9] In winning the UEFA Europa League under José Mourinho in 2016–17, they became one of five clubs to have won the original three main UEFA club competitions (the Champions League, Europa League and Cup Winners' Cup).\n" +
                "\n" +
                "Manchester United is one of the most widely supported football clubs in the world[10][11] and has rivalries with Liverpool, Manchester City, Arsenal and Leeds United. Manchester United was the highest-earning football club in the world for 2016–17, with an annual revenue of €676.3 million,[12] and the world's third-most-valuable football club in 2019, valued at £3.15 billion ($3.81 billion).[13] After being floated on the London Stock Exchange in 1991, the club was taken private in 2005 after a purchase by American businessman Malcolm Glazer valued at almost £800 million, of which over £500 million of borrowed money became the club's debt.[14] From 2012, some shares of the club were listed on the New York Stock Exchange, although the Glazer family retains overall ownership and control of the club.", R.drawable.mu));
        articleList.add(new Article("John Rolph", "Member of the Legislative Assembly of the Province of Canada for Norfolk County", "John Rolph (4 March 1793 – 19 October 1870) was a Canadian physician, lawyer, and political figure. As a politician, he was considered the leader of the Reform faction in the 1820s and helped plan the Upper Canada Rebellion. As a doctor, he founded several medical schools and incorporated new teaching techniques and medical procedures into his lectures. However, his actions against rival medical schools decreased public confidence in the ability of medical professionals to regulate themselves.\n" +
                "\n" +
                "Rolph grew up in Thornbury, Gloucestershire, England, and was educated in medicine and law. He immigrated to Upper Canada in 1813 and lived on his father's farm in Port Talbot, where he practised law and medicine concurrently and opened a medical school called the Talbot Dispensary. In 1824, Rolph was elected to the Parliament of Upper Canada and returned to England to petition the Colonial Office to allow the naturalization of American citizens in Canada. He was elected as an alderman to Toronto's first city council, though he resigned after his council colleagues did not select him to be the city's mayor.\n" +
                "\n" +
                "William Lyon Mackenzie persuaded Rolph to support the Upper Canada Rebellion in 1837. When the rebellion began, Rolph did not join the rebels at their headquarters and the Lieutenant Governor appointed him as his emissary to deliver the government's offer of a truce. Rolph fled to the US after the rebellion and focused on practising and teaching medicine. The Canadian government granted him amnesty and he returned to Canada in 1843, later creating a new medical institution called the Rolph School in Toronto. In 1851 he was elected to the Legislative Assembly of the Province of Canada and focused on his political career; upon the formation of the Morin-MacNab administration three years later, Rolph's priority returned to running his school. He retired as dean of his medical school in 1870 and died later that year after suffering a stroke.", R.drawable.john_rolph));
        articleList.add(new Article("Typhoon Yagi", "Yagi at its peak intensity over the South China Sea on September 5", "Typhoon Yagi, known in the Philippines as Severe Tropical Storm Enteng, was a deadly, powerful and destructive tropical cyclone which impacted the Philippines, South China, Vietnam, Laos, Thailand and Myanmar, in early September 2024. Yagi, which means goat or the constellation of Capricornus in Japanese, is the eleventh named storm, the first violent typhoon and the first Category 5 storm of the annual typhoon season. It was one of the most intense typhoons ever to strike Northern Vietnam, the strongest typhoon to strike Hainan during the meteorological autumn and the strongest since Rammasun in 2014. It is one of the only four Category 5 super typhoons recorded in the South China Sea, alongside Pamela in 1954, Rammasun in 2014 and Rai in 2021.\n" +
                "\n" +
                "Yagi originated from a low-pressure area that formed on August 30, approximately 540 km (330 mi) northwest of Palau. On September 1, the system was classified as a tropical storm and named Yagi by the Japan Meteorological Agency (JMA). After making landfall over Casiguran, Aurora, in the Philippines, on September 2, Yagi weakened as it moved inland through the rugged terrain of the Cordillera Central of Luzon. It later emerged over the South China Sea and began merging with a secondary circulation west of Lingayen Gulf, with its deep convection starting to wrap and develop convective bands extending west and south. On September 5, the JMA reported that the storm reached its peak intensity with ten-minute sustained winds of 195 km/h (120 mph) and a central pressure of 915 hPa (27.02 inHg). It subsequently peaked as a Category 5-equivalent super typhoon on the Saffir-Simpson scale, with one-minute sustained winds of 260 km/h (160 mph). After weakening during an eyewall replacement cycle, Yagi slightly restrengthened before making landfall near Wenchang in China's Hainan Province on September 6. Yagi passed over northern Hainan and directly over Haikou, before briefly making landfall over Xuwen County in mainland Guangdong Province and moving into the open waters of the Gulf of Tonkin. It made landfall over Haiphong and Quảng Ninh, Vietnam, on September 7 and moved southwestwards inland until it was last noted on September 8.\n" +
                "\n" +
                "The combination of Typhoon Yagi and the southwest monsoon led to heavy rains over Luzon, causing widespread flash floods in various areas. The Hong Kong Observatory issued a Gale or Storm No. 8 warning as Typhoon Yagi approached. Power outages and downed trees were reported in Hainan. In preparation for Typhoon Yagi, schools and transport services in areas within the storm’s trajectory were closed. In Vietnam, several structures, including electric poles, were uprooted, leading to power outages in various areas. Yagi also brought heavy rainfall that caused flooding in Luang Namtha Province, Laos. Flooding also occurred in Bokeo Province. In Thailand, around 9,000 families were affected. In Shan State, Myanmar, over 200 houses were damaged, and communication lines in Tachileik were cut by floods. In total, the typhoon caused at least 209 deaths, 901 wounded, and left 171 people missing, resulting in US$9.33 billion in damage across eight countries.",  R.drawable.typhoon_yagi));
        articleList.add(new Article("September 11 attacks", "Part of terrorism in the United States", "The September 11 attacks, commonly known as 9/11,[f] were four coordinated Islamist terrorist suicide attacks carried out by al-Qaeda against the United States in 2001. On that morning, 19 terrorists hijacked four commercial airliners scheduled to travel from the East Coast to California. The hijackers crashed the first two planes into the Twin Towers of the World Trade Center in New York City and aimed the next two flights toward targets in or near Washington, D.C., in an attack on the nation's capital. The third team succeeded in striking the Pentagon, the headquarters of the U.S. Department of Defense in Arlington County, Virginia, while the fourth plane crashed in rural Pennsylvania during a passenger revolt. The September 11 attacks killed 2,977 people, making it the deadliest terrorist attack in history. In response to the attacks, the United States waged the multi-decade global war on terror to eliminate hostile groups deemed terrorist organizations, as well as the foreign governments purported to support them, in Afghanistan, Iraq, Syria, and several other countries.", R.drawable.attack));
        articleList.add(new Article("Russian invasion of Ukraine", "This article is about the invasion that began in 2022", "On 24 February 2022, Russia invaded Ukraine in a major escalation of the Russo-Ukrainian War, which started in 2014. The invasion, the largest conflict in Europe since World War II,[13][14][15] has caused hundreds of thousands of military casualties and tens of thousands of Ukrainian civilian casualties. As of 2024, Russian troops occupy about 20% of Ukraine. From a population of 41 million, about 8 million Ukrainians had been internally displaced and more than 8.2 million had fled the country by April 2023, creating Europe's largest refugee crisis since World War II.\n" +
                "\n" +
                "In late 2021, Russia massed troops near Ukraine's borders but denied any plan to attack. On 24 February 2022, Russian president Vladimir Putin announced a \"special military operation\", stating that it was to support the Russian-backed breakaway republics of Donetsk and Luhansk, whose paramilitary forces had been fighting Ukraine in the Donbas conflict since 2014. Putin espoused irredentist views challenging Ukraine's legitimacy as a state, falsely claimed that Ukraine was governed by neo-Nazis persecuting the Russian minority, and said that Russia's goal was to \"demilitarise and denazify\" Ukraine. Russian air strikes and a ground invasion were launched on a northern front from Belarus towards Kyiv, a southern front from Crimea, and an eastern front from the Donbas and towards Kharkiv. Ukraine enacted martial law, ordered a general mobilisation and severed diplomatic relations with Russia.\n" +
                "\n" +
                "Russian troops retreated from the northern front, including from the outskirts of Kyiv, by April 2022 after encountering logistical challenges and stiff resistance. On the southern and southeastern fronts, Russia captured Kherson in March and Mariupol in May, the latter after a destructive siege. Russia launched a renewed offensive in the Donbas and continued to bomb military and civilian targets far from the front, including the energy grid through the winter months. In late 2022, Ukraine launched successful counteroffensives in the south and east. Soon after, Russia announced the illegal annexation of four partly-occupied oblasts. In November, Ukraine retook parts of Kherson Oblast, including Kherson city. In June 2023, Ukraine launched another counteroffensive in the southeast, which by the end of the year had failed with only small amounts of territory retaken. After small but steady gains for Russia in eastern Ukraine in the first half of 2024, Ukraine launched a cross-border incursion into Russia's Kursk Oblast in August of that year.\n" +
                "\n" +
                "War-related disruption to Ukrainian agriculture and shipping contributed to a world food crisis, while extensive environmental damage caused by the conflict has been described as an ecocide. The Russian attacks on civilians have led to allegations of genocide.[16][17][18][19] The invasion was met with widespread international condemnation. The United Nations General Assembly passed a resolution condemning the invasion and demanding a full Russian withdrawal in March 2022. The International Court of Justice ordered Russia to suspend military operations, and the Council of Europe expelled Russia. Many countries imposed sanctions on Russia and its ally Belarus, and provided humanitarian and military aid to Ukraine. The Baltic states all declared Russia a terrorist state. Protests occurred around the world, with anti-war protesters in Russia being met by mass arrests and greater media censorship. The International Criminal Court (ICC) opened an investigation into war crimes, crimes against humanity, abduction of Ukrainian children, and genocide against Ukrainians. The ICC issued six arrest warrants: for Putin and Maria Lvova-Belova, and for military officials Sergey Kobylash, Viktor Sokolov, Sergei Shoigu and Valery Gerasimov.",R.drawable.russion_ukraine ));
        articleList.add(new Article("Nuclear Weapons", "\"Atom bomb\", \"A-bomb\", and \"Nuke\" redirect here.", "A nuclear weapon[a] is an explosive device that derives its destructive force from nuclear reactions, either fission (fission bomb) or a combination of fission and fusion reactions (thermonuclear bomb), producing a nuclear explosion. Both bomb types release large quantities of energy from relatively small amounts of matter.\n" +
                "\n" +
                "The first test of a fission (\"atomic\") bomb released an amount of energy approximately equal to 20,000 tons of TNT (84 TJ).[1] The first thermonuclear (\"hydrogen\") bomb test released energy approximately equal to 10 million tons of TNT (42 PJ). Nuclear bombs have had yields between 10 tons TNT (the W54) and 50 megatons for the Tsar Bomba (see TNT equivalent). A thermonuclear weapon weighing as little as 600 pounds (270 kg) can release energy equal to more than 1.2 megatonnes of TNT (5.0 PJ).[2]\n" +
                "\n" +
                "A nuclear device no larger than a conventional bomb can devastate an entire city by blast, fire, and radiation. Since they are weapons of mass destruction, the proliferation of nuclear weapons is a focus of international relations policy. Nuclear weapons have been deployed twice in war, both by the United States against the Japanese cities of Hiroshima and Nagasaki in 1945 during World War II.", R.drawable.nuclear_weapons));
        articleList.add(new Article("Vikings","For the North Germanic ethnic group from which most Vikings originated", "Vikings were seafaring people originally from Scandinavia (present-day Denmark, Norway, and Sweden),[3][4][5][6] who from the late 8th to the late 11th centuries raided, pirated, traded, and settled throughout parts of Europe.[7][8][9] They also voyaged as far as the Mediterranean, North Africa, the Middle East, Greenland, and Vinland (present-day Newfoundland in Canada, North America). In their countries of origin, and some of the countries they raided and settled in, this period is popularly known as the Viking Age, and the term \"Viking\" also commonly includes the inhabitants of the Scandinavian homelands as a whole. The Vikings had a profound impact on the early medieval history of Scandinavia, the British Isles, France, Estonia, and Kievan Rus'.[10]\n" +
                "\n" +
                "Expert sailors and navigators of their characteristic longships, Vikings established Norse settlements and governments in the British Isles, the Faroe Islands, Iceland, Greenland, Normandy, and the Baltic coast, as well as along the Dnieper and Volga trade routes across modern-day Russia, Belarus,[11] and Ukraine,[12] where they were also known as Varangians. The Normans, Norse-Gaels, Rus' people, Faroese, and Icelanders emerged from these Norse colonies. At one point, a group of Rus Vikings went so far south that, after briefly being bodyguards for the Byzantine emperor, they attacked the Byzantine city of Constantinople.[13] Vikings also voyaged to Iran[14][page needed] and Arabia.[15] They were the first Europeans to reach North America, briefly settling in Newfoundland (Vinland). While spreading Norse culture to foreign lands, they simultaneously brought home slaves, concubines, and foreign cultural influences to Scandinavia, influencing the genetic[16] and historical development of both. During the Viking Age, the Norse homelands were gradually consolidated from smaller kingdoms into three larger kingdoms: Denmark, Norway, and Sweden.\n" +
                "\n" +
                "The Vikings spoke Old Norse and made inscriptions in runes. For most of the period, they followed the Old Norse religion, but later became Christians. The Vikings had their own laws, art, and architecture. Most Vikings were also farmers, fishermen, craftsmen, and traders. Popular conceptions of the Vikings often strongly differ from the complex, advanced civilisation of the Norsemen that emerges from archaeology and historical sources. A romanticised picture of Vikings as noble savages began to emerge in the 18th century; this developed and became widely propagated during the 19th-century Viking revival.[17][18] Perceived views of the Vikings as violent, piratical heathens or as intrepid adventurers owe much to conflicting varieties of the modern Viking myth that had taken shape by the early 20th century. Current popular representations of the Vikings are typically based on cultural clichés and stereotypes, complicating modern appreciation of the Viking legacy. These representations are rarely accurate—for example, there is no evidence that they wore horned helmets, a costume element that first appeared in the 19th century.", R.drawable.vikings));
       articleList.add(new Article("Slavery", "Typically involves compulsory work", "Slavery is the ownership of a person as property, especially in regards to their labour.[1] Slavery typically involves compulsory work, with the slave's location of work and residence dictated by the party that holds them in bondage. Enslavement is the placement of a person into slavery, and the person is called a slave or an enslaved person (see § Terminology).\n" +
               "\n" +
               "Many historical cases of enslavement occurred as a result of breaking the law, becoming indebted, suffering a military defeat, or exploitation for cheaper labor; other forms of slavery were instituted along demographic lines such as race or sex. Slaves may be kept in bondage for life, or for a fixed period of time after which they would be granted freedom.[2] Although slavery is usually involuntary and involves coercion, there are also cases where people voluntarily enter into slavery to pay a debt or earn money due to poverty. In the course of human history, slavery was a typical feature of civilization,[3] and was legal in most societies, but it is now outlawed in most countries of the world, except as a punishment for a crime.[4][5]\n" +
               "\n" +
               "In chattel slavery, the slave is legally rendered the personal property (chattel) of the slave owner. In economics, the term de facto slavery describes the conditions of unfree labour and forced labour that most slaves endure.[6]\n" +
               "\n" +
               "\n" +
               "Gordon, a slave from Louisiana, in 1863. The scars are the result of a whipping by his overseer.\n" +
               "Mauritania was the last country in the world to officially ban slavery, in 1981,[7] with legal prosecution of slaveholders established in 2007.[8] However, in 2019, approximately 40 million people, of whom 26% were children, were still enslaved throughout the world despite slavery being illegal. In the modern world, more than 50% of slaves provide forced labour, usually in the factories and sweatshops of the private sector of a country's economy.[9] In industrialised countries, human trafficking is a modern variety of slavery; in non-industrialised countries, debt bondage is a common form of enslavement,[6] such as captive domestic servants, people in forced marriages, and child soldiers.", R.drawable.slavery));
       articleList.add((new Article("NHS England", "NHS England, formerly the NHS Commissioning Board, is an executive non-departmental public body of the Department of Health and Social Care", "t oversees the budget, planning, delivery and day-to-day operation of the commissioning side of the National Health Service in England as set out in the Health and Social Care Act 2012.[3] It directly commissions NHS general practitioners, dentists, optometrists and some specialist services. The Secretary of State publishes annually a document known as the NHS mandate which specifies the objectives which the Board should seek to achieve. National Health Service (Mandate Requirements) Regulations are published each year to give legal force to the mandate.\n" +
               "\n" +
               "In 2018 it was announced that the organisation, while maintaining its statutory independence, would be merged with NHS Improvement, and seven \"single integrated regional teams\" would be jointly established.", R.drawable.nhs )));

       //set the adapter to RecyclerView
       exploreAdapter = new ExploreAdapter(articleList);
       recyclerView.setAdapter(exploreAdapter);


        
        return view;
    }

//    public List<Article> getSampleArticles() {
//        // mock data
//        List<Article> articles = new ArrayList<>();
//        articles.add(new Article("John Rolph", (R.drawable.john_rolph) , "Explore the wonders of our solar system, its planets, and its many secrets."));
//        articles.add(new Article("Typhoon Yagi", (R.drawable.typhoon_yagi),   "Explore the wonders of our solar system, its planets, and it"));
//        return articles;
//    }


}