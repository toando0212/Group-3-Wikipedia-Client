package vn.edu.usth.wikipediaclient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private Adapter adapter;
    private List<Article> articleList;

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

        recyclerView = view.findViewById(R.id.recyclerViewExplore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articleList = new ArrayList<>();
        articleList.add(new Article("John Rolph", "Member of the Legislative Assembly of the Province of Canada for Norfolk County", "John Rolph (4 March 1793 – 19 October 1870) was a Canadian physician, lawyer, and political figure. As a politician, he was considered the leader of the Reform faction in the 1820s and helped plan the Upper Canada Rebellion. As a doctor, he founded several medical schools and incorporated new teaching techniques and medical procedures into his lectures. However, his actions against rival medical schools decreased public confidence in the ability of medical professionals to regulate themselves.\n" +
                "\n" +
                "Rolph grew up in Thornbury, Gloucestershire, England, and was educated in medicine and law. He immigrated to Upper Canada in 1813 and lived on his father's farm in Port Talbot, where he practised law and medicine concurrently and opened a medical school called the Talbot Dispensary. In 1824, Rolph was elected to the Parliament of Upper Canada and returned to England to petition the Colonial Office to allow the naturalization of American citizens in Canada. He was elected as an alderman to Toronto's first city council, though he resigned after his council colleagues did not select him to be the city's mayor.\n" +
                "\n" +
                "William Lyon Mackenzie persuaded Rolph to support the Upper Canada Rebellion in 1837. When the rebellion began, Rolph did not join the rebels at their headquarters and the Lieutenant Governor appointed him as his emissary to deliver the government's offer of a truce. Rolph fled to the US after the rebellion and focused on practising and teaching medicine. The Canadian government granted him amnesty and he returned to Canada in 1843, later creating a new medical institution called the Rolph School in Toronto. In 1851 he was elected to the Legislative Assembly of the Province of Canada and focused on his political career; upon the formation of the Morin-MacNab administration three years later, Rolph's priority returned to running his school. He retired as dean of his medical school in 1870 and died later that year after suffering a stroke.", R.drawable.typhoon_yagi));
        articleList.add(new Article("Typhoon Yagi", "Yagi at its peak intensity over the South China Sea on September 5", "Typhoon Yagi, known in the Philippines as Severe Tropical Storm Enteng, was a deadly, powerful and destructive tropical cyclone which impacted the Philippines, South China, Vietnam, Laos, Thailand and Myanmar, in early September 2024. Yagi, which means goat or the constellation of Capricornus in Japanese, is the eleventh named storm, the first violent typhoon and the first Category 5 storm of the annual typhoon season. It was one of the most intense typhoons ever to strike Northern Vietnam, the strongest typhoon to strike Hainan during the meteorological autumn and the strongest since Rammasun in 2014. It is one of the only four Category 5 super typhoons recorded in the South China Sea, alongside Pamela in 1954, Rammasun in 2014 and Rai in 2021.\n" +
                "\n" +
                "Yagi originated from a low-pressure area that formed on August 30, approximately 540 km (330 mi) northwest of Palau. On September 1, the system was classified as a tropical storm and named Yagi by the Japan Meteorological Agency (JMA). After making landfall over Casiguran, Aurora, in the Philippines, on September 2, Yagi weakened as it moved inland through the rugged terrain of the Cordillera Central of Luzon. It later emerged over the South China Sea and began merging with a secondary circulation west of Lingayen Gulf, with its deep convection starting to wrap and develop convective bands extending west and south. On September 5, the JMA reported that the storm reached its peak intensity with ten-minute sustained winds of 195 km/h (120 mph) and a central pressure of 915 hPa (27.02 inHg). It subsequently peaked as a Category 5-equivalent super typhoon on the Saffir-Simpson scale, with one-minute sustained winds of 260 km/h (160 mph). After weakening during an eyewall replacement cycle, Yagi slightly restrengthened before making landfall near Wenchang in China's Hainan Province on September 6. Yagi passed over northern Hainan and directly over Haikou, before briefly making landfall over Xuwen County in mainland Guangdong Province and moving into the open waters of the Gulf of Tonkin. It made landfall over Haiphong and Quảng Ninh, Vietnam, on September 7 and moved southwestwards inland until it was last noted on September 8.\n" +
                "\n" +
                "The combination of Typhoon Yagi and the southwest monsoon led to heavy rains over Luzon, causing widespread flash floods in various areas. The Hong Kong Observatory issued a Gale or Storm No. 8 warning as Typhoon Yagi approached. Power outages and downed trees were reported in Hainan. In preparation for Typhoon Yagi, schools and transport services in areas within the storm’s trajectory were closed. In Vietnam, several structures, including electric poles, were uprooted, leading to power outages in various areas. Yagi also brought heavy rainfall that caused flooding in Luang Namtha Province, Laos. Flooding also occurred in Bokeo Province. In Thailand, around 9,000 families were affected. In Shan State, Myanmar, over 200 houses were damaged, and communication lines in Tachileik were cut by floods. In total, the typhoon caused at least 209 deaths, 901 wounded, and left 171 people missing, resulting in US$9.33 billion in damage across eight countries.",  R.drawable.john_rolph));
        articleList.add(new Article("September 11 attacks", "Part of terrorism in the United States", "The September 11 attacks, commonly known as 9/11,[f] were four coordinated Islamist terrorist suicide attacks carried out by al-Qaeda against the United States in 2001. On that morning, 19 terrorists hijacked four commercial airliners scheduled to travel from the East Coast to California. The hijackers crashed the first two planes into the Twin Towers of the World Trade Center in New York City and aimed the next two flights toward targets in or near Washington, D.C., in an attack on the nation's capital. The third team succeeded in striking the Pentagon, the headquarters of the U.S. Department of Defense in Arlington County, Virginia, while the fourth plane crashed in rural Pennsylvania during a passenger revolt. The September 11 attacks killed 2,977 people, making it the deadliest terrorist attack in history. In response to the attacks, the United States waged the multi-decade global war on terror to eliminate hostile groups deemed terrorist organizations, as well as the foreign governments purported to support them, in Afghanistan, Iraq, Syria, and several other countries.", R.drawable.attack));


        adapter = new Adapter(articleList);
        recyclerView.setAdapter(adapter);


        
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